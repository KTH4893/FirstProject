package com.kh.message.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.message.model.service.MessageService;
import com.kh.message.model.vo.MessageNoReadPageData;

/**
 * Servlet implementation class MessageListServlet
 */
@WebServlet(name = "MessageList", urlPatterns = { "/messageList" })
public class MessageListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//안읽은 받은 메세지 목록 불러오기
		
		//파라미터
		//현재 로그인한 아이디
		HttpSession session = request.getSession(false);
		String id = session.getAttribute("");
		//요청페이지
		int reqPage;
		try {
			reqPage = Integer.parseInt(request.getParameter("reqPage"));
		}catch(NumberFormatException e) {
			reqPage = 1;
		}
		//비지니스로직
		MessageService service = new MessageService();
		MessageNoReadPageData pd = service.selectNoReadList(id, reqPage);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/message/messageList.jsp");
		request.setAttribute("pd", pd);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
