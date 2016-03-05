package com.springapp.controllers;

import hibernate.Itemsorder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by george on 11/25/2014.
 */

@Controller
@RequestMapping("/chickfila")
public class ChickFilAController {
    @RequestMapping(method = RequestMethod.GET)
    public String chickFilAOrder(ModelMap modelMap) {
        modelMap.addAttribute("itemsorder", new Itemsorder());
        return "chickFilA";
    }
}
