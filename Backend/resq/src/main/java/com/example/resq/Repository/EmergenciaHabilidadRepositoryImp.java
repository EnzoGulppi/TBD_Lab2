package com.example.resq.Repository;

import com.example.resq.Models.EmergenciaHabilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class EmergenciaHabilidadRepositoryImp implements EmergenciaHabilidadRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<EmergenciaHabilidad> findAll(){
        String query = "SELECT * FROM emergencia_habilidad";
        try (Connection connection = sql2o.open()){
            return connection.createQuery(query)
                    .executeAndFetch(EmergenciaHabilidad.class);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public EmergenciaHabilidad findById(Integer id){
        EmergenciaHabilidad emergenciaHabilidad;
        String query = "SELECT * FROM emergencia_habilidad WHERE id_emergencia_habilidad = :id";
        try (Connection connection = sql2o.open()){
            emergenciaHabilidad = connection.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetchFirst(EmergenciaHabilidad.class);
            return emergenciaHabilidad;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<EmergenciaHabilidad> findByEmergencia(Integer id){
        List<EmergenciaHabilidad> emergencias;
        String query = "SELECT * FROM emergencia_habilidad WHERE id_emergencia = :id";
        try (Connection connection = sql2o.open()){
            emergencias = connection.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetch(EmergenciaHabilidad.class);
            return emergencias;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<EmergenciaHabilidad> findByHabilidad(Integer id){
        List<EmergenciaHabilidad> habilidades;
        String query = "SELECT * FROM emergencia_habilidad WHERE id_habilidad = :id";
        try (Connection connection = sql2o.open()){
            habilidades = connection.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetch(EmergenciaHabilidad.class);
            return habilidades;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public EmergenciaHabilidad save(EmergenciaHabilidad emergenciaHabilidad){
        String query = "INSERT INTO emergencia_habilidad (id_emergencia, id_habilidad) VALUES (:id_emergencia, :id_habilidad)";
        try (Connection connection = sql2o.open()){
            Integer id = (int) connection.createQuery(query, true)
                    .addParameter("id_emergencia", emergenciaHabilidad.getId_emergencia())
                    .addParameter("id_habilidad", emergenciaHabilidad.getId_habilidad())
                    .executeUpdate()
                    .getKey();
            emergenciaHabilidad.setId_emergencia_habilidad(id);
            return emergenciaHabilidad;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public EmergenciaHabilidad update(EmergenciaHabilidad emergenciaHabilidad){
        String query = "UPDATE emergencia_habilidad SET id_emergencia = :id_emergencia, id_habilidad = :id_habilidad WHERE id_emergencia_habilidad = :id_emergencia_habilidad";
        try (Connection connection = sql2o.open()){
            connection.createQuery(query, true)
                    .addParameter("id_emergencia", emergenciaHabilidad.getId_emergencia())
                    .addParameter("id_habilidad", emergenciaHabilidad.getId_habilidad())
                    .addParameter("id_emergencia_habilidad", emergenciaHabilidad.getId_emergencia_habilidad())
                    .executeUpdate();
            return emergenciaHabilidad;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public boolean delete(Integer id){
        String query = "DELETE FROM emergencia_habilidad WHERE id_emergencia_habilidad = :id";
        try (Connection connection = sql2o.open()){
            connection.createQuery(query)
                    .addParameter("id", id)
                    .executeUpdate();
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
}
