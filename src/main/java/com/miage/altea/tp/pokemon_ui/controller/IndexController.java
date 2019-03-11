package com.miage.altea.tp.pokemon_ui.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SpringBootApplication
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/registerTrainer")
    ModelAndView registerNewTrainer(@RequestParam String trainerName){
        ModelAndView modelView = new ModelAndView("register");
        modelView.getModel().put("name", trainerName);
        return modelView;
    }
}
