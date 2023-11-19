package com.example.resq.Services;

import com.example.resq.Models.Habilidad;
import com.example.resq.Repository.HabilidadRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habilidades")
public class HabilidadService {
    @Autowired
    HabilidadRepository habilidadRepository;
    @GetMapping
    public List<Habilidad> getAllHabilidad(){
        return habilidadRepository.findAll();
    }
    @GetMapping("/{id}")
    public Habilidad findById(@PathVariable("id") Integer id){
        return habilidadRepository.findById(id);
    }
    @PostMapping
    @ResponseBody
    public Habilidad save(@RequestBody Habilidad habilidad){
        return habilidadRepository.save(habilidad);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        habilidadRepository.delete(id);
    }
    @PutMapping
    @ResponseBody
    public Habilidad update(@RequestBody Habilidad habilidad){
        return habilidadRepository.update(habilidad);
    }
}
