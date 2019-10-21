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

	public void randomView() {
		int lotto[] = new int[12];
        ArrayList<String> num = new ArrayList<>();
        for(int i=0; i<lotto.length; i++) {
            lotto[i] = (int)(Math.random()*45)+1;
            for (int j = 0; j < i; j++) {
                if(lotto[i] == lotto[j]) {
                    i--;
                    break;
                }
            }
        }
        Arrays.sort(lotto);
        for (int i = 0; i < lotto.length; i++) {
        	
            System.out.print("[" + lotto[i] + "] ");
        }
        System.out.println(" 입니다.");
        
    }

	
		
	}


