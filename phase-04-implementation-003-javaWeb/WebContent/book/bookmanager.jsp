<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="Book.borrowing.management.system.*"%>
<%@page import="Book.borrowing.management.system.model.*"%>
<%@page import="java.util.*"%>
<%	String username=null;
	if(session.getAttribute("username") != null){ 	
		username = session.getAttribute("username").toString();
	} else {
%>
	<script>
		alert("非法操作！");
		window.location.href='index.jsp'
	</script>
<%	return;
	} 
%>
<%
	request.setCharacterEncoding("UTF-8"); 
	String querysql = new String();
	BookModel bookinfo = new BookModel();
	if (request.getMethod().equals("POST")){
		bookinfo = new BookModel(request.getParameter("bookno"),request.getParameter("bookname"),request.getParameter("author"),request.getParameter("press"),request.getParameter("price"),request.getParameter("publishdate"),request.getParameter("shopnum"));
		querysql = bookinfo.getSqlQueryString1();
	}
%>
<%
	request.setCharacterEncoding("UTF-8");
	String orderby=new String("");
	String appendsql = new String("");
	if (request.getParameter("orderby")!=null) {
		orderby = new String(request.getParameter("orderby").getBytes("iso-8859-1"), "utf-8");
		if (session.getAttribute("sort")==null || session.getAttribute("sort").toString().equals(""))
		{
		session.setAttribute("sort", "desc");
		} else session.setAttribute("sort", "");
		appendsql = " order by "+orderby+" "+session.getAttribute("sort");
	}
	TableModel BookTable = new TableModel("select * from View_Book_Admin "+querysql+appendsql);
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>图书信息管理 - 图书借阅管理系统</title>
		<link rel="stylesheet" href="css/style.css">
	</head>

	<body>
		<div class="header">
			<p>
				您好，<%=username%>
				<span class="right">
					<a href="api/logout">注销</a>
				</span>
			</p>
		</div>

		<div class="screen">
			<form method="POST" action="bookmanager.jsp">
				<fieldset>
				<legend>筛选模式（左栏信息可筛选）</legend>
				<p>图书编号：<input name="bookno" value="<%=bookinfo.bookno%>">
				<span class="right">价格：<input name="price" value="<%=bookinfo.price%>"></span></p>
				<p>图书名称：<input name="bookname" value="<%=bookinfo.bookname%>">
				<span class="right">出版日期：<input name="publishdate" value="<%=bookinfo.publishdate%>"></span></p>
				<p>作者：<input name="author" value="<%=bookinfo.author%>">
				<span class="right">入库数量：<input name="shopnum" value="<%=bookinfo.shopnum%>"></span></p>
				<p>出版社：<input name="press" value="<%=bookinfo.press%>"></p>
				<input type="submit" value="查询" class="btn"> 
				</fieldset>
			</form>
		</div>

		<div id="tabs">
			<table border="1">
			  	<thead>
					<tr>
						<% for (String item:BookTable.name) { %>
							<th><a href="?orderby=<%=item %>"><%=item %></a></th>
						<%}
						%>
					</tr>
				</thead>
				<tbody>
					<% for (Vector<String> row:BookTable.data) { %>
						<tr>
							<% for (String item:row) { %>
								<td><%=item %></td>
							<%}%>
						</tr>
					<%}%>
				</tbody>
			</table>
		</div>
	</body>
	
</html>
