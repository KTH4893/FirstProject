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
import com.kh.message.model.vo.MessageViewPageData;

/**
 * Servlet implementation class MessageViewServlet
 */
@WebServlet(name = "MessageView", urlPatterns = { "/messageView" })
public class MessageViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//파라미터가져오기
		//보내는사람id, 받는사람id
		//보내는사람
		HttpSession session = request.getSession(false);
		String msgFromId = session.getAttribute("");
		//받는사람
		String msgToId = "";
		//요청페이지
		int reqPage;
		try {
			reqPage = Integer.parseInt(request.getParameter("reqPage"));
		}catch(NumberFormatException e) {
			reqPage = 1;
		}
		//비지니스로직
		MessageService service = new MessageService();
		MessageViewPageData pd = service.selectSendRecMessage(reqPage, msgToId, msgFromId);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/message/messageView.jsp");
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
