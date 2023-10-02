package com.example.co2.Service;

import com.example.co2.Dao.BilanRepository;
import com.example.co2.Dao.UserRepository;
import com.example.co2.Entite.Bilan;
import com.example.co2.Entite.Userco2;
import com.example.co2.Service.ServiceImpl.BilanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BilanService implements BilanServiceImpl {

    @Autowired
    BilanRepository bilanRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;



    public  Bilan GetBilanByuser(){
        Optional<Userco2> userco2=userService.getCurrentUser();
        if (userco2.isPresent()) {
            return bilanRepository.findByUserco2(userco2.get());
        }
        return null;
    }
    public Bilan getBilanbyUser(Userco2 userco2){
        return bilanRepository.findByUserco2(userco2);
    }

    public Double SumEmp() {
        Bilan bilan = GetBilanByuser();

        if (bilan != null) {
            Double sum_total =(Double) bilan.getSum_alimontation_carbo() + bilan.getSum_transport_carbo() + bilan.getSum_works_carbo();
            bilan.setSum_total(sum_total);
            bilanRepository.save(bilan);
            return sum_total;
        } else {
            return 0.0;
        }
    }
    public Double SumEntp() {
        Bilan bilan = GetBilanByuser();

        if (bilan != null) {
            Double sum_total =(Double) bilan.getSum_resources_carbo() + bilan.getSum_transport_carbo() ;
            bilan.setSum_total(sum_total);
            bilanRepository.save(bilan);
            return sum_total;
        } else {
            return 0.0;
        }
    }
    public Bilan getBilanByCuurentUser(){
        Optional<Userco2> userco2=userService.getCurrentUser();
        if (userco2.isPresent()) {
            return bilanRepository.findByUserco2(userco2.get());
        }
            return null;
    }

}