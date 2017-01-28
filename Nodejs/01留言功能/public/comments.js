var comment = {
	'text':"",
	'name': ""
};
var num;

window.onload = function() {
	$("#summit")[0].onclick = function() {
		if (checkformat()) {
			$.post('/comment', comment, function(data) {
				if (data.toString() == "success") {
					alert("评论成功");
					window.location="/comments.html";
				}
				else
					$("#hints").html(data);
			})
		}
	};
	
	$.get("comments",function(data,status){
		var datas = JSON.parse(data);
		var comments = datas["comments"];
		num = comments.length;
		for (var i = 0; i < num; i++) {
			var parentdiv=$('<div></div>');     
			parentdiv.addClass('guest');  
			var childdiv=$('<div></div>');    
			childdiv.addClass('guestcommit');  
			childdiv.appendTo(parentdiv);
			childdiv.html(comments[i]["text"]);
			var childdiv2=$('<div></div>');    
			childdiv2.addClass('guestname');    
			childdiv2.appendTo(parentdiv);  
			childdiv2.html("——"+comments[i]["name"]);			
			parentdiv.appendTo('#comments');     
		}
		//$("#comments").html(data);
	});
}

function checkformat() {
	var text = $("#comment").val();
	if (text == "" || text.length > 200) {
		$("#hints").html("You should leave a correct comment...");
		return false;
	}
	
	var name = $("#name").val();
	if (name == "" || name.length > 30) {
		$("#hints").html("You should leave a correct name...");
		return false;
	}
	
	comment['text'] = text;
	comment['name'] = name;
	return true;
}