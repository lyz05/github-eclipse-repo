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
		<!-- bootstrap样式 -->
		<link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- 自定义样式 -->
		<link rel="stylesheet" href="css/style.css">
	</head>

	<body>
		<div class="header">
			<p>
				您好，管理员：<%=username%>
				<span class="right">
					<a href="api/logout">注销</a>
				</span>
			</p>
		</div>

		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">
					筛选模式（左栏信息可筛选）
				</h3>
			</div>
			<div class="panel-body">
				<form method="POST" name="form1" id="form1">
					<p>
					<label>图书编号：</label>
					<input name="bookno" value="<%=bookinfo.bookno%>">
					<span class="right">
					<label>价格：</label>
					<input name="price" value="<%=bookinfo.price%>"></span>
					</p>
					<p>
					<label>图书名称：</label>
					<input name="bookname" value="<%=bookinfo.bookname%>">
					<span class="right">
					<label>出版日期：</label>
					<input name="publishdate" value="<%=bookinfo.publishdate%>"></span>
					</p>
					<p>
					<label>作者：</label>
					<input name="author" value="<%=bookinfo.author%>">
					<span class="right">
					<label>入库数量：</label>
					<input name="shopnum" value="<%=bookinfo.shopnum%>"></span>
					</p>
					<p>
					<label>出版社：</label>
					<input name="press" value="<%=bookinfo.press%>">
					</p>
					<input type="button" value="查询" class="btn btn-primary" onclick="search()" >
					<input type="button" value="添加" class="btn" onclick="add()">
					<input type="button" value="保存" class="btn" onclick="save()" style="<%=style %>" >
				</form>
			</div>
		</div>

		<div id="tabs">
			<table class="table table-striped table-bordered table-hover">
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
								<a href="javascript:del('<%=row.get(0)%>')">删除</a>
							</td>
						</tr>
					<%}%>
				</tbody>
			</table>
		</div>
		
	</body>
	<script>
	//发送ajax请求，成功刷新当前页面
		function ajaxRequest(type, url, data) {
	        $.ajax({
				url: url,
				type: type,
				dataType: "json",
				data: data,
				success:function(result,testStatus)
				{
					alert(result.message);
					if (result.code=="200"){
						window.location.href = window.location.pathname;
					}
					if (result.code=="601") {
						window.location.href='./';
					}
				},
				error:function(xhr,errorMessage,e)
				{
					alert("发送请求失败，请检查网络状态");
				}
			});
		}
		function search(){
	        document.form1.action="bookmanager.jsp";
	        document.form1.submit();
		}
		function add()
		{
			ajaxRequest("post","api/bookadd",$('#form1').serialize());
		}
		function del(bookno){
	        ajaxRequest("get","api/bookdelete","bookno="+bookno);
		}
		function save() {
	        ajaxRequest("post","api/bookedit",$('#form1').serialize());
		}
	</script>
	<script src="/static/jquery.min.js"></script>
</html>
