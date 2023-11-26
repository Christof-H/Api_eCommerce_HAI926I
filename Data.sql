/* Requètes SQL récupérées de Spring Boot :
create table t_client (numc integer not null auto_increment, 
        email varchar(255), 
        localite varchar(255), 
        login varchar(255), 
        nom varchar(255), 
        password varchar(255), 
        prenom varchar(255), 
        primary key (numc));

create table t_commande (id integer not null auto_increment, 
        id_client integer, 
        prix_total float(23), 
        statut tinyint check (statut between 0 and 2), 
        date_envoi datetime(6), 
        date_reglement datetime(6), 
        primary key (id));

create table t_fournisseur (numf integer not null auto_increment, 
        email varchar(255), 
        localite varchar(255), 
        login varchar(255), 
        nom varchar(255), 
        password varchar(255), 
        prenom varchar(255), 
        primary key (numf));
*/


INSERT INTO t_client (numc, nom, prenom, login, password, email, localite, centre_interet) VALUES 
('Dubois', 'Sophie', 'sophie_dubois', 'mdpSophie123', 'sophie.dubois@example.com', 'Paris', 'COSMETIQUE'),
('Martin', 'Pierre', 'pierre_martin', 'mdpPierre456', 'pierre.martin@example.com', 'Lyon', 'VETEMENT'),
('Lefèvre', 'Marie', 'marie_lefevre', 'mdpMarie789', 'marie.lefevre@example.com', 'Marseille', 'JOUET'),
('Thomas', 'Jean', 'jean_thomas', 'mdpJean012', 'jean.thomas@example.com', 'Toulouse', 'COSMETIQUE'),
('Richard', 'Julie', 'julie_richard', 'mdpJulie345', 'julie.richard@example.com', 'Bordeaux', 'VETEMENT'),
('Petit', 'Nicolas', 'nicolas_petit', 'mdpNicolas678', 'nicolas.petit@example.com', 'Lille', 'COSMETIQUE'),
('Durand', 'Emma', 'emma_durand', 'mdpEmma901', 'emma.durand@example.com', 'Nice', 'JOUET', 'COSMETIQUE'),
('Leroy', 'Lucas', 'lucas_leroy', 'mdpLucas234', 'lucas.leroy@example.com', 'Strasbourg', 'VETEMENT'),
('Moreau', 'Manon', 'manon_moreau', 'mdpManon567', 'manon.moreau@example.com', 'Nantes', 'COSMETIQUE'),
('Garcia', 'Hugo', 'hugo_garcia', 'mdpHugo890', 'hugo.garcia@example.com', 'Rennes', 'JOUET');


INSERT INTO t_fournisseur (nom, prenom, login, password, email, localite, categorie) VALUES
('Girard', 'Antoine', 'antoine_girard', 'mdpAntoine123', 'antoine.girard@example.com', 'Paris', 'COSMETIQUE'),
('Bernard', 'Isabelle', 'isabelle_bernard', 'mdpIsabelle456', 'isabelle.bernard@example.com', 'Lyon', 'JOUET'),
('Roux', 'François', 'francois_roux', 'mdpFrancois789', 'francois.roux@example.com', 'Marseille', 'COSMETIQUE'),
('Leroux', 'Sandrine', 'sandrine_leroux', 'mdpSandrine012', 'sandrine.leroux@example.com', 'Toulouse', 'VETEMENT'),
('Garnier', 'Juliette', 'juliette_garnier', 'mdpJuliette345', 'juliette.garnier@example.com', 'Bordeaux', 'JOUET'),
('Dubois', 'Matthieu', 'matthieu_dubois', 'mdpMatthieu678', 'matthieu.dubois@example.com', 'Lille', 'COSMETIQUE'),
('Fournier', 'Manon', 'manon_fournier', 'mdpManon901', 'manon.fournier@example.com', 'Nice', 'VETEMENT'),
('Perrin', 'Adrien', 'adrien_perrin', 'mdpAdrien234', 'adrien.perrin@example.com', 'Strasbourg', 'COSMETIQUE'),
('Barbier', 'Charlotte', 'charlotte_barbier', 'mdpCharlotte567', 'charlotte.barbier@example.com', 'Nantes', 'JOUET'),
('Chevalier', 'Nicolas', 'nicolas_chevalier', 'mdpNicolas890', 'nicolas.chevalier@example.com', 'Rennes', 'JOUET');


INSERT INTO t_produit (reference, nom, prix, description, taille, qt_stock, categorie) VALUES
('REF123', 'Fond de teint', 15.99, 'Fond de teint liquide pour une couvrance légère', 'Petite', 50, 'COSMETIQUE'),
('REF456', 'Mascara', 9.75, 'Mascara allongeant pour des cils volumineux', 'Normale', 80, 'COSMETIQUE'),
('REF789', 'Crayon à lèvres', 7.50, 'Crayon pour définir et souligner les lèvres', 'Normale', 60, 'COSMETIQUE'),
('REF101', 'Palette ombres à paupières', 25.00, 'Palette ombres à paupières avec 12 couleurs vives', 'Grande', 30, 'COSMETIQUE'),
('REF202', 'Poupée en peluche', 19.99, 'Poupée en peluche douce et câline', 'Grande', 45, 'JOUET'),
('REF303', 'Voiture télécommandée', 29.99, 'Voiture télécommandée rapide et maniable', 'Normale', 20, 'JOUET'),
('REF404', 'Lego Construction', 39.99, 'Ensemble de Lego pour construire divers objets', 'Grande', 15, 'JOUET'),
('REF505', 'Jeu de société', 24.50, 'Jeu de société familial pour des heures de divertissement', 'Grande', 35, 'JOUET'),
('REF606', 'Peluche Licorne', 12.99, 'Peluche douce et colorée représentant une licorne', 'Normale', 25, 'JOUET'),
('REF001', 'Chemise homme', 29.99, 'Chemise élégante pour homme', 'M', 50, 'VETEMENT'),
('REF002', 'Robe été', 39.99, 'Robe légère pour été', 'S', 30, 'VETEMENT'),
('REF003', 'Jeans slim', 49.99, 'Jeans slim fit pour femme', 'L', 40, 'VETEMENT'),
('REF004', 'Pull en laine', 34.99, 'Pull chaud pour lhiver', 'XL', 20, 'VETEMENT'),
('REF005', 'Veste en cuir', 99.99, 'Veste élégante en cuir pour homme', 'M', 15, 'VETEMENT'),
('REF707', 'Kit de maquillage enfant', 8.99, 'Kit de maquillage ludique pour enfants', 'Petite', 55, 'JOUET');


INSERT INTO t_offre (date_debut, date_fin, remise, categorie, numf) VALUES
('2023-12-01', '2023-12-15', 12.0, 'JOUET', numfournisseur2),
('2024-02-01', '2024-02-28', 18.0, 'COSMETIQUE', numfournisseur2),
('2024-03-15', '2024-04-15', 25.0, 'VETEMENT', numfournisseur2);

