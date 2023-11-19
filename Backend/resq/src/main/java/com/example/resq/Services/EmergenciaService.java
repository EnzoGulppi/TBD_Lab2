package com.example.resq.Services;

import com.example.resq.Models.Emergencia;
import com.example.resq.Repository.EmergenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/emergencias")
public class EmergenciaService {
    @Autowired
    private EmergenciaRepository emergenciaRepository;

    @GetMapping
    public List<Emergencia> getAllEmergencias(){
        return emergenciaRepository.getAllEmergencias();
    }

    @GetMapping("/{id}")
    public Emergencia  getEmergenciaById(@PathVariable("id") Integer id){
        return emergenciaRepository.getEmergenciaById(id);
    }

    @GetMapping("/estado/{estado}")
    public List<Emergencia> getEmergenciaByEstado(@PathVariable("estado") String estado){
        return emergenciaRepository.getEmergenciasByEstado(estado);
    }

    @PostMapping
    public void saveEmergencia(@RequestBody Emergencia emergencia){
        emergenciaRepository.saveEmergencia(emergencia);
    }

    @DeleteMapping("/{id}")
    public void deleteEmergencia(@PathVariable Integer id){
        emergenciaRepository.deleteEmergencia(id);
    }
}
