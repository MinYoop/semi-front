<%@page import="dto.User"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>


<%@page import="com.google.gson.JsonElement"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.JsonParser"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>마커 클러스터러에 클릭이벤트 추가하기</title>

</head>
<body>
	<div id="header"></div>
   <center>
   <div>
	<div id="map" style="width: 70%; height: 700px;"></div>


	<script type="text/javascript" src="JSON/jquery-3.3.1.min.js"></script>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=fcce2df2939bca5734fd756caf9ea252&libraries=clusterer"></script>
	
<script src="js/script.js"></script>
	<script>
	

    var map = new daum.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
        center : new daum.maps.LatLng(36.2683, 127.6358), // 지도의 중심좌표
        level : 14 // 지도의 확대 레벨
    });
    
 // HTML5의 geolocation으로 사용할 수 있는지 확인합니다 

    if (navigator.geolocation) {
        
        // GeoLocation을 이용해서 접속 위치를 얻어옵니다
        navigator.geolocation.getCurrentPosition(function(position) {
            
            var lat = position.coords.latitude, // 위도
                lon = position.coords.longitude; // 경도
            
            var locPosition = new daum.maps.LatLng(lat, lon), // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
                
                message = '<a href="http://naver.com"><%=((User)session.getAttribute("User")).getNickName() %>님의 접속 위치  <img src="JSON/이창환.JPG" width="30" height="30"/> </a>';
            // 마커와 인포윈도우를 표시합니다
            displayMarker(locPosition, message);
                
          });
        
    } else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다        
        var locPosition = new daum.maps.LatLng(37.499005, 127.032907),    //kh정보교육원 위치로 잡음
            message = 'KH정보교육원';            
        displayMarker(locPosition, message);
    }
 
    function displayMarker(locPosition, message) {

        // 마커를 생성합니다
        var marker = new daum.maps.Marker({  
            map: map, 
            position: locPosition
        }); 
        
        var iwContent = message, // 인포윈도우에 표시할 내용
            iwRemoveable = true;

        // 인포윈도우를 생성합니다
        var infowindow = new daum.maps.InfoWindow({
            content : iwContent,
            removable : iwRemoveable
        });
        
        // 인포윈도우를 마커위에 표시합니다 
        infowindow.open(map, marker);
        
        // 지도 중심좌표를 접속위치로 변경합니다
        map.setCenter(locPosition);      
    }    

    // 마커 클러스터러를 생성합니다
    // 마커 클러스터러를 생성할 때 disableClickZoom 값을 true로 지정하지 않은 경우
    // 클러스터 마커를 클릭했을 때 클러스터 객체가 포함하는 마커들이 모두 잘 보이도록 지도의 레벨과 영역을 변경합니다
    // 이 예제에서는 disableClickZoom 값을 true로 설정하여 기본 클릭 동작을 막고
    // 클러스터 마커를 클릭했을 때 클릭된 클러스터 마커의 위치를 기준으로 지도를 1레벨씩 확대합니다
    var clusterer = new daum.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정
        minLevel: 10, // 클러스터 할 최소 지도 레벨
        
    });

    // 데이터를 가져오기 위해 jQuery를 사용합니다
    // 데이터를 가져와 마커를 생성하고 클러스터러 객체에 넘겨줍니다
    
<%-- <%

JSONObject jsonObject=(JSONObject)request.getAttribute("jsonObject"); 
System.out.println("-----------------");
System.out.println(jsonObject.toJSONString());


JSONArray jsonArray = (JSONArray)jsonObject.get("positions");

for(int i = 0 ; i< jsonArray.size(); i++){
	JSONObject json = (JSONObject)jsonArray.get(i);
	String res = (String)json.get("html");
	String lang = (String)json.get("lng");
	String lat = (String)json.get("lat");
	System.out.println(res);
%>
	var lang<%=i%> = '<%=lang%>'
	var lat<%=i%> = '<%=lat%>'
<%
}



%>  --%>
	
//민엽
/* var mark;
$.ajax({
	   url:"servlet.do?command=getJson",
	   dataType:"json",
	   success:function(msg){
		   mark = msg;
		   var test = alert(JSON.stringify(msg));
		   
	   },
	   error:function(jqXHR, textStatus){
		   alert(textStatus + " " + jqXHR.status + "\n" +jqXHR.responseText);
	   }
}); */

/* 	
	//민엽 끝 */
	
    /* $.get("/json/sdf", function(data) {
        // 데이터에서 좌표 값을 가지고 마커를 표시합니다

        // 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다
        var markers = $(data.positions).map(function(i, position) {
            var maks = new daum.maps.Marker({
                map: map,
                position : new daum.maps.LatLng(position.lat, position.lng)
            
            });
             
          
            
            var infowindow = new daum.maps.InfoWindow({
                content: position.html,
                
                removable : true
            });


            daum.maps.event.addListener(maks, 'click', makeOverListener(map, maks, infowindow));
          
 
            return maks;
 
        });
        // 클러스터러에 마커들을 추가합니다
        clusterer.addMarkers(markers);
    }); */
    
     
    function myJson(mark) {
        // 데이터에서 좌표 값을 가지고 마커를 표시합니다
        
        alert("hi");
        
        $.ajax({
     	   url:"servlet.do?command=getJson",
     	   dataType:"json",
     	   success:function(msg){
     		   
     		  /*  alert(JSON.stringify(msg));     		   
     		   
     		  var markers = $(msg.positions).map(function(i,position) {   	           
     	            return new daum.maps.Marker({
     	            	map : map,
     	                position : new daum.maps.LatLng(position.lat, position.lng)
     	            });    	           
     		   });    		              
     		   
     		  clusterer.addMarkers(markers); */
     		  
     		  //수정시작
     		  
     		  var markers = $(msg.positions).map(function(i, position) {
     	            var markers = new daum.maps.Marker({
     	                map: map,
     	                position : new daum.maps.LatLng(position.lat, position.lng)
     	            
     	            }); 
     	          
     	            
     	            var infowindow = new daum.maps.InfoWindow({
     	                content: position.html,
     	                
     	                removable : true
     	            });
     	            infowindow.open(map, markers);


     	           /*  daum.maps.event.addListener(makers, 'click', makeOverListener(map, markers, infowindow)); */
     	          
     	 
     	            return markers;
     	 
     	        });
     		  
     		 clusterer.addMarkers(markers);
     		  
     		  //수정끝
     		   
     		   
     	   },
     	   error:function(jqXHR, textStatus){
     		   alert(textStatus + " " + jqXHR.status + "\n" +jqXHR.responseText);
     	   }
     	});
        

        // 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다
        /*var markers = mark.positions.map(function(i,position) {
            var maks = new daum.maps.Marker({
                map: map,
                position : new daum.maps.LatLng(position.lat, position.lng)
            
            });
             
          
            
            var infowindow = new daum.maps.InfoWindow({
                content: position.html,
                
                removable : true
            });


            daum.maps.event.addListener(maks, 'click', makeOverListener(map, maks, infowindow));
          
 
            return maks;
 
          });
        // 클러스터러에 마커들을 추가합니다
        clusterer.addMarkers(markers); */
    }
    myJson();
   

    // 인포윈도우를 표시하는 클로저를 만드는 함수입니다

    function makeOverListener(map, marker, infowindow) {
        infowindow.close();
        return function() {
            infowindow.open(map, marker);
        };
    }

  
    

</script>
</div>
   </center>
   <div id="footer"></div>
</body>
</html>