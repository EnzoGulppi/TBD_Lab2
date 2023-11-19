package com.example.resq.Services;

import com.example.resq.Models.Institucion;
import com.example.resq.Repository.InstitucionRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/institucion")
public class InstitucionServices {
    @Autowired
    InstitucionRepository institucionRepository;
    @GetMapping
    public List<Institucion> findAllInstituciones(){
        return institucionRepository.findAllInstitucion();
    }
    @GetMapping("/{id}")
    public Institucion findByIdInstitucion(@PathVariable("id") Integer id){
        return institucionRepository.findByIdInstitucion(id);
    }
    @PostMapping
    public Institucion saveInstitucion(@RequestBody Institucion institucion){
        return institucionRepository.saveInstitucion(institucion);
    }
    @DeleteMapping("/{id}")
    public void deleteInstitucion(@PathVariable("id") Integer id){
        institucionRepository.deleteInstitucion(id);
    }
    @PutMapping
    public Institucion updateInstitucion(@RequestBody Institucion institucion){
        return institucionRepository.updateInstitucion(institucion);
    }
}
