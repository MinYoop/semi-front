package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.NoticeBoardDao;
import dto.Admin;
import dto.NoticeBoardDto;

@WebServlet("/NoticeBoard.do")
public class NoticeBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;

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

		HttpSession session = request.getSession();

		String command = request.getParameter("command");
		System.out.println("[" + command + "]");

		NoticeBoardDao noticedao = new NoticeBoardDao();

		if (command.equals("list")) {
			dispatch("Message.do?command=getPage&boardName=NOTICE_BOARD_TB&page=1&where=noticelist.jsp", request, response); 
			
		}else if (command.equals("insertNoticeForm")) {
			System.out.println("공지폼");
			response.sendRedirect("insertNotice.jsp");

		} else if (command.equals("insertNotice")) {

			if (session.getAttribute("admin_id") != null) {
				String admin_id = (String)session.getAttribute("admin_id");
				String title = request.getParameter("title");
				String content = request.getParameter("content");

				NoticeBoardDto dto = new NoticeBoardDto(admin_id, title, content);

				int res = noticedao.insertNotice(dto);

				if (res > 0) {
					jsResponse("글 작성이 성공하였습니다", "NoticeBoard.do?command=list", response);
				} else {
					dispatch("NoticeBoard.do?command=insertNoticeform", request, response);
				}
			}
		}else if(command.equals("isAdminLogedIn")) {
			System.out.println(session.getAttribute("admin_id"));
			response.getWriter().print(session.getAttribute("admin_id")==null?0:1);
			
		}else if (command.equals("logOut")) {
			session.invalidate();
			response.sendRedirect("faq.html");
		}else if (command.equals("loginform")) {

			response.sendRedirect("adminlogin.jsp");

		} else if (command.equals("adminLogin")) {
			Admin admin = new Admin();
			admin = noticedao.selectOneAdmin(request.getParameter("admin_id"));
			if(request.getParameter("adminPw").equals(admin.getAdminPw())) {
				session.setAttribute("admin_id", request.getParameter("admin_id"));
				response.sendRedirect("noticelist.jsp");
			}else {
				response.sendRedirect("faq.html");
			}

		} 
		
		
		else if (command.equals("selectOne")) {

			int notice_seq = Integer.parseInt(request.getParameter("notice_seq"));
			NoticeBoardDto dto = noticedao.selectOne(notice_seq);

			request.setAttribute("dto", dto); 

			dispatch("selectoneNotice.jsp", request, response);

		} else if (command.equals("deleteNotice"))

		{
			int notice_seq = Integer.parseInt(request.getParameter("notice_seq"));
			int res = noticedao.DeleteNotice(notice_seq);
			if (res > 0) {
				jsResponse("삭제가 자알 되었습니다", "NoticeBoard.do?command=list", response);
			} else {
				dispatch("NoticeBoard.do?command=list" + notice_seq, request, response);
			}
		} else if (command.equals("updateNoticeform"))

		{
			int notice_seq = Integer.parseInt(request.getParameter("notice_seq").trim());

			NoticeBoardDto dto = noticedao.selectOne(notice_seq);
			request.setAttribute("dto", dto);
			dispatch("updateNotice.jsp", request, response);

		} else if (command.equals("updateNotice"))

		{
			int notice_seq = Integer.parseInt(request.getParameter("notice_seq"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");

			NoticeBoardDto dto = new NoticeBoardDto(notice_seq, title, content);

			int res = noticedao.updateNotice(dto);

			if (res > 0) {
				jsResponse("수정이 자알 되었구먼유", "NoticeBoard.do?command=list", response);
			} else {
				dispatch("NoticeBoard.do?command=updateNoticeform&notice_seq=" + notice_seq, request, response);
			}

		}

	}

	private void dispatch(String url, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(url);

		dispatch.forward(request, response);

	}

	private void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {
		String s = "<script type='text/javascript'>" + "alert('" + msg + "');" + "location.href='" + url + "';"
				+ "</script>";

		PrintWriter out = response.getWriter();
		out.print(s);
	}

}
