<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="sdlc.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script type="text/javascript" src="static/jquery.min.js" ></script>

<script>
	function register()
	{
		var $mobile = $("#mobile").val();
		alert($mobile);
		$.ajax({
			url: "Servlettest",
			type: "post",
			data: "mobile="+$mobile,
			success:function(result,testStatus)
			{
				if (result=="true")
					alert("此号码已存在");
				else alert("注册成功");
			},
			error:function(xhr,errorMessage,e)
			{
				alert("系统异常");
			}
		});
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