<%--
  Created by IntelliJ IDEA.
  User: george
  Date: 11/22/2014
  Time: 6:42 PM
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
<form class="form-horizontal" id="registerUserForm" action="/register" method="post">
    <h1 style="padding-left:50px">New User Registration!</h1>

    <div class="form-group">
        <label for="customerName" class="col-sm-2 control-label">Username</label>
        <input type="text" value="" class="form-control" placeholder="Your Name" name="customerName" id="customerName">
    </div>
    <div class="form-group">
        <label for="email" class="col-sm-2 control-label">Email</label>
        <input type="text" value="" class="form-control" placeholder="email" name="email" id="email">
    </div>
    <div class="form-group">
        <label for="password" class="col-sm-2 control-label">Password</label>
        <input type="password" value="" class="form-control" placeholder="Password" name="password" id="password">
    </div>
    <div class="form-group">
        <label for="confirmPassword" class="col-sm-2 control-label">Confirm Password</label>
        <input type="password" value="" class="form-control" placeholder="Confirm Password" name="confirmPassword"
               id="confirmPassword">
    </div>
    <div class="form-group">
        <label for="phoneNumber" class="col-sm-2 control-label">Phone Number</label>
        <input type="text" value="" class="form-control" placeholder="Phone Number" name="phoneNumber" id="phoneNumber">
    </div>
    <div class="form-group">
        <label for="address" class="col-sm-2 control-label">Address</label>
        <textarea value="" rows="3" class="form-control" name="address" id="address">
        </textarea>
    </div>

    <div class="form-group" style="padding-left: 234px">
        <input type="submit" value="Create Account" class="btn btn-primary"/>
    </div>
    </div>
</form>

<script src="http://code.jquery.com/jquery.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript">
    jQuery("#email").focusout(function(){
        var emailString = jQuery('#email').val();
        jQuery.getJSON("/emailTakenOrNot", { email: emailString }, function (availability) {
            if (availability) {
                var len = Object.keys(availability).length;
                if (availability.emailPresent === "true") {
                    alert("Email Id is taken");
                }
                else {

                }

            }
        })
    });


</script>
</body>
</html>
