package com.kh.member.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;

import com.kh.common.JDBCTemplate;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;
import com.kh.member.model.vo.MemberPage;
import com.kh.member.model.vo.Profile;

public class MemberService {

	public ArrayList<MemberPage> rankingView() {
		Connection conn = JDBCTemplate.getConnection();
		MemberDao dao = new MemberDao();
		ArrayList<MemberPage> list =  dao.rankingView(conn);
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<MemberPage> randomView() {
		Connection conn = JDBCTemplate.getConnection();
		MemberDao dao = new MemberDao();
		int lotto[] = new int[12];
        for(int i=0; i<lotto.length; i++) {
            lotto[i] = (int)(Math.random()*22)+1;
            for (int j = 0; j < i; j++) {
                if(lotto[i] == lotto[j]) {
                    i--;
                    break;
                }
            }
        }
        for(int i=0;i<lotto.length;i++) {
        	System.out.println(lotto[i]);
        }
        ArrayList<MemberPage> list = dao.randomView(conn,lotto);
        return list;
    }

	public int insertHeart(String toId, String fromId) {
		Connection conn = JDBCTemplate.getConnection();
		MemberDao dao = new MemberDao();
		int result = dao.insertHeart(conn,toId,fromId);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}
	
	
		
}


