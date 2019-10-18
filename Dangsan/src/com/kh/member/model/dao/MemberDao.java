package com.kh.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.member.model.vo.Profile;

public class MemberDao {

	public ArrayList<Profile> rankingView(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Profile> list = new ArrayList<Profile>();
		System.out.println("여기");
		String query = "select * from ( select * from profile order by heart desc ) where ROWNUM <= 12";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Profile p = new Profile();
				p.setId(rset.getString("profile_id"));
				p.setBlood(rset.getString("blood"));
				p.setCity(rset.getString("city"));
				p.setHeart(rset.getInt("heart"));
				p.setHeight(rset.getInt("height"));
				p.setHobby(rset.getString("hobby"));
				p.setIntro(rset.getString("intro"));
				p.setJob(rset.getString("profile_job"));
				p.setReligion(rset.getString("religion"));
				p.setSmoke(rset.getString("smoke"));
				p.setAge(rset.getInt("age"));
				list.add(p);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}return list;
		
		
	}
	
}
