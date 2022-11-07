package com.aidkit.controllers;

import com.aidkit.SessionObject;
import com.aidkit.models.*;
import com.aidkit.models.Package;
import com.aidkit.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

import java.util.Comparator;
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

    // Creating new AidKit
    @RequestMapping(value = "/newAidKit", method = RequestMethod.POST)
    public String newAidKit(Model model) {
        Aidkit aidkit = new Aidkit();
        MemberShip memberShip = new MemberShip();

        User userOld = userService.getUserById(sessionObject.getId());
        memberShip.setUserId(userOld);
        memberShip.setAidkitId(aidkit);
        memberShipService.saveMemberShip(memberShip);
        aidKitService.saveAidKit(aidkit);

        List<Aidkit> aidkitList = memberShipService.getAidKitIdbyUserId(sessionObject.getId());
        model.addAttribute("listMedicine", aidkitList);
        return "aboutAidKit";
    }

    // Method to add medicine
    @RequestMapping(value = "/addMedicine", method = RequestMethod.POST)
    public String addMedicine(@RequestParam(name = "packageId", required = false) String packageId,
            @RequestParam(name = "medicineId", required = false) String medicineId,
            Model model) {
        model.addAttribute("id1", Integer.parseInt(medicineId));
        model.addAttribute("id2", Integer.parseInt(packageId));
        Medicine medicine = medicineService.getMedicineById(Integer.parseInt(medicineId));
        Package packageTo = packageService.getPackageById(Integer.parseInt(packageId));
        AidKitMedicine aidKitMedicine = new AidKitMedicine();
        List<MemberShip> memberShipList = aidKitService.getMemberShipList(sessionObject.getId());
        Aidkit aidkit = memberShipList.get(0).getAidkitId();
        aidKitMedicineService.addMedicineToAidKit(aidKitMedicine, medicine, packageTo, aidkit);
        return "aboutAidKit";
    }

    // Method GET to add medicine
    @RequestMapping(value = "/addMedicine", method = RequestMethod.GET)
    public String addMedicineGet(
            @RequestParam(name = "packageId", required = false) int packageId,
            @RequestParam(name = "medicineId", required = false) int medicineId,
            Model model) {
        model.addAttribute("id1", medicineId);
        model.addAttribute("id2", packageId);
        return "aboutAidKit";
    }

    @RequestMapping(value = "/removeMedicine", method = RequestMethod.GET)
    public String removeMedicineGet(
            @RequestParam(name = "id", required = false) int aidkitid,
            @RequestParam(name = "aidKitMedicineId", required = false) int aidKitMedicineId,
            Model model) {
        aidKitMedicineService.removeMedicine(aidKitMedicineId);

        model.addAttribute("course", aidKitMedicineService.getAidMedicineList(aidkitid));
        model.addAttribute("aidkitId", aidkitid);
        return "aidkit-detail";
    }

    @RequestMapping(value = "/useMedicine", method = RequestMethod.GET)
    public String useMedicineGet(
            @RequestParam(name = "id", required = false) int aidkitid,
            @RequestParam(name = "aidKitMedicineId", required = false) int aidKitMedicineId,
            Model model) {

        model.addAttribute("course", aidKitMedicineService.getAidMedicineList(aidkitid));
        model.addAttribute("aidkitId", aidkitid);
        return "aidkit-detail";
    }

    @RequestMapping(value = "/useMedicine", method = RequestMethod.POST)
    public String useMedicinePost(
            @RequestParam(name = "id", required = false) int aidkitid,
            @RequestParam(name = "aidKitMedicineId", required = false) int aidKitMedicineId,
            @RequestParam(name = "amount", required = false) int amount,
            Model model) {
        AidKitMedicine aidKitMedicine = aidKitMedicineService.getAidKitMedicine(aidKitMedicineId);

        int newAmount = aidKitMedicine.getAmountOfMedicine() - amount;     
        if(newAmount >= 0)
        {
            aidKitMedicineService.useMedicine(aidKitMedicineId, newAmount);
        }

        model.addAttribute("course", aidKitMedicineService.getAidMedicineList(aidkitid));
        model.addAttribute("aidkitId", aidkitid);
        return "aidkit-detail";
    }

    @RequestMapping(value = "/sort", method = RequestMethod.GET)
    public String sortGet(@RequestParam(name = "id", required = false) int aidkitid,
     Model model) {
                
        return "aidkit-detail";
    }

    @RequestMapping(value = "/sort", method = RequestMethod.POST)
    public String sortPost(@RequestParam(name = "id", required = false) int aidkitid,
     Model model) {
        List<AidKitMedicine> listAidKitMedicine = aidKitMedicineService.getAidMedicineList(aidkitid);
        listAidKitMedicine.sort(Comparator.comparing(AidKitMedicine::getAmountOfMedicine));
    
        model.addAttribute("course", listAidKitMedicine);
        model.addAttribute("aidkitId", aidkitid);
        return "aidkit-detail";
    }

    @RequestMapping(value = "/sortname", method = RequestMethod.POST)
    public String sortNamePost(@RequestParam(name = "id", required = false) int aidkitid,
     Model model) {
    
        model.addAttribute("course", aidKitMedicineService.getAidMedicineList(aidkitid));
        model.addAttribute("aidkitId", aidkitid);
        return "aidkit-detail";
    }

    @RequestMapping(value = "/sortdate", method = RequestMethod.POST)
    public String sortDatePost(@RequestParam(name = "id", required = false) int aidkitid,
     Model model) {
        List<AidKitMedicine> listAidKitMedicine = aidKitMedicineService.getAidMedicineList(aidkitid);
        listAidKitMedicine.sort(Comparator.comparing(AidKitMedicine::getExpirationDate));
    
        model.addAttribute("course", listAidKitMedicine);
        model.addAttribute("aidkitId", aidkitid);
        return "aidkit-detail";
    }
}