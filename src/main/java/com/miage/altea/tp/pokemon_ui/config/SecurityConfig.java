package com.miage.altea.tp.pokemon_ui.config;

import com.miage.altea.tp.pokemon_ui.trainers.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    TrainerService trainerService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        System.out.println("----------------------------------- userDetailsService IN trainserServiceDefined: " + (trainerService != null) + " -- " + (trainerService != null ? trainerService.getClass().getName(): "Not Found"));
        return userName -> Optional.ofNullable(trainerService.getTrainer(userName))
        .map(trainer -> User.withUsername(trainer.getName()).password(trainer.getPassword()).roles("USER").build())
        .orElseThrow(() -> new BadCredentialsException("No such user"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.csrf().ignoringAntMatchers("/api/**");
    }

    @Autowired
    public void setTrainerService(TrainerService trainerService) {
        this.trainerService = trainerService;
    }
}
