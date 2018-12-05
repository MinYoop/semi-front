package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.NoticeBoardDao;

@WebServlet("/noticeBoard.do")
public class NoticeBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NoticeBoard() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		// ���� ��ü ����(���ǽ����� ���)
		HttpSession session = request.getSession();

		String command = request.getParameter("command");
		System.out.println("[" + command + "]");

		NoticeBoardDao noticedao = new NoticeBoardDao();

		if (command.equals("list")) {
			List<dto.NoticeBoard> list = noticedao.selectAll();
			request.setAttribute("list", list);

			dispatch("noticelist.jsp", request, response); // forward
															// �ϳ��ϳ���������Ƽ� �޼ҵ�θ���

		}
	}

	private void dispatch(String url, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(url);

		dispatch.forward(request, response);

	}

}
