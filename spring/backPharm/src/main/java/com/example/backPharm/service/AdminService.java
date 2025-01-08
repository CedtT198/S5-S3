package com.example.backPharm.service;

import com.example.backPharm.model.Admin;
import com.example.backPharm.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public int auth(Admin a) {
        List<Admin> admins = adminRepository.findAll();

        for (Admin admin : admins) {
            System.out.println(admin.getNomAdmin());
            if (a.getNomAdmin().equals(admin.getNomAdmin())) {
                if (a.getMdp().equals(admin.getMdp())) {
                    System.out.println(admin.getId_admin());
                    return admin.getId_admin();
                }
                else {
                    System.out.println("Mdp incorrect");
                    return -1; 
                }
            }
        }
        System.out.println("User introuvable");
        return -2; 
    }

    // Trouver tous les historiques de postes
    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    // Trouver un historique de poste par son ID
    public Optional<Admin> findById(Integer id) {
        return adminRepository.findById(id);
    }

    // Sauvegarder un nouvel historique de poste
    public Admin save(Admin admin) {
        return adminRepository.save(admin);
    }

    // Supprimer un historique de poste
    public void delete(Integer id) {
        adminRepository.deleteById(id);
    }

    // Mettre à jour un historique de poste
    public Admin update(Integer id, Admin admin) {
        if (adminRepository.existsById(id)) {
            admin.setId_admin(id);  // Assurez-vous que l'ID est celui à mettre à jour.
            return adminRepository.save(admin);
        }
        return null; // ou une exception personnalisée si l'historique de poste n'existe pas
    }
}

