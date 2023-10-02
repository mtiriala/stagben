package com.example.co2.Controller;

import com.example.co2.Dto.Resources;
import com.example.co2.Service.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("/api/ListResources")
@RestController
public class ResourcesController {

    @Autowired
    ResourcesService resourcesService;


    @PostMapping("/sum_carbo_resource")
    public double calculer(@RequestBody Resources resources){
        return resourcesService.sum_resources(resources);

    }
}
