package com.example.co2.Entite;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Bilan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = true)
    private Double sum_works_carbo;
    @Column(nullable = true)
    private Double sum_transport_carbo;
    @Column(nullable = true)
    private Double sum_alimontation_carbo;
    @Column(nullable = true)
    private Double sum_total;
    @OneToOne
    @JoinColumn(name = "userco2_id")
    private Userco2 userco2;
    @Column(nullable = true)
    private Double sum_resources_carbo;


}
