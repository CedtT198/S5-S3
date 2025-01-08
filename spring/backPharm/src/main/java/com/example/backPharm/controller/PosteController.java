package com.example.backPharm.controller;

import com.example.backPharm.model.Poste;
import com.example.backPharm.service.PosteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/poste")
public class PosteController {

    @Autowired
    private PosteService posteService;

    // Afficher la liste de tous les postes
    @GetMapping("/liste")
    public String getAll(Model model) {
        model.addAttribute("postes", posteService.findAll());
        model.addAttribute("body", "poste/liste");
        return "layout";
    }

    // Afficher les détails d'un poste
    // @GetMapping("/{id}")
    // public String getById(@PathVariable Integer id, Model model) {
    //     model.addAttribute("poste", posteService.findById(id).orElse(null));
    //     return "poste/detail";
    // }

    // Afficher le formulaire de création d'un poste
    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("poste", new Poste());
        model.addAttribute("body", "poste/insert");
        return "layout";
    }

    // Sauvegarder un nouveau poste
    @PostMapping("/save")
    public String save(@ModelAttribute Poste poste, RedirectAttributes redirectAttributes) {
        posteService.save(poste);
        redirectAttributes.addFlashAttribute("success", "Suppressioneffectuée avec succès.");
        return "redirect:/poste/new";
    }

    // Afficher le formulaire de mise à jour d'un poste
    // @GetMapping("/edit/{id}")
    // public String editForm(@PathVariable Integer id, Model model) {
    //     model.addAttribute("poste", posteService.findById(id).orElse(null));
    //     return "poste/form";
    // }

    // Mettre à jour un poste
    // @PostMapping("/update/{id}")
    // public String update(@PathVariable Integer id, @ModelAttribute Poste poste) {
    //     posteService.update(id, poste);
    //     return "redirect:/poste";
    // }

    // Supprimer un poste
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        posteService.delete(id);
        return "redirect:/poste/liste";
    }
}
