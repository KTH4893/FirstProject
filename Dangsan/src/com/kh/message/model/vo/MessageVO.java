package com.kh.message.model.vo;

import java.sql.Date;

public class MessageVO {
	private int msgNo;			//쪽지번호
	private String msgFromId;	//보낸사람아이디
	private String msgToId;		//받은사람아이디
	private String msgContent;	//쪽지내용
	private Date msgDate;		//보낸날짜
	private String msgCheck;	//수신확인용
	public MessageVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MessageVO(int msgNo, String msgFromId, String msgToId, String msgContent, Date msgDate, String msgCheck) {
		super();
		this.msgNo = msgNo;
		this.msgFromId = msgFromId;
		this.msgToId = msgToId;
		this.msgContent = msgContent;
		this.msgDate = msgDate;
		this.msgCheck = msgCheck;
	}
	public int getMsgNo() {
		return msgNo;
	}
	public void setMsgNo(int msgNo) {
		this.msgNo = msgNo;
	}
	public String getMsgFromId() {
		return msgFromId;
	}
	public void setMsgFromId(String msgFromId) {
		this.msgFromId = msgFromId;
	}
	public String getMsgToId() {
		return msgToId;
	}
	public void setMsgToId(String msgToId) {
		this.msgToId = msgToId;
	}
	public String getMsgContent() {
		return msgContent;
	}
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}
	public Date getMsgDate() {
		return msgDate;
	}
	public void setMsgDate(Date msgDate) {
		this.msgDate = msgDate;
	}
	public String getMsgCheck() {
		return msgCheck;
	}
	public void setMsgCheck(String msgCheck) {
		this.msgCheck = msgCheck;
	}
	
	
	
	
}
