package com.example.backPharm.controller;

import com.example.backPharm.model.TypeMvtStock;
import com.example.backPharm.service.TypeMvtStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/typeMvtStock")
public class TypeMvtStockController {

    @Autowired
    private TypeMvtStockService typeMvtStockService;

    // Afficher la liste de tous les types de mouvements de stock
    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("typeMvtStocks", typeMvtStockService.findAll());
        return "typeMvtStock/list";
    }

    // Afficher les détails d'un type de mouvement de stock
    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id, Model model) {
        model.addAttribute("typeMvtStock", typeMvtStockService.findById(id).orElse(null));
        return "typeMvtStock/detail";
    }

    // Afficher le formulaire de création d'un type de mouvement de stock
    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("typeMvtStock", new TypeMvtStock());
        return "typeMvtStock/form";
    }

    // Sauvegarder un nouveau type de mouvement de stock
    @PostMapping("/save")
    public String save(@ModelAttribute TypeMvtStock typeMvtStock) {
        typeMvtStockService.save(typeMvtStock);
        return "redirect:/typeMvtStock";
    }

    // Afficher le formulaire de mise à jour d'un type de mouvement de stock
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Integer id, Model model) {
        model.addAttribute("typeMvtStock", typeMvtStockService.findById(id).orElse(null));
        return "typeMvtStock/form";
    }

    // Mettre à jour un type de mouvement de stock
    @PostMapping("/update/{id}")
    public String update(@PathVariable Integer id, @ModelAttribute TypeMvtStock typeMvtStock) {
        typeMvtStockService.update(id, typeMvtStock);
        return "redirect:/typeMvtStock";
    }

    // Supprimer un type de mouvement de stock
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        typeMvtStockService.delete(id);
        return "redirect:/typeMvtStock";
    }
}
