package com.kh.profile.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.profile.model.service.ProfileService;
import com.kh.profile.model.vo.Ideal;
import com.kh.profile.model.vo.Profile;



@WebServlet(name = "SearchProfileList", urlPatterns = { "/searchProfileList" })
public class SearchProfileListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchProfileListServlet() {
        super();
    }
    /**
     * @param : 이상형 프로필정보 (ex)religion, height, smoke, city, 객체 Ideal생성했음
     * @return : 적합한 회원목록(ArrayList)
     * @see : 이상형 조건을 페이지단위로 저장 후 조건에 맞는 이상형목록 출력
     * @author : 김태환 (작성자)
     * @date : 2019-10-18 (최종수정날짜)
     * **/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ProfileService service = new ProfileService();
		ArrayList<Profile> list = new ArrayList<Profile>();
		Ideal i = null;
		String religion = request.getParameter("religion");
		String heightStr = request.getParameter("height");
		String smoke = request.getParameter("smoke");
		String city = request.getParameter("city");
		//~150, 150~180, 180~ 세개로 나눠 값받아야함
		StringTokenizer st = new StringTokenizer(heightStr,"~");
		System.out.println(3333);
		//150, (150,160), (160,170), (170,180),180
		if(st.countTokens()==1) {	// int값 한개만 들어오면 150cm아님 180cm면
			int height = Integer.parseInt(st.nextToken());
			ArrayList<Profile> HeightList = service.searchHeight(height);
		}else if(st.countTokens()==2){ //int값 2개면
			int min = Integer.parseInt(st.nextToken());
			int max = Integer.parseInt(st.nextToken());
			ArrayList<Profile> HeightList = service.searchHeight(min,max);
		}
		
		
		System.out.println(religion + "," + heightStr + "," + smoke + "," + city);
		i = new Ideal(religion, heightStr, smoke, city);
		
		System.out.println(religion + "," + heightStr + "," + smoke + "," + city);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
