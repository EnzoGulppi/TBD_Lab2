package com.example.resq.Repository;

import com.example.resq.Models.EmergenciaHabilidad;

import java.util.List;

public interface EmergenciaHabilidadRepository {
    public List<EmergenciaHabilidad> findAll();
    public EmergenciaHabilidad findById(Integer id);
    public List<EmergenciaHabilidad> findByEmergencia(Integer id_emergencia);
    public List<EmergenciaHabilidad> findByHabilidad(Integer id_habilidad);
    public EmergenciaHabilidad save(EmergenciaHabilidad emergenciaHabilidad);
    public EmergenciaHabilidad update(EmergenciaHabilidad emergenciaHabilidad);
    public boolean delete(Integer id);
}
