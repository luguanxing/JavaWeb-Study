(function () {
    $.get("test_my_info.js",function(data,status){
      load_ok3();
    });
})();

function load_ok3() {
	if ($("#logout")[0] != undefined) {
		$("#logout")[0].onclick = function() {
			$.post('/logout', function(data) {
				alert(data);
				window.location="../";
			})
		};
	}
}