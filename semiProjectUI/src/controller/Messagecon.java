package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dao.MessageDao;
import dto.Message;

/**
 * Servlet implementation class Message
 */
@WebServlet("/Message")
public class Messagecon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Messagecon() {
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
		MessageDao dao = new MessageDao();
		
		String command = request.getParameter("command");
		
		if(command=="sendMessage") {
			
			

			Message newMsg = new Gson().fromJson(request.getParameter("data"), Message.class);
			int res = dao.sendMessage(newMsg);
			
			if(res>0) {
			response.getWriter().print("쪽지를 보냈습니다.");
			} else { response.getWriter().print("쪽지 실패 아오 ");}
			

		} else if(command=="chkMessage") {
			//사용자의 신규메세지 chk(페이지 이동시마다 체크하므로, 헤더나 푸터에 chk.js파일을 만들어 거기서 불러 사용.)
			session.setAttribute("unchkedMsg",dao.selectNeverChk(Integer.parseInt((String)session.getAttribute("usr"))));
			//프론트엔드에서 페이지 로딩시 셋타임아웃 등으로(마이크로테스크로 프로미스 예약하면 너무 빠를 수도... 시간 좀 넘겨서! unchkedMsg의 세션어트리뷰트 체크해야 함.
		} else if(command=="msgListing") {
			//쪽지 페이지. 받은 쪽지 보낸 쪽지 각각 리스팅. 개인정보 페이지에서 쪽지페이지로 이동시의 컨트롤 
			
			
		}
				
		
		//쪽지 확인시 쪽지에 받은 사람 조회여부 업데이트 
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
