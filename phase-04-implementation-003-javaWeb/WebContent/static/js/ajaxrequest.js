/**
 * ajax请求相关操作
 */
// 发送ajax请求，成功跳转href链接
function ajaxRequest(type, url, data, href, func) {
	$.ajax({
		url : url,
		type : type,
		dataType : "json",
		data : data,
		success : function(result, testStatus) {
			if (result.code == "200") {
				//命令执行成功跳转
				alert(result.message);
				if (href!=null)
					window.location.href = href;
			}
			if (result.code == "605" && href!=null) window.location.href = href;
			if (result.code == "403") {
				//命令执行失败，或有错误消息需要显示
				alert(result.message);
			}
			if (result.code == "601") {
				//未登录
				alert(result.message);
				window.location.href = './';
			}
			if (func!=null) 
				func(result);
		},
		error : function(xhr, errorMessage, e) {
			alert("发送请求失败，请检查网络状态");
		}
	});
}
function logout(){
	ajaxRequest("get","api/logout",null,"index.html",null);
}