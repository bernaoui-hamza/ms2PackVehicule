package com.example.ms2_packvehicule1;

import com.example.ms2_packvehicule1.Service.IserviceVoiture;
import com.example.ms2_packvehicule1.dto.clientRequestDTO;
import com.example.ms2_packvehicule1.dto.clientResponseDTO;
import com.example.ms2_packvehicule1.entities.client;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Ms2PackVehicule1Application {

    public static void main(String[] args) {
        SpringApplication.run(Ms2PackVehicule1Application.class, args);
    }
    @Bean
CommandLineRunner commandLineRunner(IserviceVoiture iserviceVoiture) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
Date dt= formatter.parse("2022-03-11");
        Date dt2= formatter.parse("2023-01-30");
        return args -> {
            clientResponseDTO cc=iserviceVoiture.saveClient(
                    new clientRequestDTO(null,"hamza","ber","BWB111","casa","0618776090",
                            "bernaouihamza@gmail.com", dt,dt2,"v1"));
            clientResponseDTO c2=iserviceVoiture.saveClient(
                    new clientRequestDTO(null,"amine","ber","BWB2221","sale","0618776090",
                            "bernaouiamine@gmail.com",dt ,dt2,"v2"));

        };
}

}
