package com.example.backPharm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.backPharm.model.Admin;
import com.example.backPharm.service.AdminService;

@Controller
public class LoginController {

    @Autowired
    AdminService adminService;

    // @GetMapping("/")
    // public String home(Model model) {
    //     model.addAttribute("body", "medicaments/liste");
    //     return "layout";
    // }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("admin", new Admin());
        // return "login";
        return "redirect:/medicaments/";
    }

    @PostMapping("/auth")
    public String auth(Model model, Admin formAdmin) {
        
        int response = adminService.auth(formAdmin);

        switch (response) {
            case -1:
                model.addAttribute("error", "Mot de passe incorrect.");
                return "login";
            
            case -2:
                model.addAttribute("error", "Identifiant introuable.");
                return "login";
        }

        // atao anaty session le mi-log

        // model.addAttribute("body", "medicaments/liste");
        // return "layout";

        return "redirect:/medicaments/";
    }
}
