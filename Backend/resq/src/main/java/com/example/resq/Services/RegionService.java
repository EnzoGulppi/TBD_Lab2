package com.example.resq.Services;

import com.example.resq.Models.Region;
import com.example.resq.Repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/regiones")
public class RegionService {
    @Autowired
    RegionRepository regionRepository;

    @GetMapping
    public List<Region> getAllRegiones(){return regionRepository.getAllRegiones();}

    @GetMapping("/{id}")
    public Region getRegionById(@PathVariable("id") Integer id){return regionRepository.getRegionById(id);}

    @PostMapping
    @ResponseBody
    public void saveRegion(@RequestBody Region region){regionRepository.saveRegion(region);}

    @DeleteMapping("/{id}")
    public void deleteRegion(@PathVariable("id") Integer id){regionRepository.deleteRegion(id);}

    @PutMapping
    @ResponseBody
    public Region updateRegion(@RequestBody Region region){return regionRepository.updateRegion(region);}

    @GetMapping("/{nombre}")
    public Integer getIdByNombre(@PathVariable("nombre") String nombre){return regionRepository.getIdByNombre(nombre);}
}
