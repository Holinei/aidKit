package com.aidkit.controllers;

import com.aidkit.SessionObject;
import com.aidkit.models.*;
import com.aidkit.models.Package;
import com.aidkit.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class MedicineControl {

    @Autowired
    IAuthenticationService authenticationService;
    @Autowired
    IUserService userService;
    @Autowired
    IPackageService packageService;
    @Autowired
    IMedicineService medicineService;
    @Autowired
    IAidKitMedicineService aidKitMedicineService;
    @Autowired
    IAidKitService aidKitService;
    @Autowired
    IMemberShipService memberShipService;
    @Resource(name = "sessionObject")
    SessionObject sessionObject;


    @RequestMapping(value = "/newAidKit", method = RequestMethod.POST)
    public String newAidKit( Model model) {
        Aidkit aidkit = new Aidkit();
        MemberShip memberShip = new MemberShip();

        User userOld = userService.getUserById(sessionObject.getId());
        memberShip.setUserId(userOld);
        memberShip.setAidkitId(aidkit);
        memberShipService.saveMemberShip(memberShip);
        aidKitService.saveAidKit(aidkit);

        return "newAidKit";
    }

    @RequestMapping(value = "/addMedicine", method = RequestMethod.POST)
    public String addMedicine(@RequestParam(name = "packageId", required = false) String packageId,
                              @RequestParam(name = "medicineId", required = false) String medicineId,
                              Model model) {model.addAttribute("id1", Integer.parseInt(medicineId));
        model.addAttribute("id2", Integer.parseInt(packageId));
        Medicine medicine = medicineService.getMedicineById(Integer.parseInt(medicineId));
        Package packageTo = packageService.getPackageById(Integer.parseInt(packageId));
        AidKitMedicine aidKitMedicine = new AidKitMedicine();
        List<MemberShip> memberShipList = aidKitService.getMemberShipList(sessionObject.getId());
        Aidkit aidkit = memberShipList.get(0).getAidkitId();
        aidKitMedicineService.addMedicineToAidKit(aidKitMedicine,medicine,packageTo,aidkit);
        return "newAidKit";
    }

    @RequestMapping(value = "/addMedicine", method = RequestMethod.GET)
    public String addMedicineGet(
                              @RequestParam(name = "packageId", required = false) int packageId,
                              @RequestParam(name = "medicineId", required = false) int medicineId,
                              Model model) {
        model.addAttribute("id1", medicineId);
        model.addAttribute("id2", packageId);
        return "newAidKit";
    }
}
