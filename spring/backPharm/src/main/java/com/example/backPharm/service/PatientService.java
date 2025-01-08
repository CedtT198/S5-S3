package com.example.backPharm.service;

import com.example.backPharm.model.Patient;
import com.example.backPharm.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    // Méthode pour récupérer tous les patients
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    // Méthode pour récupérer un patient par son id
    public Optional<Patient> getPatientById(Integer id) {
        return patientRepository.findById(id);
    }

    // Méthode pour ajouter un nouveau patient
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    // Méthode pour mettre à jour un patient existant
    public Patient updatePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    // Méthode pour supprimer un patient par son id
    public void deletePatient(Integer id) {
        patientRepository.deleteById(id);
    }
}
