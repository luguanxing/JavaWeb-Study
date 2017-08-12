window.onload = function() {
	reset();
	setbutton();
}

function reset() {
	$(".unread").hide().fadeOut();
	$(".hover").removeClass("hover").fadeIn();
	$("li").attr("iswaiting", "false");
	$("li").attr("havenum", "false");
	$("li").attr("free", "true");	
	$(".info")[0].style.opacity = 0;
	$(".info").html("");	
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
						$("li").addClass("hover").fadeIn();
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
}
