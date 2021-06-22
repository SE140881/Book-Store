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
                            <h2>Checkout</h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--================Checkout Area =================-->
    <form action="MainController" method="POST">
    <section class="checkout_area section_padding">
        <div class="container">

            <div class="billing_details">
                <div class="row">
                    <div class="col-lg-8">
                        <div class="cupon_area">
                            <div class="check_title">
                                <h3>
                                    Have a voucher?
                                </h3>
                                <!--<form action="MainController">-->
                                <span style="color: red">
                                    ${sessionScope.EXPIRE_VOU}
                                </span>
                                <input type="text" name="codeOrder"  placeholder="Enter voucher code" />
                                <input type="hidden" name="userIDOrder" value="${sessionScope.USER.userID}" />

                                <button class="tp_btn" name="action" type="submit" value="apply">
                                    Apply Voucher
                                </button>
                                <!--</form>-->
                            </div>
                        </div>
                        <h3>Shipping Information</h3>
                            <div class="col-md-12 form-group p_star">
                                <input type="text" class="form-control" id="city" name="name"
                                       placeholder="Your Name" disabled="true" 
                                       value="${sessionScope.USER.userName}"/>

                            </div>

                            <div class="col-md-6 form-group p_star">
                                <input type="text" class="form-control" id="number" name="phone" 
                                       placeholder="Phone" disabled="true" 
                                       value="${sessionScope.USER.phone}"/>
                            </div>

                            <div class="col-md-6 form-group p_star">
                                <input type="text" class="form-control" id="email" name="email" 
                                       placeholder="Email" disabled="true" 
                                       value="${sessionScope.USER.email}"/>
                            </div>

                            <div class="col-md-12 form-group p_star">
                                <input type="text" class="form-control" id="city" name="addressOrder" 
                                       placeholder="Address" 
                                       value="${sessionScope.USER.address}"/>
                            </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="order_box">
                            <h2>Your Order</h2>
                            <c:if test="${empty sessionScope.CART || empty sessionScope.LIST_CART}">
                                <h2>
                                    Cart empty!
                                </h2>
                            </c:if>
                            <ul class="list">
                                <li>
                                    <a href="#">Product
                                        <span>Total</span>
                                    </a>
                                </li>
                                <c:if test="${not empty sessionScope.CART || not empty sessionScope.LIST_CART}">
                                    <c:forEach var="itemCart" items="${sessionScope.LIST_CART}">
                                        <c:forEach var="bookCart" items="${sessionScope.LIST_BOOK}">
                                            <c:if test="${itemCart.key.trim() eq bookCart.bookID.trim()}">
                                                <li>
                                                    <a
                                                        <span> 
                                                            ${bookCart.tittle.trim()} 
                                                        </span> 
                                                        <span class="middle">
                                                            x ${itemCart.value}
                                                        </span>
                                                        <span class="last">
                                                            ${String.format("%,.0f", itemCart.value * bookCart.price)}
                                                        </span>
                                                        <c:set var="total" value="${total + (itemCart.value * bookCart.price)}" />
                                                    </a>
                                                </li>
                                            </c:if>
                                        </c:forEach>
                                    </c:forEach>
                                </c:if>
                            </ul>
                            <ul class="list list_2">
                                <li>
                                    <a href="#">Subtotal
                                        <span>
                                            ${total > 0 ? String.format("%,.0f", total) : 0}$
                                        </span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">Shipping
                                        <span>Flat rate: $5.00</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">Voucher
                                        <span>Sale: ${sessionScope.VOU_SUCCESS.value}%</span>
                                        <c:set var="voucher" value="${(sessionScope.VOU_SUCCESS.value) / 100}" />
                                        <input type="hidden" name="voucherCode" value="${sessionScope.VOU_SUCCESS.code}" />
                                    </a>
                                </li>
                                <li>
                                    <a href="#">Total
                                        <span>
                                            <c:if test="${empty sessionScope.VOU_SUCCESS}">
                                                ${total > 0 ? String.format("%,.2f", total + 5) : 0}$
                                                <c:set var="lastTotal" value="${total + 5}" />
                                            </c:if>

                                            <c:if test="${not empty sessionScope.VOU_SUCCESS}">
                                                ${total > 0 ? String.format("%,.2f", total - (total * voucher) + 5) : 0}$
                                                <c:set var="lastTotal" value="${total - (total * voucher) + 5}" />
                                            </c:if>
                                                
                                        </span>
                                    </a>
                                </li>
                            </ul>

                            <div class="payment_item active">
                                <div class="radion_btn">
                                    <input type="radio" id="f-option6" name="selector" />
                                    <label for="f-option6">Paypal </label>
                                    <img src="img/product/single-product/card.jpg" alt="" />
                                    <div class="check"></div>
                                </div>
                                <p>
                                    Please send a check to Store Name, Store Street, Store Town,
                                    Store State / County, Store Postcode.
                                </p>
                            </div>

                            
                                <input type="hidden" name="userIDOrder" value="${sessionScope.USER.userID}" />
                                <!--<input type="hidden" name="takeAddress" value="" />-->
                                <input type="hidden" name="totalOrder" value="${lastTotal}" />
                                
                                <input type="hidden" name="bookIDOrder" value="${bookID}" />
                                <input type="hidden" name="priceOrder" value="${price}" />
                                <input type="hidden" name="quantityOrder" value="${quantity}" />
                                <input type="hidden" name="tittleOrder" value="${tittle}" />
                                <button class="btn_3" type="submit" name="action" value="paypal" style="width: 300px">
                                Process to Pay
                                </button>  
                                
<!--                            </form>-->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    </form>
    <!--================End Checkout Area =================-->
</main>
<div style="height: 50px"> </div>
<%@include file="footer.jsp" %>