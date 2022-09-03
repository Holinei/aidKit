package com.aidkit.controllers;

import com.aidkit.SessionObject;
import com.aidkit.models.Aidkit;
import com.aidkit.models.RegisterUser;
import com.aidkit.models.User;
import com.aidkit.services.IAidKitMedicineService;
import com.aidkit.services.IMedicineService;
import com.aidkit.services.IMemberShipService;
import com.aidkit.services.IPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    IAidKitMedicineService aidKitMedicineService;
    @Autowired
    IMemberShipService memberShipService;
    @Autowired
    IMedicineService medicineService;
    @Autowired
    IPackageService packageService;

    @Resource(name = "sessionObject")
    SessionObject sessionObject;

    @RequestMapping(value = { "", "/", "/aidkit" }, method = RequestMethod.GET)
    public String showMainPage(Model model) {
        model.addAttribute("userModel", new User());
        model.addAttribute("errorMessage", "");
        model.addAttribute("registerUserModel", new RegisterUser());
        model.addAttribute("errorMessageRegister", "");
        return "mainPage";
    }

    @RequestMapping(value = { "/showMyAidKit" }, method = RequestMethod.GET)
    public String myAidKit(Model model) {
        List<Aidkit> aidkitList = memberShipService.getAidKitIdbyUserId(sessionObject.getId());
        model.addAttribute("listMedicine", aidkitList);
        return "aboutAidKit";
    }

    @RequestMapping(value = "/showAidKit", method = RequestMethod.GET)
    public String showAidkit(@RequestParam(name = "id", required = false) int aidkitid, Model model, User user) {

        model.addAttribute("course", aidKitMedicineService.getAidMedicineList(aidkitid));

        return "aidkit-detail";
    }
}
