package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.google.gson.Gson;

import dao.UsrDao;
import dto.User;

/**
 * Servlet implementation class usrcon
 */
@WebServlet("/usr.do")
public class usrcon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public usrcon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		UsrDao dao = new UsrDao();
		
		
		if(command=="signin") {
			
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");

			User newser = new Gson().fromJson(request.getParameter("data"), User.class);
			int res = dao.insertUsr(newser);
			
			if(res>0) {
			response.getWriter().print(newser.getNickname()+"님 가입 성공 ");
			} else { response.getWriter().print("회원가입 실패 아오 ");}
			
		}
		//개인정보 관리
		//1.개인정보창(수정, 탈퇴)
		//2.쪽지
		//3.판매, 구매 이력 조회
		
		
		
	}

}



/*
 * package controller.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.api.NaverDao;
import dto.api.NaverMember;


@WebServlet("/nvlogin")
public class NVlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NVlogin() {
		super();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		NaverDao dao = new NaverDao();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		NaverMember navermember = new Gson().fromJson(request.getParameter("data"), NaverMember.class);
		int res = dao.insertNV(navermember);
		
		
		
		
		
		if(res>0) {
		response.getWriter().print(navermember.getNickname());
		} else { response.getWriter().print("회원가입 실패하셨네요 하지만...일단은 ");}
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

 * */
