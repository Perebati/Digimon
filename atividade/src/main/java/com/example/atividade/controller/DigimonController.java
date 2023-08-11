package com.example.atividade.controller;

import com.example.atividade.model.Digimon;
import com.example.atividade.service.DigimonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/digimon")
public class DigimonController {
    @Autowired
    private DigimonService digimonService;

    @GetMapping
    public List <Digimon> getDigimon() {
        return digimonService.getDigimons();
    }

    @GetMapping("/name/{name}")
    public List <Digimon> getDigimonByName(@PathVariable String name){
        String arg = name.substring(0, 1).toUpperCase() + name.substring(1);
        return digimonService.getDigimonsByName(arg);
    }

    @GetMapping("/level/{level}")
    public List <Digimon> getDigimonByLevel(@PathVariable String level){
        String arg = level.substring(0, 1).toUpperCase() + level.substring(1);
        return digimonService.getDigimonsByLevel(arg);
    }
}