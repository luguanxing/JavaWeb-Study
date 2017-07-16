
function check() {
    var url = "AJAXCacheServer?name=" + $("#username").val();
    url = addTime(url);
    $.get(url, null, dataCallback);
}

function dataCallback(data) {
    console.log("data = " + data)
    $("#result").html(data);
}

//加上时间戳避免读缓冲
function addTime(url) {
    var timestamp = (new Date()).valueOf();
    if (url.indexOf("?") >= 0) {
        url = url + "&t=" + timestamp;
    } else {
        url = url + "?t=" + timestamp;
    }
    return url;
}
