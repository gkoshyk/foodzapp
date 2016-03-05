package com.springapp.controllers;

import hibernate.Itemsorder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.*;
import java.util.Properties;

/**
 * Created by george on 11/26/2014.
 */

@Controller
@RequestMapping("/paymentSuccessful")
public class PaymentSuccessfulController {
    @RequestMapping(method = RequestMethod.POST)
    public String paymentPage(@RequestParam(value = "email", required = true) String email, ModelMap modelMap) throws ClassNotFoundException, SQLException {

        Connection connection = null;
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "root");
        Statement statement = connection.createStatement();
        statement.execute("USE foodzapp");
        ResultSet resultSet = statement.executeQuery("select CustomerID from customer where email=\""+email+"\"");
        Integer customerID = null;
        while (resultSet.next()) {
            customerID = resultSet.getInt("CustomerID");
            resultSet.close();
            break;
        }
        String insertItemQuery = "insert into itemsorder(CustomerID,Amount) values("+customerID+","+2.00+")";
        statement.executeUpdate(insertItemQuery);
        System.out.println("Entered value into database!");

        final String username = "foodzzapp";
        final String password = "foodzapp123$";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("foodzzapp@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email));
            message.setSubject("Your order has been confirmed!");
            message.setText("Dear Customer,"
                    + "\n\n Hope you are enjoying the experience with us! Your order would be delivered in half an hour! Team FOODZAPP!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

        return "paymentSuccessful";

    }
}
