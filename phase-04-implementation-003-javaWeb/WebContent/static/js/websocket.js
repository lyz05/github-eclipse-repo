var websocket = null;
function connect() {
	//判断当前浏览器是否支持WebSocket
	if ('WebSocket' in window) {
		if (location.protocol == 'https:')
			wsprotol = "wss";
		else 
			wsprotol = "ws";
		port = location.port;
		if (port!="") port = ":"+port;
		var url = wsprotol+"://"+location.hostname+port+location.pathname+"WebSocket";
		//alert(url);
		websocket = new WebSocket(url);
	} else {
		alert("Not Support Websocket!");
	}
	//连接发生错误的回调方法
    websocket.onerror = function () {
    	alert("WebSocket连接发生错误");
    };

    //连接成功建立的回调方法
    websocket.onopen = function () {
    }

    //接收到消息的回调方法
    websocket.onmessage = function (event) {
    	//$("#textarea").val(event.data);
    	$("#footer").html(event.data);
    }

    //连接关闭的回调方法
    websocket.onclose = function () {
    }

    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
    window.onbeforeunload = function () {
        closeWebSocket();
    }

}

//关闭WebSocket连接
function closeWebSocket() {
    websocket.close();
}