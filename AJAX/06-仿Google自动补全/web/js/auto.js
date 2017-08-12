var highlightIndex = -1;
var timeoutId = -1;

$(document).ready(function () {
	inputnode = $("#word");
	var inputOffset = $("#word").offset();
	highlightIndex = -1;
	$("#auto").hide()
		.css("position", "absolute")
		.css("border", "1px solid black")
		.css("left", inputOffset.left + 1 + "px")
		.css("top", inputOffset.top + inputnode.height() + 6 + "px")
		.width(inputnode.width());
	
	$("#word").keyup(function (event) {
		var myEvent = event || window.event;
		var keyCode = myEvent.keyCode;
		if ((65 <= keyCode && keyCode <= 90) || keyCode == 8 || keyCode == 46) {	//按下字母或退格
			var wordtext = $("#word").val();
			highlightIndex = -1;
			if (wordtext != '') {
				if (timeoutId != -1)
					clearTimeout(timeoutId);
				timeoutId  = setTimeout(function () {	//延迟500ms再交互，防止误操作
					$.post("AutoComplete", {word: wordtext}, function (data) {
						var json = $(data);
						var nodes = json.find("word");
						var root = $("#auto");
						root.html('');
						nodes.each(function (i) {
							var wordText = $(this).text();
							var newdiv = $('<div>').attr("id", "text"+i).addClass("text");
							newdiv.html(wordText).appendTo(root);
							newdiv.mouseover(function () {
								$(".text").css("background-color", "white").css("color", "black");
								highlightIndex = eval($(this).attr("id").substr(4));
								$(this).css("background-color", "black").css("color", "white");
							});
							newdiv.mouseout(function () {
								$(".text").css("background-color", "white").css("color", "black");
							});
							newdiv.click(function () {
								var comText = $(this).text();
								$("#auto").hide();
								highlightIndex = -1;
								$("#word").val(comText);
							});
						});
						if (nodes.length > 0) {
							$("#auto").show();
						} else {
							$("#auto").hide();
						}
					}, "xml");
				}, 500);
			} else {
				$("#auto").hide();
				highlightIndex = -1;
			}
		} else if (keyCode == 38 || keyCode == 40) {	//按下上下键
			if (keyCode == 38) {
				var nodes = $("#auto").children("div");
				if (highlightIndex != -1)
					nodes.css("background-color", "white").css("color", "black");
				if (--highlightIndex < 0)
					highlightIndex = nodes.length -1;
				nodes.eq(highlightIndex).css("background-color", "black").css("color", "white");
			} else {
				var nodes = $("#auto").children("div");
				if (highlightIndex != -1)
					nodes.css("background-color", "white").css("color", "black");
				if (++highlightIndex >= nodes.length)
					highlightIndex = 0;
				nodes.eq(highlightIndex).css("background-color", "black").css("color", "white");
			}
		} else if (keyCode == 13) {	//按下回车键
			if (highlightIndex != -1) {
				var comText = $("#auto").children("div").eq(highlightIndex).text();
				$("#auto").hide();
				highlightIndex = -1;
				$("#word").val(comText);
			} else {
				$("#submit").click();
			}
		}
	});

	$("#submit").click(function () {
		alert($("#word").val());
	});
})