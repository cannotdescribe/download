package com.insigma.download.entity;

public class ResultEndBean {
	private Object data;
	private Integer codeId;
	private String msg;
	public ResultEndBean() {
		codeId = 0;
		msg = "success";
	}
	public ResultEndBean(boolean flag) {
		codeId = flag?0:1;
		msg = flag?"success":"error";
	}
	public ResultEndBean(boolean flag, String msg) {
		codeId = flag?0:1;
		this.msg = msg; 
	}
	public ResultEndBean(Integer codeId, String msg, Object data) {
		this.codeId = codeId;
		this.msg = msg;
		this.data = data;
	}
	public ResultEndBean(Integer codeId, String msg) {
		this.codeId = codeId;
		this.msg = msg;
	}
	public ResultEndBean(Integer codeId) {
		this.codeId = codeId;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Integer getCodeId() {
		return codeId;
	}
	public void setCodeId(Integer codeId) {
		this.codeId = codeId;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
