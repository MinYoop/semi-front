<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>  


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 

<!DOCTYPE html>
<html lang="zxx">


<head>
<meta charset="utf-8">
<title>IUTRADE</title>

<!-- mobile responsive meta -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport"
   content="width=device-width, initial-scale=1, maximum-scale=1">


<!--Favicon-->
<head>
<link rel="stylesheet" href="/examples/media/expand_style.css">
<link rel="shortcut icon" href="images/favicon.png" type="image/x-icon">
<link rel="icon" href="images/favicon.png" type="image/x-icon">
<script type="text/javascript"
   src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<style type="text/css">
.chkchk{
   width: 100%; height: 100%;
}
</style>   
   
</head>

<!-- preloader start -->
<body>

<div id="header" class="yj"></div> 


   <div class="preloader">
      <img src="images/preloader.gif" alt="preloader">
   </div>
   <!-- preloader end -->

   <!-- main wrapper -->
   <div class="main-wrapper" style="text-align:center;margin-top:30px;">
   
<!-- 녹색장터 -->
<div style="margin-left:50px">
<h1 >서울의 각 구별 오프라인 장터</h1>

   <fieldset>
      <legend>장터 정보 조회</legend>
      <h3 style="text-align:left">구 검색</h3><select id="emp_search" >
         <option>--지역선택--</option>
         <option value="송파구">송파구</option>
         <option value="금천구">금천구</option>
         <option value="양천구">양천구</option>
         <option value="동작구">동작구</option>
         <option value="동대문구">동대문구</option>
         <option value="노원구">노원구</option>
         <option value="강서구">강서구</option>
         <option value="영등포구">영등포구</option>
         <option value="강남구">강남구</option>
         <option value="서대문구">서대문구</option>
         <option value="종로구">종로구</option>
         <option value="강동구">강동구</option>
      </select>
   </fieldset>
   <div class="chkchk"></div><!-- 녹색장터 테이블의 위치 -->
<!-- 녹색장터 -->
<div id="map-canvas" style="width: 100%; height: 400px"></div>
</div>
<div id="footer" style="position:absolute;bottom:0;width:100%"></div>
   
</div>
   <!-- Bootstrap JS -->
   <script src="plugins/bootstrap/bootstrap.min.js"></script>
   <script src="plugins/slick/slick.min.js"></script>
   <script src="plugins/venobox/venobox.min.js"></script>
   <script src="plugins/aos/aos.js"></script>
   <script src="plugins/syotimer/jquery.syotimer.js"></script>
   <script src="plugins/instafeed/instafeed.min.js"></script>
   <script src="plugins/zoom-master/jquery.zoom.min.js"></script>
   <script src="plugins/bootstrap-touchspin-master/jquery.bootstrap-touchspin.min.js"></script>
   <script src="plugins/nice-select/jquery.nice-select.min.js"></script>
   <script src="plugins/bootstrap-slider/bootstrap-slider.min.js"></script>
   <!-- google map -->
   <script src="maps/api/js7402?key=AIzaSyBI14J_PNWVd-m0gnUBkjmhoQyNyd7nllA"></script>
   <script src="plugins/google-map/gmap.js"></script>
   <!-- Main Script -->
   <script src="js/script.js"></script>
   
   <script src="js/greenmarket.js"></script>

</body>

</html>