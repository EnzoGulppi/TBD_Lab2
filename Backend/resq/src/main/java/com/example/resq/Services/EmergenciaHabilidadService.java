package com.example.resq.Services;

import com.example.resq.Models.Emergencia;
import com.example.resq.Models.EmergenciaHabilidad;
import com.example.resq.Repository.EmergenciaHabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emergencia-habilidades")
public class EmergenciaHabilidadService {
    @Autowired
    EmergenciaHabilidadRepository emergenciaHabilidadRepository;

    @GetMapping
    public List<EmergenciaHabilidad> getAllEmergenciaHabilidad(){return emergenciaHabilidadRepository.findAll();}

    @GetMapping("/{id}")
    public EmergenciaHabilidad findById(@PathVariable("id") Integer id){
        return emergenciaHabilidadRepository.findById(id);
    }

    @GetMapping("/emergencia/{id}")
    public List<EmergenciaHabilidad> findByEmergencia(@PathVariable("id") Integer id){
        return emergenciaHabilidadRepository.findByEmergencia(id);
    }

    @GetMapping("/habilidad/{id}")
    public List<EmergenciaHabilidad> findByHabilidad(@PathVariable("id") Integer id){
        return emergenciaHabilidadRepository.findByHabilidad(id);
    }

    @PostMapping
    public EmergenciaHabilidad saveEmergenciaHabilidad(@RequestBody EmergenciaHabilidad emergenciaHabilidad){
        return emergenciaHabilidadRepository.save(emergenciaHabilidad);
    }

    @PutMapping
    public EmergenciaHabilidad updateEmergenciaHabilidad(@RequestBody EmergenciaHabilidad emergenciaHabilidad){
        return emergenciaHabilidadRepository.update(emergenciaHabilidad);
    }

    @DeleteMapping("/{id}")
    public void deleteEmergenciaHabilidad(@PathVariable("id") Integer id){
        emergenciaHabilidadRepository.delete(id);
    }
}
