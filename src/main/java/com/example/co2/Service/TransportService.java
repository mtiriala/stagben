package com.example.co2.Service;


import com.example.co2.Dao.BilanRepository;
import com.example.co2.Dao.UserRepository;
import com.example.co2.Dto.Transport;
import com.example.co2.Dto.Works;
import com.example.co2.Entite.Bilan;
import com.example.co2.Entite.Userco2;
import com.example.co2.Service.ServiceImpl.TransportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransportService implements TransportServiceImpl {



    @Autowired
    BilanRepository bilanRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
    @Autowired
    BilanService bilanService;

    public Double sum_transport_public(Transport transport) {
        Optional<Userco2> userco2=userService.getCurrentUser();
        if (userco2.isPresent()) {
            Double value ="option1".equals(transport.getOption())? 1.0:0.0;
            Double sum =value*30;
            Bilan b1 = bilanService.getBilanbyUser(userco2.get());
            b1.setUserco2(userco2.get());
            b1.setSum_transport_carbo(sum);
            b1.getSum_alimontation_carbo();
            bilanRepository.save(b1);
            return sum;
        }
        return 0.0;
    }
    public Double sum_transport_voiture(Transport transport) {
        Optional<Userco2> userco2=userService.getCurrentUser();
        if (userco2.isPresent()) {
            Double value ="option2".equals(transport.getOption())? 1.0:0.0;
            Double sum =value*130;
            Bilan b1 = bilanService.getBilanbyUser(userco2.get());
            b1.setUserco2(userco2.get());
            b1.setSum_transport_carbo(sum);
            bilanRepository.save(b1);
            return sum;
        }
        return 0.0;
    }
    public Double sum_transport_vl(Transport transport) {
        Optional<Userco2> userco2=userService.getCurrentUser();
        if (userco2.isPresent()) {
            Double value ="option3".equals(transport.getOption())? 1.0:0.0;
            Double sum =value*0.4;
            Bilan b1 = bilanService.getBilanbyUser(userco2.get());
            b1.setUserco2(userco2.get());
            b1.setSum_transport_carbo(sum);
            bilanRepository.save(b1);
            return sum;
        }
        return 0.0;
    }

}
