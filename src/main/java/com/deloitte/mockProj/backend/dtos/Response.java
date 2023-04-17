package com.deloitte.mockProj.backend.dtos;

public class Response<T> {

	private Boolean success;
	private String message;
	private T data;
	private int totalUsers;
	
	public Response() {
		super();
	}
	
	public Response(Boolean success, String message, T data, int totalUsers) {
		super();
		this.success = success;
		this.message = message;
		this.data = data;
		this.totalUsers = totalUsers;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public int getTotalUsers() {
		return totalUsers;
	}

	public void setTotalUsers(int totalUsers) {
		this.totalUsers = totalUsers;
	}

	@Override
	public String toString() {
		return "Response [success=" + success + ", message=" + message + ", data=" + data + ", totalUsers=" + totalUsers
				+ "]";
	}
	
	
}
