window.onload = function() {
	reset();
	setbutton();
}

function error(msg, sum) {
	this.msg = msg;
	this.sum = sum;
}

function reset() {
	$(".apb").attr("isclicking", "false");
	$(".apb").attr("value", "0");
	$(".apb").attr("random", "0");
	$(".unread").hide().fadeOut();
	$(".hover").removeClass("hover").fadeIn();
	$("li").attr("iswaiting", "false");
	$("li").attr("havenum", "false");
	$("li").attr("free", "true");
	$(".info")[0].style.opacity = 0;
	$(".info").html("");
	$("#order").html("");
	$("#hint").html("");
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
										bubbleHandler();
									}
								};
	$(".apb")[0].onclick = function() {
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
}


function autoclick() {

	var hintstrings = ["这是一个天大的秘密", "我不知道", "你不知道", "他不知道", "才怪"];
    var handles = [aHandler, bHandler, cHandler, dHandler, eHandler];
	var random = [];
	var string = "";
	var symbol = "ABCDE";
	while(random.length < 5) {
		var t = Math.round(Math.random()*4);
		var flag = true;
		for (var i = 0; i < random.length; i++)
			if (t==random[i])
				flag = false;
		if (flag) {	//生成随机
			random.push(t);
			string += symbol[t];
		}
	}
	$("#order").html(string);
	
	$(".apb").attr("value", 0);
	$(".apb").attr("random", random);
	var timer = setInterval(function() {
		var i = parseInt($(".apb").attr("value"));
		var random = $(".apb").attr("random").split(",");
		if (i >= 5 || $(".apb").attr("isclicking") != "true") {
			clearInterval(timer);
			return;
		}
		for (var j = 0; j < $("li").length; j++)
			if ($($("li")[j]).attr("iswaiting") == "true")
				return;		
		$($("li")[parseInt(random[i])]).find(".unread").html("...").show();
		$($("li")[parseInt(random[i])]).attr("iswaiting", "true");
		$($("li")[parseInt(random[i])]).addClass("hover");
		
		(function(i) {
			var check = $.get("/", function(data,status) {		//异步回调函数,预判未来
										if ($($("li")[i]).hasClass("hover") != true) {
											check.abort();
											return;									
										}
										$($("li")[i]).find(".unread").html(data);
										$($("li")[i]).attr("iswaiting", "false");									
										$($("li")[i]).attr("havenum", "true");
										$($("li")[i]).attr("free", "true");
										$($("li")[i]).addClass("hover");
										
										$("#info-bar")[0].click();
										
										var noerror = true;
										try {
											handles[i]();
										} catch (error) {
											$("#hint").html(error.msg);
											noerror = false;
										}
										if (noerror)
											$("#hint").html(hintstrings[i]);
							});
		})(parseInt(random[i]));
		i++;
		$(".apb").attr("value", i);
	}, 2222);
}

function aHandler() {
    if (Math.random() > 0.5)
        throw new error("<span>这不是一个地小的秘密</span>");		
}
function bHandler() {
    if (Math.random() > 0.5)
        throw new error("<span>我知道</span>");			
}
function cHandler() {
    if (Math.random() > 0.5)
        throw new error("<span>你知道</span>");	
}
function dHandler() {
    if (Math.random() > 0.5)
        throw new error("<span>他知道</span>");	
}
function eHandler() {
    if (Math.random() > 0.5)
        throw new error("<span>才不怪</span>");		
}

function bubbleHandler() {
	$("li").unbind("click");	
	setTimeout(function() {
		$("#hint").html("楼猪异步战斗力感人，目测不超过");
		$(".info")[0].style.opacity = 1;											
		getsum.call(this);
	},1500);	
}
