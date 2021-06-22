<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta name="description" content="" />
        <meta name="author" content="" />

        <title>BShop</title>

        <!-- Bootstrap Core CSS -->
        <link href="./lib-manager/css/bootstrap.min.css" rel="stylesheet">

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
                    <a class="navbar-brand" href="#"
                       ><i class="fa fa-home fa-fw"></i>Admin</a
                    >
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
                            <h1 style="color: #007aff" class="page-header">Product Management</h1>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="panel panel-default">
                                <div class="panel-heading" style="height: 47px">
                                    <form action="MainController" method="POST" style="float: left">
                                        Search: <input type="text" name="txtSearchUser" />
                                        <button type="submit"
                                                name="action"
                                                value="AdminSearchUser"><i class="fa fa-search"></i></button>
                                    </form>
                                    <font color="red">
                                    ${sessionScope.DEL_USER}
                                    ${sessionScope.DEL_USERFAIL}
                                    ${sessionScope.UPDATE_USER}
                                    ${sessionScope.UPDATE_USERFAIL}
                                    ${sessionScope.SEARCH_USERFAIL}
                                    </font>
                                </div>
                                <div class="panel-body">
                                    <div class="table-responsive">
                                        
                                        <table
                                            class="table table-striped table-bordered table-hover"
                                            id="dataTables-example"
                                            >
                                            <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th> User ID
                                                        <div style="height: 8px">                                                          
                                                        </div>
                                                    </th>
                                                    <th>
                                                        Full name
                                                        <font color="red" class="ml-1">
                                                        ${sessionScope.INVALID.newUserNameError}
                                                        </font>
                                                    </th>
                                                    <th>
                                                        Address
                                                        <font color="red" class="ml-1">
                                                        ${sessionScope.INVALID.newAddressError}
                                                        </font>
                                                    </th>
                                                    <th>
                                                        Phone
                                                        <font color="red" class="ml-1">
                                                        ${sessionScope.INVALID.newPhoneError}
                                                        </font>
                                                    </th>
                                                    <th>
                                                        Email
                                                        <font color="red" class="ml-1">
                                                        ${sessionScope.INVALID.newEmailError}
                                                        </font>
                                                    </th>
                                                    <th>
                                                        Role ID
                                                    </th>
                                                    <th></th>
                                                    <th></th>
                                                </tr>
                                            </thead>
                                            <tbody>       
                                                <c:if test="${sessionScope.USERLIST != null}" var="info">
                                                    <c:if test="${not empty sessionScope.USERLIST}" var="checkList">
                                                        <c:forEach var="user" items="${sessionScope.USERLIST}" varStatus="counter">
                                                            <tr>
                                                                <form action="MainController" method="POST">
                                                                    <td>${counter.count}</td>
                                                                    <td>${user.userID}
                                                                        <input type="hidden" name="txtUserIDUp" value="${user.userID}" />
                                                                    </td>
                                                                    <td>
                                                                        <input type="text" name="txtUserNameUp" value="${user.userName}" />
                                                                    </td>
                                                                    <td>
                                                                        <input type="text" name="txtAddressUp" value="${user.address}" />
                                                                    </td>
                                                                    <td>
                                                                        <input type="text" name="txtPhoneUp" value="${user.phone}" />
                                                                    </td>
                                                                    <td>
                                                                        <input type="text" name="txtEmailUp" value="${user.email}" />                                                     
                                                                    </td>
                                                                    <td>
                                                                        <select name="cbxRoleUp">
                                                                            <option 
                                                                                <c:if test="${user.roleID eq 'US'}"> 
                                                                                    selected="true"
                                                                                </c:if> 
                                                                                value="US"
                                                                                >User</option>
                                                                            <option 
                                                                                <c:if test="${user.roleID eq 'AD'}">
                                                                                    selected="true"
                                                                                </c:if> 
                                                                                value="AD"         
                                                                                >Admin</option>
                                                                            
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <button name="action" value="UpdateUser" type="submit">Update</button>
                                                                    </td>
                                                                    <td>
                                                                        
                                                                        <button name="action" value="DeleteUser" type="submit">Delete</button>           
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
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- /#wrapper -->

        <!-- jQuery -->
                     
        <script src="./lib-manager/js/jquery.min.js"></script>

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
                $("#dataTables-example").DataTable({
                    responsive: true,
                });
            });
        </script>
    </body>
</html>
