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


@WebServlet("/goodsWrite.do")
public class GoodsWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("goods/goodsWrite.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		ServletContext context = getServletContext();
		String path = context.getRealPath("upload");
		String encType="UTF-8";
		int sizeLimit = 20* 1024 * 1024;
		
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
		
	    String name = multi.getParameter("name");
	    int price = Integer.parseInt(multi.getParameter("price"));
	    String description = multi.getParameter("description");
	    String pictureUrl = multi.getFilesystemName("pictureUrl");
	    
	    GoodsVO gVo = new GoodsVO();
	    gVo.setName(name);
	    gVo.setPrice(price);
	    gVo.setDescription(description);
	    gVo.setPictureUrl(pictureUrl);
	    
	    GoodsDAO gDao = GoodsDAO.getInstance();
	    gDao.insertGoods(gVo);
	    
	    response.sendRedirect("goodsList.do");
	    
	}

}
