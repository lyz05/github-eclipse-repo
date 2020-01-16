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
		boolean check;
		if ("on".equals(request.getParameter("check"))) check=true; else check=false;
		bookinfo = new BookModel(request.getParameter("bookno"),request.getParameter("bookname"),request.getParameter("author"),request.getParameter("press"),request.getParameter("publishdate_1"),request.getParameter("publishdate_2"),check,username);
		querysql = bookinfo.getSqlQueryString();
	}
%>
<%
	request.setCharacterEncoding("UTF-8");
	int tabs=0;
	String orderby=new String();
	if (request.getParameter("tabs")!=null && request.getParameter("orderby")!=null) {
		tabs = Integer.parseInt(request.getParameter("tabs"));
		orderby = new String(request.getParameter("orderby").getBytes("iso-8859-1"), "utf-8");
	}
	String[] appendsql = new String[]{"","","",""};
	if (session.getAttribute("sort")==null || session.getAttribute("sort").toString().equals(""))
	{
		session.setAttribute("sort", "desc");
	} else session.setAttribute("sort", "");
	appendsql[tabs] = " order by "+orderby+" "+session.getAttribute("sort");
	TableModel BorrowTable = new TableModel("select 图书编号,图书名称,作者,出版社,借书时间,应归还日期,归还日期 from View_Borrow where 读者编号='"+ username + "' and 归还日期 is null"+appendsql[1]);
	TableModel BorrowHistoryTable = new TableModel("select 图书编号,图书名称,作者,出版社,借书时间,应归还日期,归还日期 from View_Borrow where 读者编号='"+ username + "' and 归还日期 is not null"+appendsql[2]);
	TableModel BookTable = new TableModel("select * from View_Book "+querysql+appendsql[3]);
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>借阅信息 - 图书借阅管理系统</title>
		<!-- bootstrap样式 -->
		<link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- 自定义样式 -->
		<link rel="stylesheet" href="css/style.css">
		
		<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
	    <script src="/static/jquery.min.js"></script>
	    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
	    <script src="/static/bootstrap/js/bootstrap.min.js"></script>
	    
		<!-- 执行选项卡跳转 -->
		<script>
			//用于实现延时刷新网页
	  		function reload(tabs) {
				if (tabs!=0) tabs --;
				$('#myTab li:eq('+tabs+') a').tab('show');
				console.log('#myTab li:eq('+tabs+') a');
	  		}
	  		setTimeout(function(){ reload(<%=tabs%>) }, 0);
		</script>
	</head>

	<body>
		<div class="header">
			<p>
				您好，<%=BookDBCon.preparedqueryResult("select readerName from Reader where readerNO=?",username)%>
				<span class="right">
					<a href="alterpassword.jsp?username=<%=username%>">修改密码</a>
					<a href="api/logout">注销</a>
				</span>
			</p>
		</div>

		<!-- 过滤器 -->
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">
					图书信息 过滤器
				</h3>
			</div>
			<div class="panel-body">
				<form method="POST" action="#tabs-3" class="form-inline">
					<p>
					<label>图书编号</label>
					<input name="bookno" value="<%=bookinfo.bookno%>">
					<span class="right">
					<label>出版社</label>
					<input name="press" value="<%=bookinfo.press%>">
					</span>
					</p>
					<p>
					<label>图书名称</label>
					<input name="bookname" value="<%=bookinfo.bookname%>">
					<span class="right">
					<label>出版日期</label>
					<input name="publishdate_1" value="<%=bookinfo.publishdate_1%>">&nbsp;至&nbsp;<input name="publishdate_2" value="<%=bookinfo.publishdate_2%>"></span>
					</p>
					<p>
					<label>作者</label>
					<input name="author" value="<%=bookinfo.author%>">
					<span class="right">
					<label class="checkbox-inline">
					<input name="check" type="checkbox" <%=bookinfo.check?"checked=\"\"":""%>>
					仅显示可借阅书籍
					</label>
					</span>
					</p>
					<p>
					<input type="submit" value="查询"  class="btn btn-primary">
					</p>
				</form>
			</div>
		</div>

		<!-- 导航栏 -->
		<ul class="nav nav-tabs" role="tablist" id="myTab">
		    <li role="presentation" class="active"><a href="#tabs-1" aria-controls="tabs-1" role="tab" data-toggle="tab">当前借阅</a></li>
		    <li role="presentation"><a href="#tabs-2" aria-controls="tabs-2" role="tab" data-toggle="tab">历史借阅</a></li>
		    <li role="presentation"><a href="#tabs-3" aria-controls="tabs-3" role="tab" data-toggle="tab">图书信息</a></li>
	  	</ul>
	  	<div class="tab-content">
	  	<!-- 当前借阅 -->
		  <div role="tabpanel" class="tab-pane fade in active" id="tabs-1">
			<table class="table table-striped table-bordered table-hover">
			  	<thead>
					<tr>
						<% for (String item:BorrowTable.name) { %>
							<th><a href="?tabs=1&orderby=<%=item %>"><%=item %></a></th>
						<%}
						%>
						<th>借阅操作</th>
					</tr>
				</thead>
				<tbody>
					<% for (Vector<String> row:BorrowTable.data) { %>
						<tr>
							<% for (String item:row) { %>
								<td><%=item %></td>
							<%}%>
							<td>
								<a href="api/bookreturn?bookno=<%=row.get(0)%>">还书</a> |
								<a href="api/bookrenew?bookno=<%=row.get(0)%>">续借</a>
							</td>
						</tr>
					<%}%>
				</tbody>
			</table>
		  </div>
		  <!-- 历史借阅 -->
		  <div role="tabpanel" class="tab-pane fade" id="tabs-2">
	   	    <table class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<% for (String item:BorrowHistoryTable.name) { %>
							<th><a href="?tabs=2&orderby=<%=item %>"><%=item %></a></th>
						<%}
						%>
					</tr>
				</thead>
				<tbody>
					<% for (Vector<String> row:BorrowHistoryTable.data) { %>
						<tr>
							<% for (String item:row) { %>
								<td><%=item %></td>
							<%}%>
						</tr>
					<%}%>
				</tbody>
			</table>
		  </div>
		  <!-- 图书信息 -->
		  <div role="tabpanel" class="tab-pane fade" id="tabs-3">
	   	    <table class="table table-striped table-bordered table-hover">
	   	    	<thead>
					<tr>
						<% for (String item:BookTable.name) { %>
							<th><a href="?tabs=3&orderby=<%=item %>"><%=item %></a></th>
						<%}
						%>
						<th>借阅操作</th>
					</tr>
				</thead>
				<tbody>
					<% for (Vector<String> row:BookTable.data) { %>
						<tr>
							<% for (String item:row) { %>
								<td><%=item %></td>
							<%}%>
							<td><a href="api/bookborrow?bookno=<%=row.get(0)%>">借书</a></td>
						</tr>
					<%}%>
				</tbody>
			</table>
		  </div>
		</div>
	</body>
	
	<script>
		//用于实现tabs切换
		$('#myTab a').click(function (e) {
		  e.preventDefault()
		  $(this).tab('show')
		})
  	</script>
</html>
