package com.springapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by george on 12/8/2014.
 */
@Controller
@RequestMapping("/availableItemsChickFila")
public class AvailableItemsChickFila {
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    Map<String,Double> availableItemsChickFila(){
        Map<String,Double> map = new HashMap<String, Double>();
        map.put("Chick-fil-A-chicken-sandwhich",2.15);
        map.put("Chick-fil-A-spicy-chicken-sandwhich",4.17);
        map.put("Chick-fil-A-deluxe-sandwhich",3.25);
        map.put("Chick-fil-A-nuggets",1.15);
        return map;
    }
}
