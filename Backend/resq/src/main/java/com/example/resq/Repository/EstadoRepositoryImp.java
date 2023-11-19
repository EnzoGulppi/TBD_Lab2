package com.example.resq.Repository;

import com.example.resq.Models.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class EstadoRepositoryImp implements EstadoRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Estado> findAllEstado(){
        List<Estado> estados;
        String query = "SELECT * FROM Estado";
        try (Connection connection = sql2o.open()){
            estados = connection.createQuery(query)
                    .executeAndFetch(Estado.class);
            return estados;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Estado findByIdEstado(Integer id){
        Estado estado;
        String query = "SELECT * FROM Estado WHERE id_estado = :id_estado";
        try (Connection connection = sql2o.open()){
            estado = connection.createQuery(query)
                    .addParameter("id_estado", id)
                    .executeAndFetchFirst(Estado.class);
            return estado;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<Estado> findByNombreEstado(String nombre){
        List<Estado> estados;
        String query = "SELECT * FROM Estado WHERE nombre = :nombre";
        try (Connection connection = sql2o.open()){
            estados = connection.createQuery(query)
                    .addParameter("nombre", nombre)
                    .executeAndFetch(Estado.class);
            return estados;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Integer getIdEstado(String nombre){
        String query = "SELECT id_estado FROM Estado WHERE nombre = :nombre";
        try (Connection connection = sql2o.open()){
            String id = connection.createQuery(query)
                    .addParameter("nombre", nombre)
                    .executeAndFetchFirst(String.class);
            return Integer.parseInt(id);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Estado saveEstado(Estado estado){
        String query = "INSERT INTO Estado (nombre) " +
                "VALUES (:nombre)";
        try (Connection connection = sql2o.open()){
            Integer id = (int) connection.createQuery(query,true)
                    .addParameter("nombre", estado.getNombre())
                    .executeUpdate()
                    .getKey();
            estado.setId_Estado(id);
            return estado;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Estado updateEstado(Estado estado){
        String query = "UPDATE Estado SET nombre = :nombre WHERE id_estado = :id";
        try (Connection connection = sql2o.open()){
            connection.createQuery(query)
                    .addParameter("nombre", estado.getNombre())
                    .addParameter("id", estado.getId_Estado())
                    .executeUpdate();
            return estado;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public void deleteEstado(Integer id){
        String query = "DELETE FROM Estado WHERE id_estado = :id_estado";
        try (Connection connection = sql2o.open()){
            connection.createQuery(query)
                    .addParameter("id_estado",id)
                    .executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
