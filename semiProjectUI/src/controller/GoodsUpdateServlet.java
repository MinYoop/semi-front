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

@WebServlet("/goodsUpdate.do")
public class GoodsUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		
		GoodsDAO gDao = GoodsDAO.getInstance();
		GoodsVO gVo = gDao.selectGoodsByCode(code);
		
		request.setAttribute("goods", gVo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("goods/goodsUpdate.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		ServletContext context = getServletContext();
		String path = context.getRealPath("upload");
		String encType="UTF-8";
		int sizeLimit= 20 * 1024 * 1024;
		
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType , new DefaultFileRenamePolicy());
		
		String code = multi.getParameter("code");
		String name = multi.getParameter("name");
		int price= Integer.parseInt(multi.getParameter("price"));
		String description = multi.getParameter("description");
		String pictureUrl = multi.getFilesystemName("pictureUrl");
		if(pictureUrl==null) {
			pictureUrl=multi.getParameter("nonmakeImg");
		}
		
		GoodsVO gVo = new GoodsVO();
		gVo.setCode(Integer.parseInt(code));
		gVo.setName(name);
		gVo.setPrice(price);
		gVo.setDescription(description);
		gVo.setPictureUrl(pictureUrl);
		
		GoodsDAO gDao = GoodsDAO.getInstance();
		gDao.updateGoods(gVo);
		
		response.sendRedirect("goodsList.do");
	}

}
