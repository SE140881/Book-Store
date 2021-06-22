<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp" %>
    <main>
        <!-- Hero Area Start-->
        <div class="slider-area ">
            <div class="single-slider slider-height2 d-flex align-items-center">
                <div class="container">
                    <div class="row">
                        <div class="col-xl-12">
                            <div class="hero-cap text-center">
                                <h2>Book Shop</h2>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Hero Area End-->
        <!-- Latest Products Start -->
        <section class="popular-items latest-padding">
            <div class="container">
                
                    <div class="row product-btn justify-content-between mb-40">
                        <div class="properties__button">
                            <!--Nav Button  -->
                            <nav>                                                      
                                <div class="nav nav-tabs" id="nav-tab" role="tablist">
                                    <a class="nav-item nav-link active" id="nav-home-tab" 
                                       href="MainController?action=searchBook&search=${""}">All IT Book</a>
                                    <a class="nav-item nav-link active" id="nav-home-tab" 
                                       href="MainController?action=loadBook&cateID=${"IT001"}">C book</a>
                                    <a class="nav-item nav-link active" id="nav-home-tab" 
                                       href="MainController?action=loadBook&cateID=${"IT002"}">Java book</a> 
                                    <a class="nav-item nav-link active" id="nav-home-tab" 
                                       href="MainController?action=loadBook&cateID=${"IT003"}">React book</a>
                                </div>
                                
                            </nav>
                            <!--End Nav Button  -->
                        </div>
                        <!-- Grid and List view -->
                        <div class="grid-list-view">
                        </div>
                        <!-- Select items -->
                        <div class="select-this">
                            <form action="MainController">
                                <input type="text" name="search" value="" />
                                <button name="action" value="searchBook" type="submit">
                                    <span class="flaticon-search"></span>
                                </button>
                            </form>
                        </div>
                    </div>
                <!-- Nav Card -->
                <div class="tab-content" id="nav-tabContent">
                    <!-- card one -->
                    <c:if test="${empty sessionScope.BOOKLIST}">
                        <h3 style="color: red">
                            ${sessionScope.EMPTY}
                        </h3>
                    </c:if>
                    <c:if test="${not empty sessionScope.BOOKLIST}" var="checklist">
                    <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
                        <div class="row">
                            <c:forEach var="book" items="${sessionScope.BOOKLIST}">
                                <div class="col-sm-6 col-md-6 col-lg-4 col-xl-4">
                                    <div class="single-popular-items mb-50 text-center">
                                        <div class="popular-img">
                                            <img style="width: 360px; height: 490px" src="./images/image_Book/${book.image.trim()}" alt="">
                                            
                                        </div>
                                        <div class="popular-caption">
                                            <h3>
                                                <a href="product_details.html"> 
                                                    ${book.tittle}
                                                </a>
                                            </h3>
                                            <span>$ ${book.price}</span>
                                            <div class="img-cap">
                                                <form action="MainController">

                                                    <button type="submit" name="action" value="AddToCart" style="font-size: 24px; color: red">
                                                        Add to Cart
                                                    </button>
                                                    <input type="hidden" name="cartBookID" value="${book.bookID}" />
                                                    <input type="hidden" name="cartTittle" value="${book.tittle}" />
                                                    <input type="hidden" name="cartBookPrice" value="${book.price}" />
                                                    <input type="hidden" name="cartBookImage" value="${book.image}" />
                                                    <input type="hidden" name="cartBookQuantity" value="${book.quantity}" />
                                                </form>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                    </c:if>
                </div>
                <!-- End Nav Card -->
            </div>
        </section>
        <!-- Latest Products End -->
    </main>
<div style="height: 50px"></div>
<%@include file="footer.jsp" %>