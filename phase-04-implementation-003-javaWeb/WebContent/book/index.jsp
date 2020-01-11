<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="Book.borrowing.management.system.*"%>
<%	if(request.getMethod().equals("POST")){
        String username = request.getParameter("username");
        String pwd = request.getParameter("password");
        pwd = Util4Frm.encodeInp(pwd);
		//System.out.println(username+"\t"+pwd);
		
        if (BookDBCon.preparedqueryResult("select readerNO from Reader where readerNo=? and password=?", username,pwd) != null) {
        	session.setAttribute("username", username);
        	//进入到主界面
			//response.getWriter().append("<script>alert('读者登录成功')</script>");
        	response.sendRedirect("borrowinformation.jsp");
        }else if (BookDBCon.preparedqueryResult("select username from AdminUsers where username=? and password=?", username,pwd) != null){
        	session.setAttribute("username", username);
        	//进入到管理员选择界面后跳转到指定页面
            response.getWriter().print("<script>var res=confirm('您好，管理员\\n确定 进入图书管理界面\\n取消 进入读者管理界面');\nif(res==true)\nwindow.location.href='bookmanager.jsp';\n else window.location.href='readerinformation.jsp';</script>");
        } else response.getWriter().append("<script>alert('用户名或密码错误')</script>");

	}
%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>登录 - 图书借阅管理系统</title>
</head>

<body>
	<div align="center">
		<h1>登录</h1>
		<form id="myform" action="index.jsp" method="post">
			<p>读者号：<input name="username" type="text"><br></p>
			<p>密码：<input name="password" type="password"><br></p>
			<p>
				<input type="submit" value="登录"/>
				<input type="reset" value="重置" />
			</p>
		</form>
	</div>
</body>
<script src="/static/jquery.min.js"></script>
</html>