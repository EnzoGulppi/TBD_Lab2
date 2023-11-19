package com.example.resq.Services;

import com.example.resq.Models.Ranking;
import com.example.resq.Repository.RankingRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rankings")
public class RankingService {
    @Autowired
    RankingRepository rankingRepository;
    @GetMapping
    public List<Ranking> getAllRankings(){
        return rankingRepository.findAll();
    }
    @GetMapping("/{id}")
    public Ranking findById(@PathVariable("id") Integer id){
        return rankingRepository.findById(id);
    }
    @GetMapping("/voluntario/{id}")
    public List<Ranking> findByVoluntario(@PathVariable("id") Integer id){
        return rankingRepository.findByVoluntario(id);
    }
    @GetMapping("/tarea/{id}")
    public List<Ranking> findByTarea(@PathVariable("id") Integer id){
        return rankingRepository.findByTarea(id);
    }
    @PostMapping
    public Ranking saveRanking(@RequestBody Ranking ranking){
        return rankingRepository.save(ranking);
    }
    @DeleteMapping("/{id}")
    public void deleteRanking(@PathVariable("id") Integer id){
        rankingRepository.delete(id);
    }
    @PutMapping
    public Ranking updateRanking(@RequestBody Ranking ranking){
        return rankingRepository.update(ranking);
    }
}
