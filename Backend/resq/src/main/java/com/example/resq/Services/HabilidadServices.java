package com.example.resq.Services;

import com.example.resq.Models.Habilidad;
import com.example.resq.Repository.HabilidadRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habilidad")
public class HabilidadServices {
    @Autowired
    HabilidadRepository habilidadRepository;
    @GetMapping
    public List<Habilidad> findAllHabilidades(){
        return habilidadRepository.findAll();
    }
    @GetMapping("/{id}")
    public Habilidad findByIdHabilidad(@PathVariable("id") Integer id){
        return habilidadRepository.findById(id);
    }
    @PostMapping
    public Habilidad saveHabilidad(@RequestBody Habilidad habilidad){
        return habilidadRepository.save(habilidad);
    }
    @DeleteMapping("/{id}")
    public void deleteHabilidad(@PathVariable("id") Integer id){
        habilidadRepository.delete(id);
    }
    @PutMapping
    public Habilidad updateHabilidad(@RequestBody Habilidad habilidad){
        return habilidadRepository.update(habilidad);
    }
}
