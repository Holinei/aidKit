package com.aidKit.controllers;

import com.aidKit.SessionObject;
import com.aidKit.model.RegisterUser;
import com.aidKit.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
public class RegisterController {

    @Resource(name = "sessionObject")
    SessionObject sessionObject;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegisterPage(Model model) {
        model.addAttribute("registerUser", new RegisterUser());
        return "registerPage";
    }
}
