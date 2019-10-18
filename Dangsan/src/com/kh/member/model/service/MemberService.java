package com.kh.member.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Profile;

public class MemberService {

	public ArrayList<Profile> rankingView() {
		Connection conn = JDBCTemplate.getConnection();
		MemberDao dao = new MemberDao();
		ArrayList<Profile> list =  dao.rankingView(conn);
		JDBCTemplate.close(conn);
		return list;
	}

}
