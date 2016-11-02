
window.onload = function() {
	$("th").append("<div class=\"icon\"><\/div>");	//����ͼ��
	$("th").attr("flag", "false");	//���õ�����
	$("table").find("th").click(sort);	//���������¼�
}

function sort() {
	sortrow.call(this); //����
	seticon.call(this);	//��ͼ��	
}

function sortrow() {
	var index = $(this).index();
	var tbody = $(this).parentsUntil("body").find("tbody");
	var trs = tbody.find("tr");
	var that = this;
	trs.sort(function (trA, trB) {
				var text1 = trA.cells[index].textContent;
				var text2 = trB.cells[index].textContent;
				if ($(that).attr("flag")=="false")
					return text1.localeCompare(text2);
				else
					return text2.localeCompare(text1);
			});
	tbody.append(trs);
}

function seticon() {
	$(".ascend").removeClass("ascend");	
	$(".descend").removeClass("descend");	
	$("th").not($(this)).removeClass("chosen");
	$("th").not($(this)).attr("flag", "false");
	if ($(this).attr("flag")=="false") {
		$(this).find(".icon").removeClass("descend");		
		$(this).find(".icon").addClass("ascend");
		$(this).attr("flag", "true");
	} else {
		$(this).find(".icon").removeClass("ascend");
		$(this).find(".icon").addClass("descend");
		$(this).attr("flag", "false");
	}
	$(this).addClass("chosen").fadeIn();
}
