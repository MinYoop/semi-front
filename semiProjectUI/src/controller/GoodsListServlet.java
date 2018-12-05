package controller;

import java.io.IOException;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.goods.dao.*;
import com.goods.dto.*;



@WebServlet("/goodsList.do")

public class GoodsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GoodsDAO gDao = GoodsDAO.getInstance();
		
		List<GoodsVO> goodsList = gDao.selectAllGoods();
		request.setAttribute("goodsList", goodsList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("goods/goodsList.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
