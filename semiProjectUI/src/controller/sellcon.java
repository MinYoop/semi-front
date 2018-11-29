package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.SellBoard;

/**
 * Servlet implementation class sellcon
 */
@WebServlet("/sellcon")
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
		
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
