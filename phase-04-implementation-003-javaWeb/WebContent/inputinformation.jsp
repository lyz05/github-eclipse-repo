<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ page  import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
	<title>Input information</title>
</head>
<script>
	function submit1()
	{
		//alert(123);
		var odiv=document.getElementById("information");
		odiv.style.display="block";
		
	}
</script>
<body>
<% if( request.getMethod().equals("POST") ){ %>
    <div id="information" style="display:block;">
    	<jsp:include page = "/information.jsp" />
    </div>
<% }else if( request.getMethod().equals("GET") ){ %> 
    <div align="center">
		<form method="post" action="">        
	            <h1>登录信息采集</h1>
	            <table>                        
	            <tr>
	                <td><label for="username">姓名：</label></td>
	                <td><input type="text" name="username" size="15" maxlength="6" /></td>
	            </tr>
	            <tr>
	                <td>密码：</td>
	                <td><input type="password" name="password" size="15" maxlength="6"></td>
	            </tr>
	            <tr>
	                <td>性别：</td>
	                <td>
	                    <input type="radio" name="sex" checked="checked" value="男" />男
	                    <input type="radio" name="sex" value="女" />女
	                </td>
	            </tr>
	            <tr>
	                <td>兴趣：</td>
	                <td>
	                    <input type="checkbox" name="inst" value="听音乐" />听音乐
	                    <input type="checkbox" name="inst" value="玩游戏" />玩游戏
	                    <input type="checkbox" name="inst" value="看书" />看书
	                </td>
	            </tr>
	            <tr>
	                <td>出生年月</td>
	                <td><input type="date" name="date" ></td>
	            </tr>
	            <tr>
	                <td>电子邮箱</td>
	                <td><input type="email" name="email" ></td>
	            </tr>
	            <tr>
	                <td>个人简介</td>
	                <td><textarea name="textarea" rows="5" cols="30"></textarea></td>
	            </tr>
	            <tr>
	                <td colspan="2" align="center" >
	                    <input type="submit" value="提交"  />
	                    <input type="reset" value="重置" />                
	                </td>
	            </tr>
            </table>
		</form>    
    </div>
<% } %>


</body>
</html>