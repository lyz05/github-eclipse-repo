package Book.borrowing.management.system.model;

import java.util.Locale;
import java.util.ResourceBundle;

//返回操作信息
public class Msg {
	private String message;
	private String code;
	private Locale locale;
	
	public Msg() {}
	
	//国际化信息构造函数
	public Msg(String code,String message,String language) {
		setCode(code);
		setlocale(language);
		setMessage(message);
	}
	//非国际化信息构造函数
	public Msg(String code,String message) {
		setCode(code);
		this.message=message; 
	}
	
	public static Msg success(String message) {
		Msg result = new Msg();
		result.setCode("200");
		result.setMessage(message);
		return result;
	}
	
	public static Msg fail(String message) {
		Msg result = new Msg();
		result.setCode("403");
		result.setMessage(message);
		return result;
	}
	
	public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = geti18nString(message);
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public void setlocale(String language) {
    	String[] locale = language.split("_");
    	this.locale = new Locale(locale[0],locale[1]);
    }
	protected String geti18nString(String keys) {
		ResourceBundle bundle=ResourceBundle.getBundle("i18n",locale);
		return bundle.getString(keys);
	}
}
