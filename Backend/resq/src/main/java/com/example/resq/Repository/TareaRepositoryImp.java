package com.example.resq.Repository;

import com.example.resq.Models.Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class TareaRepositoryImp implements TareaRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Tarea> findAll() {
        List<Tarea> tareas;
        String query = "SELECT * FROM tarea";
        try (Connection connection = sql2o.open()) {
            tareas = connection.createQuery(query)
                    .executeAndFetch(Tarea.class);
            return tareas;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Tarea findById(Integer id) {
        Tarea tarea;
        String query = "SELECT * FROM tarea WHERE id_tarea = :id_tarea";
        try (Connection connection = sql2o.open()) {
            tarea = connection.createQuery(query)
                    .addParameter("id_tarea", id)
                    .executeAndFetchFirst(Tarea.class);
            return tarea;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<Tarea> findByNombre(String nombre) {
        List<Tarea> tareas;
        String query = "SELECT * FROM tarea WHERE nombre = :nombre";
        try (Connection connection = sql2o.open()) {
            tareas = connection.createQuery(query)
                    .addParameter("nombre", nombre)
                    .executeAndFetch(Tarea.class);
            return tareas;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<Tarea> findByEmergencia(Integer id_emergencia) {
        List<Tarea> tareas;
        String query = "SELECT * FROM tarea WHERE id_emergencia = :id_emergencia";
        try (Connection connection = sql2o.open()) {
            tareas = connection.createQuery(query)
                    .addParameter("id_emergencia", id_emergencia)
                    .executeAndFetch(Tarea.class);
            return tareas;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<Tarea> findByRegion(String region) {
        List<Tarea> tareas;
        String query = "SELECT * FROM tarea WHERE region = :region";
        try (Connection connection = sql2o.open()) {
            tareas = connection.createQuery(query)
                    .addParameter("region", region)
                    .executeAndFetch(Tarea.class);
            return tareas;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Tarea save(Tarea tarea) {
        String query = "INSERT INTO tarea (nombre, descripcion, region, longitud, latitud, geom, id_estado, id_emergencia) " +
                "VALUES (:nombre, :descripcion, :region, :longitud, :latitud, ST_PointFromText('POINT(' || :longitud || ' ' || :latitud || ')'), :id_estado, :id_emergencia)";
        try (Connection connection = sql2o.open()) {
            Integer id = connection.createQuery(query, true)
                    .addParameter("nombre", tarea.getNombre())
                    .addParameter("descripcion", tarea.getDescripcion())
                    .addParameter("region", tarea.getRegion())
                    .addParameter("longitud", tarea.getLongitud())
                    .addParameter("latitud", tarea.getLatitud())
                    .addParameter("id_estado", tarea.getId_estado())
                    .addParameter("id_emergencia", tarea.getId_emergencia())
                    .executeUpdate().getKey(Integer.class);
            tarea.setId_tarea(id);
            return tarea;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Tarea update(Tarea tarea) {
        String query = "UPDATE tarea SET nombre = :nombre, descripcion = :descripcion, region = :region," +
                " longitud = :longitud, latitud = :latitud, " +
                "geom = ST_PointFromText('POINT(' || :longitud || ' ' || :latitud || ')'), id_estado = :id_estado," +
                " id_emergencia = :id_emergencia WHERE id_tarea = :id_tarea";
        try (Connection connection = sql2o.open()) {
            connection.createQuery(query, true)
                    .addParameter("id_tarea", tarea.getId_tarea())
                    .addParameter("nombre", tarea.getNombre())
                    .addParameter("descripcion", tarea.getDescripcion())
                    .addParameter("region", tarea.getRegion())
                    .addParameter("longitud", tarea.getLongitud())
                    .addParameter("latitud", tarea.getLatitud())
                    .addParameter("id_estado", tarea.getId_estado())
                    .addParameter("id_emergencia", tarea.getId_emergencia())
                    .executeUpdate();
            return tarea;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public boolean deleteTarea(Integer id) {
        String query = "DELETE FROM tarea WHERE id_tarea = :id_tarea";
        try (Connection connection = sql2o.open()) {
            connection.createQuery(query)
                    .addParameter("id_tarea", id)
                    .executeUpdate();
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
}
