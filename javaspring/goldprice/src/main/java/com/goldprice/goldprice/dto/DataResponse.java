package com.goldprice.goldprice.dto;

/*
 * Response Api
 * */
public class DataResponse {
	private String status;
	private String errMsg;
	private Object data;

	public DataResponse() {
	}
	
	public DataResponse(String status, String errMsg, Object data) {
		super();
		this.status = status;
		this.errMsg = errMsg;
		this.data = data;
	}
	public DataResponse(String status, String errMsg) {
		super();
		this.status = status;
		this.errMsg = errMsg;
		this.data = "";
	}

	public DataResponse(Object data) {
		super();
		this.status = "200";
		this.errMsg = "";
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public String getErrMsg() {
		return errMsg;
	}


	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}


	public Object getData() {
		return data;
	}


	public void setData(Object data) {
		this.data = data;
	}

	
	
}