<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="Book.borrowing.management.system.*"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>登录 - 图书借阅管理系统</title>
		<style>
			.btn{
		  		height: 30px;
		  	}
		</style>
	</head>

	<body>
		<div align="center">
			<h1>登录</h1>
			<form id="myform" method="post" action="api/login">
				<p>读者号：<input name="username" type="text"><br></p>
				<p>密码：<input name="password" type="password"><br></p>
				<p>
					<input type="submit" value="登录" class="btn"/>
					<input type="reset" value="重置" class="btn"/>
				</p>
			</form>
		</div>
	</body>
</html>