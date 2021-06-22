<%@include file="header.jsp" %>
    <main>
        <!--? Hero Area Start-->
        <div class="slider-area ">
            <div class="single-slider slider-height2 d-flex align-items-center">
                <div class="container">
                    <div class="row">
                        <div class="col-xl-12">
                            <div class="hero-cap text-center">
                                <h2>Register</h2>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--? Hero Area End-->
        <!-- ================ contact section start ================= -->
        <section class="contact-section">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <h2 class="contact-title">Let us know your information</h2>
                    </div>
                    <div class="col-lg-8">
                        <form class="form-contact contact_form" action="MainController" method="POST">
                            <div class="row">
                                <div class="col-sm-6">
                                    <font color="red">
                                    ${requestScope.CREATEFAIL.userIDError}
                                    </font>
                                    <div class="form-group">
                                        <input class="form-control valid" name="txtUserID" type="text"  placeholder="Enter user id">
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <font color="red">
                                    ${requestScope.CREATEFAIL.userNameError}
                                    </font>
                                    <div class="form-group">
                                        <input class="form-control valid" name="txtUserName" type="text" placeholder="What your name?">
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <font color="red">
                                    ${requestScope.CREATEFAIL.passwordError}
                                    </font>
                                    <div class="form-group">
                                        <input class="form-control valid" name="txtPassword" type="password" placeholder="Password">
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <font color="red">
                                    ${requestScope.CREATEFAIL.confirmError}
                                    </font>
                                    <div class="form-group">
                                        <input class="form-control valid" name="txtConfirm" type="password" placeholder="Confirm Password">  
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <font color="red">
                                    ${requestScope.CREATEFAIL.phoneError}
                                    </font>
                                    <div class="form-group">
                                        <input class="form-control valid" name="txtPhone" type="text" placeholder="Phone number">  
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <font color="red">
                                    ${requestScope.CREATEFAIL.emailError}
                                    </font>
                                    <div class="form-group">
                                        <input class="form-control valid" name="txtEmail" type="text" placeholder="Email">  
                                    </div>
                                </div>
                                <div class="col-12">
                                    <font color="red">
                                    ${requestScope.CREATEFAIL.addressError}
                                    </font>
                                    <div class="form-group">
                                        <input class="form-control" name="txtAddress" type="text" placeholder="Address">
                                    </div>
                                </div>
                            </div>
                            <div class="form-group mt-3">
                                <button type="submit" name="action" value="Register" class="button button-contactForm boxed-btn">Register</button>
                            </div>
                        </form>
                    </div>
                    <div class="col-lg-3 offset-lg-1">
                        <div class="media contact-info">
                            <span class="contact-info__icon"><i class="ti-home"></i></span>
                            <div class="media-body">
                                <h3>9 District, Ho Chi Minh city</h3>
                                <p>666 Le Van Viet</p>
                            </div>
                        </div>
                        <div class="media contact-info">
                            <span class="contact-info__icon"><i class="ti-tablet"></i></span>
                            <div class="media-body">
                                <h3>+84 346 754 957</h3>
                                <p>Monday to Sunday</p>
                                <p>09:00 - 21:00</p>
                            </div>
                        </div>
                        <div class="media contact-info">
                            <span class="contact-info__icon"><i class="ti-email"></i></span>
                            <div class="media-body">
                                <h3>support.bshop@gmail.com</h3>
                                <p>Send us your query anytime!</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- ================ contact section end ================= -->
    </main>
<%@include file="footer.jsp" %>