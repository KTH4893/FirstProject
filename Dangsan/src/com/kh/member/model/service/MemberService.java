package com.kh.member.model.service;

<<<<<<< HEAD
public class MemberService {

	

}
=======
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

<<<<<<< HEAD
	public int insertHeart(String toId, String fromId) {
		Connection conn = JDBCTemplate.getConnection();
		MemberDao dao = new MemberDao();
		int result = dao.insertHeart(conn,toId,fromId);
=======
	public int insertMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		MemberDao dao = new MemberDao();
		int result = dao.insertMember(conn, m);
>>>>>>> ee340be8a12028d82746491911757d9be61f64d7
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
<<<<<<< HEAD
		return result;
	}
	
=======
		JDBCTemplate.close(conn);
		return result;
		
	}

	public Member selectOne(String id) {
		Connection conn = JDBCTemplate.getConnection();
		MemberDao dao = new MemberDao();
		Member m = dao.selectOne(conn, id);
		JDBCTemplate.close(conn);
		return m;
	}

	public int selectEmail(String emailAddr) {
		Connection conn = JDBCTemplate.getConnection();
		MemberDao dao = new MemberDao();
		int result = dao.selectEmail(conn, emailAddr);
		JDBCTemplate.close(conn);
		return result;
	}

	public Member login(String id, String pw) {
		Connection conn = JDBCTemplate.getConnection();
		MemberDao dao = new MemberDao();
		Member m = dao.login(conn, id, pw);
		JDBCTemplate.close(conn);
		return m;
	
	}

	public int delete(String id) {
		Connection conn = JDBCTemplate.getConnection();
		MemberDao dao = new MemberDao();
		int result = dao.delete(conn, id);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
>>>>>>> ee340be8a12028d82746491911757d9be61f64d7
	
		
}


>>>>>>> d2ea2537b9be55e62062b94e1074354f41cb6858
