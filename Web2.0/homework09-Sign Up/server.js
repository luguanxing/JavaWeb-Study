var fs = require("fs");
var http = require("http");
var url = require("url");
var path = require("path");
var querystring = require("querystring");
var hintstring = ["", "未填姓名", "未填学号", "未填电话", "未填邮箱","姓名格式错误", "学号格式错误", "电话格式错误", "邮箱格式错误","姓名重复", "学号重复", "电话重复", "邮箱重复"];
var formatstring = ["用户名6~18位英文字母、数字或下划线，必须以英文字母开头", "学号8位数字，不能以0开头", "电话11位数字，不能以0开头", "邮箱按照课程讲义中的规则校验"];
var mime = {
	".html":"text/html",
	".css":"text/css",
	".js":"application/javascript",
	".jpg":"image/jpeg"
}
var userdata = [];
var usersignupdatas;
var usersignupname, usersignupstudentid,usersignupphone, usersignupemail;

onload();

function onload() {
	loaddata();
	var server = http.createServer(function (request, response) {
		if (request.method == "POST") {		//用户发送数据
			console.log("-------------------用户发送数据:------------------");		
			request.on('data',function(data){						
				usersignupdatas = decodeURIComponent(data).toString().split('&');
				console.log("服务器接收到的数据：　"+ usersignupdatas);
				usersignupname = usersignupdatas[0].toString().split('=')[1];
				usersignupstudentid = usersignupdatas[1].toString().split('=')[1];
				usersignupphone = usersignupdatas[2].toString().split('=')[1];
				usersignupemail = usersignupdatas[3].toString().split('=')[1];
				console.log("-----注册:-----");
				console.log("姓名：　"+ usersignupname + "\n学号：　"+ usersignupstudentid + "\n电话：　"+ usersignupphone + "\n邮箱：　"+ usersignupemail);
				if (checkempty(response)) {
					console.log("---提交信息为空---");
					showhints(response, hintstring[checkempty(response)]);
				} else if (checkformat(response)) {
					console.log("---提交信息不合法---");
					showhints(response, hintstring[checkformat(response)]);					
				} else {
					if (checkinfos(response)) {
						showhints(response, hintstring[checkinfos(response)]);							
					} else {
						console.log("---注册成功---");	
						storageinfo();
						showinfo(response);	
					}		
				}
			});
		} else {	//用户接收数据
			console.log("-------------------用户接收数据:------------------");			
			var queryusername = querystring.parse(url.parse(request.url).query).username;
			console.log("----查询数据:" + queryusername);	
			if (queryusername != "undefined" && checkusernameexist(queryusername)) {
				console.log("该用户存在,显示详情");
				/*response.writeHead(301, {"Location": "?username=" + usersignupname});*/			
				showinfo(response);
			} else {
				console.log("---未查询或该用户不存在");				
				loadresource(request, response);				
			}
		}
	}).listen(8000);
}

function loaddata() {
	console.log("--------加载：用户信息----------");		
	fs.readFile("userdata.txt", 'utf-8', function (error, data) {
		if (error) throw error;
		var datas = data.toString().split('\r\n');
		for (var i = 0; i < datas.length; i++) {
			infos = datas[i].split(",");
			userdata[i] = {};
			userdata[i]['username'] = infos[0];
			userdata[i]['studentid'] = infos[1];
			userdata[i]['phone'] = infos[2];			
			userdata[i]['email'] = infos[3];
		}
		console.log(userdata);		
	});	
}

function loadresource(request, response) {
	var parse = url.parse(request.url);
	var pathname = parse.pathname;
	var suffix = path.extname(pathname);
	var type = mime[suffix];
	console.log("---加载文件:" + pathname + "---------------");	
	console.log("---加载后缀:" + suffix + "---------------");
	console.log("---加载类型:" + type + "---------------");		
	if (pathname == "/")
		loadfile(response, "html/index.html", "text/html");
	else if (type != undefined)
		loadfile(response, pathname, type);
	else
		console.log(">未加载");
}

function loadfile(response, path, suffix) {	//同步加载本地文件
	console.log(">已加载:"+path);
	response.writeHead(200, {"Content-Type": suffix + ";charset=utf-8"});
	response.end(fs.readFileSync("./"+path));
}

function checkempty(response) {
	if (usersignupname == "" || usersignupname == formatstring[0])
		return 1;
	else if (usersignupstudentid == "" || usersignupstudentid == formatstring[1])
		return 2;
	else if (usersignupphone == "" || usersignupphone == formatstring[2])	
		return 3;
	else if (usersignupemail == "" || usersignupemail == formatstring[3])
		return 4;
	return false;
}

function checkformat(response) {
	var testname = /^[a-zA-Z]{1}\w{5,17}$/;
	var teststudentid = /^[1-9]{1}\d{7}$/;
	var testphone = /^[1-9]{1}[0-9]{10}$/;
	var testemail = /^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$/;
	if (!testname.test(usersignupname))
		return 5;
	else if (!teststudentid.test(usersignupstudentid))
		return 6;	
	else if (!testphone.test(usersignupphone))
		return 7;	
	else if (!testemail.test(usersignupemail))
		return 8;	
	else
		return false;
}

function checkinfos(response) {
	for (var i = 0; i < userdata.length; i++) {
		if (userdata[i]["username"] == usersignupname) {
			console.log("---姓名重复---");		
			return 9;
		} else if (userdata[i]["studentid"] == usersignupstudentid) {
			console.log("---学号重复---");	
			return 10;
		} else if  (userdata[i]["phone"] == usersignupphone) {
			console.log("---电话重复---");
			return 11;			
		} else if  (userdata[i]["email"] == usersignupemail) {
			console.log("---邮箱重复---");
			return 12;			
		}
	}
	return 0;
}

function showhints(response, hint) {
	fs.readFile("html/index.html", 'utf-8', function (error, data) {
		if (error) throw error;
		var indexpage = data.toString();
		indexpage = indexpage.replace("&nbsp", hint);
		indexpage = indexpage.replace("name=\"username\"", "name=\"username\", value = \""+usersignupname+"\"");
		indexpage = indexpage.replace("name=\"studentid\"", "name=\"studentid\", value = \""+usersignupstudentid+"\"");
		indexpage = indexpage.replace("name=\"phone\"", "name=\"phone\", value = \""+usersignupphone+"\"");
		indexpage = indexpage.replace("name=\"email\"", "name=\"email\", value = \""+usersignupemail+"\"");
		response.end(indexpage);
	})
}


function checkusernameexist(queryusername) {
	for (var i = 0; i < userdata.length; i++)
		if (userdata[i]["username"] == queryusername) {
			usersignupname = userdata[i]["username"];
			usersignupstudentid = userdata[i]["studentid"];
			usersignupphone = userdata[i]["phone"];
			usersignupemail = userdata[i]["email"];			
			return true;
		}
	return false;
}

function storageinfo() {
	var newuser = "\r\n" + usersignupname + "," + usersignupstudentid + "," + usersignupphone + "," + usersignupemail;
	fs.appendFile("userdata.txt", newuser);	
	console.log("---新用户注册成功，重新加载数据-----");
	loaddata();	
}

function showinfo(response) {
	fs.readFile("html/info.html", 'utf-8', function (error, data) {
		if (error) throw error;
		var infopage = data.toString();
		infopage = infopage.replace("{name}", usersignupname);
		infopage = infopage.replace("{studentid}", usersignupstudentid);
		infopage = infopage.replace("{phone}", usersignupphone);
		infopage = infopage.replace("{email}", usersignupemail);		
		response.end(infopage);
	})
}



