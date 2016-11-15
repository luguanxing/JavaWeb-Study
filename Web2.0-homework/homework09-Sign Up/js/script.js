var formatstring = ["用户名6~18位英文字母、数字或下划线，必须以英文字母开头", "学号8位数字，不能以0开头", "电话11位数字，不能以0开头", "邮箱按照课程讲义中的规则校验"];

window.onload = function() {
	$("#reset")[0].onclick = function() {	//刷新
								  $("input[type='text']").val("");		
								  $("#hints").html("");
								  setinputs();								  
							  };
	$("#summit")[0].onclick = function() {	//提交
								  /*检验信息为空和格式正确性的代码与服务端一样，就不重复写了*/							  
							  };							  
	setinputs();
}

function setinputs() {
	for (var i = 0; i < 4; i++) {
		(function (i){
			var inputi = $($("input[type='text']")[i]);
			if (inputi.val().trim()=="" || inputi.val()==formatstring[i]) {
				inputi.addClass("noinput");				
				inputi.val(formatstring[i]);
			}
			$("input[type='text']")[i].onblur = function() {
				if ($(this).val().trim()=="") {
					$(this).addClass("noinput");			
					$(this).val(formatstring[i]);
				} else {
					$(this).val($(this).val().replaceAll(" ", ""));
				}
			}
			$("input[type='text']")[i].onfocus = function() {
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

