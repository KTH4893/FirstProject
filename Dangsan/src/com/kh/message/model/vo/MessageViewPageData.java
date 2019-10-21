package com.kh.message.model.vo;

import java.util.ArrayList;

public class MessageViewPageData {

	private ArrayList<MessageVO> list;
	private String pageNavi;
	public MessageViewPageData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MessageViewPageData(ArrayList<MessageVO> list, String pageNavi) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
	}
	public ArrayList<MessageVO> getList() {
		return list;
	}
	public void setList(ArrayList<MessageVO> list) {
		this.list = list;
	}
	public String getPageNavi() {
		return pageNavi;
	}
	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
	
}
