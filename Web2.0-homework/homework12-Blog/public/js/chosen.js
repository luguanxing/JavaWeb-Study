window.onload = function() {
	for (var i = 0; i < $(".chosen").length; i++) {
		$(".chosen")[i].onclick = function() {
			$(".chosen2").removeClass("chosen2");
			$(this).addClass("chosen2");
		}
	}
	$($(".chosen")[0]).addClass("chosen2");
	
	$(".return").click(function() {
		$(".chosen2").removeClass("chosen2");
		$($(".chosen")[0]).addClass("chosen2");	
	})
	
	$($(".chosen")[3]).click(function() {
		showpage2();
	})
	
	begray();
}

function comeback() {
	setTimeout(function(){
		$(".chosen2").removeClass("chosen2");
		$($(".chosen")[3]).addClass("chosen2");	
		$(".chosen")[3].click();
		alert("提交成功");
	}, 50);
}

function getjs2(name) {
	getjs(name);
	getjs("javascripts/info.js");
}

function getjs(name) {
	var oHead = document.getElementsByTagName('HEAD').item(0);
	var oScript= document.createElement("script");
	oScript.type = "text/javascript";
	oScript.src=name;
	var debug = oScript.src.replace("getPosts/","");
	debug = debug.replace("readPost/","");
	oScript.src = debug;
	oHead.appendChild(oScript);
}

function beblue() {
	$(".inputfield").css("color","blue");
}

function begray() {
	$(".inputfield").val($(".inputfield").val().trim());
	var text = $(".inputfield").val();
	if (text == "" || text == "输入关键字...") {
		$(".inputfield").css("color","gray");
		$(".inputfield").val("输入关键字...");
	}
}

function showpage2() {
	$.get("test_my_page.js",function(data,status){
		getjs("javascripts/pages.js"); 
	});
}

function returncommit() {
	$(".chosen")[3].click();
}

function returnhead() {
	window.location="./";
}
