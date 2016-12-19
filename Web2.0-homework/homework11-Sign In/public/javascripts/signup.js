var formatstring = ["用户名6~18位英文字母、数字或下划线，必须以英文字母开头", "密码为6~12位数字、大小写字母、中划线、下划线", "重复密码校验与密码一致", "学号8位数字，不能以0开头", "电话11位数字，不能以0开头", "邮箱按照课程讲义中的规则校验"];
var user = {
	'username':"",
	'password': "",
	'studentid': "",
	'phone': "",
	'email': ""
};

window.onload = function() {
	$("#reset")[0].onclick = function() {
								  $("input:lt(6)").val("");		
								  $("#hints").html("");
								  setinputs();								  
	};
	$("#summit")[0].onclick = function() {
		if (checkformat()) {
			$.post('/checksigup', user, function(data) {
				if(data.toString().length < 50) {
					if (data.toString() == "登录成功")
						window.location="../?username="+user["username"];
					else
						$("#hints").html(data);
				}
			})
		}
	};							  
	setinputs();
	
	$("#goback")[0].onclick = function() {
		window.location="../";							  
	};
}


function setinputs() {
	for (var i = 0; i < 6; i++) {
		(function (i){
			var inputi = $($("input")[i]);
			if (inputi.val().trim()=="" || inputi.val()==formatstring[i]) {
				inputi.addClass("noinput");
				if (i == 1 || i == 2)
					inputi.attr("type", "text");	
				inputi.val(formatstring[i]);
			}
			$("input")[i].onblur = function() {
				if ($(this).val().trim()=="") {
					$(this).addClass("noinput");			
					$(this).val(formatstring[i]);
					if (i == 1 || i == 2)
						inputi.attr("type", "text");
				} else {
					$(this).val($(this).val().replaceAll(" ", ""));
					if (i == 1 || i == 2)
						inputi.attr("type", "password");
				}
			}
			$("input")[i].onfocus = function() {
				if ($(this).val()==formatstring[i]) {		
					$(this).removeClass("noinput");
					$(this).val("");
					if (i == 1 || i == 2)
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
	
	var password2 = $($("input")[2]).val();
	if (password2 == formatstring[2]) {
		$("#hints").html("未填重复密码");
		return false;
	} else if (password2 != password) {
		$("#hints").html("重复密码错误");
		return false;
	}
	
	var studentid = $($("input")[3]).val();
	if (studentid == formatstring[3]) {
		$("#hints").html("未填学号");
		return false;
	} else if (/^[1-9]{1}\d{7}$/.test(studentid) == false) {
		$("#hints").html("学号格式错误");
		return false;
	}
	
	var phone = $($("input")[4]).val();
	if (phone == formatstring[4]) {
		$("#hints").html("未填电话");
		return false;
	} else if (/^[1-9]{1}[0-9]{10}$/.test(phone) == false) {
		$("#hints").html("电话格式错误");
		return false;
	}
	
	var email = $($("input")[5]).val();
	if (email == formatstring[5]) {
		$("#hints").html("未填邮箱");
		return false;
	} else if (/^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$/.test(email) == false) {
		$("#hints").html("邮箱格式错误");
		return false;
	}
	
	user['username'] = username;
	user['password'] = password;
	user['studentid'] = studentid;
	user['phone'] = phone;
	user['email'] = email;
	return true;
}

