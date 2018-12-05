package controller;


import java.io.IOException;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.goods.dao.*;
import com.goods.dto.*;

@WebServlet("/goodsDelete.do")
public class GoodsDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String code= request.getParameter("code");
		
		GoodsDAO gDao = GoodsDAO.getInstance();
		GoodsVO gVo = gDao.selectGoodsByCode(code);
		
		request.setAttribute("goods", gVo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("goods/goodsDelete.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String code = request.getParameter("code");
		
		GoodsDAO gDao = GoodsDAO.getInstance();
		gDao.deleteGoods(code);
		
		response.sendRedirect("goodsList.do");
	}

}
