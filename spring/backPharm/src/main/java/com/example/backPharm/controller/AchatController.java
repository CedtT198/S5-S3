package com.example.backPharm.controller;

import com.example.backPharm.model.MouvementStock;
import com.example.backPharm.model.TypeMvtStock;
import com.example.backPharm.service.FormeService;
import com.example.backPharm.service.PatientService;
import com.example.backPharm.service.MedicamentsService;
import com.example.backPharm.service.MouvementStockService;
import com.example.backPharm.service.TypeMvtStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/achats")
public class AchatController {

    @Autowired
    private MouvementStockService mouvementStockService;
    @Autowired
    private MedicamentsService medicamentsService;
    @Autowired
    private TypeMvtStockService typeMvtStockService;
    @Autowired
    private FormeService formeService;
    @Autowired
    private PatientService patientService;

    // Afficher la liste de tous les mouvements de stock
    @GetMapping("/liste")
    public String getAll(Model model) {
        model.addAttribute("mouvementStocks", mouvementStockService.findAllByTypeMvtStock(1));
        model.addAttribute("formes", formeService.findAll());
        model.addAttribute("patients", patientService.findAll());
        model.addAttribute("body", "achats/liste");
        return "layout";
    }

    // Afficher le formulaire de création d'un mouvement de stock
    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("mouvementStock", new MouvementStock());
        model.addAttribute("medicaments", medicamentsService.findAll());
        model.addAttribute("body", "achats/insert");
        return "layout";
    }

    // Sauvegarder un nouveau mouvement de stock
    @PostMapping("/save")
    public String save(@ModelAttribute MouvementStock mouvementStock, RedirectAttributes redirectAttributes) {
        TypeMvtStock tms = typeMvtStockService.findById(1).get();
        mouvementStock.setTypeMouvementStock(tms);
        mouvementStock.setClient(null);

        if (mouvementStock.getQuantite() <= 0) {
            redirectAttributes.addFlashAttribute("error", "Quantité ne doit pas être inférieur à 0. Insertion annulée.");
        }
        else {
            mouvementStockService.save(mouvementStock);
            redirectAttributes.addFlashAttribute("success", "Insertion effectuée avec succès.");
        }
        return "redirect:/achats/new";
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
        return "redirect:/achats/liste";
    }
}
