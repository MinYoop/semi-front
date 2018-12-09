package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import dao.SellBoardDao;
import dto.SellBoard;
import dto.User;
import util.MyUtil;




@WebServlet("/servlet.do")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Servlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.println("["+command+"]");
		
		
		HttpSession session = request.getSession();///세션 얻기
		SellBoardDao dao = new SellBoardDao();
		
		
		if(command.equals("kakaologin")) {
			
			String obj = request.getParameter("obj");
			System.out.println(obj);//json 뽑아냄
			
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(obj);
			
			String id = element.getAsJsonObject().get("id").getAsString();
			
			System.out.println("카톡 아이디는 : " + id); //id 뽑아냄
			
			String nickname = element.getAsJsonObject().get("properties").getAsJsonObject().get("nickname").getAsString();
								
			System.out.println("카톡 닉네임은 : " + nickname);
					
			
			PrintWriter out = response.getWriter();			
			out.println("ok");				
		}else if(command.equals("geolocation")) {
			String latitude = request.getParameter("latitude");
			String longitude = request.getParameter("longitude");
			
			System.out.println("위도 경도 " + latitude + " / " + longitude);
			
			/*PrintWriter out = response.getWriter();			
			out.println("위도경도 받음 ok"+latitude+"/"+longitude);*/
			
			session.setAttribute("latitude",latitude);
			session.setAttribute("longitude",longitude);
			
			System.out.println("session에서 받은위도 경도 값 : " + session.getAttribute("latitude") + "/" + session.getAttribute("longitude"));
		}else if(command.equals("sellboardlist")) {		
			response.sendRedirect("shopEx.jsp");
			
			
		}else if(command.equals("settingItem")){
			
			List<SellBoard> list = getAll(request).subList(0, 6);
		
			String outHtml = "";
			
			for(int i = 0 ; i < list.size(); i++) {
				SellBoard dto = list.get(i);
				String[] imgSrc = getImgSrc(dto.getSellContent());
				
				if(imgSrc[1]==null) {
					imgSrc[1]="images/noimage.JPG";
				}
				
				outHtml +=
						"<!-- product -->\r\n" + 
								"          <div class=\"col-lg-4 col-sm-6 mb-4\">\r\n" + 
								"              <div class=\"product text-center\">\r\n" + 
								"                <div class=\"product-thumb\">\r\n" + 
								"                  <div class=\"overflow-hidden position-relative\">\r\n" + 
								"                    <a href=\"servlet.do?command=boarddetail&sellSeq="+dto.getSellSeq()+"\">\r\n" + 
								"                      <img class=\"img-fluid w-100 mb-3 img-first\" src=\""+ imgSrc[0] +"\" alt=\"product-img\">\r\n" + 
								"                      <img class=\"img-fluid w-100 mb-3 img-second\" src=\""+ imgSrc[1]+"\" alt=\"product-img\">\r\n" + 
								"                    </a>\r\n" + 
								"                    <div class=\"btn-cart\">\r\n" + 
								"                        <a href=\"#\" class=\"btn btn-primary btn-sm\">Add To Cart</a>\r\n" + 
								"                    </div>\r\n" + 
								"                  </div>\r\n" + 
								"                  <div class=\"product-hover-overlay\">\r\n" + 
								"                    <a href=\"#\" class=\"product-icon favorite\" data-toggle=\"tooltip\" data-placement=\"left\" title=\"Wishlist\"><i\r\n" + 
								"                        class=\"ti-heart\"></i></a>\r\n" + 
								"                    <a href=\"#\" class=\"product-icon cart\" data-toggle=\"tooltip\" data-placement=\"left\" title=\"Compare\"><i\r\n" + 
								"                        class=\"ti-direction-alt\"></i></a>\r\n" + 
								"                    <a data-vbtype=\"inline\" href=\"#quickView\" class=\"product-icon view venobox\" data-toggle=\"tooltip\"\r\n" + 
								"                      data-placement=\"left\" title=\"Quick View\"><i class=\"ti-search\"></i></a>\r\n" + 
								"                  </div>\r\n" + 
								"                </div>\r\n" + 
								"                <div class=\"product-info\">\r\n" + 
								"                  <h3 class=\"h5\"><a class=\"text-color\" href=\"servlet.do?command=boarddetail&sellSeq="+dto.getSellSeq()+"\">"+dto.getTitle()+"</a></h3>\r\n" + 
								"                  <span class=\"h5\">"+((dto.getDistance()<1)?(dto.getDistance()*1000+"m"):(dto.getDistance()+"km"))+"</span>\r\n" + 
								"                </div>\r\n" + 
								"				<div class=\"product-label sale\">"+ dto.getStatus()+"</div>\r\n" +
								"              </div>\r\n" + 
								"            </div>\r\n" + 
								"            <!-- //end of product -->";
			}
			
			
			
			PrintWriter out = response.getWriter();
			out.println(outHtml);
			
		}else if(command.equals("limit")) {
			
			int page = Integer.parseInt(request.getParameter("page"));
			
			
			PrintWriter out = response.getWriter();			
			List<SellBoard> list = getAll(request);			
			
			if(page < list.size()) {
				
				
				SellBoard dto = list.get(page);
				
				String[] imgSrc = getImgSrc(dto.getSellContent());
				
				if(imgSrc[1]==null) {
					imgSrc[1]="images/noimage.JPG";
				}
				
				System.out.println(imgSrc[0]);
				System.out.println(imgSrc[1]);
				System.out.println("--------");
				
				out.println("<!-- product -->\r\n" + 
						"          <div class=\"col-lg-4 col-sm-6 mb-4\">\r\n" + 
						"              <div class=\"product text-center\">\r\n" + 
						"                <div class=\"product-thumb\">\r\n" + 
						"                  <div class=\"overflow-hidden position-relative\">\r\n" + 
						"                    <a href=\"servlet.do?command=boarddetail&sellSeq="+dto.getSellSeq()+"\">\r\n" + 
						"                      <img class=\"img-fluid w-100 mb-3 img-first\" src=\""+ imgSrc[0] +"\" alt=\"product-img\">\r\n" + 
						"                      <img class=\"img-fluid w-100 mb-3 img-second\" src=\""+ imgSrc[1]+"\" alt=\"product-img\">\r\n" + 
						"                    </a>\r\n" + 
						"                    <div class=\"btn-cart\">\r\n" + 
						"                        <a href=\"#\" class=\"btn btn-primary btn-sm\">Add To Cart</a>\r\n" + 
						"                    </div>\r\n" + 
						"                  </div>\r\n" + 
						"                  <div class=\"product-hover-overlay\">\r\n" + 
						"                    <a href=\"#\" class=\"product-icon favorite\" data-toggle=\"tooltip\" data-placement=\"left\" title=\"Wishlist\"><i\r\n" + 
						"                        class=\"ti-heart\"></i></a>\r\n" + 
						"                    <a href=\"#\" class=\"product-icon cart\" data-toggle=\"tooltip\" data-placement=\"left\" title=\"Compare\"><i\r\n" + 
						"                        class=\"ti-direction-alt\"></i></a>\r\n" + 
						"                    <a data-vbtype=\"inline\" href=\"#quickView\" class=\"product-icon view venobox\" data-toggle=\"tooltip\"\r\n" + 
						"                      data-placement=\"left\" title=\"Quick View\"><i class=\"ti-search\"></i></a>\r\n" + 
						"                  </div>\r\n" + 
						"                </div>\r\n" + 
						"                <div class=\"product-info\">\r\n" + 
						"                  <h3 class=\"h5\"><a class=\"text-color\" href=\"servlet.do?command=boarddetail&sellSeq="+dto.getSellSeq()+"\">"+dto.getTitle()+"</a></h3>\r\n" + 
						"                  <span class=\"h5\">"+((dto.getDistance()<1)?(dto.getDistance()*1000+"m"):(dto.getDistance()+"km"))+"</span>\r\n" + 
						"                </div>\r\n" + 
						"				<div class=\"product-label sale\">"+ dto.getStatus()+"</div>\r\n" +
						"              </div>\r\n" + 
						"            </div>\r\n" + 
						"            <!-- //end of product -->");
			}else {
				out.println("nomoreitem");
			}
				
			
			
		}else if(command.equals("boarddetail")) {
	         int sellSeq = Integer.parseInt(request.getParameter("sellSeq"));
			
	         SellBoard dto = dao.selectOne(sellSeq);
	         
	         request.setAttribute("dto", dto);
	         dispatch("boarddetail.jsp",request,response);
	         
	      }else if(command.equals("writeform")){
	         response.sendRedirect("boardwrite.jsp");
	      }
	      
	      else if(command.equals("boardwrite")){
	         String seller = ((User)session.getAttribute("nickName")).getNickName();
	         String tradeLat = request.getParameter("tradeLat");
	         String tradeLon = request.getParameter("tradeLon");
	         String sellContent = request.getParameter("sellContent");
	         String status="판매중";
	         String title = request.getParameter("title");
	         String category = "미정";
	         String tag = "미정";
	      
	         SellBoard dto = new SellBoard(seller,tradeLat,tradeLon, sellContent,status,title,category,tag);
	               
	        	      
	         boolean res=dao.insert(dto);
	         if(res) {
	            jsResponse("글 작성 성공","servlet.do?command=sellboardlist",response);
	         }else {
	            dispatch("servlet.do?command=writeform",request,response);
	         }
	            
	         
	      }/*else if(command.equals("boardupdateform")) {
	         int sellSeq = 58;//Integer.parseInt(request.getParameter("sellSeq"));

	         SellBoard dto = dao.selectOne(sellSeq);
	         request.setAttribute("dto", dto);
	         
	         dispatch("boardupdate.jsp",request,response);
	         
	      }*/else if(command.equals("boarddeleteform")) {
	         
	         int sellSeq = Integer.parseInt(request.getParameter("sellSeq"));
	    	 
	         boolean res = dao.delete(sellSeq);
	      
	         
	         if(res) {
	            jsResponse("글 삭제 성공","servlet.do?command=sellboardlist",response);
	            
	         }else {
	            dispatch("boarddetail.jsp",request,response);
	         }
	            
	         
	      }else if(command.equals("map1")) {
	         
	         response.sendRedirect("map1.jsp");
	            
	         
	      }else if(command.equals("map3")) {
	          String tradeLat = request.getParameter("tradeLat");
	          String tradeLon = request.getParameter("tradeLon");
	          request.setAttribute("tradeLat", tradeLat);
	          request.setAttribute("tradeLon", tradeLon);
	          dispatch("map3.jsp",request,response);
	       }
		
		
		
		
	}
	
	private List<SellBoard> getAll(HttpServletRequest request) {
		
		HttpSession session = request.getSession();///세션 얻기
		SellBoardDao dao = new SellBoardDao();
		List<SellBoard> list = dao.selectAll();
		
		MyUtil.getDistance(Double.parseDouble((String)session.getAttribute("latitude")),Double.parseDouble((String)session.getAttribute("longitude")),list);
		MyUtil.setSortList(list);	
		
		return list;
	}
	
	private String[] getImgSrc(String sellContent) {
		
		String[] imgSrc= new String[2] ;
		
		String abc = "<img[^>]*src=[\"']?([^>\"']+)[\"']?[^>]*>";
        
        Pattern pattern = Pattern.compile(abc, Pattern.CASE_INSENSITIVE); //img 태그 src 추출 정규표현식
        Matcher matcher = pattern.matcher(sellContent);     
        int i = 0;

          while(matcher.find() && i<2){
             imgSrc[i]=(matcher.group(1));	              
             i++;
          }	           
          return imgSrc;
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	private void dispatch(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher dispatch = request.getRequestDispatcher(url);
		dispatch.forward(request, response);
	}
	
	private void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {
	      String s ="<script type='text/javascript'>" + "alert('"+msg+"');" + "location.href='"+url+"';"+"</script>";
	      PrintWriter out=response.getWriter();
	      out.print(s);
	   }
	
	

}
