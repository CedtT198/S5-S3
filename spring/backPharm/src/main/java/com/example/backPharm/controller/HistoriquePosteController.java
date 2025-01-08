package com.example.backPharm.controller;

import com.example.backPharm.model.HistoriquePoste;
import com.example.backPharm.model.Personnel;
import com.example.backPharm.model.Salaire;
import com.example.backPharm.model.Poste;
import com.example.backPharm.service.HistoriquePosteService;
import com.example.backPharm.service.PersonnelService;
import com.example.backPharm.service.PosteService;
import java.sql.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/historique_poste")
public class HistoriquePosteController {

    @Autowired
    private HistoriquePosteService historique_posteService;
    @Autowired
    private PersonnelService personnelService;
    @Autowired
    private PosteService posteService;

    // // Afficher la liste de tous les historiques de postes
    // @GetMapping("liste")
    // public String getAll(Model model) {
    //     model.addAttribute("historiques", historique_posteService.findAll());
    //     return "historique_poste/list";
    // }

    // // Afficher les détails d'un historique de poste
    // @GetMapping("/{id}")
    // public String getById(@PathVariable Integer id, Model model) {
    //     model.addAttribute("historique_poste", historique_posteService.findById(id).orElse(null));
    //     return "historique_poste/detail";
    // }

    // Afficher le formulaire de création d'un historique de poste
    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("historique_poste", new HistoriquePoste());
        return "historique_poste/form";
    }

    // Sauvegarder un nouvel historique de poste
    @PostMapping("/save")
    public String save(@RequestParam("idPerso") Integer idPerso, @RequestParam("idPoste") Integer idPoste,
        @RequestParam("dateDebut") Date dateDebut, @RequestParam("dateFin") Date dateFin, RedirectAttributes redirectAttributes) {
        Optional<Personnel> persoOpt = personnelService.findById(idPerso);
        Optional<Poste> posteOpt = posteService.findById(idPoste);
        
        if (dateDebut.after(dateFin)) {
            redirectAttributes.addFlashAttribute("error2", "Date début doit être inférieure à date fin.");
        }
        else {
            HistoriquePoste h = new HistoriquePoste();
            Personnel perso = persoOpt.get();
            Poste poste = posteOpt.get();
            h.setPersonnel(perso);
            h.setdate_debut(dateDebut);
            h.setdate_fin(dateFin);
            h.setPoste(poste);
            historique_posteService.save(h);
            redirectAttributes.addFlashAttribute("success2", "Insertion effectuée avec succès.");
        }
        
        return "redirect:/personnel/detail/"+idPerso;
    }

    // // Afficher le formulaire de mise à jour d'un historique de poste
    // @GetMapping("/edit/{id}")
    // public String editForm(@PathVariable Integer id, Model model) {
    //     model.addAttribute("historique_poste", historique_posteService.findById(id).orElse(null));
    //     return "historique_poste/form";
    // }

    // // Mettre à jour un historique de poste
    // @PostMapping("/update/{id}")
    // public String update(@PathVariable Integer id, @ModelAttribute HistoriquePoste historique_poste) {
    //     historique_posteService.update(id, historique_poste);
    //     return "redirect:/historique_poste";
    // }

    // Supprimer un historique de poste
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        historique_posteService.delete(id);
        redirectAttributes.addFlashAttribute("success2", "Suppression effectuée avec succès.");
        return "redirect:/personnel/detail/"+id;
    }
}
