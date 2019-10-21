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

/**
 * Servlet implementation class MessageInsertServlet
 */
@WebServlet(name = "MessageInsert", urlPatterns = { "/messageInsert" })
public class MessageInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//쪽지 보내기
		
		//파라미터
		//보내는사람 id
		HttpSession session = request.getSession(false);
		//String msgFromId = session.getAttribute("");
		String msgFromId = request.getParameter("msgFromId");
		//받는사람
		String msgToId =  request.getParameter("msgToId");
		//내용
		String msgContent = request.getParameter("msgContent");
		System.out.println(msgFromId);
		System.out.println(msgToId);
		System.out.println(msgContent);
		
		//비지니스로직
		MessageService service = new MessageService();
		int result = service.insertMessage(msgToId, msgFromId, msgContent);
		if(result>0) {
			request.setAttribute("msg", "성공적으로 쪽지를 보냈습니다");
			request.setAttribute("loc", "/messageList");
		}else {
			request.setAttribute("msg", "쪽지 보내기를 실패했습니다...");
			request.setAttribute("loc", "/messageList");
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
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
