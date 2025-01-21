package com.example.backPharm.controller;

import com.example.backPharm.model.Medicaments;
import com.example.backPharm.model.PrixMed;
import com.example.backPharm.service.PrixMedService;
import com.example.backPharm.service.MedicamentsService;

import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/prixMed")
public class PrixMedController {

    @Autowired
    private PrixMedService prixMedService;
    @Autowired
    private MedicamentsService medService;

    // // Afficher la liste de tous les prix des médicaments
    // @GetMapping
    // public String getAll(Model model) {
    //     model.addAttribute("prixMeds", prixMedService.findAll());
    //     return "";
    // }

    // // Afficher les détails d'un prix de médicament
    // @GetMapping("/{id}")
    // public String getById(@PathVariable Integer id, Model model) {
    //     model.addAttribute("prixMed", prixMedService.findById(id).orElse(null));
    //     return "prixMed/detail";
    // }

    // Afficher le formulaire de création d'un prix de médicament
    // @GetMapping("/new")
    // public String createForm(@RequestParam("idMed") Integer idMed, @RequestParam("montant") Double montant, Model model) {
    //     model.addAttribute("prixMed", new PrixMed());
    //     return "redirect:/medicaments/detail/"+idMed;
    // }

    // Sauvegarder un nouveau prix de médicament
    @PostMapping("/save")
    public String createForm(@RequestParam("idMed") Integer idMed, @RequestParam("montant") Double montant,
    Model model, RedirectAttributes redirectAttributes) {
        PrixMed pm = new PrixMed();
        
        Optional<Medicaments> med = medService.findById(idMed);
        
        if (montant > 0) {
            if (!med.isPresent()) {
            redirectAttributes.addFlashAttribute("error", "Error : Médicamet introuvable..");
            }
            else {
                pm.setMedicament(med.get());
                pm.setDatePrix(new Date(System.currentTimeMillis()));
                pm.setMontant(montant);
                prixMedService.save(pm);
                redirectAttributes.addFlashAttribute("success1", "Nouveau prix ajouté avec succès.");
            }
        }
        else {
            redirectAttributes.addFlashAttribute("error", "Le montant doit être supérieur à 0.");
        }
        return "redirect:/medicaments/detail/"+idMed;
    }

    // // Afficher le formulaire de mise à jour d'un prix de médicament
    // @GetMapping("/edit/{id}")
    // public String editForm(@PathVariable Integer id, Model model) {
    //     model.addAttribute("prixMed", prixMedService.findById(id).orElse(null));
    //     return "prixMed/form";
    // }

    // // Mettre à jour un prix de médicament
    // @PostMapping("/update/{id}")
    // public String update(@PathVariable Integer id, @ModelAttribute PrixMed prixMed) {
    //     prixMedService.update(id, prixMed);
    //     return "redirect:/prixMed";
    // }

    // Supprimer un prix de médicament
    @GetMapping("/delete")
    public String delete(@RequestParam("idMed") Integer idMed, @RequestParam("idPrixMed") Integer id, RedirectAttributes redirectAttributes) {
        prixMedService.delete(id);
        redirectAttributes.addFlashAttribute("success", "Nouveau prix ajouter avec succès.");
        return "redirect:/medicaments/detail/"+idMed;
    }
}
