<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String basePath = "ws://"+request.getServerName()+":"+request.getServerPort();//远程ip地址
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<script src="/static/jquery.min.js"></script>
<script>
	var websocket = null;
	function connect(basepath) {
		//判断当前浏览器是否支持WebSocket
		if ('WebSocket' in window) {
			var url=basepath+'/WebSocket';
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
	    	setMessage("连接成功!");
	    }
	
	    //接收到消息的回调方法
	    websocket.onmessage = function (event) {
	    	$("#textarea").val(event.data);
	    	//$("#footer").val(event.data);
	    }
	
	    //连接关闭的回调方法
	    websocket.onclose = function () {
	    	setMessage("WebSocket连接关闭");
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
	
	function sendMessage(){
		  var message = document.getElementById("sendmessage");
	      websocket.send(message.value);
	      //$('#sendmessage').value = "";
	      //setMessage(message.value);
	      message.value = "";
	}
	
	function setMessage(val) {
	    document.getElementById('message').value = val;
	}
</script>
<body>
	<h1>WebsocketTest</h1>
	<span>
		要发送的信息：
		<input type="text" id="sendmessage">
		<br><br>
		收到的消息：
		<textarea id="textarea" name="textarea" rows="5" cols="30"></textarea>
		<br><br>
		WebSocket当前状态：
		<input type="text" id="message">
		<br><br>
	</span>
	<span>
		<input type="button" value="连接" onclick="connect('<%=basePath%>');">
		<input type="button" value="断开" onclick="closeWebSocket();">
		<input type="button" value="发送" onclick="sendMessage();">
	</span>
	
</body>
</html>