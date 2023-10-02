package com.example.co2.Service.ServiceImpl;

import com.example.co2.Entite.Activity;

import java.util.List;
import java.util.Optional;

public interface ActivityServiceImpl {
   Activity addActivity(Activity a1);
   Activity deleteActivity(Long id);
 List<Activity> gettAllActivity();

}
