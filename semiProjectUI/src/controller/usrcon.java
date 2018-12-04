package controller;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		System.out.println("유저컨트롤러 진입 ");
		String command = request.getParameter("command");
		UsrDao dao = new UsrDao();

		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();

		JsonParser parser = new JsonParser();
		System.out.println(command);

		if(command.equals("isUs")) {
			User usr = dao.selectOne(request.getParameter("sns"), request.getParameter("snsId"));
			if(usr==null) {
				out.print(0);
				
			} else {
				out.print(1);
			}
			
		}else if (command.equals( "signin")) {

			// User newser = new Gson().fromJson(request.getParameter("data"), User.class);
			User newser = new User(0, request.getParameter("nickName"), request.getParameter("email"),
					request.getParameter("sns"), request.getParameter("snsId"), request.getParameter("address1"),
					request.getParameter("address2"), request.getParameter("homeLat"), request.getParameter("homeLon"),
					Integer.parseInt(request.getParameter("zipNo")));

			int res = dao.insertUsr(newser);
			if (res > 0) {
				RequestDispatcher dispatch = request.getRequestDispatcher("usr.do?command=login");
				request.setAttribute("sns", newser.getSns());
				request.setAttribute("snsId", newser.getSnsId());
				dispatch.forward(request, response);
			} else {

				out.print(res);
			}

		} else if (command.equals("isNew")) {
			if(session.isNew()) {
				// 물품비교객체 생성
				List<Integer> favs = null;
				session.setAttribute("favs", favs);
				System.out.println("유저컨트롤러 isNew 진입 true");

				// 장바구니 객체 생성
				List<Integer> basket = null;
				session.setAttribute("basket", basket);
				out.print(true);
			} else {
				System.out.println("유저컨트롤러 isNew 진입 false");

				RequestDispatcher dispatch = request.getRequestDispatcher("sellcon.do?command=favsAndBasket");
				dispatch.forward(request, response);

			}
			
		} else if(command.equals("isSessionHasUsr")){
			System.out.println("유저컨트롤러 세션에 유저 확인  ");
			System.out.println(session.getAttribute("usr")!=null?((User)(session.getAttribute("usr"))).getSnsId():"널");

			if(session.getAttribute("usr")==null) {
				out.print(0);
				System.out.println("유저컨트롤러 isSessionHasUsr 널일때  ");

			} else {out.print(1);
			System.out.println("유저컨트롤러  isSessionHasUsr 널아님 ");

			}
			
		}else if (command.equals( "signInPage")) {
		
		
			RequestDispatcher dispatch = request.getRequestDispatcher("signin.jsp");
			dispatch.forward(request, response);

		}

		else if (command.equals( "loginchk")) { // 페이지마다 확인하는 부분
			System.out.println("유저컨트롤러 로긴첵 진입  ");

			if (session.getAttribute("usr") != null) {
				out.print(true);
			//	if (request.getParameter("cryptUsr") == session.getAttribute("cryptUsr")) {
			//		out.print(1);// 로긴인거확인
			//	} else {
					// 여기로 오게 된다면 사실상 해커임. 우리 사이트는 봐주세요 라고 출력하자...
			//		out.println(0);
			//	}
			} else {
				out.print(false);// 비로그인중.
			}

		} else if (command.equals("login")) {
			System.out.println("jajajaa");
			User usr = dao.selectOne(request.getParameter("sns"), request.getParameter("snsId"));
			System.out.println(usr.getSns()+usr.getSnsId());

			if (usr.getSnsId() != null) {
				session.setAttribute("usr", usr);// 유저 세션에 저장 
				System.out.println("유저가 널이 아님 ");

				// 물품비교객체 생성
				if(session.getAttribute("favs")!=null) {
				List<Integer> favs = null;
				session.setAttribute("favs", favs);
				}
				// 장바구니 객체 생성
				if(session.getAttribute("basket")!=null) {
				List<Integer> basket = null;
				session.setAttribute("basket", basket);
				}
				// 유저 암호화값 입력
				// session.setAttribute("cryptUsr", dao.cryptusr(usr.getEmail()));
			} 
			response.sendRedirect("index.jsp");

		} else if (command.equals( "logout")) { // 로그아웃
			session.invalidate();
			response.sendRedirect("index.html");

		} else if (command.equals( "updateUsr")) { // 정보 수정
			String updateObj = request.getParameter("updateObj");
			JsonElement element = parser.parse(updateObj);
			if (session.getAttribute("usr") != null) {
				// if (element.getAsJsonObject().get("cryptUsr") ==
				// session.getAttribute("cryptUsr"))
				{
					User usr = new User(0, request.getParameter("nickName"), request.getParameter("email"),
							request.getParameter("sns"), request.getParameter("snsId"),
							request.getParameter("address1"), request.getParameter("address2"),
							request.getParameter("homeLat"), request.getParameter("homeLon"),
							Integer.parseInt(request.getParameter("zipCode")));

					// User usr = new
					// Gson().fromJson(element.getAsJsonObject().get("usr").getAsString(),
					// User.class);
					int res = dao.update(usr);// 체크를 거친 후 수정
					if (res > 0) {
					// out.print(session.getAttribute("cryptUsr"));
						out.print(true);
					}

					else {
						out.print(false);
					}

					// } else {
					// 여기로 오게 된다면 사실상 해커임. 우리 사이트는 봐주세요 라고 출력하자...
					// out.println(0);
				}
			} else {
				out.print(-1);// 비로그인중. 어떻게 일로 들어올 수 있지?

			}
		} else if (command.equals( "deleteUsr")) {
			if (session.getAttribute("usr") != null) {
				if (request.getParameter("cryptUsr") == session.getAttribute("cryptUsr")) {// cryptUsr만 파라미터로 보냄.
					out.print(dao.delete(((User) (session.getAttribute("usr"))).getUsrSeq()));// 체크를 거친 후 삭제(탈퇴)

			//	} else {
					// 여기로 오게 된다면 사실상 해커임. 우리 사이트는 봐주세요 라고 출력하자...
			//		out.println(0);
				}
			} else {
				out.print(-1);// 비로그인중.

			}
		} else {
			System.out.println("유저컨트롤러 들어와들어 ");

		}

		

		// 3.판매, 구매 이력 조회

	}

}

/*
 * package controller.api;
 * 
 * import java.io.IOException;
 * 
 * import javax.servlet.ServletException; import
 * javax.servlet.annotation.WebServlet; import javax.servlet.http.HttpServlet;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import com.google.gson.Gson;
 * 
 * import dao.api.NaverDao; import dto.api.NaverMember;
 * 
 * 
 * @WebServlet("/nvlogin") public class NVlogin extends HttpServlet { private
 * static final long serialVersionUID = 1L;
 * 
 * public NVlogin() { super();
 * 
 * }
 * 
 * protected void doGet(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException {
 * 
 * NaverDao dao = new NaverDao(); request.setCharacterEncoding("UTF-8");
 * response.setContentType("text/html; charset=UTF-8");
 * 
 * NaverMember navermember = new Gson().fromJson(request.getParameter("data"),
 * NaverMember.class); int res = dao.insertNV(navermember);
 * 
 * 
 * 
 * 
 * 
 * if(res>0) { response.getWriter().print(navermember.getNickname()); } else {
 * response.getWriter().print("회원가입 실패하셨네요 하지만...일단은 ");} }
 * 
 * protected void doPost(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException { doGet(request, response); }
 * 
 * }
 * 
 */
