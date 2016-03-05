package com.springapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by george on 11/15/2014.
 */

@Controller
@RequestMapping("/available")
public class BillServiceController {
    @RequestMapping(method = RequestMethod.GET)
    public String availableItemsPage(ModelMap modelMap){
        modelMap.addAttribute("message","The list of available Food Items!");
        return "availableItems";
    }
}
