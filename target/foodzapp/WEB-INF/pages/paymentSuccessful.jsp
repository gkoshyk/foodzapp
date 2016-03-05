<%--
  Created by IntelliJ IDEA.
  User: george
  Date: 11/26/2014
  Time: 4:49 PM
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
<span style="float:right;padding-right:20px"><h3>
    <%=session.getAttribute("email")%>
</h3>
            <h4><a href="/"> Log Out</a></h4></span>

<h1 style="padding:20px">You have successfully checked out! Please check your mail for your receipt!</h1>
<script src="http://code.jquery.com/jquery.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
