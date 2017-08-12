var formatstring = ["用户名6~18位英文字母、数字或下划线，必须以英文字母开头", "密码为6~12位数字、大小写字母、中划线、下划线"];
var user = {
	'username':"",
	'password': "",
};

(function () {
    $.get("test_my_signin.js",function(data,status){
      load_ok();
    });
})();

function load_ok() {	
	if ($("#signin")[0] != undefined) {
		$("#signin")[0].onclick = function() {	//提交
			if (checkformat()) {
				$.post('/checksigin', user, function(data) {
					if(data.toString().length < 50) {
						if (data.toString() == "登录成功") {
							alert("登录成功");
							window.location="./";
							$("#guesthome")[0].click();
							getjs("javascripts/info.js");
						}				
						else
							$("#hints").html(data);
					}
				})
			}				
		};
		setinputs();
	}
}

function setinputs() {
	for (var i = 0; i < 2; i++) {
		(function (i){
			var inputi = $($("input")[i]);
			if (inputi.val().trim()=="" || inputi.val()==formatstring[i]) {
				inputi.addClass("noinput");
				if (i == 1)
					inputi.attr("type", "text");	
				inputi.val(formatstring[i]);
			}
			$("input")[i].onblur = function() {
				if ($(this).val().trim()=="") {
					$(this).addClass("noinput");			
					$(this).val(formatstring[i]);
					if (i == 1)
						inputi.attr("type", "text");
				} else {
					$(this).val($(this).val().replaceAll(" ", ""));
					if (i == 1)
						inputi.attr("type", "password");
				}
			}
			$("input")[i].onfocus = function() {
				if ($(this).val()==formatstring[i]) {		
					$(this).removeClass("noinput");
					$(this).val("");
					if (i == 1)
						inputi.attr("type", "password");
				}
			}					
		})(i)
	}
}

String.prototype.replaceAll = function(s1,s2){     
    return this.replace(new RegExp(s1,"gm"),s2);     
}

function checkformat() {
	var username = $($("input")[0]).val();
	if (username == formatstring[0]) {
		$("#hints").html("未填姓名");
		return false;
	} else if (/^[a-zA-Z]{1}\w{5,17}$/.test(username) == false) {
		$("#hints").html("姓名格式错误");
		return false;
	}
	
	var password = $($("input")[1]).val();
	if (password == formatstring[1]) {
		$("#hints").html("未填密码");
		return false;
	} else if (/^[a-zA-Z0-9_]{6,12}$/.test(password) == false) {
		$("#hints").html("密码格式错误");
		return false;		
	}
	
	user['username'] = username;
	user['password'] = password;
	return true;
}