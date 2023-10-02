package com.example.co2.Service;

import com.example.co2.Dao.BilanRepository;
import com.example.co2.Dao.UserRepository;
import com.example.co2.Dao.WorkRepository;
import com.example.co2.Dto.Works;
import com.example.co2.Entite.Bilan;
import com.example.co2.Entite.Userco2;
import com.example.co2.Service.ServiceImpl.WorkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class WorkService implements WorkServiceImpl {

@Autowired
    WorkRepository workRepository;
@Autowired
    BilanRepository bilanRepository;
@Autowired
    UserRepository userRepository;
@Autowired
   UserService userService;
@Autowired
BilanService bilanService;

    public Double sum_works(Works works) {
        Optional<Userco2> userco2=userService.getCurrentUser();
        if (userco2.isPresent()) {
            Double sum =works.getA()*0.3+works.getB()*27.3+works.getC()*16.6;
            var b1=bilanService.getBilanbyUser(userco2.get());
            if(b1==null){
                b1 = new Bilan();
            }
            b1.setUserco2(userco2.get());
            b1.setSum_works_carbo(sum);
            bilanRepository.save(b1);
            return sum;
        }
        return 0.0;


    }

}
