function loadProperties(type, func) {
	console.log(type);
	jQuery.i18n.properties({
		name : 'i18n', // 资源文件名称
		path : 'i18n/', // 资源文件所在目录路径
		mode : 'map', // 模式：变量或 Map
		language : type, // 对应的语言
		cache : false,
		encoding : 'UTF-8',
		callback : function(){
			$("[data-locale]").each(function(){
				$(this).html($.i18n.prop($(this).data("locale")));
			});
			$("[data-locale-btn]").each(function(){
				$(this).val($.i18n.prop($(this).data("locale-btn")));
			});
			$("[data-locale-placeholder]").each(function(){
				$(this).attr('placeholder',$.i18n.prop($(this).data("locale-placeholder")));
			});
			func();
		}
	});
}

$(document).ready(
	function() {
		var LANGUAGE_CODE = localStorage.getItem("LANGUAGE_CODE");
		if (LANGUAGE_CODE == null)
			// 获取浏览器的语言
			localStorage.setItem("LANGUAGE_CODE", jQuery.i18n
					.normaliseLanguageCode({}));
		LANGUAGE_CODE = localStorage.getItem("LANGUAGE_CODE");
		loadProperties(LANGUAGE_CODE, i18nCallBack);
	});