package com.kh.profile.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.kh.common.JDBCTemplate;
import com.kh.member.model.dao.MemberDao;
import com.kh.profile.model.dao.ProfileDao;
import com.kh.profile.model.vo.Profile;

public class ProfileService {
	ProfileDao dao = new ProfileDao();
	public ArrayList<Profile> searchProfile(String city,int height) {
		Connection conn = JDBCTemplate.getConnection();
		
		
		ArrayList<Profile> list = dao.searchProfile(conn,city,height);
		JDBCTemplate.close(conn);
		return list;
		
	}
	public ArrayList<Profile> searchHeight(int height) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Profile> list = dao.searchHeight1(conn,height);
		JDBCTemplate.close(conn);
		return list;
	}
	
	public ArrayList<Profile> searchHeight(int min, int max) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Profile> list = dao.searchHeight2(conn, min, max);
		JDBCTemplate.close(conn);
		return list;
	}

	
	
}
