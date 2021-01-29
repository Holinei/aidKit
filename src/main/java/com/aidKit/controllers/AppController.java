package com.aidKit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showMainPage() {
        return "mainPage";
    }
    @RequestMapping(value = "/aidkit", method = RequestMethod.GET)
    public String showMainPage2() {
        return "mainPage";
    }
}
