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
            	Util4Frm.showMessageDialogAndReturn(response, "修改密码成功", "borrowinformation.jsp");
            } else{
            	Util4Frm.showMessageDialogAndReturn(response, "修改密码失败", "borrowinformation.jsp");
            }
        } else {
        	Util4Frm.showMessageDialogAndReturn(response, "用户名或原密码错误", "");
        }
	}
%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>修改密码 - 图书借阅管理系统</title>
	<!-- bootstrap样式 -->
	<link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css">
	<meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body>
	<div align="center">
		<h1>修改密码</h1>
		<form id="myform" action="alterpassword.jsp" method="post">
			<p><label>读者号：</label><input name="username" type="text" value="<%=request.getParameter("username")%>"><br></p>
			<p><label>旧密码：</label><input name="pwd" type="password"><br></p>
			<p><label>新密码：</label><input name="newpwd" type="password"><br></p>
			<p><input type="submit" value="修改密码" class="btn btn-primary"/></p>
		</form>
	</div>
</body>
</html>