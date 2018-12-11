package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dao.MessageDao;
import dto.Message;
import dto.PageSelector;
import dto.User;

/**
 * Servlet implementation class Message
 */
@WebServlet("/Message.do")
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();
		MessageDao dao = new MessageDao();
		PrintWriter out = response.getWriter();
		
		String command = request.getParameter("command");
		
		if(command.equals("sendMessage")) {
		HashMap<String,String> newmsg = new HashMap<String,String>();
		newmsg.put("msgTitle", request.getParameter("msgTitle"));
		newmsg.put("msgContent", request.getParameter("msgContent"));
		newmsg.put("sender",((User)session.getAttribute("User")).getNickName());
		newmsg.put("receiver",request.getParameter("receiver"));
			int res = dao.sendMessage(newmsg);
			if(res>0) {
			response.getWriter().print("쪽지 발신 성공");
			} else { response.getWriter().print("쪽지 실패 아오 ");
			}
			

		} else if(command.equals("chkMessage")) {
			//사용자의 신규메세지 chk(페이지 이동시마다 체크하므로, 헤더나 푸터에 chk.js파일을 만들어 거기서 불러 사용.)
			System.out.println("체크메세지 진입");
			System.out.println(((User)session.getAttribute("User")).getNickName());
			int unchkedMsg =dao.selectNeverChk(((User)session.getAttribute("User")).getNickName());
			System.out.print(unchkedMsg);
			response.getWriter().print(unchkedMsg);
			//프론트엔드에서 페이지 로딩시 셋타임아웃 등으로(마이크로테스크로 프로미스 예약하면 너무 빠를 수도... 시간 좀 넘겨서! unchkedMsg의 세션어트리뷰트 체크해야 함.
		
		
		} else if(command.equals("recevedMsgPage")) {
			PageSelector pageinfo = dao.PgsMaker(Integer.parseInt(request.getParameter("page")),((User)session.getAttribute("User")).getNickName());
			String res = " ";
			HashMap<String,String> page = new HashMap<String,String>();
			page.put("page", request.getParameter("page"));
			page.put("sender", ((User)session.getAttribute("User")).getNickName());
			List<Message> rclist = new ArrayList<Message>();
			rclist = dao.selectReceived(pageinfo);
			res.concat(dao.makeReceived(rclist));
			res.concat(dao.pagingInfo(page));
			out.print(res);
		 
		
		} else if(command.equals("sentMsgPage")) {
			PageSelector pageinfo = dao.PgsMaker(Integer.parseInt(request.getParameter("page")),((User)session.getAttribute("User")).getNickName());
			String res = " ";
			HashMap<String,String> page = new HashMap<String,String>();
			page.put("page", request.getParameter("page"));
			page.put("sender", ((User)session.getAttribute("User")).getNickName());
			List<Message> sdlist = new ArrayList<Message>();
			sdlist = dao.selectSent(pageinfo);
			res.concat(dao.makeSent(sdlist));
			res.concat(dao.pagingInfo(page));
			out.print(res);
		 
		
		}else if(command.equals("msgFirstPage")) {
			PageSelector pageinfo = dao.PgsMaker(1,((User)session.getAttribute("User")).getNickName());
			
			//쪽지 페이지. 받은 쪽지 보낸 쪽지 각각 리스팅. 개인정보 페이지에서 쪽지페이지로 이동시의 컨트롤 
			List<Message> rclist = new ArrayList<Message>();
			rclist = dao.selectReceived(pageinfo);
			List<Message> sdlist = new ArrayList<Message>();
			sdlist = dao.selectSent(pageinfo);

			request.setAttribute("rclist", rclist);
			request.setAttribute("sdlist", sdlist);
			
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
