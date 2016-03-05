package com.springapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by george on 12/8/2014.
 */
@Controller
@RequestMapping("/emailTakenOrNot")
public class EmailTakenOrNotClass {
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody Map emailTakenOrNot(@RequestParam(value = "email", required = true) String email) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Map<String,String> map = new HashMap<String, String>();
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "root");
        Statement statement = connection.createStatement();
        statement.execute("USE foodzapp");
        String checkIfemailPresent = "select CustomerID from customer where email=\"" + email + "\"";
        ResultSet resultSet = statement.executeQuery(checkIfemailPresent);
        while (resultSet.next()) {
            map.put("emailPresent","true");
            resultSet.close();
            connection.close();
            return map;
        }
        map.put("emailPresent","false");
        resultSet.close();
        connection.close();
        return map;

    }
}
