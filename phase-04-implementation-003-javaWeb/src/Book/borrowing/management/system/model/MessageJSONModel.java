package Book.borrowing.management.system.model;

import java.util.Locale;
import java.util.ResourceBundle;

//返回操作信息
public class MessageJSONModel {
	private String message;
	private String code;
	private Locale locale;
	public MessageJSONModel() {
		// TODO 自动生成的构造函数存根
	}
	//国际化信息
	public MessageJSONModel(String code,String message,String language) {
		setCode(code);
		setlocale(language);
		setMessage(message);
	}
	//非国际化信息
	public MessageJSONModel(String code,String message) {
		setCode(code);
		this.message=message; 
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
    	this.locale = new Locale(language.split("_")[0],language.split("_")[1]);
    }
	protected String geti18nString(String keys) {
		ResourceBundle bundle=ResourceBundle.getBundle("i18n",locale);
		return bundle.getString(keys);
	}
    @Override
    public String toString() {
        return "User [code=" + code + ", message=" + message + "]";
    }
}
