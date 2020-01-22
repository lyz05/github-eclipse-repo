package Book.borrowing.management.system.model;

public class MessageJSONModel {
	private String message;
	private String code;
	public MessageJSONModel() {
		// TODO 自动生成的构造函数存根
	}
	public MessageJSONModel(String code,String message) {
		this.code=code;
		this.message=message;
	}
	public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    @Override
    public String toString() {
        return "User [code=" + code + ", message=" + message + "]";
    }
}
