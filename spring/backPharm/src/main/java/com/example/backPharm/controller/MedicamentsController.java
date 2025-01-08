package com.example.backPharm.controller;

import com.example.backPharm.model.Forme;
import com.example.backPharm.model.Medicaments;
import com.example.backPharm.model.PrixMed;
import com.example.backPharm.model.TypeMedicament;
import com.example.backPharm.service.FormeService;
import com.example.backPharm.service.MaladieService;
import com.example.backPharm.service.MedicamentsService;
import com.example.backPharm.service.PatientService;
import com.example.backPharm.service.PrixMedService;
import com.example.backPharm.service.TypeMedicamentService;
import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/medicaments")
public class MedicamentsController {

    @Autowired
    private MedicamentsService medicamentsService;
    @Autowired
    private TypeMedicamentService typeMedService;
    @Autowired
    private PrixMedService prixMedService;
    @Autowired
    private FormeService formeService;
    @Autowired
    private MaladieService maladieService;
    @Autowired
    private PatientService patientService;

    // Afficher la liste de tous les médicaments
    @GetMapping("/")
    public String getAll(Model model) {
        model.addAttribute("medicaments", medicamentsService.findAll());
        model.addAttribute("typeMeds", typeMedService.findAll());
        model.addAttribute("maladies", maladieService.findAll());
        model.addAttribute("patients", patientService.findAll());
        model.addAttribute("body", "medicaments/liste");
        return "layout";
    }
    
    @GetMapping("/filterbytype")
    public String getAllFilteredAZ(@RequestParam("idTypeMed") Integer idtype, Model model) {
        model.addAttribute("medicaments", medicamentsService.findAllByTypeMedicament(idtype));
        model.addAttribute("typeMeds", typeMedService.findAll());
        model.addAttribute("maladies", maladieService.findAll());
        model.addAttribute("patients", patientService.findAll());
        model.addAttribute("body", "medicaments/liste");
        return "layout";
    }

    @GetMapping("/filterasc")
    public String getAllFilteredAZ(Model model) {
        model.addAttribute("medicaments", medicamentsService.findAllByNameOrderAsc());
        model.addAttribute("typeMeds", typeMedService.findAll());
        model.addAttribute("maladies", maladieService.findAll());
        model.addAttribute("patients", patientService.findAll());
        model.addAttribute("body", "medicaments/liste");
        return "layout";
    }
    
    @GetMapping("/filterdesc")
    public String getAllFilteredZA(Model model) {
        model.addAttribute("medicaments", medicamentsService.findAllByNameOrderDesc());
        model.addAttribute("typeMeds", typeMedService.findAll());
        model.addAttribute("maladies", maladieService.findAll());
        model.addAttribute("patients", patientService.findAll());
        model.addAttribute("body", "medicaments/liste");
        return "layout";
    }

    // Afficher les détails d'un médicament
    @GetMapping("/search")
    public String search(@RequestParam("idMaladie") Integer idMaladie, @RequestParam("idPatient") Integer idPatient, Model model) {
        model.addAttribute("medicaments", medicamentsService.findMedicamentsByMaladieAndPatient(idMaladie, idPatient));
        model.addAttribute("typeMeds", typeMedService.findAll());
        model.addAttribute("maladies", maladieService.findAll());
        model.addAttribute("patients", patientService.findAll());
        model.addAttribute("body", "medicaments/liste");
        return "layout";
    }

    // Afficher les détails d'un médicament
    @GetMapping("/detail/{id}")
    public String getById(@PathVariable Integer id, Model model) {
        model.addAttribute("listePrixMed", prixMedService.findByMedicamentId(id));
        model.addAttribute("med", medicamentsService.findById(id).orElse(null));
        model.addAttribute("prixActuel", prixMedService.getLatestPrixForMedicament(id));
        model.addAttribute("body", "medicaments/detail");
        return "layout";
    }

    // Afficher le formulaire de création d'un médicament
    @GetMapping("/new")
    public String createForm(Model model) {
        Medicaments med = new Medicaments();
        med.setTypeMedicament(new TypeMedicament());
        
        model.addAttribute("medicaments", medicamentsService.findAll());
        model.addAttribute("formes", formeService.findAll());
        model.addAttribute("med", med);
        model.addAttribute("prix", new PrixMed());
        model.addAttribute("typeMeds", typeMedService.findAll());
        model.addAttribute("body", "medicaments/insert");
        return "layout";
    }

    // Sauvegarder un nouveau médicament
    @PostMapping("/save")
    public String save(@RequestParam("nom") String nom, @RequestParam("idTypeMed") Integer idTypeMed, @RequestParam("idForme") Integer idForme,
        @RequestParam("notice") String notice, @RequestParam("prix") Double prix, Model model, RedirectAttributes redirectAttributes) {
        TypeMedicament tm = typeMedService.findById(idTypeMed).get();
        Forme f = formeService.findById(idForme).get();

        Medicaments med = new Medicaments();
        med.setnom_med(nom);
        med.setTypeMedicament(tm);
        med.setNotice(notice);
        med.setForme(f);
        Medicaments m = medicamentsService.save(med);

        PrixMed prixMed = new PrixMed();
        prixMed.setMontant(prix);
        prixMed.setMedicament(m);
        prixMed.setDatePrix(new Date(System.currentTimeMillis()));
        prixMedService.save(prixMed);
        
        // System.out.println(nom);
        // System.out.println(idTypeMed);
        // System.out.println(notice);
        // System.out.println(prix);

        redirectAttributes.addFlashAttribute("success", "Insertion effectuée avec succès.");
        return "redirect:/medicaments/new";
    }

    // // Afficher le formulaire de mise à jour d'un médicament
    // @GetMapping("/edit/{id}")
    // public String editForm(@PathVariable Integer id, Model model) {
    //     model.addAttribute("medicament", medicamentsService.findById(id).orElse(null));
    //     return "medicaments/form";
    // }

    // // Mettre à jour un médicament
    // @PostMapping("/update/{id}")
    // public String update(@PathVariable Integer id, @ModelAttribute Medicaments medicament) {
    //     medicamentsService.update(id, medicament);
    //     return "redirect:/medicaments";
    // }

    // // Supprimer un médicament
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        medicamentsService.delete(id);
        redirectAttributes.addFlashAttribute("success", "Suppression effectuée avec succès.");
        return "redirect:/medicaments/";
    }
}
