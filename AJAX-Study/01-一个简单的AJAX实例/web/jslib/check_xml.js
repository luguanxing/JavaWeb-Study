//使用XMLHTTPRequest对象进行AJAX异步交互
var xmlhttp;
function  check_js_get() {
    //1.使用dom方法获取文本框值
    var username = document.getElementById('username').value;

    //2,创建XMLHTTPRequest对象，需要根据浏览器对象写不同代码
    if (window.XMLHttpRequest) {    //优先判断XMLHttpRequest
        //针对FireFox、Mozillar、Opera、Chrome、Safari、IE7、IE8等
        xmlhttp = new XMLHttpRequest();
        if (xmlhttp.overrideMimeType) {   //针对某些BUG修复
            xmlhttp.overrideMimeType("text/xml");
        }
    } else if (window.ActiveXObject) {
        //IE5、IE5.5、IE6已淘汰
        //常见XMLHTTPRequest对象的控件名称
        var activexName = ["MSXML2.XMLHHTP","Microsoft.XMLHTTP"];
        for (var i = 0; i < activexName.length; i++) {
            try {
                //取出控件名进行创建，创建失败则抛出异常
                xmlhttp = new ActiveXObject(activexName[i]);
                break;
            } catch (e) {

            }
        }
    }
    //确认XMLHTTPRequest对象创建成功
    if (xmlhttp) {
        alert("成功");
    } else {
        alert("失败");
    }

    //3.注册回调函数,若函数名后加括号变成返回值
    xmlhttp.onreadystatechange = callback;

    //4.设置链接信息，包括请求方式（get或post）、请求url地址、请求方式（同步或异步）
    //GET方式
    xmlhttp.open("GET", "AJAXXMLServer?name=" + username, true);

    //5.发送数据，和服务器端进行交互，参数若已用URL传递则send空值，同步方式会在此等到数据返回
    xmlhttp.send(null);
}

function check_js_post() {
    //1.使用dom方法获取文本框值
    var username = document.getElementById('username').value;

    //2,创建XMLHTTPRequest对象，需要根据浏览器对象写不同代码
    if (window.XMLHttpRequest) {    //优先判断XMLHttpRequest
        //针对FireFox、Mozillar、Opera、Chrome、Safari、IE7、IE8等
        xmlhttp = new XMLHttpRequest();
        if (xmlhttp.overrideMimeType) {   //针对某些BUG修复
            xmlhttp.overrideMimeType("text/xml");
        }
    } else if (window.ActiveXObject) {
        //IE5、IE5.5、IE6已淘汰
        //常见XMLHTTPRequest对象的控件名称
        var activexName = ["MSXML2.XMLHHTP","Microsoft.XMLHTTP"];
        for (var i = 0; i < activexName.length; i++) {
            try {
                //取出控件名进行创建，创建失败则抛出异常
                xmlhttp = new ActiveXObject(activexName[i]);
                break;
            } catch (e) {

            }
        }
    }
    //确认XMLHTTPRequest对象创建成功
    if (xmlhttp) {
        alert("成功");
    } else {
        alert("失败");
    }

    //3.注册回调函数,若函数名后加括号变成返回值
    xmlhttp.onreadystatechange = callback;

    //4.设置链接信息，包括请求方式（get或post）、请求url地址、请求方式（同步或异步）
    //POST方式,需要自己设置请求头和参数
    xmlhttp.open("POST", "AJAXXMLServer", true);
    xmlhttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");

    //5.发送数据，和服务器端进行交互，参数若已用URL传递则send空值，同步方式会在此等到数据返回
    xmlhttp.send("name=" + username);
}


//回调函数
function callback() {
    //6.接收响应数据，判断对象交互是否完成
    if (xmlhttp.readyState == 4) {
        //判断对象交互是否交互成功
        if (xmlhttp.status == 200) {
            //使用responseXML方式接收XML数据DOM对象，获取节点并显示
            var dom = xmlhttp.responseXML;
            var messageNodes = dom.getElementsByTagName("message");
            var text = messageNodes[0].firstChild.nodeValue;
            document.getElementById('result').innerHTML = text;

        }
    }
}
