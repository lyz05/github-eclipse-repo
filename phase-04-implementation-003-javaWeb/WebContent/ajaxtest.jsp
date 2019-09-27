<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="sdlc.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script>
	function register()
	{
		var mobile = document.getElementById("mobile").value;
		alert(mobile);
		//通过ajax异步刷新
		xmlHttprequest = new XMLHttpRequest();
		//设置xmlHttprequest对象的回调函数
		xmlHttprequest.onreadystatechange = callBack;
		xmlHttprequest.open("post","Servlettest",true);
		//设置post方式头信息
		xmlHttprequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		xmlHttprequest.send("mobile="+mobile);//k=v
	}
	//定义回调函数（接收返回值）
	function callBack()
	{
		//alert(xmlHttprequest.State);
		if (xmlHttprequest.readyState == 4 && xmlHttprequest.status == 200)
		{
			var data = xmlHttprequest.responseText;
			if (data=="true")
			{
				alert("该号码已存在，请更换");	
			} else 
			{
				alert("注册成功");
			}
		}
	}
</script>

<title>Insert title here</title>
</head>
<body>
		手机：<input id="mobile" />
		<br/>
		<input type="button" value="注册" onclick="register();" /> 
</body>
</html>