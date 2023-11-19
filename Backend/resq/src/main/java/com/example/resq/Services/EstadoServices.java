package com.example.resq.Services;

import com.example.resq.Models.Estado;
import com.example.resq.Repository.EstadoRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/estado")
public class EstadoServices {
    @Autowired
    EstadoRepository estadoRepository;
    @GetMapping
    public List<Estado> findAllEstados(){
        return estadoRepository.findAllEstado();
    }
    @GetMapping("/{id}")
    public Estado findByIdEstado(@PathVariable("id") Integer id){
        return estadoRepository.findByIdEstado(id);
    }
    @GetMapping("/nombre/{nombre}")
    public List<Estado> findByNombreEstado(@PathVariable("nombre") String nombre){
        return estadoRepository.findByNombreEstado(nombre);
    }
    @GetMapping("/id/{nombre}")
    public Integer getIdEstado(@PathVariable("nombre") String nombre){
        return estadoRepository.getIdEstado(nombre);
    }
    @PostMapping
    public Estado saveEstado(@RequestBody Estado estado){
        return estadoRepository.saveEstado(estado);
    }
    @DeleteMapping("/{id}")
    public void deleteEstado(@PathVariable("id") Integer id){
        estadoRepository.deleteEstado(id);
    }
    @PutMapping
    public Estado updateEstado(@RequestBody Estado estado){
        return estadoRepository.updateEstado(estado);
    }
}
