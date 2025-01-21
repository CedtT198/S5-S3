package com.example.backPharm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.backPharm.model.Conseil;
import com.example.backPharm.model.Medicaments;
import com.example.backPharm.model.Poste;
import com.example.backPharm.model.TypeMedicament;
import com.example.backPharm.service.ConseilService;
import com.example.backPharm.service.FormeService;
import com.example.backPharm.service.MaladieService;
import com.example.backPharm.service.MedicamentsService;
import com.example.backPharm.service.PatientService;
import com.example.backPharm.service.PrixMedService;
import com.example.backPharm.service.TypeMedicamentService;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/conseils")
public class ConseilController {
    @Autowired
    private TypeMedicamentService typeMedService;
    @Autowired
    private MaladieService maladieService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private ConseilService conseilService;
    @Autowired
    private MedicamentsService medicamentService;

    @GetMapping("/")
    public String getAll(Model model) {
        model.addAttribute("conseils", conseilService.findAll());
        model.addAttribute("body", "conseil/liste");
        return "layout";
    }
    
    @GetMapping("/filterdate")
    public String search(@RequestParam("date_conseil") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateConseil, Model model) {
        model.addAttribute("conseils", conseilService.findAllByDateConseil(dateConseil.getMonthValue(), dateConseil.getYear()));
        model.addAttribute("typeMeds", typeMedService.findAll());
        model.addAttribute("maladies", maladieService.findAll());
        model.addAttribute("patients", patientService.findAll());
        model.addAttribute("body", "conseil/liste");
        return "layout";
    }
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        conseilService.delete(id);
        redirectAttributes.addFlashAttribute("success", "Suppression effectuée avec succès.");
        return "redirect:/medicaments/";
    }

    
    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("medicaments", medicamentService.findAll());
        model.addAttribute("body", "conseil/insert");
        return "layout";
    }
    
    @PostMapping("/save")
    public String save(@RequestParam("date") Date date, @RequestParam("idMed") int idMed, RedirectAttributes redirectAttributes) {
        Medicaments m = medicamentService.findById(idMed).get();
        Conseil c = new Conseil(date, m);
        conseilService.save(c);

        redirectAttributes.addFlashAttribute("success", "Insertion effectuée avec succès.");
        return "redirect:/conseils/new";
    }
}
