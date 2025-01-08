package com.example.backPharm.controller;

import com.example.backPharm.model.MouvementStock;
import com.example.backPharm.model.TypeMvtStock;
import com.example.backPharm.service.MedicamentsService;
import com.example.backPharm.service.MouvementStockService;
import com.example.backPharm.service.TypeMvtStockService;

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
    private MedicamentsService medicamentsService;
    @Autowired
    private TypeMvtStockService typeMvtStockService;

    // Afficher la liste de tous les mouvements de stock
    @GetMapping("/liste")
    public String getAll(Model model) {
        model.addAttribute("mouvementStocks", mouvementStockService.findAll());
        model.addAttribute("body", "mvtStock/liste");
        return "layout";
    }

    @GetMapping("/filter")
    public String getAll(@RequestParam("idType") Integer id, Model model) {
        model.addAttribute("mouvementStocks", mouvementStockService.findAllByTypeMvtStock(id));
        model.addAttribute("body", "mvtStock/liste");
        return "layout";
    }

    @GetMapping("/reste_stock")
    public String getAllResteStock(Model model) {
        model.addAttribute("stocks", mouvementStockService.remainingStockByMed());
        model.addAttribute("body", "mvtStock/reste");
        return "layout";
    }

    // Afficher les détails d'un mouvement de stock
    // @GetMapping("/{id}")
    // public String getById(@PathVariable Integer id, Model model) {
    //     model.addAttribute("mouvementStock", mouvementStockService.findById(id).orElse(null));
    //     return "mouvementStock/detail";
    // }

    // Afficher le formulaire de création d'un mouvement de stock
    @GetMapping("/newachat")
    public String createForm(Model model) {
        model.addAttribute("mouvementStock", new MouvementStock());
        model.addAttribute("medicaments", medicamentsService.findAll());
        model.addAttribute("body", "mvtStock/achat");
        return "layout";
    }
    
    @GetMapping("/newvente")
    public String createForm2(Model model) {
        model.addAttribute("mouvementStock", new MouvementStock());
        model.addAttribute("medicaments", medicamentsService.findAll());
        // model.addAttribute("medicaments", medicamentsService.calculateStockDifference(1));
        model.addAttribute("body", "mvtStock/vente");
        return "layout";
    }

    // Sauvegarder un nouveau mouvement de stock
    @PostMapping("/saveachat")
    public String save(@ModelAttribute MouvementStock mouvementStock, RedirectAttributes redirectAttributes) {
        TypeMvtStock tms = typeMvtStockService.findById(1).get();
        mouvementStock.setTypeMouvementStock(tms);

        if (mouvementStock.getQuantite() <= 0) {
            redirectAttributes.addFlashAttribute("error", "Quantité ne doit pas être inférieur à 0. Insertion annulée.");
        }
        else {
            mouvementStockService.save(mouvementStock);
            redirectAttributes.addFlashAttribute("success", "Insertion effectuée avec succès.");
        }
        return "redirect:/mouvementStock/newachat";
    }
    
    // Sauvegarder un nouveau mouvement de stock
    @PostMapping("/savevente")
    public String save2(@ModelAttribute MouvementStock mouvementStock, RedirectAttributes redirectAttributes) {
        TypeMvtStock tms = typeMvtStockService.findById(2).get();
        mouvementStock.setTypeMouvementStock(tms);

        if (mouvementStockService.calculateStockDifference(1) < mouvementStock.getQuantite()) {
            redirectAttributes.addFlashAttribute("error", "Quantité en stock insuffisante.");
        }
        else {
            if (mouvementStock.getQuantite() <= 0) {
                redirectAttributes.addFlashAttribute("error", "Quantité ne doit pas être inférieur à 0. Insertion annulée.");
            }
            else {
                mouvementStockService.save(mouvementStock);
                redirectAttributes.addFlashAttribute("success", "Insertion effectuée avec succès.");
            }
        }
        return "redirect:/mouvementStock/newvente";
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
