<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ page  import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
	<title>Input information</title>
</head>
<script type="text/javascript" src="static/jquery.min.js" ></script>

<script>
	
	function register()
	{
		var $username = $("input[name=username]").val();
		var $password = $("input[name=password]").val();
		var $sex = $('input[type=radio][name=sex]:checked').val();
		var $date = $("input[name=date]").val();
		var $email = $("input[name=email]").val();
		var $textarea = $("textarea").val();
		var inst=[];
        $("input[type=checkbox][name=inst]:checked").each(function(i){
        	inst[i] = $(this).val();
        });
        $.ajax({
			url: "Registerservlet",
			type: "post",
			dataType: "html",
			data: $('#form').serialize(),
			success:function(result,testStatus)
			{
				alert("提交成功");
				$('#result').html(result);
				$('#index').hide();
			},
			error:function(xhr,errorMessage,e)
			{
				alert("Ajax提交失败");
			}
		});
	}
</script>

<body>
<div align="center">
	<div id="index" style=display:> 
    	<form id="form" method="post" action="">        
		            <h1>登录信息采集</h1>
		            <table>                        
		            <tr>
		                <td><label for="username">姓名：</label></td>
		                <td><input id="username" type="text" name="username" size="15" maxlength="6" /></td>
		            </tr>
		            <tr>
		                <td>密码：</td>
		                <td><input id="password" type="password" name="password"></td>
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
		                    <input type="button" value="提交"  onclick="register();"/>
		                    <input type="reset" value="重置" />                
		                </td>
		            </tr>
	            </table>
			</form>    
	</div>
	<div id="result"> </div> 
</div>
</body>
</html>