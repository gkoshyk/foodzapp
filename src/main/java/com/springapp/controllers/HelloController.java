
package com.springapp.controllers;

import hibernate.Customer;
import net.spy.memcached.MemcachedClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.sql.*;

@Controller
@RequestMapping("/")
public class HelloController {
    @RequestMapping(method = RequestMethod.GET)
    public String loginPage(ModelMap modelMap) {
        modelMap.addAttribute("customer", new Customer());
        return "hello";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String loginSubmit(ModelMap modelMap, HttpSession httpSession, HttpServletRequest httpServletRequest, @RequestParam(value = "email", required = true) String email, @RequestParam(value = "password", required = true) String password) throws ClassNotFoundException, SQLException, IOException {
        //Code to insert new user into the database
        System.out.println("Entered this method!");
        try {
            Customer customer = new Customer();
            customer.setEmail(email);
            customer.setPassword(password);
            System.out.println(customer.getEmail());

            MemcachedClient memcachedClient = new MemcachedClient(new InetSocketAddress("localhost", 11211));
            System.out.println("Retrieving key and values from memcache!");
            Object memcachedPassword = memcachedClient.get(customer.getEmail());

            if (memcachedPassword == null) {
                Connection connection = null;
                System.out.println("Key value not in memcache so, querying database!");
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "root");
                Statement statement = connection.createStatement();
                statement.execute("USE foodzapp");
                String retrievePasswords = "SELECT password FROM customer where email=\"" + customer.getEmail() + "\"";
                ResultSet resultSet = statement.executeQuery(retrievePasswords);
                String dbPassword;

                while (resultSet.next()) {
                    dbPassword=resultSet.getString("password");
                    if (customer.getPassword().equals(dbPassword)) {
                        System.out.println(true);
                        String httpSessionId = httpSession.getId();
                        httpSession.setAttribute("email", email);
                        modelMap.addAttribute("email", email);
                        System.out.println("Updating a new key value into memcache!");
                        memcachedClient.set(customer.getEmail(), 3600, dbPassword);
                        resultSet.close();
                        connection.close();
                        return "chooseStore";
                    }
                }
            }
            if (customer.getPassword().equals(memcachedPassword)) {
                System.out.println(true);
                String httpSessionId = httpSession.getId();
                httpSession.setAttribute("email", email);
                modelMap.addAttribute("email", email);
                return "chooseStore";
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return "redirect:/";
    }
}