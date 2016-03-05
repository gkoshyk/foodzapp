<%--
  Created by IntelliJ IDEA.
  User: george
  Date: 11/25/2014
  Time: 4:09 PM
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
<a class="navbar-brand" href="#">
    <img alt="Brand" src="http://utdallas.edu/~george.koshy/images/foodzapp.png" height="60"
         width="60">
</a>
<span style="float:right"><h3>
    <%=session.getAttribute("email")%>
</h3>
            <h4><a href="/"> Log Out</a></h4></span>

<div class="container">
    <img src="http://order.papajohns.com/assets/images/logoWhite.png" alt="papa johns">
    <br/>

    <p>Select your pizza:</p>

    <form class="form-horizontal" action="/paymentpage" method="get">
        <div class="checkbox">
            <label><input type="radio" value="4">Cheese pizza 2$</label>
        </div>
        <div class="checkbox">
            <label><input type="checkbox" value="5">Meats 2$</label>
        </div>
        <div class="checkbox">
            <label><input type="checkbox" value="6">Garden fresh 2$</label>
        </div>
        <div class="checkbox">
            <label><input type="checkbox" value="4">Spicy italian 2$</label>
        </div>
        <div class="checkbox">
            <label><input type="checkbox" value="5">BBQ chicken and bacon 2$</label>
        </div>
        <input type="submit" value="Check Out" class="btn btn-primary">
    </form>
</div>

<h3 style="padding-left: 163px">Enter friends Email to see their last order amount :D!</h3>
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
        <th>OrderID</th>
        <th>Amount</th>
    </tr>
</table>

<script src="http://code.jquery.com/jquery.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript">
    function ajaxFunction() {
        var emailString = jQuery('#email').val();
        jQuery.getJSON("/lastOrderService", { email: emailString }, function (availability) {
            if (availability) {
                var len = Object.keys(availability).length;
                var txt = '';
                if (len > 0) {
                    txt = "<tr><td>" + availability.orderId + "</td><td>" + availability.amount + "$</td></tr>";
                }
                else {
                    alert("This is your first order!");
                }
                if (txt !== "") {
                    jQuery("#table").append(txt).removeClass("hidden");
                }

            }
        });
    }
</script>
<script>
    var totalPrice = 0;
    jQuery( document ).ready(function() {
        totalPrice=totalPrice+jQuery('input:checkbox:checked').val();
    });

    jQuery(".checkbox").change(function() {
        if(this.checked) {
            totalPrice=totalPrice+jQuery('input:checkbox:checked').val();
        }
    });
</script>
</body>
</html>
