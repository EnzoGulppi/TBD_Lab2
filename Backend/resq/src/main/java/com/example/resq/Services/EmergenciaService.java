package com.example.resq.Services;

import com.example.resq.Models.Emergencia;
import com.example.resq.Repository.EmergenciaRepository;
import org.locationtech.jts.geom.Geometry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/emergencias")
public class EmergenciaService {
    @Autowired
    private EmergenciaRepository emergenciaRepository;


    @GetMapping
    public List<Emergencia> getAllEmergencias() {
        List<Emergencia> salida = emergenciaRepository.getAllEmergencias();
        return salida;
    }

    @GetMapping("/{id}")
    public Emergencia getEmergenciaById(@PathVariable Integer id) {
        return emergenciaRepository.getEmergenciaById(id);
    }

    @GetMapping("/estado/{estado}")
    public List<Emergencia> getEmergenciaByEstado(@PathVariable String estado) {
        return emergenciaRepository.getEmergenciasByEstado(estado);
    }
    @GetMapping("/region/{id_region}")
    public List<Emergencia> getEmergenciaByRegion(@PathVariable Integer id_region) {
        return emergenciaRepository.getEmergenciasByRegion(id_region);
    }

    @PostMapping
    public void saveEmergencia(@RequestBody Map<String, Object> json) {
        String nombre = (String) json.get("nombre");
        String gravedad = (String) json.get("gravedad");
        String fecha = (String) json.get("fecha");
        String institucion = (String) json.get("institucion");
        String estado = (String) json.get("estado");
        Integer id_region = (Integer) json.get("id_region");
        Double longitud = (Double) json.get("longitud");
        Double latitud = (Double) json.get("latitud");

        System.out.println("Nombre: " + nombre);
        System.out.println("Gravedad: " + gravedad);
        System.out.println("Fecha: " + fecha.toString());
        System.out.println("Institucion: " + institucion);
        System.out.println("Region: " + id_region);
        System.out.println("Longitud: " + longitud);
        System.out.println("Latitud: " + latitud);

        // Buscar id de la institucion

        //Integer idInstitucion = institucionService.getByName(institucion).getIdInstitucion();
        Integer idInstitucion = 1;

        Emergencia salida = new Emergencia();
        salida.setNombre(nombre);
        salida.setGravedad(gravedad);
        salida.setFecha(fecha);
        salida.setIdInstitucion(idInstitucion);
        salida.setEstado(estado);
        salida.setIdRegion(id_region);
        salida.setLongitud(longitud);
        salida.setLatitud(latitud);
        emergenciaRepository.saveEmergencia(salida);
    }

    @DeleteMapping("/{id}")
    public void deleteEmergencia(@PathVariable Integer id) {
        emergenciaRepository.deleteEmergencia(id);
    }
}
