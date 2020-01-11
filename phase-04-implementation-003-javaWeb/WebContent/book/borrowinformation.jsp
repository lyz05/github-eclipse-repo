<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="Book.borrowing.management.system.*"%>
<%@page import="java.util.*"%>
<%	String username=null;
	if(session.getAttribute("username") != null){ 	
		username = session.getAttribute("username").toString();
	} else {
%>
	<script>
		alert("非法登录！");
		window.location.href='index.jsp'
	</script>
<%} %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>借阅信息 - 图书借阅管理系统</title>
</head>

<body>
	<p>
		您好，<%=BookDBCon.preparedqueryResult("select readerName from Reader where readerNO=?",username)%>
	</p>
	<% String appendsql="";
	Vector<Vector<String>> data = new Vector<Vector<String>>();
	Vector<String> name = new Vector<String>();
	BookDBCon.queryVector2("select 图书编号,图书名称,作者,出版社,借书时间,应归还日期,归还日期 from View_Borrow where 读者编号='"+ username + "' and 归还日期 is null"+appendsql, data, name);
	%>
	<table border="1">
	<tr>
		<% for (String item:name) { %>
			<th><%=item %></th>
		<%}
		%>
	</tr>
		<% for (Vector<String> row:data) { %>
			<tr>
				<% for (String item:row) { %>
					<td><%=item %></td>
				<%}%>
			</tr>
		<%}%>
	</table>
</body>
<script src="/static/jquery.min.js"></script>
</html>