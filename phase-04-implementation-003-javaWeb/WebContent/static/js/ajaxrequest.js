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
				alertjs(result);
				if (href!=null)
					window.location.href = href;
			}
			if (result.code == "605" && href!=null) window.location.href = href;
			if (result.code == "403") {
				//命令执行失败，或有错误消息需要显示
				alertjs(result);
			}
			if (result.code == "601") {
				//未登录
				alertjs(result);
				window.location.href = './';
			}
			if (func!=null) 
				func(result);
		},
		error : function(xhr, errorMessage, e) {
			alert(xhr.statusText);
			//alert("发送请求失败，请检查网络状态");
		}
	});
}
function logout(){
	ajaxRequest("get","api/logout",null,"index.html",null);
}
//alert弹窗需要alert组件
function alertjs(result){
	var fadetimes = 300,showtimes = 3000;
	$("#alert").removeClass("alert-success");
	$("#alert").removeClass("alert-info");
	$("#alert").removeClass("alert-warning");
	$("#alert").removeClass("alert-danger");
	if (result.code==200) 
		$("#alert").addClass("alert-success");
	else if (result.code==403) 
		$("#alert").addClass("alert-danger");
	else $("#alert").addClass("alert-info");
	
	$("#alert").show(fadetimes);
	$("#alert").text(result.message);
	setTimeout( function(){
		$("#alert").hide(fadetimes)
	},showtimes);
}
//回调函数
function callBack(result){
	if (result.code == 200) {
		search();
	}
}
function callBackReset(result) {
	if (result.code == 200) {
		$('#form1')[0].reset();
		$('#savebtn').hide();	
		search();
	}
}