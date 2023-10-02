package com.example.co2.Controller;

import com.example.co2.Entite.Bilan;
import com.example.co2.Service.BilanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RequestMapping("/api/Bilan")
@RestController
public class BilanController {
    @Autowired
    BilanService bilanService ;

    @GetMapping("/list-Bilan")
    public Bilan GetBilanByUser() {
        return bilanService.GetBilanByuser();
    }

    @GetMapping ("/Sum-Emp")
    public double Sumemp() {
        return bilanService.SumEmp();
    }
    @GetMapping ("/Sum-Entp")
    public double Sumentrp() {
        return bilanService.SumEntp();
    }
    @GetMapping("/get-Bilan-By-User")
    public Bilan getBilanByUser(){
        return bilanService.getBilanByCuurentUser();
    }


}
