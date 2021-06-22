<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>BShop</title>

        <!-- Bootstrap Core CSS -->
        <link href="./lib-manager/css/bootstrap.min.css" rel="stylesheet">
        <link href="./css/bootstrap-datetimepicker.min.css" rel="stylesheet">

        <!-- MetisMenu CSS -->
        <link href="./lib-manager/css/metisMenu.min.css" rel="stylesheet">

        <!-- DataTables CSS -->
        <link href="./lib-manager/css/dataTables/dataTables.bootstrap.css" rel="stylesheet">

        <!-- DataTables Responsive CSS -->
        <link href="./lib-manager/css/dataTables/dataTables.responsive.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="./lib-manager/css/startmin.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="./lib-manager/css/font-awesome.min.css" rel="stylesheet" type="text/css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>

        <div id="wrapper">

            <!-- Navigation -->
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#"><i class="fa fa-home fa-fw"></i>Admin</a>
                </div>
                <ul class="nav navbar-right navbar-top-links">
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="fa fa-user fa-fw"></i> Welcome, ${sessionScope.USER.userName}! <b class="caret"></b>
                        </a>
                        <form action="MainController" method="POST">
                            <ul class="dropdown-menu dropdown-user">
                                <li>
                                    <button type="submit" name="action" value="Logout"><i class="fa fa-sign-out fa-fw"></i> Logout</button>
                                </li>
                            </ul>
                        </form>
                    </li>
                </ul>

                <div class="navbar-default sidebar" role="navigation">
                    <div class="sidebar-nav navbar-collapse">
                        <ul class="nav" id="side-menu">
                            <li>
                                <a href="adminProduct.jsp"><i class="fa fa-table fa-fw"></i> Product Management</a>
                            </li>
                            <li>
                                <a href="adminUser.jsp"><i class="fa fa-table fa-fw"></i> User Management</a>
                            </li>
                            <li>
                                <a href="adminDiscount.jsp"><i class="fa fa-table fa-fw"></i> Discount Management</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <div id="page-wrapper">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">Discount Management</h1>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <form action="MainController" method="POST">
                                        Search: <input type="text" name="txtSearch" />
                                        <button type="submit"
                                                name="action"
                                                value="SearchUser"><i class="fa fa-search"></i></button>
                                    </form>
                                </div>
                                <div class="panel-body">
                                    <div class="table-responsive">
                                        <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                            <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>Code
                                                        <div style="height: 26px">                                                          
                                                        </div>
                                                    </th>
                                                    <th>Discount name
                                                        <div style="height: 28px">
                                                            <font color="red" class="ml-1">
                                                            ${requestScope.INVALID.newFullnameError}
                                                            </font>
                                                        </div>
                                                    </th>
                                                    <th>User ID
                                                        <div style="height: 28px">
                                                            <font color="red" class="ml-1">
                                                            ${requestScope.INVALID.newEmailError}
                                                            </font>
                                                        </div>
                                                    </th>
                                                    <th>Value
                                                        <div style="height: 28px">
                                                            <font color="red" class="ml-1">
                                                            ${requestScope.INVALID.newPasswordError}
                                                            </font>
                                                        </div>
                                                    </th>
                                                    <th>Begin Date
                                                        <div style="height: 28px">
                                                            <font color="red" class="ml-1">
                                                            ${requestScope.INVALID.newAddressError}
                                                            </font>
                                                        </div>
                                                    </th>
                                                    <th>Close Date
                                                        <div style="height: 28px">
                                                            <font color="red" class="ml-1">
                                                            ${requestScope.INVALID.newAddressError}
                                                            </font>
                                                        </div>
                                                    </th>
                                                    <th> Create Date
                                                        <div style="height: 28px">
                                                        </div>
                                                    </th>
                                                    <th></th>
                                                    <th></th>
                                                </tr>
                                            </thead>
                                            <tbody>       
                                                <c:if test="${sessionScope.LISTVOUCHER != null}" var="info">
                                                    <c:if test="${not empty sessionScope.LISTVOUCHER}" var="checkList">
                                                        <c:forEach var="vou" items="${sessionScope.LISTVOUCHER}" varStatus="counter">
                                                            <tr>
                                                                <form action="MainController" method="POST">
                                                                    <td>${counter.count}</td>
                                                                    <td>${vou.code}
                                                                        <input type="hidden" name="txtNewCode" value="${vou.code}" />
                                                                    </td>
                                                                    <td>
                                                                        <input type="text" name="txtNewDisName" value="${vou.name}" />
                                                                    </td>
                                                                    <td>
                                                                        <input type="text" name="txtNewUserID" value="${vou.userID}" />
                                                                    </td>
                                                                    <td>
                                                                        <input type="text" name="txtNewValue" value="${vou.value}" />                                                     
                                                                    </td>
                                                                    <td>
                                                                        <input type="text" name="txtNewBeginDate" value="${vou.beginDate}" />                                                    
                                                                    </td>
                                                                    <td>
                                                                        <input type="text" name="txtNewCloseDate" value="${vou.closeDate}" />                                                              
                                                                    </td>
                                                                    <td>
                                                                        ${vou.importDate}
                                                                    </td>
                                                                    <td>
                                                                        <button name="action" value="UpdateBook" type="submit">Update</button>
                                                                    </td>
                                                                    <td>
                                                                        
                                                                        <button name="action" value="DeleteVoucher" type="submit">Delete</button>           
                                                                    </td>
                                                                </form>
                                                            </tr>
                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${!checkList}">
                                                </c:if>
                                            </c:if> 
                                            </tbody>                                                
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <div class="panel panel-default">
                                <div>
                                    <h4 style="color: #007aff">
                                        Create Discount
                                    </h4>
                                    <font color="red">
                                        ${requestScope.CREATESUCCESS}
                                        ${requestScope.CREATEFAIL}
                                    </font>
                                </div>
                                <table border="1" 
                                       class="table table-striped table-bordered table-hover"
                                       id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th>
                                                Code
                                                <font color="red" class="ml-1">
                                                ${requestScope.VALIDFAL.bookIDError}
                                                </font>
                                            </th>
                                            <th>
                                                User ID
                                                <font color="red" class="ml-1">
                                                ${requestScope.VALIDFAL.tittleError}
                                                </font>
                                            </th>
                                            <th>
                                                Name 
                                                <font color="red" class="ml-1">
                                                ${requestScope.VALIDFAL.authorError}
                                                </font>
                                            </th>
                                            <th>
                                                Value 
                                                <font color="red" class="ml-1">
                                                ${requestScope.VALIDFAL.priceError}
                                                </font>
                                            </th>
                                            <th>
                                                Begin Date
                                                <font color="red" class="ml-1">
                                                ${requestScope.VALIDFAL.descriptionError}
                                                </font>
                                            </th>
                                            <th>
                                                Close Date
                                                <font color="red" class="ml-1">
                                                ${requestScope.VALIDFAL.descriptionError}
                                                </font>
                                            </th>
                                            <th style="width: 60px"></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                    <form action="MainController" method="POST">
                                        <td>
                                            <input  type="text" name="txtNewCode" value="" />
                                        </td>
                                        <td>
                                            <input type="text" name="txtNewUserID" value="" />
                                        </td>
                                        <td>
                                            <input type="text" name="txtNewName" value="" />
                                        </td>
                                        <td>
                                            <input type="text" name="txtNewValue" value="" />
                                        </td>
                                        <td>
                                            <input type="text" name="txtNewBeginDate" value="" />
                                        </td>
                                        <td>
<!--                                            <div class="well">
                                                <div id="datetimepicker1" class="input-append date">
                                                  <input data-format="dd/MM/yyyy hh:mm:ss" type="text"></input>
                                                  <span class="add-on">
                                                    <i data-time-icon="icon-time" data-date-icon="icon-calendar">
                                                    </i>
                                                  </span>
                                                </div>
                                            </div>
                                          <script type="text/javascript">
                                            $(function() {
                                              $('#datetimepicker1').datetimepicker({
                                                language: 'en'
                                              });
                                            });
                                          </script>-->
                                            <input type="text" name="txtNewCloseDate" value="" />
                                        </td>
                                        <td>
                                            <button name="action" type="submit" value="InsertVoucher">
                                                Insert
                                            </button>
                                        </td>
                                    </form>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>            
        </div>
        <!-- /#wrapper -->

        <!-- jQuery -->
        <script src="./lib-manager/js/jquery.min.js"></script>
        <script src="./js/bootstrap-datetimepicker.min.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="./lib-manager/js/bootstrap.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

        <!-- Metis Menu Plugin JavaScript -->
        <script src="./lib-manager/js/metisMenu.min.js"></script>

        <!-- DataTables JavaScript -->
        <script src="./lib-manager/js/dataTables/jqueryy.dataTables.min.js"></script>
        <script src="./lib-manager/js/dataTables/dataTables.bootstrap.min.js"></script>

        <!-- Custom Theme JavaScript -->
        <script src="./lib-manager/js/startmin.js"></script>

        <!-- Page-Level Demo Scripts - Tables - Use for reference -->
        <script>
            $(document).ready(function () {
                $('#dataTables-example').DataTable({
                    responsive: true
                });
            });
        </script>

    </body>
</html>
