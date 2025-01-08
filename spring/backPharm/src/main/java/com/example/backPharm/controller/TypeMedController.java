package com.example.backPharm.controller;

import com.example.backPharm.model.TypeMedicament;
import com.example.backPharm.service.TypeMedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/typeMed")
public class TypeMedController {

    @Autowired
    private TypeMedicamentService typemedicamentsService; 

    // Afficher la liste de tous les types médicaments
    @GetMapping("/liste")
    public String getAll(Model model) {
        model.addAttribute("typeMed", typemedicamentsService.findAll());
        model.addAttribute("body", "typeMed/liste");
        return "layout";
    }

    // Afficher les détails d'un médicament
    // @GetMapping("/detail/{id}")
    // public String getById(@PathVariable Integer id, Model model) {
    //     // model.addAttribute("medicament", typemedicamentsService.findById(id).orElse(null));
    //     model.addAttribute("body", "medicaments/detail");
    //     return "layout";
    // }

    // Afficher le formulaire de création d'un médicament
    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("tm", new TypeMedicament());
        model.addAttribute("body", "typeMed/insert");
        return "layout";
    }

    // Sauvegarder un nouveau médicament
    @PostMapping("/save")
    public String save(@ModelAttribute TypeMedicament medicament, RedirectAttributes redirectAttributes) {
        typemedicamentsService.save(medicament);
        redirectAttributes.addFlashAttribute("success", "Insertion effectuée avec succès.");
        return "redirect:/typeMed/new";
    }

    // // Afficher le formulaire de mise à jour d'un médicament
    // @GetMapping("/edit/{id}")
    // public String editForm(@PathVariable Integer id, Model model) {
    //     model.addAttribute("medicament", typemedicamentsService.findById(id).orElse(null));
    //     return "medicaments/form";
    // }

    // // Mettre à jour un médicament
    // @PostMapping("/update/{id}")
    // public String update(@PathVariable Integer id, @ModelAttribute TypeMedicament medicament) {
    //     typemedicamentsService.update(id, medicament);
    //     return "redirect:/medicaments";
    // }

    // Supprimer un médicament
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        typemedicamentsService.delete(id);
        redirectAttributes.addFlashAttribute("success", "Suppression effectuée avec succès.");
        return "redirect:/typeMed/liste";
    }
}
