package com.example.co2.Service;


import com.example.co2.Dao.SolutionRepository;
import com.example.co2.Entite.Solution;
import com.example.co2.Service.ServiceImpl.SolutionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolutionService implements SolutionServiceImpl {

@Autowired
SolutionRepository solutionRepository;


public Solution addsolution(Solution s1) {
    Solution savesSolution=solutionRepository.save(s1);
    return savesSolution;

}
    public List<Solution> getAllSolution(){
        return solutionRepository.findAll();
    }
    public Solution deleteSolution(Long id){
        Optional<Solution> solution = solutionRepository.findById(id);
        if(solution.isPresent()){
            return solution.get();
        }else
        {
            return null;
        }
    }
}


