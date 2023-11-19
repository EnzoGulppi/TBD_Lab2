package com.example.resq.Services;

import com.example.resq.Models.Voluntario;
import com.example.resq.Repository.VoluntarioRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class VoluntarioServices {
    @Autowired
    VoluntarioRepository voluntarioRepository;
    @GetMapping
    public List<Voluntario> findAllVoluntarios(){
        return voluntarioRepository.findAllVoluntario();
    }
    @GetMapping("/{id}")
    public Voluntario findByIdVoluntario(@PathVariable("id") Integer id){
        return voluntarioRepository.findVoluntarioById(id);
    }
    @GetMapping("/rut/{rut}")
    public Voluntario findByRutVoluntario(@PathVariable("rut") String rut){
        return voluntarioRepository.findVoluntarioByRut(rut);
    }
    @GetMapping("/cercanos/{id_emergencia}/{limite}")
    public List<Voluntario> traerVoluntariosCercanos(@PathVariable("id_emergencia") Integer id_emergencia,
                                                     @PathVariable("limite") Integer limite){
        return voluntarioRepository.traerVoluntariosCercanos(id_emergencia, limite);
    }
    @GetMapping("/emergencia/{id_emergencia}")
    public List<Voluntario> getVoluntariosByEmergencia(@PathVariable("id_emergencia") Integer id_emergencia){
        return voluntarioRepository.getVoluntariosByEmergencia(id_emergencia);
    }
    @PostMapping
    public Voluntario saveVoluntario(@RequestBody Voluntario voluntario){
        return voluntarioRepository.saveVoluntario(voluntario);
    }
    @DeleteMapping("/{id}")
    public void deleteVoluntario(@PathVariable("id") Integer id){
        voluntarioRepository.deleteVoluntario(id);
    }
    @PutMapping
    public Voluntario updateVoluntario(@RequestBody Voluntario voluntario){
        return voluntarioRepository.updateVoluntario(voluntario);
    }
}
