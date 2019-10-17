
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%  String wsprotol;
	if (request.isSecure()) wsprotol = "wss"; else wsprotol = "ws"; 
	String basePath = wsprotol +"://"+request.getServerName()+":"+request.getServerPort();//远程ip地址
	String username = new String(session.getAttribute("userName").toString().getBytes("iso-8859-1"),"utf-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="/static/css/style.css" />
<script src="/static/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript">
	function setReceiver(obj) {
		document.getElementById("reply-to").innerHTML = "接收人：" + obj.innerHTML;
	}
</script>
</head>
<body>
	<div class="top">
		<br>
		<h1>聊天室</h1>
	</div>
	
	<div id="chat-room">
		<div class="lefter">
			<h2>在线用户列表</h2>
			<ul id="userlist">
 
			</ul>
		</div>
		<div class="righter">
			<div id="history">
			
			</div>
			<div class="spacer"></div>
			<span>当前用户：<%=username%></span> <div id="reply-to">接收人：所有</div> 当前状态：<span id="message"></span>
			<div class="reply">
				   <input type="text" class="text" id="sendmessage" name="content" onkeydown="okd();"/>
				   <input type="button" id="sendbtn" value="发送" onclick="send();" disabled="disabled"/>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		//setInterval("getuser()", 500)
		function getuser() {
			$.ajax({
				type:'get',
				url:'RoomUser',
				async:false,
				error:function(data){
					alert('更新用户列表发生错误');
				},
				success:function(data){
					$('#userlist').html(data);
				}
				
			});
		}
		
		 var websocket = null;
		    //判断当前浏览器是否支持WebSocket
		    if ('WebSocket' in window) {
		        websocket = new WebSocket("<%=basePath %>/websocket/chat?username=<%=username%>");
		    }
		    else {
		        alert('当前浏览器不支持websocket');
		    }
 
		    //连接发生错误的回调方法
		    websocket.onerror = function () {
		        setMessageInnerHTML("WebSocket连接发生错误");
		        document.getElementById("sendbtn").disabled = true;
		    };
 
		    //连接成功建立的回调方法
		    websocket.onopen = function () {
		        setMessageInnerHTML("连接成功，可以开始聊天了");
		        document.getElementById("sendbtn").disabled = false;
		    }
 
		    //连接关闭的回调方法
		    websocket.onclose = function () {
		        setMessageInnerHTML("WebSocket连接关闭");
		        document.getElementById("sendbtn").disabled = true;
		    }

		    
		    //接收到消息的回调方法
		    websocket.onmessage = function (event) {
		    	if (event.data=="<flush>")				//收到刷新用户信息消息
		    	{
		    		getuser();
		    		return;
		    	}
		    	document.getElementById('history').innerHTML+= "<p style='float:left'>"+event.data+"</p></br>";
		    }
 
		    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
		    window.onbeforeunload = function () {
		        closeWebSocket();
		    }
 
		    //将消息显示在网页上
		    function setMessageInnerHTML(innerHTML) {
		        document.getElementById('message').innerHTML = innerHTML + '<br/>';
		    }
 
		    //关闭WebSocket连接
		    function closeWebSocket() {
		        websocket.close();
		    }
		    
		    function send(){
		    	  var message = document.getElementById('sendmessage').value;
		    	  document.getElementById('sendmessage').value="";
		    	  if (message=="<flush>") {
		    		  alert("非法关键字！无法发送！");
		    		  return;
		    	  }
		          websocket.send(message);
		          document.getElementById('history').innerHTML+= "<p style='float:right'>我说:"+message+"</p></br>";
		    }
		    function okd(){
		    	if (event.keyCode == 13){
		    		send();
		    	}
		    }
	</script>
</body>
</html>