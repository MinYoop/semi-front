<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>  


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html lang="zxx">


<!-- Mirrored from demo.themefisher.com/themefisher/elite-shop/cart.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 21 Nov 2018 12:10:32 GMT -->
<head>
  <meta charset="utf-8">
  <title>Elite Shop</title>

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
  <link href="css/contents.css" rel="stylesheet">
  <link href="css/common.css" rel="stylesheet">
  <link href="css/global.css" rel="stylesheet">

  <!--Favicon-->
  <link rel="shortcut icon" href="images/favicon.png" type="image/x-icon">
  <link rel="icon" href="images/favicon.png" type="image/x-icon">
  
  <!-- image -->
  
  <meta property="og:images" content="">
  

</head>

<body>

  <!-- preloader start -->
  <div class="preloader">
    <img src="images/preloader.gif" alt="preloader">
  </div>
  <!-- preloader end -->

<!-- header -->
<header>
  <!-- top advertise -->
  <!-- <div class="alert alert-secondary alert-dismissible fade show rounded-0 pb-0 mb-0" role="alert">
    <div class="d-flex justify-content-between">
      <p>SAVE UP TO $50</p>
      <h4>SALE!</h4>
      <div class="shop-now">
        <a href="shop.html" class="btn btn-sm btn-primary">Shop Now</a>
      </div>
    </div>
    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
      <span aria-hidden="true">&times;</span>
    </button>
  </div> -->

  <!-- top header -->
  <div class="top-header">
    <div class="row">
      <div class="col-lg-6 text-center text-lg-left">
        <p class="text-white mb-lg-0 mb-1">Free shipping • Free 30 days return • Express delivery</p>
      </div>
      <div class="col-lg-6 text-center text-lg-right">
        <ul class="list-inline">
          <li class="list-inline-item"><img src="images/flag.jpg" alt="flag"></li>
          <li class="list-inline-item"><a href="dashboard.html">My Accounts</a></li>
          <li class="list-inline-item">
            <form action="#">
              <select class="country" name="country">
                <option value="USD">USD</option>
                <option value="JPN">JPN</option>
                <option value="BAN">BAN</option>
              </select>
            </form>
          <li class="list-inline-item">
            <a class="active" href="#">EN</a>
            <a href="#">FR</a>
          </li>
        </ul>
      </div>
    </div>
  </div>
  <!-- /top-header -->
</header>

<!-- navigation -->
<nav class="navbar navbar-expand-lg navbar-light bg-white w-100" id="navbar">
  <a class="navbar-brand order-2 order-lg-1" href="index.jsp"><img class="img-fluid" src="images/logo.png" width="100px" height="50px" alt="logo"></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse order-1 order-lg-2" id="navbarSupportedContent">
    <ul class="navbar-nav mx-auto">
      <li class="nav-item">
        <a class="nav-link" href="index.html">home</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="shop.html" role="button" data-toggle="dropdown" aria-haspopup="true"
          aria-expanded="false">
          shop
        </a>
        <div class="dropdown-menu">
          <a class="dropdown-item" href="shop.html">Shop</a>
          <a class="dropdown-item" href="shop-list.html">Shop List</a>
          <a class="dropdown-item" href="product-single.html">Product Single</a>
          <a class="dropdown-item" href="checkout.html">Checkout</a>
          <a class="dropdown-item" href="cart.html">Cart</a>
          <a class="dropdown-item" href="shipping.html">Shipping Method</a>
          <a class="dropdown-item" href="payment.html">Payment Method</a>
          <a class="dropdown-item" href="review.html">Review</a>
          <a class="dropdown-item" href="confirmation.html">Confirmation</a>
        </div>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true"
          aria-expanded="false">
          pages
        </a>
        <div class="dropdown-menu">
          <a class="dropdown-item" href="about.html">About Us</a>
          <a class="dropdown-item" href="contact.html">Contact Us</a>
          <a class="dropdown-item" href="login.html">Login</a>
          <a class="dropdown-item" href="signin.html">Signup</a>
          <a class="dropdown-item" href="forget-password.html">Forget Password</a>
          <a class="dropdown-item" href="dashboard.html">Dashboard</a>
          <a class="dropdown-item" href="faq.html">FAQ</a>
          <a class="dropdown-item" href="404.html">404 Page</a>
          <a class="dropdown-item" href="coming-soon.html">Coming Soon</a>
          <a class="dropdown-item" href="blog-grid.html">Blog</a>
          <a class="dropdown-item" href="blog-single.html">Blog Single</a>
        </div>
      </li>
      <li class="nav-item dropdown mega-dropdown">
        <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true"
          aria-expanded="false">
          
        </a>
        <div class="dropdown-menu mega-menu">
          <div class="mx-3 mega-menu-item">
            <h6>Men</h6>
            <ul class="pl-0">
              <li><a href="shop.html">Jackets & Coats</a></li>
              <li><a href="shop.html">Jeans</a></li>
              <li><a href="shop.html">Top & T-Shirts</a></li>
              <li><a href="shop.html">Dresses</a></li>
              <li><a href="shop.html">Men Shirts</a></li>
            </ul>
          </div>
          <div class="mx-3 mega-menu-item">
            <h6>Women</h6>
            <ul class="pl-0">
              <li><a href="shop.html">Blouses & Shirts</a></li>
              <li><a href="shop.html">Dresses</a></li>
              <li><a href="shop.html">Top & T-Shirts</a></li>
              <li><a href="shop.html">Jeans & Trousers</a></li>
              <li><a href="shop.html">Jackets & Coats</a></li>
            </ul>
          </div>
          <div class="mx-3 mega-menu-item">
            <h6>Shoes & Bags</h6>
            <ul class="pl-0">
              <li><a href="shop.html">Backpacks</a></li>
              <li><a href="shop.html">Bum Bags</a></li>
              <li><a href="shop.html">Accross Bags</a></li>
              <li><a href="shop.html">Shoes</a></li>
              <li><a href="shop.html">Heeled Shoes</a></li>
            </ul>
          </div>
          <div class="mx-3 mega-menu-item">
            <h6>Accessories</h6>
            <ul class="pl-0">
              <li><a href="shop.html">Sunglasses</a></li>
              <li><a href="shop.html">Watches</a></li>
              <li><a href="shop.html">Gloves</a></li>
              <li><a href="shop.html">Capes & Hats</a></li>
              <li><a href="shop.html">Belts</a></li>
            </ul>
          </div>
          <div class="mx-3 mega-megu-image">
            <img class="img-fluid h-100" src="images/mega-megu.jpg" alt="feature-img">
          </div>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="contact.html">Contact Us</a>
      </li>
    </ul>
  </div>
  <div class="order-3 navbar-right-elements">
    <div class="search-cart">
      <!-- search -->
      <div class="search">
        <button id="searchOpen" class="search-btn"><i class="ti-search"></i></button>
        <div class="search-wrapper">
          <form action="#">
            <input class="search-box" id="search" type="search" placeholder="Enter Keywords...">
            <button class="search-icon" type="submit"><i class="ti-search"></i></button>
          </form>
        </div>
      </div>
      <!-- cart -->
      <div class="cart">
        <button id="cartOpen" class="cart-btn"><i class="ti-bag"></i><span class="d-xs-none">CART</span> 3</button>
        <div class="cart-wrapper">
          <i id="cartClose" class="ti-close cart-close"></i>
          <h4 class="mb-4">Your Cart</h4>
          <ul class="pl-0 mb-3">
            <li class="d-flex border-bottom">
              <img src="images/cart/product-1.jpg" alt="product-img">
              <div class="mx-3">
                <h6>Eleven Paris Skinny Jeans</h6>
                <span>1</span> X <span>$79.00</span>
              </div>
              <i class="ti-close"></i>
            </li>
            <li class="d-flex border-bottom">
              <img src="images/cart/product-2.jpg" alt="product-img">
              <div class="mx-3">
                <h6>Eleven Paris Skinny Jeans top</h6>
                <span>1 X</span> <span>$79.00</span>
              </div>
              <i class="ti-close"></i>
            </li>
          </ul>
          <div class="mb-3">
            <span>Cart Total</span>
            <span class="float-right">$79.00</span>
          </div>
          <div class="text-center">
            <a href="cart.html" class="btn btn-dark btn-mobile rounded-0">view cart</a>
            <a href="checkout.html" class="btn btn-dark btn-mobile rounded-0">check out</a>
          </div>
        </div>
      </div>
    </div>
  </div>
</nav>
<!-- /navigation -->

<!-- main wrapper -->
<div class="main-wrapper">

<!-- breadcrumb -->
<nav class="bg-gray py-3">
  <div class="container">
    <ol class="breadcrumb">
      <li class="breadcrumb-item"><a href="index.html">Home</a></li>
      <li class="breadcrumb-item active" aria-current="page">Cart</li>
    </ol>
  </div>
</nav>
<!-- /breadcrumb -->
<h2 class="sub-title2">배송상품</h2>	
<table class="tbl_prd_list">
<colgroup>

					<col style="width:40px" />

					<col style="width:160px" />

					<col style="width:110px" />

					<col style="width:100px" />

					<col style="width:110px" />					

					<col style="width:120px" />

					<col style="width:150px" />

				</colgroup>

				<thead>

				<tr>

					<th scope="col"><input type="checkbox" checked id="inp_allRe1" name="" value="" disabled="disabled" title="올리브영 배송상품 전체 선택" /></th>

					<th scope="col">상품정보</th>

					<th scope="col">판매가</th>

					<th scope="col">수량</th>

					<th scope="col">구매가</th>					

					<th scope="col">배송정보</th>

					<th scope="col">선택</th>					

				</tr>
				</thead>
				
				<tbody>
				
				
				<c:choose>
					<c:when test="${empty basketlist }">
				<tr>	
				   <td colspan="7" class="no_data">  장바구니에 저장된 상품이 없습니다.</td>
				   </tr>
				   </c:when>
				   <c:otherwise>
				   <c:forEach var="dto" items="${basketlist  }">
				   <tr>
				   <td></td>
				  <td></td> 
				   <td></td>
				   <td></td>
				   </tr>
				   
				   </c:forEach>
				   </c:otherwise>
				   </c:choose>
				   
				   </tbody>
			
</table>		
       <!--  <td><input type="text" value="1" name="cart-quantity"></td>  숫자 올려주는-->    
                <hr>
                <div class="d-flex flex-column flex-md-row align-items-center">
                  <input type="text" class="form-control text-md-left text-center mb-3 mb-md-0" name="coupon" id="coupon" placeholder="I Love you">
                  <button class="btn btn-outline-primary ml-md-3 w-100 mb-3 mb-md-0">쿠폰</button>
                  <a href="#" class="btn ml-md-4 btn-dark w-100">Update Cart</a>
                </div>
                <hr>
                
               
                <div class="basket_price_info">
				
				
				<div class="sum_price" >총 판매가 <span class="tx_num">0</span>원 <span class="tx_sign minus">-</span> 총 할인금액 <span class="tx_num">0</span>원 <span class="tx_sign plus">+</span> 배송비 <span class="tx_num">0</span>원 <span class="tx_sign equal">=</span> <span class="tx_total_price">총 결제금액 <span class="tx_price"><span class="tx_num">0</span>원</span></span></div>
		     	</div>
		     	
		        <div class="total_price_info">
		           <div class="detail_price">
		             <p>총 판매가<span><span class="tx_num">0</span>원</span></p>
		             <span class="tx_sign2 minus">-</span>
		             <p class= "tx_sale">총 할인금액<span><span class="tx_num">0</span>원</span></p>
		             
		             <span class="tx_sign2 plus">+</span>
		             <p>배송비<span><span class="tx_num">0</span>원</span></p>
		           
		           </div>
		           
		           <div class="sum_price">
		             <span class="tx_text">배송비는 쿠폰할인금액에 따라 변경될 수 있습니다.</span>
		             총 결제예상금액<span class="tx_price"><span class="tx_num">0</span>원</span>
		           
		           </div>
		           
		        
		        
		        </div>
                  
               
                <hr>
                <a href="coming-soon.html" class="btn btn-primary float-right">결제</a>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>


<!-- footer -->
<footer class="bg-light">
  <div class="section">
    <div class="container">
      <div class="row">
        <div class="col-md-3 col-sm-6 mb-5 mb-md-0 text-center text-sm-left">
          <h3 class="mb-4">Contact</h3>
          <p>20464 Hirthe Curve Suite, Emardton, CT 12471-4107</p>
          <p>+5(305) 785-0437</p>
          <p>info@example.com</p>
          <ul class="list-inline social-icons">
            <li class="list-inline-item"><a href="#"><i class="ti-facebook"></i></a></li>
            <li class="list-inline-item"><a href="#"><i class="ti-twitter-alt"></i></a></li>
            <li class="list-inline-item"><a href="#"><i class="ti-vimeo-alt"></i></a></li>
            <li class="list-inline-item"><a href="#"><i class="ti-google"></i></a></li>
          </ul>
        </div>
        <div class="col-md-3 col-sm-6 mb-5 mb-md-0 text-center text-sm-left">
          <h3 class="mb-4">Category</h3>
          <ul class="pl-0 list-unstyled">
            <li class="mb-2"><a class="text-color" href="shop.html">Men</a></li>
            <li class="mb-2"><a class="text-color" href="shop.html">Women</a></li>
            <li class="mb-2"><a class="text-color" href="shop.html">Kids</a></li>
            <li class="mb-2"><a class="text-color" href="shop.html">Accessories</a></li>
            <li class="mb-2"><a class="text-color" href="shop.html">Shoe</a></li>
          </ul>
        </div>
        <div class="col-md-3 col-sm-6 mb-5 mb-md-0 text-center text-sm-left">
          <h3 class="mb-4">Useful Link</h3>
          <ul class="pl-0 list-unstyled">
            <li class="mb-2"><a class="text-color" href="about.html">News & Tips</a></li>
            <li class="mb-2"><a class="text-color" href="about.html">About Us</a></li>
            <li class="mb-2"><a class="text-color" href="address.html">Support</a></li>
            <li class="mb-2"><a class="text-color" href="shop.html">Our Shop</a></li>
            <li class="mb-2"><a class="text-color" href="contact.html">Contact Us</a></li>
          </ul>
        </div>
        <div class="col-md-3 col-sm-6 text-center text-sm-left">
          <h3 class="mb-4">Our Policies</h3>
          <ul class="pl-0 list-unstyled">
            <li class="mb-2"><a class="text-color" href="404.html">Privacy Policy</a></li>
            <li class="mb-2"><a class="text-color" href="404.html">Terms & Conditions</a></li>
            <li class="mb-2"><a class="text-color" href="404.html">Cookie Policy</a></li>
            <li class="mb-2"><a class="text-color" href="404.html">Terms of Sale</a></li>
            <li class="mb-2"><a class="text-color" href="dashboard.html">Free Shipping & Returns</a></li>
          </ul>
        </div>
      </div>
    </div>
  </div>
  <div class="bg-dark py-4">
    <div class="container">
      <div class="row">
        <div class="col-md-5 text-center text-md-left mb-4 mb-md-0 align-self-center">
          <p class="text-white mb-0">Logo &copy; 2018 all right reserved</p>
        </div>
        <div class="col-md-2 text-center text-md-left mb-4 mb-md-0">
          <img src="images/logo-alt.png" alt="logo">
        </div>
        <div class="col-md-5 text-center text-md-right mb-4 mb-md-0">
          <ul class="list-inline">
            <li class="list-inline-item"><img src="images/payment-card/card-1.jpg" alt="card"></li>
            <li class="list-inline-item"><img src="images/payment-card/card-2.jpg" alt="card"></li>
            <li class="list-inline-item"><img src="images/payment-card/card-3.jpg" alt="card"></li>
            <li class="list-inline-item"><img src="images/payment-card/card-4.jpg" alt="card"></li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</footer>
<!-- /footer -->

</div>
<!-- /main wrapper -->

<!-- jQuery -->
<script src="plugins/jQuery/jquery.min.js"></script>
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
<script src="js/cart.js"></script>
</body>

<!-- Mirrored from demo.themefisher.com/themefisher/elite-shop/cart.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 21 Nov 2018 12:10:32 GMT -->
</html>