package com.example.backPharm.controller;

import com.example.backPharm.model.MouvementStock;
import com.example.backPharm.model.TypeMvtStock;
import com.example.backPharm.service.ClientService;
import com.example.backPharm.service.FormeService;
import com.example.backPharm.service.PatientService;
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
@RequestMapping("/ventes")
public class VenteController {

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
    @Autowired
    private ClientService clientsService;

    // Afficher la liste de tous les mouvements de stock
    @GetMapping("/liste")
    public String getAll(Model model) {
        model.addAttribute("mouvementStocks", mouvementStockService.findAllByTypeMvtStock(2));
        model.addAttribute("formes", formeService.findAll());
        model.addAttribute("patients", patientService.findAll());
        model.addAttribute("body", "ventes/liste");
        return "layout";
    }
    
    @GetMapping("/search_by_forme_patient")
    public String searchInjectableByPatient(@RequestParam("idForme") Integer idForme, @RequestParam("idPatient") Integer idPatient, Model model) {
        model.addAttribute("mouvementStocks", mouvementStockService.findSoldMedicamentByFormePatient(idForme, idPatient));
        model.addAttribute("patients", patientService.findAll());
        model.addAttribute("formes", formeService.findAll());
        model.addAttribute("body", "ventes/liste");
        return "layout";
    }
    
    @GetMapping("/search_by_dates")
    public String searchByDate(@RequestParam("date") Date date, Model model) {
        model.addAttribute("mouvementStocks", mouvementStockService.findSoldMedicamentByDate(date));
        model.addAttribute("patients", patientService.findAll());
        model.addAttribute("formes", formeService.findAll());
        model.addAttribute("body", "ventes/liste");
        return "layout";
    }
    
    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("mouvementStock", new MouvementStock());
        model.addAttribute("clients", clientsService.findAll());
        model.addAttribute("medicaments", medicamentsService.findAll());
        // model.addAttribute("medicaments", medicamentsService.calculateStockDifference(1));
        model.addAttribute("body", "ventes/insert");
        return "layout";
    }
    
    @PostMapping("/save")
    public String save(@ModelAttribute MouvementStock mouvementStock, RedirectAttributes redirectAttributes) {
        TypeMvtStock tms = typeMvtStockService.findById(2).get();
        mouvementStock.setTypeMouvementStock(tms);

        if (mouvementStockService.calculateStockDifference(mouvementStock.getMedicament().getid_med()) < mouvementStock.getQuantite()) {
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
        return "redirect:/ventes/new";
    }

    // Supprimer un mouvement de stock
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        mouvementStockService.delete(id);
        redirectAttributes.addFlashAttribute("success", "Suppression effectuée avec succès.");
        return "redirect:/ventes/liste";
    }
}
