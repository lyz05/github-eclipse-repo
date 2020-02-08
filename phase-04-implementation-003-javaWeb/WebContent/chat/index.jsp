<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>聊天室登陆页面</title>
</head>
<body>
<%
	if( request.getMethod().equals("POST") ){
		String userName = request.getParameter("name");		//从post表单中获取数据
		if (userName != null && userName != "") {
			 session.setAttribute("userName", userName);
			 response.sendRedirect("Chat-room.jsp");
		}else {
%>
			<script>
			alert("姓名不能为空");
			</script>
<%
		}
	}
%>
	<div align="center">
		<%

		%>
		<h1>聊天室登录</h1>
		<form id="myform" action="index.jsp" method="post">
			姓名：<input id="name" name="name" type="text" />
			<input type="submit" value="开始聊天"/>
		</form>
	</div>

</body>
</html>
