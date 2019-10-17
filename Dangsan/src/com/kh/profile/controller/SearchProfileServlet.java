package com.kh.profile.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.profile.model.service.ProfileService;
import com.kh.profile.model.vo.Profile;
@WebServlet(name = "SearchProfile", urlPatterns = { "/searchProfile" })
public class SearchProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchProfileServlet() {
        super();
    }
/**
 * @param : 이상형 프로피정보 (ex)addr, height
 * @return : 적합한 회원목록(ArrayList)
 * @see : 이상형 검색 후 조건에 맞는 이상형들을 가지고 오는 메소드
 * @author : 김태환 (작성자)
 * @date : 2019-10-17 (최종수정날짜)
 * **/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("이상형찾기 Servlet 시작");
		//2.변수저장
		String city = request.getParameter("city");
		int height = Integer.parseInt(request.getParameter("height"));
		//3.비지니스로직처리
		ProfileService service = new ProfileService();
		ArrayList<Profile> profileList = service.searchProfile(city,height);
		
		
		
		//4.view처리
//		if(m!=null) {
//			HttpSession session = request.getSession();
//			session.setAttribute("member", m);
//			request.setAttribute("msg", "로그인성공");
//		}else {
//			request.setAttribute("msg", "로그인실패");
//		}
		request.setAttribute("loc", "/showProfile.jsp");
		
		//-> 경로로 페이지 이동 -> url에 msg.jsp가 안뜨고 지정한 서블렛이름이 뜬다 !! (login)
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		rd.forward(request, response);
		System.out.println("이상형찾기 Servlet 끝");
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
