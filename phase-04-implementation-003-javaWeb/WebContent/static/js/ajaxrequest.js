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
				if (href != null)
					window.location.href = href;
			}
			if (result.code == "601") {
				alert(result.message);
				window.location.href = './';
			}
			
			if (func!=null) func(result);
		},
		error : function(xhr, errorMessage, e) {
			alert("发送请求失败，请检查网络状态");
		}
	});
}
function logout(){
	ajaxRequest("get","api/logout",null,"index.html",null);
}