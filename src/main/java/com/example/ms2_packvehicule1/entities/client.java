package com.example.ms2_packvehicule1.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.*;
@Entity
@AllArgsConstructor @NoArgsConstructor
@Data
public class client {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_client;
    private String nom;
    private String prenom;
    @Column(name="cin", unique=true)
    private String cin;
    private String adresse;
    private String tel;
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateLocation;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateRetour;
    private String idv;
    @Transient
    private Voiture v1;

}
