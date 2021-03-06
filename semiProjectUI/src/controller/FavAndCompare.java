package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FavAndCompareDao;
import dto.SellBoard;

import java.util.ArrayList;
import java.util.List;
/**
 * Servlet implementation class FavAndCompare
 */
@WebServlet("/FavAndCompare.do")
public class FavAndCompare extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FavAndCompare() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		FavAndCompareDao dao = new FavAndCompareDao();
		
		String command = request.getParameter("command");
		
		if(command=="addFav") {
			if(session.getAttribute("favs")==null) {
				out.println(0);//ajax에서 받는 부분에서 로그인시 이용가능한 서비스입니다. 라고 출력.
			} else {
			session.setAttribute("favs",(((List<Integer>)session.getAttribute("favs")).add(Integer.parseInt(request.getParameter("sellNum")))));
			out.println(1);
			}
		} else if(command.equals("viewFav")) {
			
			List<Integer> favs = new ArrayList<Integer>();
			favs = (List<Integer>)session.getAttribute("favs");
			List<SellBoard> favList = new ArrayList<SellBoard>();
			favList = dao.viewFav(favs);
			session.setAttribute("favList", favList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("cart.jsp");
			dispatcher.forward(request, response);
			
			
		} else if(command=="delFav") {
			session.setAttribute("favs",(((List<Integer>)session.getAttribute("favs")).remove(Integer.parseInt(request.getParameter("sellNum")))));
			out.println(true);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
