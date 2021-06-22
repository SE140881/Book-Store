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
                            <h2>Cart List</h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--================Cart Area =================-->
    <section class="cart_area section_padding">
        <div class="container">
            <div class="cart_inner">
                <div class="table-responsive">
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col" style="font-size: 20px;">Product</th>
                                <th scope="col" style="font-size: 20px;">Price</th>
                                <th scope="col" style="font-size: 20px;">Quantity</th>
                                <th scope="col" style="font-size: 20px;">Total</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:if test="${empty sessionScope.CART || empty sessionScope.LIST_CART}">
                            <h1>
                                Cart empty!
                            </h1>
                            </c:if>
                        <c:if test="${not empty sessionScope.CART || not empty sessionScope.LIST_CART}">
                            <c:set var="listBook" value="${sessionScope.LIST_BOOK}"/>
                            <form>
                                <c:forEach var="itemCart" items="${sessionScope.LIST_CART}" varStatus="counter">
                                    <c:forEach var="bookCart" items="${listBook}">
                                        <c:if test="${itemCart.key.trim() eq bookCart.bookID.trim()}">
                                            <tr>
                                                <td>
                                                    <div class="media">
                                                        <div class="d-flex">
                                                            <img src="./images/image_Book/${bookCart.image}" alt="" />
                                                        </div>
                                                        <div class="media-body">
                                                            <p>${bookCart.tittle}</p>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <h5>${bookCart.price}$</h5>
                                                </td>
                                                <td>
                                                    <div class="product_count">
                                                        <a href="MainController?action=InDe&flag=true&id=${bookCart.bookID}" style="color: black"> 
                                                            +
                                                        </a>
                                                        <p>
                                                            ${itemCart.value}
                                                        </p>
                                                        <a href="MainController?action=InDe&flag=false&id=${bookCart.bookID}" style="color: black"> 
                                                            -
                                                        </a>
                                                    </div>
                                                </td>
                                                <td>
                                                    ${String.format("%,.0f", itemCart.value * bookCart.price)}$
                                                </td>
                                                <td>
                                                    <form action="MainController">
                                                        <a style="color: black" href="MainController?action=Remove&removeID=${bookCart.bookID.trim()}">Remove</a>
                                                    </form>

                                                </td>
                                                <td>
                                                    <c:set var="total" value="${total + (itemCart.value * bookCart.price)}"/>
                                                </td>
                                            </tr>
                                        </c:if>
                                    </c:forEach>
                                </c:forEach>
                            </form>
                        </c:if>
                        <tr>
                            <td></td>
                            <td></td>
                            <td>
                                <h4>Subtotal</h4>
                            </td>
                            <td>
                                <h4>
                                    ${total > 0 ? String.format("%,.0f", total) : 0}$
                                </h4>
                            </td>
                        </tr>

                        </tbody>
                    </table>
                    <div class="checkout_btn_inner float-right">
                        <form action="MainController">
                            <a class="btn_1" href="shop.jsp">Continue Shopping</a>
                            <button class="btn_1 checkout_btn_1" type="submit" name="action" value="processToCheckout" > 
                                Proceed to checkout
                            </button>
                        </form>
                    </div>
                </div>
            </div>
    </section>
    <!--================End Cart Area =================-->
    <div style="height: 50px">

    </div>
</main>

<%@include file="footer.jsp" %>