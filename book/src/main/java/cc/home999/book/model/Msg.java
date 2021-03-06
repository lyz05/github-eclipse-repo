package cc.home999.book.model;

/**
 * 通用的返回类
 * @author congcong
 *
 */
public class Msg {
	//状态码  200-成功 403-失败
	private int code;
	//提示信息
	private String message;

	public static Msg success(String message) {
		Msg result = new Msg();
		result.setCode(200);
		result.setMessage(message);
		return result;
	}
	
	public static Msg fail(String message) {
		Msg result = new Msg();
		result.setCode(403);
		result.setMessage(message);
		return result;
	}
	
	public Msg() {
		super();
	}

	public Msg(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
