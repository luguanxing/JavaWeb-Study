//定义用户名的方法
function check() {
    //1.获取到文本框内容
    var username = $("#username").val();
    
    //2.将文本框数据发给指定Servlet
    $.get("AJAXServer?name=" + username, null, dataCallback);
    
}

function dataCallback(data) {
    //3.接收服务器端返回的数据
    console.log("data = " + data)
    
    //4.将返回的数据动态显示到页面上
    $("#result").html(data);
}

//简略写法
function check_simple() {
    $.get("AJAXServer?name=" + $("#username").val(), null, function (data) {
        $("#result").html(data);
    });
}