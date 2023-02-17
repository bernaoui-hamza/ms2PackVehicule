package com.example.ms2_packvehicule1.dto;


import com.example.ms2_packvehicule1.entities.Voiture;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@AllArgsConstructor @NoArgsConstructor
@Data
public class clientResponseDTO {
    private Long id_client;
    private String nom;
    private String prenom;

    private String cin;
    private String adresse;
    private String tel;
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateLocation;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateRetour;
    private Voiture voiture;
    private String  idv;
    //@OneToMany(mappedBy = "client")
    //private List<Voiture> voitures;
}
