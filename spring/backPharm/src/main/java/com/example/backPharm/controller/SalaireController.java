package com.example.backPharm.controller;

import com.example.backPharm.model.Personnel;
import com.example.backPharm.model.Salaire;
import com.example.backPharm.service.PersonnelService;
import com.example.backPharm.service.SalaireService;
import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/salaire")
public class SalaireController {

    @Autowired
    private SalaireService salaireService;
    @Autowired
    private PersonnelService personnelService;

    // Afficher la liste de tous les salaires
    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("salaires", salaireService.findAll());
        return "salaire/list";
    }

    // Afficher les détails d'un salaire
    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id, Model model) {
        model.addAttribute("salaire", salaireService.findById(id).orElse(null));
        return "salaire/detail";
    }

    // Afficher le formulaire de création d'un salaire
    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("salaire", new Salaire());
        return "salaire/form";
    }

    // Sauvegarder un nouveau salaire
    @PostMapping("/save")
    public String save(@RequestParam("idPerso") Integer idPerso, @RequestParam("montant") Double montant, RedirectAttributes redirectAttributes) {
        Optional<Personnel> perso = personnelService.findById(idPerso);

        if (montant <= 0) {
            redirectAttributes.addFlashAttribute("error", "Montant ne devanet pas être inférieure ou égale à 0.");
        }
        else {
            Salaire salaire = new Salaire();
            salaire.setPersonnel(perso.get());
            salaire.setDateSalaire(new Date(System.currentTimeMillis()));
            salaire.setMontantSalaire(montant);
            salaireService.save(salaire);
    
            redirectAttributes.addFlashAttribute("success", "Insertion effectuée avec succès.");
        }

        return "redirect:/personnel/detail/"+idPerso;
    }

    // // Afficher le formulaire de mise à jour d'un salaire
    // @GetMapping("/edit/{id}")
    // public String editForm(@PathVariable Integer id, Model model) {
    //     model.addAttribute("salaire", salaireService.findById(id).orElse(null));
    //     return "salaire/form";
    // }

    // // Mettre à jour un salaire
    // @PostMapping("/update/{id}")
    // public String update(@PathVariable Integer id, @ModelAttribute Salaire salaire) {
    //     salaireService.update(id, salaire);
    //     return "redirect:/salaire";
    // }

    // Supprimer un salaire
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        salaireService.delete(id);
        redirectAttributes.addFlashAttribute("success", "Suppression effectuée avec succès.");
        return "redirect:/personnel/detail/"+id;
    }
}
