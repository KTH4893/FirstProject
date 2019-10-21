package com.kh.message.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.message.model.vo.MessageVO;

public class MessageDao {

	//안 읽은 받은 쪽지 불러오기
	public ArrayList<MessageVO> selectNoReadList(Connection conn, String id, int start, int end) {
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		ArrayList<MessageVO> list = new ArrayList<MessageVO>();
		String query = "select * from (select ROWNUM as mnum, m.* from(select * from message where msg_to_id = ? and msg_check='x' order by msg_date desc)m) where mnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				MessageVO msg = new MessageVO();
				msg.setMsgCheck(rset.getString("msg_check"));
				msg.setMsgContent(rset.getString("msg_content"));
				msg.setMsgDate(rset.getDate("msg_date"));
				msg.setMsgFromId(rset.getString("msg_from_id"));
				msg.setMsgNo(rset.getInt("msg_no"));
				msg.setMsgToId(rset.getString("msg_to_id"));
				
				list.add(msg);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}
	
	//주고받은 메세지 불러오기
	public ArrayList<MessageVO> selectSendRecMessage(Connection conn, String msgToId, String msgFromId,int start, int end) {
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		ArrayList<MessageVO> list = new ArrayList<MessageVO>();
		String query = "select * from (select ROWNUM as mnum, m.* from(select * from message where msg_to_id=? and msg_from_id=? or msg_to_id=? and msg_from_id=? order by msg_date desc)m) where mnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, msgToId);
			pstmt.setString(2, msgFromId);
			pstmt.setString(3, msgFromId);
			pstmt.setString(4, msgToId);
			pstmt.setInt(5, start);
			pstmt.setInt(6, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				MessageVO msg = new MessageVO();
				msg.setMsgCheck(rset.getString("msg_check"));
				msg.setMsgContent(rset.getString("msg_content"));
				msg.setMsgDate(rset.getDate("msg_date"));
				msg.setMsgFromId(rset.getString("msg_from_id"));
				msg.setMsgNo(rset.getInt("msg_no"));
				msg.setMsgToId(rset.getString("msg_to_id"));
				
				list.add(msg);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}

	//쪽지 보내기
	public int insertMessage(Connection conn, String msgToId, String msgFromId, String msgContent) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into message values (message_seq.nextVal,?,?,?,sysdate,'x')";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, msgFromId);
			pstmt.setString(2, msgToId);
			pstmt.setString(3, msgContent);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	//안읽은 쪽지리스트의 전체 개수 구하기
	public int totalCountNoRead(Connection conn,String id) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "select count(*) from message where msg_to_id = ? and msg_check='x' order by msg_date desc";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	//주고받은 쪽지의 총 개수
	public int totalCountSendRec(Connection conn, String msgToId, String msgFromId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "select count(*) from message where msg_to_id=? and msg_from_id=? or msg_to_id=? and msg_from_id=? order by msg_date desc";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, msgToId);
			pstmt.setString(2, msgFromId);
			pstmt.setString(3, msgFromId);
			pstmt.setString(4, msgToId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	

}
