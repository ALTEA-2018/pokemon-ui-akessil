package com.miage.altea.tp.pokemon_ui.trainers.service;

import com.miage.altea.tp.pokemon_ui.trainers.bo.Trainer;
import com.miage.altea.tp.pokemon_ui.trainers.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService {
    RestTemplate restTemplate;
    private String trainerServiceUrl;

    @Override
    public List<Trainer> listAllTrainers() {
        Trainer[] result = restTemplate.getForObject(
                this.trainerServiceUrl, Trainer[].class );
        return Arrays.asList(result);
    }

    @Value("${trainer.service.url}")
    public void setTrainerUrl(String trainerUrl){
        this.trainerServiceUrl = trainerUrl;
    }

    @Autowired
    @Qualifier("trainerApiRestTemplate")
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


}
