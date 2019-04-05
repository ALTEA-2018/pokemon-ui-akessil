package com.miage.altea.tp.pokemon_ui.config;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class SecurityControllerAdvice {

    @ModelAttribute("user")
    public Object principal(){
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
