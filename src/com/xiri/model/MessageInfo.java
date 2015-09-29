package com.xiri.model;

public class MessageInfo {
	private int number;
	private String time; 
	private String content;
	public MessageInfo(int number, String time,String content) {
		super();
		this.number = number;
		this.time=time;
		this.content = content;
	}
	public MessageInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

}
