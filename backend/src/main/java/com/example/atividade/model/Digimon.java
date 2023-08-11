package com.example.atividade.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Digimon {
        @Id
        @GeneratedValue
        private int id;
        private String name;
        private String img;
        private String level;

        public Digimon() {
        }

        public Digimon (String name, String img, String level)
        {
            this.name = name;
            this.img = img;
            this.level = level;
        }

    public String getName() {
        return name;
    }

    public String getImg() {
        return img;
    }

    public String getLevel() {
        return level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "DigimonModel{" +
                "name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
