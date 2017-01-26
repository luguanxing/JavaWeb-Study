(function () {
	$.get("test_my_page.js",function(data,status){
		setTimeout(initalpage, 0);
	});
})();

var currentitems;
var currentpage;

function initalpage() {
	currentitems = $(".sortitem").length;
	currentpage = 0;
	showpage();
	$("#leftpage")[0].onclick = lastpage;
	$("#rightpage")[0].onclick = nextpage;
}

function showpage() {
	$(".sortitem").hide();
	for (var i=currentpage*4; i<4*currentpage+4; i++)
		$($(".sortitem")[i]).fadeIn();
	$("#pagecontrol span").html("第"+currentpage+"/"+Math.floor((currentitems+-1)/4)+"页");
}

function nextpage() {
	currentpage++;
	if (currentpage >= Math.floor((currentitems+3)/4))
		currentpage--;
	showpage();
	$("#pagecontrol span").html("第"+currentpage+"/"+Math.floor((currentitems-1)/4)+"页");
}

function lastpage() {
	currentpage--;
	if (currentpage < 0)
		currentpage = 0;
	showpage();
	$("#pagecontrol span").html("第"+currentpage+"/"+Math.floor((currentitems+-1)/4)+"页");
}


function searchitem() {
	$(".sortitem").hide();
	var substr = $(".inputfield").val();
	var sum = 0;
	for (var i = 0; i < $(".sortitem").length; i++) {
		var heading_str = $($(".sortitem h3")[i]).html();
		var content_str = $($(".sortitem span")[i]).html();
		var name_str = $($(".sortitem h5")[i]).html();
		if (heading_str.indexOf(substr) != -1 || content_str.indexOf(substr) != -1 || name_str.indexOf(substr) != -1 ) {
			$($(".sortitem")[i]).fadeIn();
			sum++;
		}
		$("#pagecontrol span").html("共"+sum+"条结果");
	}
}