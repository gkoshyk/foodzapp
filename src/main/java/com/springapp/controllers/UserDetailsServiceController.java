package com.springapp.controllers;

import hibernate.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.*;

/**
 * Created by george on 12/8/2014.
 */
@Controller
@RequestMapping("/userDetailsService")
public class UserDetailsServiceController {
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody Customer customerDetails(@RequestParam(value = "email", required = true) String email,HttpSession httpSession) throws SQLException, ClassNotFoundException {
        Customer customer=new Customer();
        httpSession.getAttribute(email);
        Connection connection = null;
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "root");
        Statement statement = connection.createStatement();
        statement.execute("USE foodzapp");
        String selectNewUserFromDatabase="SELECT CustomerID,Email,CustomerName,PhoneNumber,Address FROM customer WHERE email=\""+email+"\"";
        ResultSet resultSet = statement.executeQuery(selectNewUserFromDatabase);
        while (resultSet.next()) {
            customer.setCustomerId(resultSet.getInt("CustomerID"));
            customer.setEmail(resultSet.getString("Email"));
            customer.setCustomerName(resultSet.getString("CustomerName"));
            customer.setPhoneNumber(resultSet.getString("PhoneNumber"));
            customer.setAddress(resultSet.getString("Address"));
            break;
        }
        resultSet.close();
        connection.close();
        return customer;
    }
}
