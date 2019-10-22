package com.kh.profile.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.kh.common.JDBCTemplate;
import com.kh.profile.model.vo.Profile;

public class ProfileDao {
	public ArrayList<Profile> searchProfile(Connection conn, String city, int height) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from profile where profile_city=? and height=?";
		ArrayList<Profile> list = new ArrayList<Profile>();
		Profile p = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, city);
			pstmt.setInt(2, height);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				p = new Profile();
				p.setBlood(rset.getString("blood"));
				p.setProfileId(rset.getString("profile_id"));
				p.setIntro(rset.getString("intro"));
				p.setHeight(rset.getInt("height"));
				p.setJob(rset.getString("job"));
				p.setHobby(rset.getString("hobby"));
				p.setHeart(rset.getInt("heart"));
				p.setReligion(rset.getString("religion"));
				p.setSmoke(rset.getString("smoke"));
				p.setProfileCity(rset.getString("profile_city"));
				list.add(p);
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

	public ArrayList<Profile> searchHeight1(Connection conn, int height) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query =null;
		if(height==150) {
			query = "select * from profile where height < ?";
		}else if(height==180) {
			query = "select * from profile where height > ?";
		}
		ArrayList<Profile> list = new ArrayList<Profile>();
		Profile p = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, height);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				p = new Profile();
				p.setBlood(rset.getString("blood"));
				p.setProfileId(rset.getString("profile_id"));
				p.setIntro(rset.getString("intro"));
				p.setHeight(rset.getInt("height"));
				p.setJob(rset.getString("job"));
				p.setHobby(rset.getString("hobby"));
				p.setHeart(rset.getInt("heart"));
				p.setReligion(rset.getString("religion"));
				p.setSmoke(rset.getString("smoke"));
				p.setProfileCity(rset.getString("profile_city"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}
	public ArrayList<Profile> searchHeight2(Connection conn, int min, int max) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query ="select * from profile where height between ? and ?";
		ArrayList<Profile> list = new ArrayList<Profile>();
		Profile p = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, min);
			pstmt.setInt(2, max);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				p = new Profile();
				p.setBlood(rset.getString("blood"));
				p.setProfileId(rset.getString("profile_id"));
				p.setIntro(rset.getString("intro"));
				p.setHeight(rset.getInt("height"));
				p.setJob(rset.getString("job"));
				p.setHobby(rset.getString("hobby"));
				p.setHeart(rset.getInt("heart"));
				p.setReligion(rset.getString("religion"));
				p.setSmoke(rset.getString("smoke"));
				p.setProfileCity(rset.getString("profile_city"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}
	
}
