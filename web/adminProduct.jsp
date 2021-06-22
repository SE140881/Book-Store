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
                                        Search: <input type="text" name="txtSearchBA" />
                                        <button type="submit"
                                                name="action"
                                                value="AdminSearchBook"><i class="fa fa-search"></i></button>
                                    </form>
                                    <font color="red">
                                        ${requestScope.DELSUCCESS}
                                        ${requestScope.DELFAIL}
                                        ${requestScope.UPDATESUCCESS}
                                        ${requestScope.UPDATEFAIL}
                                        ${requestScope.SEARCHFAIL}
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
                                                    <th>Book ID
                                                        <div style="height: 8px">                                                          
                                                        </div>
                                                    </th>
                                                    <th>
                                                        Tittle
                                                        <font color="red" class="ml-1">
                                                            ${requestScope.INVALID.tittleError}
                                                        </font>
                                                    </th>
                                                    <th style="width: 50px">
                                                        Price ($)
                                                        <font color="red" class="ml-1">
                                                            ${requestScope.INVALID.priceError}
                                                        </font>
                                                    </th>
                                                    <th>
                                                        Author
                                                        <font color="red" class="ml-1">
                                                            ${requestScope.INVALID.authorError}
                                                        </font>
                                                    </th>
                                                    <th>
                                                        Description
                                                        <font color="red" class="ml-1">
                                                            ${requestScope.INVALID.descriptionError}
                                                        </font>
                                                    </th>
                                                    <th style="width: 50px">
                                                        Quantity
                                                        <font color="red" class="ml-1">
                                                            ${requestScope.INVALID.quantityError}
                                                        </font>
                                                    </th>
                                                    <th>
                                                        Image
                                                        <font color="red" class="ml-1">
                                                            ${requestScope.INVALID.imageError}
                                                        </font>
                                                    </th>
                                                    <th>Import Date</th>
                                                    <th>Category</th>
                                                    <th></th>
                                                    <th></th>
                                                </tr>
                                            </thead>
                                            <tbody>       
                                                <c:if test="${sessionScope.BOOKLIST != null}" var="info">
                                                    <c:if test="${not empty sessionScope.BOOKLIST}" var="checkList">
                                                        <c:forEach var="book" items="${sessionScope.BOOKLIST}" varStatus="counter">
                                                            <tr>
                                                                <form action="MainController" method="POST">
                                                                    <td>${counter.count}</td>
                                                                    <td>${book.bookID}
                                                                        <input type="hidden" name="txtNewBookID" value="${book.bookID}" />
                                                                    </td>
                                                                    <td>
                                                                        <input type="text" name="txtNewTittle" value="${book.tittle}" />
                                                                    </td>
                                                                    <td>
                                                                        <input style="width: 50px" type="text" name="txtNewPrice" value="${book.price}" />
                                                                    </td>
                                                                    <td>
                                                                        <input type="text" name="txtNewAuthor" value="${book.author}" />                                                     
                                                                    </td>
                                                                    <td>
                                                                        <input type="text" name="txtNewDescription" value="${book.description}" />                                                    
                                                                    </td>
                                                                    <td>
                                                                        <input style="width: 50px" type="text" name="txtNewQuantity" value="${book.quantity}" />                                                              
                                                                    </td>
                                                                    <td>
                                                                        <input type="text" name="txtNewImage" value="${book.image}" />                                                              
                                                                    </td>
                                                                    <td>
                                                                        ${book.importDate}
                                                                    </td>
                                                                    <td>
                                                                        <select name="cbxNewCategory">
                                                                            <option 
                                                                                <c:if test="${book.categoryID eq 'IT001'}"> 
                                                                                    selected="true"
                                                                                </c:if> 
                                                                                value="IT001"
                                                                                >C Language</option>
                                                                            <option 
                                                                                <c:if test="${book.categoryID eq 'IT002'}">
                                                                                    selected="true"
                                                                                </c:if> 
                                                                                value="IT002"         
                                                                                >Java Book</option>
                                                                            <option 
                                                                                <c:if test="${book.categoryID eq 'IT003'}">
                                                                                    selected="true"
                                                                                </c:if> 
                                                                                value="IT003"         
                                                                                >React Language</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <button name="action" value="UpdateBook" type="submit">Update</button>
                                                                    </td>
                                                                    <td>
                                                                        
                                                                        <button name="action" value="DeleteBook" type="submit">Delete</button>           
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
                                                                        Create Book
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
                                                                                Book ID
                                                                                <font color="red" class="ml-1">
                                                                                ${requestScope.VALIDFAL.bookIDError}
                                                                                </font>
                                                                            </th>
                                                                            <th>
                                                                                Tittle
                                                                                <font color="red" class="ml-1">
                                                                                ${requestScope.VALIDFAL.tittleError}
                                                                                </font>
                                                                            </th>
                                                                            <th>
                                                                                Author
                                                                                <font color="red" class="ml-1">
                                                                                ${requestScope.VALIDFAL.authorError}
                                                                                </font>
                                                                            </th>
                                                                            <th>
                                                                                Price
                                                                                <font color="red" class="ml-1">
                                                                                ${requestScope.VALIDFAL.priceError}
                                                                                </font>
                                                                            </th>
                                                                            <th>
                                                                                Description
                                                                                <font color="red" class="ml-1">
                                                                                ${requestScope.VALIDFAL.descriptionError}
                                                                                </font>
                                                                            </th>
                                                                            <th>
                                                                                Image
                                                                                <font color="red" class="ml-1">
                                                                                ${requestScope.VALIDFAL.imageError}
                                                                                </font>
                                                                            </th>
                                                                            <th>
                                                                                Quantity
                                                                                <font color="red" class="ml-1">
                                                                                ${requestScope.VALIDFAL.quantityError}
                                                                                </font>
                                                                            </th>
                                                                            <th>Category ID</th>
                                                                            <th style="width: 60px"></th>
                                                                        </tr>
                                                                    </thead>
                                                                    <tbody>
                                                                        <tr>
                                                                    <form action="MainController" method="POST">
                                                                        <td>
                                                                            <input  type="text" name="newBookID" value="" style="width: 70px"/>
                                                                        </td>
                                                                        <td>
                                                                            <input type="text" name="newTittle" value="" />
                                                                        </td>
                                                                        <td>
                                                                            <input type="text" name="newAuthor" value="" />
                                                                        </td>
                                                                        <td>
                                                                            <input type="text" name="newPrice" value="" style="width: 60px"/>
                                                                        </td>
                                                                        <td>
                                                                            <input type="text" name="newDescription" value="" />
                                                                        </td>
                                                                        <td>
                                                                            <input type="text" name="newImage" value="" />
                                                                        </td>
                                                                        <td>
                                                                            <input type="text" name="newQuantity" value=""style="width: 60px"/>
                                                                        </td>
                                                                        <td>
                                                                            <select name="cbxNewCategory">
                                                                                <option value="IT001">
                                                                                    C Language
                                                                                </option>
                                                                                <option value="IT002">
                                                                                    Java Book
                                                                                </option>
                                                                                <option value="IT003">
                                                                                    React Language
                                                                                </option>
                                                                            </select>
                                                                        </td>
                                                                        <td>
                                                                            <button name="action" type="submit" value="InsertBook" />
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
