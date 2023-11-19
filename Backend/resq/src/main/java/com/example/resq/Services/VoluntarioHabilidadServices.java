package com.example.resq.Services;

import com.example.resq.Models.VoluntarioHabilidad;
import com.example.resq.Repository.VoluntarioHabilidadRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voluntarioHabilidad")
public class VoluntarioHabilidadServices {
    @Autowired
    VoluntarioHabilidadRepository voluntarioHabilidadRepository;
    @GetMapping
    public List<VoluntarioHabilidad> findAllVoluntarioHabilidad(){
        return voluntarioHabilidadRepository.getAll();
    }
    @GetMapping("/{id}")
    public VoluntarioHabilidad findByIdVoluntarioHabilidad(@PathVariable("id") Integer id){
        return voluntarioHabilidadRepository.getById(id);
    }
    @PostMapping
    public void saveVoluntarioHabilidad(@RequestBody VoluntarioHabilidad voluntarioHabilidad){
        voluntarioHabilidadRepository.create(voluntarioHabilidad);
    }
    @DeleteMapping("/{id}")
    public void deleteVoluntarioHabilidad(@PathVariable("id") Integer id){
        voluntarioHabilidadRepository.delete(id);
    }
}
