//期望进入页面后就可以开始从服务器获取数据显示股票价格
var json;
var sid;

$(document).ready(function () {
	//部署鼠标进入离开时显示和隐藏的信息框
	var nodes_stock = $("#stock")
		.css("border", "1px solid black")
		.width('100px')
		.css("background-color", "yellow")
		.css("color", "blue")
		.css("position", "absolute").
		css("z-index", "120");
	var nodes_a = $("a");
	nodes_stock.hide();
	nodes_a.mouseover(function (event) {
		var node_a = $(this);
		var div = node_a.parent();
		sid = div.attr("order");
		UpdateHintDiv();	//获取最新数据后更新提示框信息
		var myEvent = event || window.event;		//移到鼠标右下方
		nodes_stock.css("left", myEvent.clientX + "px");
		nodes_stock.css("top", myEvent.clientY + 10 + "px");
		nodes_stock.show();
	});
	nodes_a.mouseout(function () {
		nodes_stock.hide();
	});
	
	//进入页面立刻显示信息
	GetInfoAndShow();
	
	//设置定时访问并显示
	setInterval(GetInfoAndShow, 1000);
})

function GetInfoAndShow() {
	$.get("GetStockInfo", null, function (data) {
		json = JSON.parse(data);
		var szzs = json["stocks"][0];
		var pfyh = json["stocks"][1];

		var span_szzs = $("#300001").children("span").html(szzs.now);
		var span_pfyh = $("#000001").children("span").html(pfyh.now);
		
		if (szzs.now > szzs.yes) {
			span_szzs.css("color", "red");
		} else {
			span_szzs.css("color", "green");
		}

		if (pfyh.now > pfyh.yes) {
			span_pfyh.css("color", "red");
		} else {
			span_pfyh.css("color", "green");
		}

		UpdateHintDiv();	//获取最新数据后更新提示框信息
	});
}

function UpdateHintDiv() {
	if (json != undefined && sid != undefined) {
		var stock = json["stocks"][sid];
		for (var attrname in stock) {
			if (attrname != "name") {
				$("#"+attrname).children("span").html(stock[attrname]);
			}
		}
	}
}
