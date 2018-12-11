<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

  <!-- mobile responsive meta -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

  <!-- ** Plugins Needed for the Project ** -->
  <!-- Bootstrap -->
  <link rel="stylesheet" href="plugins/bootstrap/bootstrap.min.css">
  <link rel="stylesheet" href="plugins/themify-icons/themify-icons.css">
  <link rel="stylesheet" href="plugins/slick/slick.css">
  <link rel="stylesheet" href="plugins/venobox/venobox.css">
  <link rel="stylesheet" href="plugins/animate/animate.css">
  <link rel="stylesheet" href="plugins/aos/aos.css">
  <link rel="stylesheet" href="plugins/bootstrap-touchspin-master/jquery.bootstrap-touchspin.min.css">
  <link rel="stylesheet" href="plugins/nice-select/nice-select.css">
  <link rel="stylesheet" href="plugins/bootstrap-slider/bootstrap-slider.min.css">

  <!-- Main Stylesheet -->
  <link href="css/style.css" rel="stylesheet">

  <!--Favicon-->
  <link rel="shortcut icon" href="images/favicon.png" type="image/x-icon">
  <link rel="icon" href="images/favicon.png" type="image/x-icon">
<script type="text/javascript" src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js" charset="utf-8"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

</head>

<body>

  <!-- preloader start -->
  <div class="preloader">
    <img src="images/preloader.gif" alt="preloader">
  </div>
  <!-- preloader end -->

<section class="signin-page account">
  <div class="container">
    <div class="row">
      <div class="col-md-6 mx-auto">
        <div class="block text-center">
          <a class="logo" href="index.html">
            <img src="images/logo.png" alt="logo" width="100px" height="100px">
          </a>
          <h2 class="text-center">You Know What To Do...</h2>
          <form class="text-left clearfix" method="post" action="NoticeBoard.do">
            <div class="form-group">
              <input type="text" name="admin_id" class="form-control"  placeholder="Admin Account">
            </div>
            <div class="form-group">
              <input type="password" name="adminPw"class="form-control" placeholder="Password">
            </div>
            <div class="text-center">
              <button type="submit" class="btn btn-primary" >Login</button>
            </div>
            <input type="hidden" name="command" value="adminLogin">
          </form>
          <p class="mt-3">New in this site ?<a href="login.jsp"> Login With SNS Now!</a></p>
        </div>
      </div>
    </div>
  </div>
</section>

</div>
<!-- /main wrapper -->

<!-- jQuery -->
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
<script src="../../../maps.googleapis.com/maps/api/js7402?key=AIzaSyBI14J_PNWVd-m0gnUBkjmhoQyNyd7nllA"></script>
<script src="plugins/google-map/gmap.js"></script>
<!-- Main Script -->
<script src="js/script.js"></script>
</body>

<!-- Mirrored from demo.themefisher.com/themefisher/elite-shop/login.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 21 Nov 2018 12:11:31 GMT -->
</html>