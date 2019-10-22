package com.kh.message.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.message.model.dao.MessageDao;
import com.kh.message.model.vo.MessageNoReadPageData;
import com.kh.message.model.vo.MessageVO;
import com.kh.message.model.vo.MessageViewPageData;

public class MessageService {

	//안읽은 받은 쪽지 리스트 불러오기
	public MessageNoReadPageData selectNoReadList(String id, int reqPage){
		Connection conn = JDBCTemplate.getConnection();
		MessageDao dao = new MessageDao();
		
		/*페이징 처리(이전,다음 버튼만 있음)*/
		int numPerPage = 6; //한 페이지당 게시물 수
		int totalCount = dao.totalCountNoRead(conn, id); // 리스트의 전체 갯수
		
		//나머지가 0인 경우 -> 몫, 아닌경우-> 목+1 //전체 페이지 갯수
		int totalPage = (totalCount%numPerPage ==0)?(totalCount/numPerPage):(totalCount/numPerPage)+1;
		
		int start = (reqPage-1)*numPerPage + 1; //페이지 시작 게시물 번호
		int end = reqPage*numPerPage;			//페이지 마지막 게시물 번호

		ArrayList<MessageVO> list = dao.selectNoReadList(conn, id, start, end);
		
		/*페이지 네비게이션 생성*/
		String pageNavi = "";	//페이지 네비 HTML을 저장하는 변수
		
		//링크에 id도 추가해야되나?????????????????
		//이전 버튼 생성
		if(reqPage != 1) {
			//요청페이지가 1이 아니면
			pageNavi += "<a href='/messageList?reqPage="+(reqPage-1)+"'>이전</a>";
		}
		//다음 버튼 생성
		if(totalPage>1) {
			//총페이지수가 1보다 크면
			pageNavi += "<a href='/messageList?reqPage="+(reqPage+1)+"'>다음</a>";
		}
		
		MessageNoReadPageData pd = new MessageNoReadPageData(list, pageNavi);
		JDBCTemplate.close(conn);
		return pd;
	}
	
	//주고보낸 메세지 불러오기
	public MessageViewPageData selectSendRecMessage(int reqPage, String msgToId, String msgFromId){
		Connection conn = JDBCTemplate.getConnection();
		MessageDao dao = new MessageDao();
		
		//페이징처리추가하기
		int numPerPage = 10;
		int totalCount = dao.totalCountSendRec(conn, msgToId, msgFromId);
		
		int totalPage = (totalCount%numPerPage==0)?(totalCount/numPerPage):(totalCount/numPerPage+1);
		int start = (reqPage-1)*numPerPage + 1;
		int end = reqPage*numPerPage;
		ArrayList<MessageVO> list = dao.selectSendRecMessage(conn, msgToId, msgFromId, start, end);
		
		/*페이지 네비게이션 생성*/
		int pageNaviSize = 5;
		String pageNavi = "";
		
		//해당 페이지 시작번호
		int pageNo=1;
	
		//이전 버튼 생성
		if(reqPage != 1) {
			pageNavi += "<a href='/messageView?reqPage"+(pageNo-1)+"'>이전</a>";
		}
		int i = 1;
		while(!(i++>pageNaviSize || pageNo>totalPage)) {
			if(reqPage == pageNo) {
				//선택된 페이지
				pageNavi += "<span>"+pageNo+"</span>";
			}else {
				pageNavi += "<a href='/messageView?reqPage="+pageNo+"'>"+pageNo+"</a>";
			}
			pageNo++;
		}
		//다음 버튼 생성
		if(pageNo!=totalPage) {
			pageNavi += "<a href='/messageView?reqPage="+pageNo+"'>다음</a>";
		}
		
		MessageViewPageData pd = new MessageViewPageData(list, pageNavi);
		
		JDBCTemplate.close(conn);
		return pd;
	}
	
	//쪽지 보내기
	public int insertMessage(String msgToId, String msgFromId, String msgContent) {
		Connection conn = JDBCTemplate.getConnection();
		MessageDao dao = new MessageDao();
		int result = dao.insertMessage(conn, msgToId, msgFromId, msgContent);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}
}
