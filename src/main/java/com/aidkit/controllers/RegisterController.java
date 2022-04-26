package com.aidkit.controllers;

import com.aidkit.SessionObject;
import com.aidkit.models.RegisterUser;
import com.aidkit.models.User;
import com.aidkit.services.IRegisterService;
import com.aidkit.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
public class RegisterController {
    @Autowired
    IUserService userService;
    @Autowired
    IRegisterService registerService;

    @Resource(name = "sessionObject")
    SessionObject sessionObject;


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute RegisterUser registerUser, Model model) throws InterruptedException {

        /*Verify that all fields are entered*/
        if (registerUser.getSurname().isEmpty() || registerUser.getName().isEmpty() || registerUser.getEmail().isEmpty() || registerUser.getPassword().isEmpty() || registerUser.getRepeatPassword().isEmpty()) {
            model.addAttribute("registerUserModel", new RegisterUser());
            model.addAttribute("errorMessage", "Nie wpisano wszystkich danych");
            return "redirect:mainPage";
        }

        /*Verify that the email is not yet in the database*/
        if (userService.getUserByEmail(registerUser.getEmail()) != null) {
            model.addAttribute("registerUserModel", new RegisterUser());
            model.addAttribute("errorMessage", "Użytkownik z takim adressem email już istnieje");
            return "redirect:mainPage";
        }

        /*Verify that the passwords are equals*/
        if (registerUser.getPassword().equals(registerUser.getRepeatPassword())) {

            this.userService.registerUser(convertRegisterUserToUser(registerUser));
            model.addAttribute("registerUserModel", new RegisterUser());
            model.addAttribute("userModel", new User());
            model.addAttribute("errorMessage", "");
            return "mainPage";
        } else {
            model.addAttribute("registerUserModel", new RegisterUser());
            model.addAttribute("errorMessage", "Zle wpisane dane");
            return "redirect:mainPage";
        }
    }

    /*Converting register user to user for database*/
    private User convertRegisterUserToUser(RegisterUser registerUser) {
        User user = new User();
        user.setEmail(registerUser.getEmail());
        user.setPassword(registerUser.getPassword());
        user.setName(registerUser.getName());
        user.setSurname(registerUser.getSurname());
        user.setDateOfBirth(registerUser.getDateOfBirth());
        return user;
    }
}
