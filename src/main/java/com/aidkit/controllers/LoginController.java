package com.aidkit.controllers;

import com.aidkit.SessionObject;
import com.aidkit.models.Package;
import com.aidkit.models.*;
import com.aidkit.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    IAuthenticationService authenticationService;
    @Autowired
    IUserService userService;
    @Autowired
    IMedicineService medicineService;
    @Autowired
    IMemberShipService memberShipService;
    @Autowired
    IAidKitMedicineService aidKitMedicineService;

    @Resource(name = "sessionObject")
    SessionObject sessionObject;

    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public String showLoginPage(Model model) {
        model.addAttribute("userModel", new User());
        model.addAttribute("errorMessage", "");
        return "loginPage";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model) {
        sessionObject.setLogged(false);
        model.addAttribute("userModel", new User());
        model.addAttribute("registerUserModel", new RegisterUser());
        return "mainPage";
    }
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchTemplate(Model model) {
        List<Medicine> list = medicineService.getMedicineListFromDB();
        model.addAttribute("medicineList", list);
        return "searchPage";
    }

    @RequestMapping(value = "/aboutMedicine", method = RequestMethod.POST)
    public String postCourseDetail(@RequestParam(name = "id", required = false) int id, Model model) {
        List<Medicine> list = medicineService.getMedicineListFromDB();
        model.addAttribute("medicineList", list);
        List<AidKitMedicine> list2 = aidKitMedicineService.getAidMedicineList(id);
        model.addAttribute("aidList", list2);
        List<Package> list3 = medicineService.getpackagebyId(id);
        model.addAttribute("big", list3);
        List<Medicine> medicineList = medicineService.getMedicineListFromDB();
        model.addAttribute("medicineList", medicineList);
        Medicine medicine = medicineService.getMedicineById(id);
        model.addAttribute("medicine", medicine);
        return "aboutMedicine";
    }

    /*Authentication of user's email and password*/
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public String authenticateUser(@ModelAttribute("userModel") User user, Model model) {
        boolean authResult = this.authenticationService.authenticateUser(user);
        int authRoleResult = this.authenticationService.authenticateRole(user);
        if (user.getEmail().isEmpty() || user.getPassword().isEmpty()) {
            model.addAttribute("userModel", new User());
            return "redirect:mainPage";
        }
        if (authResult) {
            sessionObject.setLogged(true);
            User userLogging = userService.getUserByEmail(user.getEmail());
            sessionObject.setId(userLogging.getUserId());

            List<Aidkit> aidkitList = memberShipService.getAidKitIdbyUserId(sessionObject.getId());
            if(aidkitList.isEmpty()){
                return "startPage";
            }else {
                return "logged";
            }
                 } else {
            model.addAttribute("errorMessage", "Zle wpisane login lub hasło");
            model.addAttribute("userModel", new User());
            return "redirect:mainPage";
        }
    }
        //// search by code Ean substans and ??
        // sort aidkit
        //  history

}
