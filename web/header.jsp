<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html class="no-js" lang="zxx">
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>BShop</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="manifest" href="site.webmanifest">
    <link rel="shortcut icon" type="image/x-icon" href="./img/favicon.ico">

    <!-- CSS here -->
        <link rel="stylesheet" href="./css/bootstrap.min.css">
        <link rel="stylesheet" href="./css/owl.carousel.min.css">
        <link rel="stylesheet" href="./css/flaticon.css">
        <link rel="stylesheet" href="./css/slicknav.css">
        <link rel="stylesheet" href="./css/animate.min.css">
        <link rel="stylesheet" href="./css/magnific-popup.css">
        <link rel="stylesheet" href="./css/fontawesome-all.min.css">
        <link rel="stylesheet" href="./css/themify-icons.css">
        <link rel="stylesheet" href="./css/slick.css">
        <link rel="stylesheet" href="./css/nice-select.css">
        <link rel="stylesheet" href="./css/style.css">
</head>

<body>
    <!--? Preloader Start -->
    <div id="preloader-active">
        <div class="preloader d-flex align-items-center justify-content-center">
            <div class="preloader-inner position-relative">
                <div class="preloader-circle"></div>
                <div class="preloader-img pere-text">
                    <img src="./images/logo.png" alt=""> 
                </div>
            </div>
        </div>
    </div>
    <!-- Preloader Start -->
    <header>
        <!-- Header Start -->
        <div class="header-area">
            <div class="main-header header-sticky" style="height: 140px">
                <div class="container-fluid">
                    <div class="menu-wrapper" style="height: 140px">
                        <!-- Logo -->
                        <div class="logo">
                            <a href="shop.jsp"><img src="./images/logo.png" alt=""></a>
                        </div>
                        <!-- Main-menu -->
                        <div class="main-menu d-none d-lg-block">
                            <nav>
                                <c:if test="${empty sessionScope.USER}">
                                <ul id="navigation">  
                                    <li><a style="font-size: 25px"  href="shop.jsp">Shop</a></li>
                                    <li><a style="font-size: 25px" href="blog.html">Blog</a></li>
                                    <li><a style="font-size: 25px" href="cart.jsp">Cart</a></li>
                                    <li><a style="font-size: 25px" href="login.jsp">Login</a></li>
                                </ul>
                                </c:if>
                                <c:if test="${not empty sessionScope.USER}">
                                    <ul id="navigation">  
                                    <li><a style="font-size: 25px"  href="shop.jsp">Shop</a></li>
                                    <li><a style="font-size: 25px" href="blog.html">Blog</a></li>
                                    <li><a style="font-size: 25px" href="cart.jsp">Cart</a></li>
                                    <li><a style="font-size: 25px" href="MainController?action=Logout">Logout</a></li>
                                    </ul>
                                </c:if>
                            </nav>
                        </div>
                        <!-- Header Right -->
                        <div class="header-right">
                            <ul>
                                <li class="dropdown">
                                    <span style="color: red">
                                        Welcome, ${sessionScope.USER.userName}!
                                    </span>
                                </li>
                                <li> <a href="login.jsp"><span class="flaticon-user"></span></a></li>
                                <li><a href="cart.jsp"><span class="flaticon-shopping-cart"></span></a> </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Header End -->
    </header>