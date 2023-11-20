package com.example.resq.Repository;

import com.example.resq.Models.Institucion;
import com.example.resq.Models.Ranking;
import com.example.resq.Models.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class RegionRepositoryImp implements RegionRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Region> getAllRegiones(){
        List<Region> regiones;
        String query = "SELECT * FROM region";
        try (Connection connection = sql2o.open()){
            regiones = connection.createQuery(query)
                    .executeAndFetch(Region.class);
            return regiones;
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Region getRegionById(Integer id_region) {
        Region region;
        String query = "SELECT * FROM region WHERE id_region = :id";
        try (Connection connection = sql2o.open()) {
            region = connection.createQuery(query)
                    .addParameter("id", id_region)
                    .executeAndFetchFirst(Region.class);
            return region;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public void saveRegion(Region region) {
        String query = "INSERT INTO region (nombre_region,geom) VALUES (:nombre, :geom)";
        try (Connection connection = sql2o.open()) {
            Integer id = (int)connection.createQuery(query, true)
                    .addParameter("nombre_region", region.getNombre_region())
                    .addParameter("geom", region.getGeom())
                    .executeUpdate()
                    .getKey();
            region.setId_region(id);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void deleteRegion(Integer id) {
        String sql = "DELETE FROM region WHERE id_region = :id";
        try (Connection connection = sql2o.open()) {
            connection.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public Region updateRegion(Region region) {
        String query = "UPDATE region SET nombre_region = :nombre_region, geom = :geom WHERE id_region = :id";
        try (Connection connection = sql2o.open()) {
            connection.createQuery(query, true)
                    .addParameter("nombre_region", region.getNombre_region())
                    .addParameter("geom", region.getGeom())
                    .addParameter("id", region.getId_region())
                    .executeUpdate();
            return region;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
