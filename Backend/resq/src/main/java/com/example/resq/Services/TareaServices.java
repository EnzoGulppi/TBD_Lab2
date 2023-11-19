package com.example.resq.Services;

import com.example.resq.Models.Tarea;
import com.example.resq.Repository.TareaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarea")
public class TareaServices {
    @Autowired
    TareaRepository tareaRepository;
    @GetMapping
    public List<Tarea> findAllTareas(){
        return tareaRepository.findAll();
    }
    @GetMapping("/{id}")
    public Tarea findByIdTarea(@PathVariable("id") Integer id){
        return tareaRepository.findById(id);
    }
    @GetMapping("/nombre/{nombre}")
    public List<Tarea> findByNombreTarea(@PathVariable("nombre") String nombre){
        return tareaRepository.findByNombre(nombre);
    }
    @GetMapping("/emergencia/{id_emergencia}")
    public List<Tarea> findByEmergenciaTarea(@PathVariable("id_emergencia") Integer id_emergencia){
        return tareaRepository.findByEmergencia(id_emergencia);
    }
    @GetMapping("/region/{region}")
    public List<Tarea> findByRegionTarea(@PathVariable("region") String region){
        return tareaRepository.findByRegion(region);
    }
    @PostMapping
    public Tarea saveTarea(@RequestBody Tarea tarea){
        return tareaRepository.save(tarea);
    }
    @DeleteMapping("/{id}")
    public void deleteTarea(@PathVariable("id") Integer id){
        tareaRepository.deleteTarea(id);
    }
    @PutMapping
    public Tarea updateTarea(@RequestBody Tarea tarea){
        return tareaRepository.update(tarea);
    }
}
