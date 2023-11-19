package com.example.resq.Services;

import com.example.resq.Models.Tarea;
import com.example.resq.Repository.EstadoRepository;
import com.example.resq.Repository.TareaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tareas")
public class TareaService {
    @Autowired
    TareaRepository tareaRepository;
    @Autowired
    EstadoRepository estadoRepository;
    @GetMapping
    public List<Tarea> getAllTareas(){
        return tareaRepository.findAll();
    }
    @GetMapping("/{id}")
    public Tarea findById(@PathVariable("id") Integer id){
        return tareaRepository.findById(id);
    }
    @GetMapping("/emergencia/{id_emergencia}")
    public List<Tarea> findByEmergencia(@PathVariable("id_emergencia") Integer id_emergencia){
        return tareaRepository.findByEmergencia(id_emergencia);
    }
    @GetMapping("/region/{region}")
    public List<Tarea> findByRegionTarea(@PathVariable("region") String region){
        return tareaRepository.findByRegion(region);
    }
    @PostMapping
    public void save(@RequestBody Map<String, Object> json){
        String nombre = (String) json.get("nombre");
        String descripcion = (String) json.get("descripcion");
        String estado = (String) json.get("estado");
        String region = (String) json.get("region");
        Double longitud = (Double) json.get("longitud");
        Double latitud = (Double) json.get("latitud");
        Integer id_estado = estadoRepository.getIdEstado(estado);
        Integer id_emergencia = (Integer) json.get("idEmergencia");

        Tarea tarea = new Tarea();
        tarea.setNombre(nombre);
        tarea.setDescripcion(descripcion);
        tarea.setId_estado(id_estado);
        tarea.setRegion(region);
        tarea.setLongitud(longitud);
        tarea.setLatitud(latitud);
        tarea.setId_emergencia(id_emergencia);

        tareaRepository.save(tarea);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        tareaRepository.deleteTarea(id);
    }
    @PutMapping
    public Tarea update(@RequestBody Tarea tarea){
        return tareaRepository.update(tarea);
    }
}
