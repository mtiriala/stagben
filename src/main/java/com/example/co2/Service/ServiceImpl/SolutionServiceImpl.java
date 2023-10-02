package com.example.co2.Service.ServiceImpl;

import com.example.co2.Entite.Solution;

import java.util.List;

public interface SolutionServiceImpl {

    Solution addsolution(Solution s1) ;
   List<Solution> getAllSolution();
   Solution deleteSolution(Long id);
}
