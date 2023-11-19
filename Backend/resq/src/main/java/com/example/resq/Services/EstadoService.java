package com.example.resq.Services;

import com.example.resq.Models.Estado;
import com.example.resq.Repository.EstadoRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/estados")
public class EstadoService {
    @Autowired
    EstadoRepository estadoRepository;
    @GetMapping
    public List<Estado> getAllEstado(){
        return estadoRepository.findAllEstado();
    }

    @GetMapping("/{id}")
    public Estado findById(@PathVariable("id") Integer id){
        return estadoRepository.findByIdEstado(id);
    }

    @PostMapping
    @ResponseBody
    public Estado save(@RequestBody Estado estado){
        return estadoRepository.saveEstado(estado);
    }

    @PutMapping
    @ResponseBody
    public Estado update(@RequestBody Estado estado){
        return estadoRepository.updateEstado(estado);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        estadoRepository.deleteEstado(id);
    }
}
