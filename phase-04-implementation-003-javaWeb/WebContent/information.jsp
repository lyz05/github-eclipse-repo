<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ page  import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Insert title here</title>
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
            

        <h1>姓名:<%=username %></h1>
        <h1>密码:<%=password %></h1>
        <h1>性别:<%=sex %></h1>
        <h1>兴趣:</h1>
        <% if(inst!=null) {%>
        <% System.out.println(inst.length); %>
        <%for(int i=0;i<inst.length;i ++){ %>    
        <h1><%=inst[i]%></h1>
        <%} }%>
        <h1>出生日期:<%=date %></h1>
        <h1>电子邮箱:<%=email %></h1>
        <h1>个人简介:<%=textarea %></h1>
    </body>
</html>