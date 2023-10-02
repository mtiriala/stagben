package com.example.co2.Service;

import com.example.co2.Dao.BilanRepository;
import com.example.co2.Dao.FoodRepository;
import com.example.co2.Dto.Alimontaion;
import com.example.co2.Dto.Works;
import com.example.co2.Entite.Bilan;
import com.example.co2.Entite.Userco2;
import com.example.co2.Service.ServiceImpl.FoodServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FoodService implements FoodServiceImpl {
@Autowired
FoodRepository foodRepository;
@Autowired
    UserService userService;
@Autowired
    BilanRepository bilanRepository;
@Autowired
 BilanService bilanService;


    public Double sum_alimontation(Alimontaion alimontaion) {
        Optional<Userco2> userco2=userService.getCurrentUser();
        if (userco2.isPresent()) {
            if(alimontaion.getTest()==true) {
                Double sum = 0.8;
                Bilan b1 = bilanService.getBilanbyUser(userco2.get());
                b1.setUserco2(userco2.get());
                b1.setSum_alimontation_carbo(sum);
                bilanRepository.save(b1);
                return sum;
            }
            else
            {
                Double sum = 1.6;
                Bilan b1 = bilanService.getBilanbyUser(userco2.get());
                b1.setUserco2(userco2.get());
                b1.setSum_alimontation_carbo(sum);
                bilanRepository.save(b1);
                return sum;
            }
        }
        return 0.0;


    }

}


