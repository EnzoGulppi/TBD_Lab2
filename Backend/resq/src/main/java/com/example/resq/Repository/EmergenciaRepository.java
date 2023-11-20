package com.example.resq.Repository;

import com.example.resq.Models.Emergencia;
import org.locationtech.jts.geom.Geometry;

import java.util.List;

public interface EmergenciaRepository {
    List<Emergencia> getAllEmergencias();
    Emergencia getEmergenciaById(Integer id);
    void saveEmergencia(Emergencia emergencia);
    void deleteEmergencia(Integer id);

    List<Emergencia> getEmergenciasByEstado(String estado);

    List<Emergencia> getEmergenciasByRegion(String region);
}
