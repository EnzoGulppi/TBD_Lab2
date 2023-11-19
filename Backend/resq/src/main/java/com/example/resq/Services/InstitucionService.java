package com.example.resq.Services;

import com.example.resq.Models.Institucion;
import com.example.resq.Repository.InstitucionRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instituciones")
public class InstitucionService {
    @Autowired
    InstitucionRepository institucionRepository;
    @GetMapping
    public List<Institucion> getAllInstitucion(){
        return institucionRepository.findAllInstitucion();
    }
    @GetMapping("/{id}")
    public Institucion findById(@PathVariable("id") Integer id){
        return institucionRepository.findByIdInstitucion(id);
    }
    @PostMapping
    @ResponseBody
    public Institucion save(@RequestBody Institucion institucion){
        return institucionRepository.saveInstitucion(institucion);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        institucionRepository.deleteInstitucion(id);
    }
    @PutMapping
    @ResponseBody
    public Institucion update(@RequestBody Institucion institucion){
        return institucionRepository.updateInstitucion(institucion);
    }
}
