package com.example.backPharm.controller;

import com.example.backPharm.model.HistoriquePoste;
import com.example.backPharm.model.Personnel;
import com.example.backPharm.service.HistoriquePosteService;
import com.example.backPharm.service.PersonnelService;
import com.example.backPharm.service.PosteService;
import com.example.backPharm.service.SalaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/personnel")
public class PersonnelController {

    @Autowired
    private PersonnelService personnelService;
    @Autowired
    private PosteService posteService;
    @Autowired
    private SalaireService salaireService;
    @Autowired
    private HistoriquePosteService histoPosteService;

    // Afficher la liste de tous les personnels
    @GetMapping("/liste")
    public String getAll(Model model) {
        model.addAttribute("personnels", personnelService.findAll());
        model.addAttribute("postes", posteService.findAll());
        model.addAttribute("body", "personnel/liste");
        return "layout";
    }
    
    @GetMapping("/filterasc")
    public String getAllFilteredAZ(Model model) {
        model.addAttribute("personnels", personnelService.findAllByOrderByNomAsc());
        model.addAttribute("postes", posteService.findAll());
        model.addAttribute("body", "personnel/liste");
        return "layout";
    }
    
    @GetMapping("/filterdesc")
    public String getAllFilteredZA(Model model) {
        model.addAttribute("personnels", personnelService.findAllByOrderByNomDesc());
        model.addAttribute("body", "personnel/liste");
        return "layout";
    }

    // Afficher les détails d'un personnel
    @GetMapping("/detail/{id}")
    public String getById(@PathVariable Integer id, Model model) {
        model.addAttribute("personnel", personnelService.findById(id).orElse(null));
        model.addAttribute("salaires", salaireService.findByPersonnelId(id));
        model.addAttribute("histoPoste", histoPosteService.findLatestPosteByPersonnel(id));
        model.addAttribute("salaire", salaireService.findLatestSalaireByPersonnel(id));
        model.addAttribute("postes", posteService.findAll());
        model.addAttribute("histoPostes", histoPosteService.findByPersonnelId(id));
        model.addAttribute("body", "personnel/detail");
        return "layout";
    }

    // Afficher le formulaire de création d'un personnel
    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("personnel", new Personnel());
        model.addAttribute("postes", posteService.findAll());
        model.addAttribute("body", "personnel/insert");
        return "layout";
    }

    // Sauvegarder un nouveau personnel
    @PostMapping("/save")
    public String save(@ModelAttribute Personnel personnel, @RequestParam("idPoste") Integer idPoste,
        @RequestParam("salaire") Double salaire, RedirectAttributes redirectAttributes) {
        personnelService.save(personnel);
        
        // System.out.println("nom & prneom: "+personnel.getNomComplet());
        // System.out.println("date naissance : "+personnel.getDateNaissance());
        // System.out.println("ville de naissance : "+personnel.getVilleNaissance());
        // System.out.println("id poste : "+idPoste);
        // System.out.println("salaire : "+salaire);
        
        redirectAttributes.addFlashAttribute("success", "Insertion effectuée avec succès.");
        return "redirect:/personnel/new";
    }

    // Afficher le formulaire de mise à jour d'un personnel
    // @GetMapping("/edit/{id}")
    // public String editForm(@PathVariable Integer id, Model model) {
    //     model.addAttribute("personnel", personnelService.findById(id).orElse(null));
    //     return "personnel/form";
    // } 

    // // Mettre à jour un personnel
    @PostMapping("/update/{id}")
    public String update(@PathVariable Integer id, @ModelAttribute Personnel personnel) {
        personnelService.update(id, personnel);
        return "redirect:/personnel";
    }

    // Supprimer un personnel
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        personnelService.delete(id);
        redirectAttributes.addFlashAttribute("success", "Suppression effectuée avec succès.");
        return "redirect:/personnel/liste";
    }
}
