package com.example.resq.Repository;

import com.example.resq.Models.Emergencia;

import java.util.List;

public interface EmergenciaRepository {
    public List<Emergencia> getAllEmergencias();
    public Emergencia getEmergenciaById(Integer id);
    public void saveEmergencia(Emergencia emergencia);
    public void deleteEmergencia(Integer id);
    public List<Emergencia> getEmergenciasByEstado(String estado);
}
