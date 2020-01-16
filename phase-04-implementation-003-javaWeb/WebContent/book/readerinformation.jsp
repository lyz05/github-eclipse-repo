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
	ReaderModel readerinfo = new ReaderModel();
	String style="display:none";
	if (request.getMethod().equals("POST")){
		readerinfo = new ReaderModel(request.getParameter("readerno"),request.getParameter("readername"),request.getParameter("sex"),request.getParameter("idnum"),request.getParameter("workunit"));
		querysql = readerinfo.getSqlQueryString();
	} else {
		if (request.getParameter("readerno")!=null) {
			readerinfo = new ReaderModel(request.getParameter("readerno"));
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
	TableModel BookTable = new TableModel("select * from View_Reader "+querysql+appendsql);
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>读者信息管理 - 图书借阅管理系统</title>
		<!-- bootstrap样式 -->
		<link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css">
		<meta name="viewport" content="width=device-width, initial-scale=1">
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
					筛选模式
				</h3>
			</div>
			<div class="panel-body">
				<form method="POST" name="form1" action="readerinformation.jsp">
					<p><label>读者编号：</label><input name="readerno" value="<%=readerinfo.readerno%>">
					<span class="right"><label>身份证号：</label><input name="idnum" value="<%=readerinfo.idnum%>"></span></p>
					<p><label>姓名：</label><input name="readername" value="<%=readerinfo.readername%>">
					<span class="right"><label>工作单位：</label><input name="workunit" value="<%=readerinfo.workunit%>"></span></p>
					<p><label>性别：</label><input name="sex" value="<%=readerinfo.sex%>"></p>
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
								<a href="?readerno=<%=row.get(0)%>">编辑</a> |
								<a href="api/readerdelete?readerno=<%=row.get(0)%>">删除</a> |
								<a href="api/readerresetpwd?readerno=<%=row.get(0)%>">重置读者密码</a>
							</td>
						</tr>
					<%}%>
				</tbody>
			</table>
		</div>
	</body>
		<script>
		function search(){
	        document.form1.action="readerinformation.jsp";
	        document.form1.submit();
		}
		function add() {
			document.form1.action="api/readeradd";
			document.form1.submit();
		}
		function save() {
			document.form1.action="api/readeredit";
			document.form1.submit();
		}
	</script>
</html>
