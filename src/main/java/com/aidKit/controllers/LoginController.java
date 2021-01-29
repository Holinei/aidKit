package com.aidKit.controllers;

import com.aidKit.SessionObject;
import com.aidKit.model.User;
import com.aidKit.services.IAuthenticationService;
import com.aidKit.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
public class LoginController {

    @Autowired
    IAuthenticationService authenticationService;
    @Autowired
    IUserService userService;

    @Resource(name = "sessionObject")
    SessionObject sessionObject;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage(Model model) {
        model.addAttribute("userModel", new User());
        return "loginPage";
    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model) {
        sessionObject.setLogged(false);
        sessionObject.setRole(3);
        model.addAttribute("userModel", new User());
        return "login";
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public String authenticateUser(@ModelAttribute("userModel") User user, Model model) {
        boolean authResult = this.authenticationService.authenticateUser(user);
        int authRoleResult = this.authenticationService.authenticateRole(user);
        if (user.getEmail().isEmpty() || user.getPassword().isEmpty()) {
            model.addAttribute("userModel", new User());
            return "login";
        }
        if (authResult) {
            sessionObject.setLogged(true);
            switch (authRoleResult) {
                case 0:
                    sessionObject.setRole(0);
                    return "admin";
                case 1:
                    sessionObject.setRole(1);
                    sessionObject.setId(userService.getIdByEmail(user.getEmail()));
                    return "indexForStudents";
                default:
                    sessionObject.setRole(2);
                    sessionObject.setId(userService.getIdByEmail(user.getEmail()));
                    return "indexForUsers";
            }
        } else {
            model.addAttribute("userModel", new User());
            return "login";
        }
    }
}
