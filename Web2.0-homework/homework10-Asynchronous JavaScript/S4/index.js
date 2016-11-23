window.onload = function() {
	reset();
	setbutton();
}

function reset() {
	$(".apb").attr("isclicking", "false");	
	$(".unread").hide().fadeOut();
	$(".hover").removeClass("hover").fadeIn();
	$("li").attr("iswaiting", "false");
	$("li").attr("havenum", "false");
	$("li").attr("free", "true");
	$(".info")[0].style.opacity = 0;
	$("#order").html("");	
	$(".info").html("");
	$("#info-bar").attr("finish", "false");
}

function setbutton() {
	$("li").click(function() {
						for (var i = 0; i < $("li").length; i++)
							if ($($("li")[i]).attr("iswaiting") == "true")
								return;
						if ($(this).attr("free") != "true")
								return;
						$(this).attr("havenum", "false");
						$(this).attr("iswaiting", "true");								
						$(this).find(".unread").show().fadeIn();
						$(this).addClass("hover").fadeIn();
						$(".info")[0].style.opacity = 0;
						getnum.call(this);
					});
	$("#button").mouseleave(function() {	
								reset();
							});
	$("#info-bar")[0].onclick = function() {
									var flag = true;
									$("li").each(function() {
													if ($(this).attr("havenum") == "false")
														flag = false;
												});
									if (flag) {
										$(".info")[0].style.opacity = 1;											
										getsum.call(this);									
									}
								};
	$(".apb")[0].onclick = function() {
									if ($(".apb").attr("isclicking") == "true")
										return;
									reset();
									$(".apb").attr("isclicking", "true");
									autoclick();
								};								
}

function getnum() {
	var that = this;
	var unread = $(that).find(".unread");
	
	unread.html("");
	var timer = setInterval(function() {	//等待数据
								var dot = unread.html();
								if ($(that).attr("iswaiting") == "false") {		//自校验,预判未来 
									clearInterval(timer);
									return;
								}
								if (dot.length >= 3)
									dot = "";
								else
									dot += ".";
								unread.html(dot);
							}, 500);
						
	$.get("/", function(data,status) {		//异步回调函数,预判未来
										if ($(that).attr("iswaiting") == "true") {
											$(that).attr("iswaiting", "false");	
											$(that).attr("havenum", "true");
											$(that).attr("free", "false");
											for (i = 0; i < $("li").length; i++)
												if ($($("li")[i]).attr("havenum")!="true")
													$($("li")[i]).removeClass("hover").fadeIn();
											clearInterval(timer);
											unread.html(data);
											setbutton();
										}
									});
}

function getsum() {
	var sum = 0;
	$(".unread").each(function() {
							sum += parseInt($(this).html());
						});	
	$(".info").html(sum);
	$(".apb").attr("isclicking", "false");
}


function autoclick() {
	var random = [];
	var string = "";
	var symbol = "ABCDE";
	while(random.length < 5) {
		var t = Math.round(Math.random()*4);
		var flag = true;
		for (var i = 0; i < random.length; i++)
			if (t==random[i])
				flag = false;
		if (flag) {
			random.push(t);
			string += symbol[t];
		}
	}
	$("#order").html(string);
	var timer = setInterval(function() {
		if ($($(".apb")[0]).attr("isclicking")=="false") {	//自校验,预判未来 
			clearInterval(timer);
			return;
		}
		var clicked = 0;	
		for (var i = 0; i < $("li").length; i++) {
			if ($($("li")[random[i]]).attr("havenum") == "false")
				$("li")[random[i]].click();
			else
				clicked++;
		}
		if (clicked == 5) {
			$("#info-bar")[0].click();
			$("#info-bar").attr("finish", "true");
			clearInterval(timer);
		}
	}, 666);
}
