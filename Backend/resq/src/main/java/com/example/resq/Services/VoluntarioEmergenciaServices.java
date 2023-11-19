package com.example.resq.Services;

import com.example.resq.Models.VoluntarioEmergencia;
import com.example.resq.Repository.VoluntarioEmergenciaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voluntario_emergencia")
public class VoluntarioEmergenciaServices {
    @Autowired
    VoluntarioEmergenciaRepository voluntarioEmergenciaRepository;
    @GetMapping
    public List<VoluntarioEmergencia> findAllVoluntarioEmergencias(){
        return voluntarioEmergenciaRepository.getAll();
    }
    @GetMapping("/{id}")
    public VoluntarioEmergencia findByIdVoluntarioEmergencia(@PathVariable("id") Integer id){
        return voluntarioEmergenciaRepository.getById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteVoluntarioEmergencia(@PathVariable("id") Integer id){
        voluntarioEmergenciaRepository.delete(id);
    }
    @PostMapping
    public void saveVoluntarioEmergencia(@PathVariable("id") Integer id_emergencia,
                                         @PathVariable("id") Integer id_usuario){
        voluntarioEmergenciaRepository.save(id_emergencia, id_usuario);
    }
    @GetMapping("/cantidad/{id_emergencia}")
    public Integer cantidadVoluntarios(@PathVariable("id_emergencia") Integer id_emergencia){
        return voluntarioEmergenciaRepository.cantidadVoluntarios(id_emergencia);
    }
    @GetMapping("/verificar/{id_voluntario}/{id_emergencia}")
    public Boolean verificarRegistro(@PathVariable("id_voluntario") Integer id_voluntario,
                                     @PathVariable("id_emergencia") Integer id_emergencia){
        return voluntarioEmergenciaRepository.verificarRegistro(id_voluntario, id_emergencia);
    }
}
