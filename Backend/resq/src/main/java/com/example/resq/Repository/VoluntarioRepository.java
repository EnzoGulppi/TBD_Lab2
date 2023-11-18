package com.example.resq.Repository;

import com.example.resq.Models.Voluntario;

import java.util.List;

public interface VoluntarioRepository {
    public List<Voluntario> findAllVoluntario();
    public Voluntario findVoluntarioById(Integer id);
}
