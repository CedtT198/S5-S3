INSERT INTO type_medicament (nom_type_med) VALUES 
('Antibiotique'),
('Antalgique'),
('Anti-inflammatoire');

INSERT INTO type_mouvement_stock (nom_type_mvt_stock) VALUES 
('Input'),
('Output');

INSERT INTO personnel (nom, prenom, date_naissance, ville_naissance) VALUES 
('Dupont', 'Pierre', '1980-05-15', 'Antananarivo'),
('Rajaonarivelo', 'Andry', '1992-11-03', 'Antsirabe'),
('Randriamihaja', 'Lova', '1985-07-22', 'Toamasina'),
('Rakotondrasoa', 'Mamy', '1990-02-19', 'Fianarantsoa'),
('Raharinirina', 'Tiana', '1995-04-10', 'Mahajanga'),
('Rasolofonirina', 'Noeline', '1988-12-05', 'Tamatave');

INSERT INTO poste (nom_poste) VALUES
-- ('Pharmacien'),
('Caissier'),
('Nettoyeur'),
('Informaticien'),
('Responsable Stock');

INSERT INTO salaire (date_salaire, montant_salaire, id_personnel) VALUES 
('2024-01-01', 5000.00, 1),  -- Salaire pour le personnel avec idPersonnel 1
('2024-01-01', 4500.00, 2),  -- Salaire pour le personnel avec idPersonnel 2
('2024-01-01', 6000.00, 3),  -- Salaire pour le personnel avec idPersonnel 3
('2024-01-01', 5500.00, 4),  -- Salaire pour le personnel avec idPersonnel 4
('2024-01-01', 6500.00, 5),  -- Salaire pour le personnel avec idPersonnel 5
('2024-01-01', 7000.00, 6);  -- Salaire pour le personnel avec idPersonnel 6

INSERT INTO historique_poste (date_debut, date_fin, id_poste, id_personnel) VALUES 
('2024-01-01', '2024-12-31', 1, 1),  -- Caissier pour le personnel 1
('2024-01-01', '2024-12-31', 1, 2),  -- Caissier pour le personnel 2
('2024-01-01', '2024-12-31', 2, 3),  -- Nettoyeur pour le personnel 3
('2024-01-01', '2024-12-31', 3, 4),  -- Informaticien pour le personnel 4
('2024-01-01', '2024-12-31', 4, 5),  -- Responsable Stock pour le personnel 5
('2024-01-01', '2024-12-31', 4, 6);  -- Responsable Stock pour le personnel 6

INSERT INTO admin (nom_admin, mdp) VALUES
('admin', 'admin');

INSERT INTO maladie (nom_maladie) VALUES
('Grippe'),
('Diabète de type 2'),
('Hypertension'),
('Maux de tete');

INSERT INTO forme (nom_forme) VALUES
('Sirop'),
('Comprime'),
('Injection');

INSERT INTO laboratoire (nom) VALUES
('Pfizer'),
('Sanofi'),
('Novartis'),
('AstraZeneca');

INSERT INTO patient (age_min, age_max) VALUES
(3, 12),  -- Enfants
(13, 19), -- Adolescents
(20, 39), -- Jeunes adultes
(40, 100); -- Adultes 

-- Trois médicaments pour le type "Antibiotique"
INSERT INTO medicaments (nom_med, notice, id_type_med, id_forme) VALUES 
('Amoxicilline', 'Antibiotique utilisé pour traiter les infections bactériennes.', 1, 1),
('Ciprofloxacine', 'Antibiotique utilisé contre les infections urinaires et respiratoires.', 1, 1),
('Doxycycline', 'Antibiotique utilisé pour traiter les infections à bactéries.', 1, 1),
('Med4', 'Antibiotique utilisé pour traiter les infections bactériennes.', 1, 1),
('Med5', 'Antibiotique utilisé contre les infections urinaires et respiratoires.', 1, 1),
('Med6', 'Antibiotique utilisé pour traiter les infections à bactéries.', 1, 1),
('Med7', 'Antibiotique utilisé pour traiter les infections bactériennes.', 1, 1),
('Med8', 'Antibiotique utilisé contre les infections urinaires et respiratoires.', 1, 1),
('Med9', 'Antibiotique utilisé pour traiter les infections à bactéries.', 1, 1);


-- -- Trois médicaments pour le type "Antalgique"
-- INSERT INTO medicaments (nom_med, notice, id_type_med, id_forme) VALUES 
-- ('Paracétamol', 'Médicament pour soulager la douleur légère à modérée.', 2, 2),
-- ('Ibuprofène', 'Anti-inflammatoire non stéroïdien pour soulager la douleur et linflammation.', 2, 2),
-- ('Aspirine', 'Médicament utilisé pour soulager la douleur et réduire la fièvre.', 2, 2);

-- -- Trois médicaments pour le type "Anti-inflammatoire"
-- INSERT INTO medicaments (nom_med, notice, id_type_med, id_forme) VALUES 
-- ('Diclofénac', 'Anti-inflammatoire non stéroïdien utilisé pour traiter linflammation.', 3, 3),
-- ('Célécoxib', 'Anti-inflammatoire utilisé pour traiter les douleurs arthritiques.', 3, 3),
-- ('Naproxène', 'Anti-inflammatoire utilisé pour traiter les douleurs musculaires et articulaires.', 3, 3);

-- Trois prix pour les médicaments de type "Antibiotique"
INSERT INTO prix_med (montant, date_prix, id_med) VALUES 
(15.50, '2024-01-01', 1),  -- Prix pour Amoxicilline
(18.00, '2024-01-01', 2),  -- Prix pour Ciprofloxacine
(20.00, '2024-01-01', 3);  -- Prix pour Doxycycline

-- -- Trois prix pour les médicaments de type "Antalgique""
-- INSERT INTO prix_med (montant, date_prix, id_med) VALUES 
-- (5.00, '2024-01-01', 4),  -- Prix pour Paracétamol
-- (7.50, '2024-01-01', 5),  -- Prix pour Ibuprofène
-- (6.00, '2024-01-01', 6);  -- Prix pour Aspirine

-- -- Trois prix pour les médicaments de type "Anti-inflammatoire""
-- INSERT INTO prix_med (montant, date_prix, id_med) VALUES 
-- (25.00, '2024-01-01', 7),  -- Prix pour Diclofénac
-- (28.50, '2024-01-01', 8),  -- Prix pour Célécoxib
-- (24.00, '2024-01-01', 9);  -- Prix pour Naproxène


-- Mouvements de stock pour les médicaments de type "Antibiotique"
INSERT INTO mouvement_stock (date_mvt_stock, quantite, id_med, id_type_mvt_stock) VALUES 
('2024-01-01', 100, 1, 1),  -- Mouvement pour Amoxicilline (Input)
('2024-01-01', 100, 2, 1),  -- Mouvement pour Ciprofloxacine (Input)
('2024-01-01', 100, 3, 1);  -- Mouvement pour Doxycycline (Input)

-- -- Mouvements de stock pour les médicaments de type "Antalgique"
-- INSERT INTO mouvement_stock (date_mvt_stock, quantite, id_med, id_type_mvt_stock) VALUES 
-- ('2024-01-01', 100, 4, 1),  -- Mouvement pour Paracétamol (Input)
-- ('2024-01-01', 100, 5, 1),  -- Mouvement pour Ibuprofène (Input)
-- ('2024-01-01', 100, 6, 1);  -- Mouvement pour Aspirine (Input)

-- -- Mouvements de stock pour les médicaments de type "Anti-inflammatoire"
-- INSERT INTO mouvement_stock (date_mvt_stock, quantite, id_med, id_type_mvt_stock) VALUES 
-- ('2024-01-01', 100, 7, 1),  -- Mouvement pour Diclofénac (Input)
-- ('2024-01-01', 100, 8, 1),  -- Mouvement pour Célécoxib (Input)
-- ('2024-01-01', 100, 9, 1);  -- Mouvement pour Naproxène (Input)

INSERT INTO medicaments_maladie (id_medicaments_maladie, id_maladie, id_med) VALUES
('MM001', 1, 1),  -- Grippe - Médicament 1
('MM002', 2, 2),  -- Diabète - Médicament 3
('MM003', 3, 3);  -- Hypertension - Médicament 5

INSERT INTO posologie (dose, frequence, duree, id_maladie, id_forme, id_patient, id_med) VALUES
-- Posologies pour Amoxicilline (id_med = 1)
(5, 3, 7, 1, 1, 1, 1),  -- 5 ml trois fois par jour pendant 7 jours (forme sirop)
(500, 3, 5, 1, 2, 3, 1), -- 500 mg trois fois par jour pendant 5 jours (forme comprimé)

-- Posologies pour Ciprofloxacine (id_med = 2)
(250, 2, 10, 2, 2, 4, 2), -- 250 mg deux fois par jour pendant 10 jours (forme comprimé)
(500, 2, 7, 2, 2, 3, 2),  -- 500 mg deux fois par jour pendant 7 jours (forme comprimé)

-- Posologies pour Doxycycline (id_med = 3)
(100, 1, 7, 3, 2, 2, 3),  -- 100 mg une fois par jour pendant 7 jours (forme comprimé)
(200, 1, 10, 3, 2, 3, 3); -- 200 mg en dose unique puis 100 mg/jour pendant 10 jours (forme comprimé)


INSERT INTO posologie (dose, frequence, duree, id_maladie, id_forme, id_patient, id_med) VALUES
(5, 3, 7, 4, 1, 1, 4),  
(500, 3, 5, 2, 2, 3, 5),
(500, 3, 5, 4, 2, 1, 6), 
(500, 3, 5, 2, 2, 1, 7), 
(500, 3, 5, 4, 2, 3, 8), 
(500, 3, 5, 1, 2, 1, 9); 

INSERT INTO posologie (dose, frequence, duree, id_maladie, id_forme, id_patient, id_med) VALUES
(5, 3, 7, 2, 1, 2, 4);


INSERT INTO medicament_labo (id_med, id_laboratoire) VALUES 
(1, 1),  -- Amoxicilline - Pfizer
(1, 2),  -- Amoxicilline - Sanofi
(2, 3),  -- Ciprofloxacine - Novartis
(2, 1),  -- Ciprofloxacine - Pfizer
(3, 4),  -- Doxycycline - AstraZeneca
(3, 2);  -- Doxycycline - Sanofi

