package com.kh.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;

import com.kh.member.model.vo.MemberPage;
import com.kh.member.model.vo.Profile;

public class MemberDao {

	public ArrayList<MemberPage> rankingView(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MemberPage> list = new ArrayList<MemberPage>();
		String query = "select * from (select * from member join profile using(member_id) order by heart desc) where rownum <= 12";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Profile p = new Profile();
				p.setId(rset.getString("member_id"));
				p.setBlood(rset.getString("blood"));
				p.setCity(rset.getString("city"));
				p.setHeart(rset.getInt("heart"));
				p.setHeight(rset.getInt("height"));
				p.setHobby(rset.getString("hobby"));
				p.setIntro(rset.getString("intro"));
				p.setJob(rset.getString("profile_job"));
				p.setReligion(rset.getString("religion"));
				p.setSmoke(rset.getString("smoke"));
				MemberPage mp = new MemberPage();
				mp.setProfile(p);
				mp.setAge(rset.getInt("age"));
				mp.setPhoto(rset.getString("photopath"));
				mp.setHeart(rset.getInt("heart"));
				list.add(mp);
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}return list;
		
		
	}

	public ArrayList<MemberPage> randomView(Connection conn, int[] lotto) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MemberPage> list = new ArrayList<MemberPage>();
		String query = "select * from (select rownum rn,n.* from (select * from member join profile using(member_id)) n ) where rn in(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			for(int i=0;i<12;i++) {
				pstmt.setInt(i+1, lotto[i]);
			}
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Profile p = new Profile();
				p.setId(rset.getString("member_id"));
				p.setBlood(rset.getString("blood"));
				p.setCity(rset.getString("city"));
				p.setHeart(rset.getInt("heart"));
				p.setHeight(rset.getInt("height"));
				p.setHobby(rset.getString("hobby"));
				p.setIntro(rset.getString("intro"));
				p.setJob(rset.getString("profile_job"));
				p.setReligion(rset.getString("religion"));
				p.setSmoke(rset.getString("smoke"));
				MemberPage mp = new MemberPage();
				mp.setProfile(p);
				mp.setAge(rset.getInt("age"));
				mp.setPhoto(rset.getString("photopath"));
				mp.setHeart(rset.getInt("heart"));
				list.add(mp);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}return list;
		
	}
	public int heart() {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into heart values(?,?,sysdate)";
		String query = "UPDATE PROFILE SET HEART = (heart)+?  WHERE MEMBER_ID = '?'";
	}

	public int insertHeart(Connection conn, String toId, String fromId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into heart values(?,?,sysdate)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, toId);
			pstmt.setString(2, fromId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(pstmt);
		}return result;
		
	}

	
	
}
