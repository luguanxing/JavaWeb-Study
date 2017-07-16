
function check() {
    var username = $("#username").val();
    
    //定义ajax对象，包括类型，地址，数据，类型，回调方法等
    $.ajax({
        type : "POST",
        url : "AJAXXMLServer",
        data : "name=" + username, 
        dataType : "xml",
        success : dataCallback
    });
}

//成功时调用回调函数，利用jquery包装xml数据成dom并获取文本内容
function dataCallback(data) {
    var obj = $(data);
    var message = obj.children();
    var text = message.text();
    $("#result").html(text);
}
