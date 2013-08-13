package com.jeefuse.base.web.result;

/**
 * 返回信息封装.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class ResultMsg<T> {

	private boolean success = true;// 是否成功
	private T data;// 返回数据
	private String message;// 返回信息
	private boolean unlogin = false;//是否登录

	public ResultMsg() {
	}

	public ResultMsg(boolean success, T data, String message) {
		this.success = success;
		this.data = data;
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public boolean isUnlogin() {
		return unlogin;
	}

	public void setUnlogin(boolean unlogin) {
		this.unlogin = unlogin;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return new StringBuilder()
		        .append("message:"+this.message)
				.append("data:"+this.data)
				.append("success:"+this.success)
				.toString();
	}

}
