package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonParser;

import dao.SellBoardDao;
import dto.SellBoard;
import dto.User;

/**
 * Servlet implementation class sellcon
 */
@WebServlet("/sellcon.do")
public class sellcon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sellcon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		SellBoardDao dao = new SellBoardDao();		
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();

		JsonParser parser = new JsonParser();
		
		if(command=="sellDetail") {
			
			
			
		} else if(command=="favsAndBasket") {
			
			String user = ((User)session.getAttribute("User")).getNickName();
			
		}
		
		
		
		//매물 입력,수정,삭제
		
		//매물 거래 상태 변경
		
		//거래 진행시 딜테이블 생성
		
		//거래 완료시 딜테이블 수정 및 유저정보 수정(거래 시작과 종료는 판매자에게 맡기고, 구매자가 구매 완료와 함께 평가시에만 판매자의 판매 횟수가 증가한다.)
		
		
		
		
		//public List<SellBoard> selectPage(){}	//매물 거리순으로 정렬 후 출력  
			
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
