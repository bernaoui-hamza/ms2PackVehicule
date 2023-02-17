package com.example.ms2_packvehicule1.openFeigne;

import com.example.ms2_packvehicule1.entities.Voiture;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(name="VOITURE-APP",url = "http://localhost:8085")
public interface FeignRestClient {
    @GetMapping(path = "/api/voiture/{id}")
    Voiture getVoiture(@PathVariable(name="id") String id);

    @GetMapping(path = "/api/voitures")
    List<Voiture> voitures();
}
