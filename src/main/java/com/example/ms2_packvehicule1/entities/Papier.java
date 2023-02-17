package com.example.ms2_packvehicule1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class Papier {

    private String id;

    private Date date_assurance;

    private Date date_vignette;
    private Date date_visiteTechnique;
}
