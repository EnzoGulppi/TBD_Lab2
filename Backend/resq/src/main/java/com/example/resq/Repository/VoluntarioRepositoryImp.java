package com.example.resq.Repository;


import com.example.resq.Models.Voluntario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class VoluntarioRepositoryImp implements VoluntarioRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Voluntario> findAllVoluntario(){
        List<Voluntario> salida;
        String query = "SELECT * FROM Voluntario";
        try(Connection connection = sql2o.open()){
            salida = connection.createQuery(query).executeAndFetch(Voluntario.class);
            return salida;
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
        return null;
    }

    @Override
    public Voluntario findVoluntarioById(Integer id){
        Voluntario salida;
        String query = "SELECT * FROM Voluntario WHERE id = :id";
        try(Connection connection = sql2o.open()){
            salida = connection.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Voluntario.class);
            return salida;
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
        return null;
    }

    
}
