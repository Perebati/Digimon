package com.example.atividade.service;

import com.example.atividade.model.Digimon;
import com.example.atividade.repository.DigimonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DigimonService{
    @Autowired
    DigimonRepository repository;

    public List<Digimon> saveDigimons(List<Digimon> digimons) {
        return repository.saveAll(digimons);
    }

    public List<Digimon> getDigimons() {
        return repository.findAll();
    }

    public List <Digimon> getDigimonsByName(String name){
        return repository.findByName(name);
    }

    public List<Digimon> getDigimonsByLevel(String level) {
        return repository.findByLevel(level);
    }
}