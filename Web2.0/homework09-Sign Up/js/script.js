var formatstring = ["用户名6~18位英文字母、数字或下划线，必须以英文字母开头", "学号8位数字，不能以0开头", "电话11位数字，不能以0开头", "邮箱按照课程讲义中的规则校验"];
var hintstring = ["", "未填姓名", "未填学号", "未填电话", "未填邮箱","姓名格式错误", "学号格式错误", "电话格式错误", "邮箱格式错误","姓名重复", "学号重复", "电话重复", "邮箱重复"];
var usersignupname, usersignupstudentid,usersignupphone, usersignupemail;

window.onload = function() {
	$("#reset")[0].onclick = function() {	//刷新
								  $("input[type='text']").val("");		
								  $("#hints").html("");
								  setinputs();								  
							  };						  
	setinputs();
	$("input[type='text']").keydown(function (){setsummit();});
	$("input[type='text']").keyup(function (){setsummit();});	
}

function setinputs() {
	setsummit();
	for (var i = 0; i < 4; i++) {
		(function (i){
			var inputi = $($("input[type='text']")[i]);
			if (inputi.val().trim()=="" || inputi.val()==formatstring[i]) {
				inputi.addClass("noinput");				
				inputi.val(formatstring[i]);
			} else {
				inputi.removeClass("noinput");
			}
			$("input[type='text']")[i].onblur = function() {
				setsummit();				
				if ($(this).val().trim()=="") {
					$(this).addClass("noinput");			
					$(this).val(formatstring[i]);
				} else {
					$(this).val($(this).val().replaceAll(" ", ""));
				}
			}
			$("input[type='text']")[i].onfocus = function() {
				setsummit();
				if ($(this).val()==formatstring[i]) {		
					$(this).removeClass("noinput");
					$(this).val("");					
				}
			}
		})(i)
	}
}

String.prototype.replaceAll = function(s1,s2){     
    return this.replace(new RegExp(s1,"gm"),s2);     
}

function checkempty() {
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

function checkformat() {
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

function setsummit() {
	usersignupname = $($("input[type='text']")[0]).val();
	usersignupstudentid = $($("input[type='text']")[1]).val();
	usersignupphone = $($("input[type='text']")[2]).val();
	usersignupemail = $($("input[type='text']")[3]).val();		
	if (checkempty() || checkformat()) {
		$("#summit").addClass("fakebutton");
	} else {
		$("#summit").removeClass("fakebutton");
	}
}

