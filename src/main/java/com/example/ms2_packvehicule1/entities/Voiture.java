package com.example.ms2_packvehicule1.entities;

import com.example.ms2_packvehicule1.Enums.Categorie;
import com.example.ms2_packvehicule1.Enums.Energie;
import com.example.ms2_packvehicule1.Enums.Etat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor @NoArgsConstructor @Data
public class Voiture {
    private String idv;
    private  String marque;
    private String modele;
    private Categorie categorie;
    private Energie energie;
    private Etat etat;
    private long prixJour;
    private Date dateCirculation;
    private int kilometrage;
    private  Papier papier;
   // private client client;
//    private List<Panne_Voiture> panne_voitures;
//    private Papier papier;
}
