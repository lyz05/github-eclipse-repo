<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ page  import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Show information</title>
    </head>
    <body>
        <%
            request.setCharacterEncoding("UTF-8");//设置统一字符编码
            
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String sex = request.getParameter("sex");
            String inst [] = request.getParameterValues("inst");    
            String date = request.getParameter("date");
            String email = request.getParameter("email");
            String textarea = request.getParameter("textarea");
        %>
            
	<div align="center">
	<h1>信息采集结果</h1>
        	姓名:<%=username %><br>
        	密码:<%=password %><br>
        	性别:<%=sex %><br>
        	兴趣:<br>
        <% if(inst!=null) {%>
        <% System.out.println(inst.length); %>
        <%for(int i=0;i<inst.length;i ++){ %>    
        <%=inst[i]%><br>
        <%} }%>
        	出生日期:<%=date %><br>
        	电子邮箱:<%=email %><br>
        	个人简介:<%=textarea %><br>
     </div>
    </body>
</html>