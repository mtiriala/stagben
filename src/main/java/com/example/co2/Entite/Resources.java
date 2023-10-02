package com.example.co2.Entite;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Resources {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int number_Employee;
    private int number_H_travail;
    private int Taille;
    private int number_PC;
    private int number_clim;
    private float sum_resources_carbo;
    @ManyToOne
    private Activity activity;
}
