package com.springapp.controllers;

import hibernate.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by george on 11/22/2014.
 */

@Controller
@RequestMapping("/register")
public class RegisterUserController {
    @RequestMapping(method = RequestMethod.GET)
    public String registerUserPage(ModelMap modelMap) {
        modelMap.addAttribute("message", "Register Page!");
        return "registerUser";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String registerUserIntoDatabase(HttpServletRequest httpServletRequest,@RequestParam(value = "email")String email,@RequestParam(value = "password")String password,@RequestParam(value = "confirmPassword")String confirmPassword,@RequestParam(value = "customerName")String customerName,@RequestParam(value = "phoneNumber")String phoneNumber,@RequestParam(value = "address")String address) {
        System.out.println("Entered register user method");
        try {
            Customer customer = new Customer();
            if(password.equals(confirmPassword)){
                customer.setEmail(email);
                customer.setPassword(password);
                customer.setCustomerName(customerName);
                customer.setPhoneNumber(phoneNumber);
                customer.setAddress(address);

                Connection connection = null;
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "root");
                Statement statement = connection.createStatement();
                statement.execute("USE foodzapp");
                String insertNewUserIntoDatabase="INSERT INTO CUSTOMER(email,password,customerName,phoneNumber,address) values(\""+customer.getEmail()+"\",\""+ customer.getPassword()+"\",\""+customer.getCustomerName()+"\",\""+customer.getPhoneNumber()+"\",\""+customer.getAddress()+"\")" ;
                statement.executeUpdate(insertNewUserIntoDatabase);
                connection.close();

            }
            else{
                //message that both password do not match
            }
        }catch(Exception e){
            System.out.println("Could not insert new user into database!");

        }finally{


        }
        return "redirect:/";
    }
}