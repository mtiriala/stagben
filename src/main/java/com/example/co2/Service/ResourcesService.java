package com.example.co2.Service;

import com.example.co2.Dao.BilanRepository;
import com.example.co2.Dao.ResourcesRepository;
import com.example.co2.Dao.UserRepository;
import com.example.co2.Dto.Resources;
import com.example.co2.Entite.Bilan;
import com.example.co2.Entite.Userco2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResourcesService {

    @Autowired
    ResourcesRepository resourcesRepository;
    @Autowired
    BilanRepository bilanRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
    @Autowired
    BilanService bilanService;

    public Double sum_resources(Resources resources) {
        Optional<Userco2> userco2=userService.getCurrentUser();
        if (userco2.isPresent()) {
            Double sum =resources.getInput1()*0.11*resources.getInput2()+resources.getInput3()*20+resources.getInput4()*120+resources.getInput5()*1500;
            var b1=bilanService.getBilanbyUser(userco2.get());
            if(b1==null){
                b1 = new Bilan();
            }            b1.setUserco2(userco2.get());
            b1.setSum_resources_carbo(sum);
            bilanRepository.save(b1);
            return sum;
        }
        return 0.0;


    }


}
