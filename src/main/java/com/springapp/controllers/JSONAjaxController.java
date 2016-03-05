package com.springapp.controllers;

import hibernate.Itemsorder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.*;

/**
 * Created by george on 12/6/2014.
 */
@Controller
@RequestMapping("/lastOrderService")
public class JSONAjaxController {
    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    Itemsorder customerDetails(@RequestParam(value = "email", required = true) String email) throws SQLException, ClassNotFoundException {
        Itemsorder itemsorder = new Itemsorder();
        Connection connection = null;
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "root");
        Statement statement = connection.createStatement();
        statement.execute("USE foodzapp");
        String selectNewUserFromDatabase = "select MAX(OrderID),i.CustomerID,c.Email,Amount,DateAndTimeOfOrder from itemsorder i,customer c where c.email=\"" + email + "\"";
        ResultSet resultSet = statement.executeQuery(selectNewUserFromDatabase);
        while (resultSet.next()) {
            itemsorder.setOrderId(resultSet.getInt("MAX(OrderID)"));
            itemsorder.setAmount(resultSet.getFloat("Amount"));
            itemsorder.setDateAndTimeOfOrder(resultSet.getTimestamp("DateAndTimeOfOrder"));
            break;
        }
        resultSet.close();
        connection.close();
        return itemsorder;
    }
}
