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
	String style="display:none";
	if (request.getMethod().equals("POST")){
		bookinfo = new BookModel(request.getParameter("bookno"),request.getParameter("bookname"),request.getParameter("author"),request.getParameter("press"),request.getParameter("price"),request.getParameter("publishdate"),request.getParameter("shopnum"));
		querysql = bookinfo.getSqlQueryString1();
	} else {
		if (request.getParameter("bookno")!=null) {
			bookinfo = new BookModel(request.getParameter("bookno"));
			style="";
		}
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
			<form method="POST" name="form1">
				<fieldset>
				<legend>筛选模式（左栏信息可筛选）</legend>
				<p>图书编号：<input name="bookno" value="<%=bookinfo.bookno%>">
				<span class="right">价格：<input name="price" value="<%=bookinfo.price%>"></span></p>
				<p>图书名称：<input name="bookname" value="<%=bookinfo.bookname%>">
				<span class="right">出版日期：<input name="publishdate" value="<%=bookinfo.publishdate%>"></span></p>
				<p>作者：<input name="author" value="<%=bookinfo.author%>">
				<span class="right">入库数量：<input name="shopnum" value="<%=bookinfo.shopnum%>"></span></p>
				<p>出版社：<input name="press" value="<%=bookinfo.press%>"></p>
				<input type="button" value="查询" class="btn" onclick="search()" >
				<input type="button" value="添加" class="btn" onclick="add()">
				<input type="button" value="保存" class="btn" onclick="save()" style="<%=style %>" >
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
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<% for (Vector<String> row:BookTable.data) { %>
						<tr>
							<% for (String item:row) { %>
								<td><%=item %></td>
							<%}%>
							<td>
								<a href="?bookno=<%=row.get(0)%>">编辑</a> |
								<a href="api/bookdelete?bookno=<%=row.get(0)%>">删除</a>
							</td>
						</tr>
					<%}%>
				</tbody>
			</table>
		</div>
	</body>
	<script>
		function search(){
	        document.form1.action="bookmanager.jsp";
	        document.form1.submit();
		}
		function add() {
			document.form1.action="api/bookadd";
			document.form1.submit();
		}
		function save() {
			document.form1.action="api/bookedit";
			document.form1.submit();
		}
	</script>
	<script src="/static/jquery.min.js"></script>
</html>
