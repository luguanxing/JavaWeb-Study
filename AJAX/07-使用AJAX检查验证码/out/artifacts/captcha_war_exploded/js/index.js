
function changeCaptcha() {
	//加上时间戳避免读缓冲
	var timestamp = (new Date()).valueOf();
	$("#captcha").attr("src", "/getCaptcha?t="+timestamp);
}

function checkCaptcha() {
	$.post(
		"/checkCaptcha",
		{input :$("#input").val()},
		function(result){
			$("#result").html(result);
		}
	);
}
