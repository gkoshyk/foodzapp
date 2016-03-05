<%--
  Created by IntelliJ IDEA.
  User: george
  Date: 11/25/2014
  Time: 4:13 PM
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

        .hidden {
            display: none;
        }
    </style>
</head>
<body style="background: url(http://subtlepatterns.com/patterns/restaurant.png);">
<a class="navbar-brand" href="#">
    <img alt="Brand" src="http://utdallas.edu/~george.koshy/images/foodzapp.png" height="60"
         width="60">
</a>
            <span style="float:right;padding-right:20px"><h3>
                <%=session.getAttribute("email")%>
            </h3>
            <h4><a href="/"> Log Out</a></h4></span>

<div class="container" style="padding-left: 73px">
    <br/>

    <h1>Welcome to Foodzapp:</h1>

    <h3>Choose your food !</h3>
    <br/>
    <a href="/chickfila"><img src="http://www.chick-fil-a.com/Media/Img/master/cfa-new.png" alt="chickfila">
        <h4>Chick-fil-A</h4></a>
    <br/>

    <br/>
    <a href="/papajohns"><img src="http://order.papajohns.com/assets/images/logoWhite.png" alt="papa johns">
        <h4>Papa johns</h4></a>
    </br>
</div>
<br/>
<br/>

<h3 style="padding-left: 163px">Enter the email to see user details</h3>
<br/>

<div class="form-group">
    <label for="email" class="col-sm-2 control-label" style="padding-left: 163px">Email</label>

    <div class="col-sm-10">
        <input type="email" class="form-control" id="email" placeholder="Email" name="email">
    </div>
</div>
<br/>

<div class="form-group" style="padding-top: 10px">
    <div class="col-sm-offset-2 col-sm-10">
        <button class="btn btn-primary" onclick="ajaxFunction();">Find Details</button>
        <br/>
    </div>
</div>

<table id="table" class="table table-striped hidden">
    <tr>
        <th>CustomerID</th>
        <th>Email</th>
        <th>Customer Name</th>
        <th>Phone Number</th>
        <th>Address</th>
    </tr>
</table>

<script src="http://code.jquery.com/jquery.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript">
    function ajaxFunction() {
        var emailString = jQuery('#email').val();
        jQuery.getJSON("/userDetailsService", { email: emailString }, function (availability) {
            if (availability) {
                var len = Object.keys(availability).length;
                var txt = '';
                if (len > 0) {
                    txt = "<tr><td>" + availability.customerId + "</td><td>" + availability.email + "</td><td>" + availability.customerName + "</td><td>" + availability.phoneNumber + "</td><td>" + availability.address + "</td></tr>";
                }
                else {
                    alert("Not a registered user");
                }
                if (txt !== "") {
                    jQuery("#table").append(txt).removeClass("hidden");
                }

            }
        });
    }
</script>
</body>
</html>
