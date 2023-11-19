package com.example.resq.Repository;

import com.example.resq.Models.Ranking;

import java.util.List;

public interface RankingRepository {
    public List<Ranking> findAll();
    public Ranking findById(Integer id);
    public List<Ranking> findByVoluntario(Integer id_voluntario);
    public List<Ranking> findByTarea(Integer id_tarea);
    public Ranking save(Ranking ranking);
    public Ranking update(Ranking ranking);
    public boolean delete(Integer id);
}
