var fs = require("fs");
var http = require("http");
var url = require("url");
var path = require("path");
var querystring = require("querystring");


exports.check_signin = check_signin;
exports.check_signup = check_signup;
exports.showuserinfo = showuserinfo;

function check_signin(json, req, res) {
	var username = json["username"];
	var password = json["password"];
	console.log("");
	console.log(">>>>>>>>>>>>>>>>收到登录POST请求<<<<<<<<<<<<<<");
				console.log("用户名"+username);
				console.log("密码"+password);		
	fs.readFile("data/userdata.txt", 'utf-8', function (error, data) {
		if (error) throw error;
		var users = JSON.parse(data);
		var user = users[username];
		if (user != undefined && user["username"] == username) {
			if (user["password"] == md5(password)) {  //md5加密验证
				console.log("--------登录成功！----------");
				req.session.user = user;  //设置已登录,cookie
				res.end("登录成功");
			} else {
				res.end("密码错误");
				console.log("--------登录失败！----------");				
			}
		} else {
			res.end("查无此人");
			console.log("--------登录失败！----------");
		}
	});	
}

function check_signup(json, req, res) {
	var username = json["username"];
	var password = json["password"];
	var studentid = json["studentid"];
	var phone = json["phone"];
	var email = json["email"];
	console.log("");
	console.log(">>>>>>>>>>>>>>>>收到注册POST请求<<<<<<<<<<<<<<");
				console.log("用户名"+username);
				console.log("密码"+password);
				console.log("学号"+studentid);
				console.log("电话"+phone);
				console.log("邮箱"+email);
	console.log("----------校验：用户格式-----------");
	if (/^[a-zA-Z]{1}\w{5,17}$/.test(username) == false || /^[a-zA-Z0-9_]{6,12}$/.test(password) == false || /^[1-9]{1}\d{7}$/.test(studentid) == false || /^[1-9]{1}[0-9]{10}$/.test(phone) == false || /^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$/.test(email) == false) {
		console.log("二次校验失败！");
		res.end("存在格式错误！");
		return;
	}	
	console.log("二次校验成功！");
	fs.readFile("data/userdata.txt", 'utf-8', function (error, data) {
		if (error) throw error;
		var users = JSON.parse(data);
		var succeed = true;
		for(var useri in users) {
			console.log(useri);
			var user = users[useri];
			console.log("->"+user["username"]);
			if (user["username"] == username) {
				res.end("姓名重复");
				console.log("--------注册失败！----------");
				succeed = false;
				break;
			} else if (user["studentid"] == studentid) {
				res.end("学号重复");
				console.log("--------注册失败！----------");
				succeed = false;
				break;
			} else if (user["phone"] == phone) {
				res.end("电话重复");
				console.log("--------注册失败！----------");
				succeed = false;
				break;
			} else if (user["email"] == email) {
				res.end("邮箱重复");
				console.log("--------注册失败！----------");
				succeed = false;
				break;
			}
		}
		if (succeed) {
			console.log("--------注册成功！----------");
			users[username] = {};
			users[username]["username"] = username;
			users[username]["password"] = md5(password);  //md5加密密码
			users[username]["studentid"] = studentid;
			users[username]["phone"] = phone;
			users[username]["email"] = email;
			console.log(users);
			fs.writeFile("data/userdata.txt", JSON.stringify(users),  function (error) {
				if (error) throw error;
				req.session.user = users[username];  //设置已登录,cookie
				res.end("登录成功");
			})
		}
	});
}

function showuserinfo(req, res, queryusername, isgoodguy) {
	fs.readFile("data/userdata.txt", 'utf-8', function (error, data) {
		if (error) throw error;
		var users = JSON.parse(data);
		if (users[queryusername] != undefined) {
			fs.readFile("./views/info.html", 'utf-8', function (error, data) {
				if (error) throw error;
				var infopage = data.toString();	
				infopage = infopage.replace("{name}", users[queryusername]["username"]);
				infopage = infopage.replace("{studentid}", users[queryusername]["studentid"]);
				infopage = infopage.replace("{phone}", users[queryusername]["phone"]);
				infopage = infopage.replace("{email}", users[queryusername]["email"]);
				console.log("是小坏蛋吗"+(isgoodguy == false));
				if (!isgoodguy)
					infopage = infopage.replace("</head>", "<script>alert(\"小坏蛋！！非礼莫视！！ (╯・`ω´・)╯︵ ┻━┻\")</script>"+"</head>");
				res.end(infopage);
			})
		} else {
			req.session.user = undefined;
			res.end("This user is not exist!");
			console.log("--------登录失败！----------");
		}
	});
}

function md5(str) {
	nblk = ((str.length + 8) >> 6) + 1;
	blks = new Array(nblk * 16);

	for (i = 0; i < nblk * 16; i++)
		blks[i] = 0;

	for (i = 0; i < str.length; i++)
		blks[i >> 2] |= str.charCodeAt(i) << ((i % 4) * 8);

	blks[i >> 2] |= 0x80 << ((i % 4) * 8);
	blks[nblk * 16 - 2] = str.length * 8;
	return blks.join("");
}

function add(x, y) {
	var lsw = (x & 0xFFFF) + (y & 0xFFFF);
	var msw = (x >> 16) + (y >> 16) + (lsw >> 16);
	return (msw << 16) | (lsw & 0xFFFF)
}

function rol(num, cnt) {
	return (num << cnt) | (num >>> (32 - cnt))
}

function cmn(q, a, b, x, s, t) {
	return add(rol(add(add(a, q), add(x, t)), s), b)
}

function ff(a, b, c, d, x, s, t) {
	return cmn((b & c) | ((~b) & d), a, b, x, s, t)
}

function gg(a, b, c, d, x, s, t) {
	return cmn((b & d) | (c & (~d)), a, b, x, s, t)
}

function hh(a, b, c, d, x, s, t) {
	return cmn(b ^ c ^ d, a, b, x, s, t)
}

function ii(a, b, c, d, x, s, t) {
	return cmn(c ^ (b | (~d)), a, b, x, s, t)
}

function calcMD5(str) {
	x = str2blks_MD5(str);
	a = 1732584193;
	b = -271733879;
	c = -1732584194;
	d = 271733878;

	for (i = 0; i < x.length; i += 16)
		{
		olda = a;
		oldb = b;
		oldc = c;
		oldd = d;
		a = ff(a, b, c, d, x[i + 0], 7, -680876936);
		d = ff(d, a, b, c, x[i + 1], 12, -389564586);
		c = ff(c, d, a, b, x[i + 2], 17, 606105819);
		b = ff(b, c, d, a, x[i + 3], 22, -1044525330);
		a = ff(a, b, c, d, x[i + 4], 7, -176418897);
		d = ff(d, a, b, c, x[i + 5], 12, 1200080426);
		c = ff(c, d, a, b, x[i + 6], 17, -1473231341);
		b = ff(b, c, d, a, x[i + 7], 22, -45705983);
		a = ff(a, b, c, d, x[i + 8], 7, 1770035416);
		d = ff(d, a, b, c, x[i + 9], 12, -1958414417);
		c = ff(c, d, a, b, x[i + 10], 17, -42063);
		b = ff(b, c, d, a, x[i + 11], 22, -1990404162);
		a = ff(a, b, c, d, x[i + 12], 7, 1804603682);
		d = ff(d, a, b, c, x[i + 13], 12, -40341101);
		c = ff(c, d, a, b, x[i + 14], 17, -1502002290);
		b = ff(b, c, d, a, x[i + 15], 22, 1236535329);
		a = gg(a, b, c, d, x[i + 1], 5, -165796510);
		d = gg(d, a, b, c, x[i + 6], 9, -1069501632);
		c = gg(c, d, a, b, x[i + 11], 14, 643717713);
		b = gg(b, c, d, a, x[i + 0], 20, -373897302);
		a = gg(a, b, c, d, x[i + 5], 5, -701558691);
		d = gg(d, a, b, c, x[i + 10], 9, 38016083);
		c = gg(c, d, a, b, x[i + 15], 14, -660478335);
		b = gg(b, c, d, a, x[i + 4], 20, -405537848);
		a = gg(a, b, c, d, x[i + 9], 5, 568446438);
		d = gg(d, a, b, c, x[i + 14], 9, -1019803690);
		c = gg(c, d, a, b, x[i + 3], 14, -187363961);
		b = gg(b, c, d, a, x[i + 8], 20, 1163531501);
		a = gg(a, b, c, d, x[i + 13], 5, -1444681467);
		d = gg(d, a, b, c, x[i + 2], 9, -51403784);
		c = gg(c, d, a, b, x[i + 7], 14, 1735328473);
		b = gg(b, c, d, a, x[i + 12], 20, -1926607734);
		a = hh(a, b, c, d, x[i + 5], 4, -378558);
		d = hh(d, a, b, c, x[i + 8], 11, -2022574463);
		c = hh(c, d, a, b, x[i + 11], 16, 1839030562);
		b = hh(b, c, d, a, x[i + 14], 23, -35309556);
		a = hh(a, b, c, d, x[i + 1], 4, -1530992060);
		d = hh(d, a, b, c, x[i + 4], 11, 1272893353);
		c = hh(c, d, a, b, x[i + 7], 16, -155497632);
		b = hh(b, c, d, a, x[i + 10], 23, -1094730640);
		a = hh(a, b, c, d, x[i + 13], 4, 681279174);
		d = hh(d, a, b, c, x[i + 0], 11, -358537222);
		c = hh(c, d, a, b, x[i + 3], 16, -722521979);
		b = hh(b, c, d, a, x[i + 6], 23, 76029189);
		a = hh(a, b, c, d, x[i + 9], 4, -640364487);
		d = hh(d, a, b, c, x[i + 12], 11, -421815835);


		c = hh(c, d, a, b, x[i + 15], 16, 530742520);
		b = hh(b, c, d, a, x[i + 2], 23, -995338651);
		a = ii(a, b, c, d, x[i + 0], 6, -198630844);
		d = ii(d, a, b, c, x[i + 7], 10, 1126891415);
		c = ii(c, d, a, b, x[i + 14], 15, -1416354905);
		b = ii(b, c, d, a, x[i + 5], 21, -57434055);
		a = ii(a, b, c, d, x[i + 12], 6, 1700485571);
		d = ii(d, a, b, c, x[i + 3], 10, -1894986606);
		c = ii(c, d, a, b, x[i + 10], 15, -1051523);
		b = ii(b, c, d, a, x[i + 1], 21, -2054922799);
		a = ii(a, b, c, d, x[i + 8], 6, 1873313359);
		d = ii(d, a, b, c, x[i + 15], 10, -30611744);
		c = ii(c, d, a, b, x[i + 6], 15, -1560198380);
		b = ii(b, c, d, a, x[i + 13], 21, 1309151649);
		a = ii(a, b, c, d, x[i + 4], 6, -145523070);
		d = ii(d, a, b, c, x[i + 11], 10, -1120210379);
		c = ii(c, d, a, b, x[i + 2], 15, 718787259);
		b = ii(b, c, d, a, x[i + 9], 21, -343485551);
		a = add(a, olda);
		b = add(b, oldb);
		c = add(c, oldc);
		d = add(d, oldd)
		}

	return rhex(a) + rhex(b) + rhex(c) + rhex(d)
}

