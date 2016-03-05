<%--
  Created by IntelliJ IDEA.
  User: george
  Date: 11/26/2014
  Time: 4:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="http://utdallas.edu/~george.koshy/bootstrap.min.css">
    <style>
        .form-control {
            max-width: 400px !important
        }
    </style>
</head>
<body style="background: url(http://subtlepatterns.com/patterns/restaurant.png);">
<span style="float:right"><h3>
    <%=session.getAttribute("email")%>
</h3>
            <h4><a href="/"> Log Out</a></h4></span>
<h1 style="padding-left:50px">The payment Page</h1>

<form class="form-horizontal" id="paymentPageForm" action="/paymentSuccessful" method="post">
    <div class="form-group">
        <label for="cardNumber" class="col-sm-2 control-label">Card Number</label>
        <input type="text" value="" class="form-control" placeholder="Card Number" name="cardNumber" id="cardNumber">
    </div>
    <div class="form-group">
        <label for="expirationDate" class="col-sm-2 control-label">Expiration Date</label>
        <input type="text" value="" class="form-control" placeholder="Expiration Date" name="expirationDate"
               id="expirationDate">
    </div>
    <div class="form-group">
        <label for="ccvNumber" class="col-sm-2 control-label">CCV Number</label>
        <input type="text" value="" class="form-control" placeholder="CCV Number" name="ccvNumber" id="ccvNumber">
    </div>
    <div class="form-group">
        <label for="customerName" class="col-sm-2 control-label">Name On Card</label>
        <input type="text" value="" class="form-control" placeholder="Name On Card" name="customerName"
               id="customerName">
    </div>
    <div class="form-group">
        <label for="password" class="col-sm-2 control-label">Password</label>
        <input type="password" value="" class="form-control" placeholder="Password" name="password" id="password">
    </div>

    <div class="form-group">
        <label for="email" class="col-sm-2 control-label">Email</label>
        <input type="text" value="" class="form-control" placeholder="email" name="email" id="email">
    </div>
    <div class="form-group" style="padding-left: 234px">
        <input type="submit" value="Finish Payment" class="btn btn-primary"/>
    </div>
</form>

<script src="http://code.jquery.com/jquery.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
