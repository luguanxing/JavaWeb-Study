window.onload = function() {
	$("#symbol")[0].onclick = function() {
		window.location="https://github.com/luguanxing";
		/*清除cookie*/
	};
	$("#logout")[0].onclick = function() {
		$.post('/logout', function(data) {
			alert(data);
			window.location="../";
		})
	};
}
