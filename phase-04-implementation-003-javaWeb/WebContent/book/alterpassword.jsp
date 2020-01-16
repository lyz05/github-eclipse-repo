<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="Book.borrowing.management.system.*"%>
<%	
	if(request.getMethod().equals("POST")){
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        String newpwd = request.getParameter("newpwd");
        pwd = Util4Frm.encodeInp(pwd);
        newpwd = Util4Frm.encodeInp(newpwd);
        
        if (BookDBCon.preparedqueryResult("select readerNO from Reader where readerNo=? and password=?", username,pwd) != null) {
            if (BookDBCon.preparedupdateData("update Reader set password=? where readerNo=?",newpwd,username)) {
            	response.getWriter().append("<script>alert('修改密码成功');window.history.go(-2);</script>");
            } else{
            	response.getWriter().append("<script>alert('修改密码失败');</script>");
            }
        } else {
        	response.getWriter().append("<script>alert('用户名或原密码错误');</script>");
        }
	}
%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>修改密码 - 图书借阅管理系统</title>
</head>

<body>
	<div align="center">
		<h1>修改密码</h1>
		<form id="myform" action="alterpassword.jsp" method="post">
			<p>读者号：<input name="username" type="text" value="<%=request.getParameter("username")%>"><br></p>
			<p>旧密码：<input name="pwd" type="password"><br></p>
			<p>新密码：<input name="newpwd" type="password"><br></p>
			<p><input type="submit" value="修改密码"/></p>
		</form>
	</div>
</body>
</html>