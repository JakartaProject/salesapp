package salesapp.service;

public class MktResp <T> {
	private String code = SUCCESS;
	private String msg;
	private T data;
	public static final String SUCCESS = "succ";
	public static final String ERROR = "error";
	public static final String SESSION_OUT_OF_DATE = "sessionOutOfDate";
	public MktResp() {
	}
	public MktResp(T data) {
		this.data = data;
	}
	public static MktResp sessionOutOfDate() {
		MktResp resp = new MktResp();
		resp.setCode(SESSION_OUT_OF_DATE);
		return resp;
	}
	public static MktResp errorResp(String msg) {
		MktResp resp = new MktResp();
		resp.setCode(ERROR);
		resp.setMsg(msg);
		return resp;
	}
	public boolean success() {
		return SUCCESS.equals(code);
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}
