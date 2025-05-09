package com.example.backPharm.controller;

import com.example.backPharm.service.FormeService;
import com.example.backPharm.service.PatientService;
import com.example.backPharm.service.MouvementStockService;
import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/mouvementStock")
public class MouvementStockController {

    @Autowired
    private MouvementStockService mouvementStockService;
    @Autowired
    private FormeService formeService;
    @Autowired
    private PatientService patientService;

    // Afficher la liste de tous les mouvements de stock
    @GetMapping("/liste")
    public String getAll(Model model) {
        model.addAttribute("mouvementStocks", mouvementStockService.findAll());
        model.addAttribute("formes", formeService.findAll());
        model.addAttribute("patients", patientService.findAll());
        model.addAttribute("body", "mvtStock/liste");
        return "layout";
    }

    @GetMapping("/filter")
    public String getAll(@RequestParam("idType") Integer id, Model model) {
        model.addAttribute("mouvementStocks", mouvementStockService.findAllByTypeMvtStock(id));
        model.addAttribute("formes", formeService.findAll());
        model.addAttribute("patients", patientService.findAll());
        model.addAttribute("body", "mvtStock/liste");
        return "layout";
    }
    
    @GetMapping("/search_by_forme_patient")
    public String searcInjectableForKids(@RequestParam("idForme") Integer idForme, @RequestParam("idPatient") Integer idPatient, Model model) {
        model.addAttribute("mouvementStocks", mouvementStockService.findSoldMedicamentByFormePatient(idForme, idPatient));
        model.addAttribute("patients", patientService.findAll());
        model.addAttribute("formes", formeService.findAll());
        model.addAttribute("body", "mvtStock/liste");
        return "layout";
    }
    
    @GetMapping("/search_by_dates")
    public String searcInjectableForKids(@RequestParam("date") Date date, Model model) {
        model.addAttribute("mouvementStocks", mouvementStockService.findSoldMedicamentByDate(date));
        model.addAttribute("patients", patientService.findAll());
        model.addAttribute("formes", formeService.findAll());
        model.addAttribute("body", "mvtStock/liste");
        return "layout";
    }

    @GetMapping("/reste_stock")
    public String getAllResteStock(Model model) {
        model.addAttribute("stocks", mouvementStockService.remainingStockByMed());
        model.addAttribute("body", "mvtStock/reste");
        return "layout";
    }

    // Afficher le formulaire de mise à jour d'un mouvement de stock
    // @GetMapping("/edit/{id}")
    // public String editForm(@PathVariable Integer id, Model model) {
    //     model.addAttribute("mouvementStock", mouvementStockService.findById(id).orElse(null));
    //     return "mouvementStock/form";
    // }

    // Mettre à jour un mouvement de stock
    // @PostMapping("/update/{id}")
    // public String update(@PathVariable Integer id, @ModelAttribute MouvementStock mouvementStock) {
    //     mouvementStockService.update(id, mouvementStock);
    //     return "redirect:/mouvementStock";
    // }

    // Supprimer un mouvement de stock
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        mouvementStockService.delete(id);
        redirectAttributes.addFlashAttribute("success", "Suppression effectuée avec succès.");
        return "redirect:/mouvementStock/liste";
    }
}
