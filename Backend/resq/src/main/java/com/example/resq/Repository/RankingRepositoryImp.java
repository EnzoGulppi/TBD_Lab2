package com.example.resq.Repository;

import com.example.resq.Models.Ranking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class RankingRepositoryImp implements RankingRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Ranking> findAll() {
        String query = "SELECT * FROM ranking";
        try (Connection connection = sql2o.open()) {
            return connection.createQuery(query)
                    .executeAndFetch(Ranking.class);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Ranking findById(Integer id) {
        Ranking ranking;
        String query = "SELECT * FROM ranking WHERE id_ranking = :id";
        try (Connection connection = sql2o.open()) {
            ranking = connection.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Ranking.class);
            return ranking;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<Ranking> findByVoluntario(Integer id_voluntario) {
        List<Ranking> rankings;
        String query = "SELECT * FROM ranking WHERE id_voluntario = :id_voluntario";
        try (Connection connection = sql2o.open()) {
            rankings = connection.createQuery(query)
                    .addParameter("id_voluntario", id_voluntario)
                    .executeAndFetch(Ranking.class);
            return rankings;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<Ranking> findByTarea(Integer id_tarea) {
        List<Ranking> rankings;
        String query = "SELECT * FROM ranking WHERE id_tarea = :id_tarea";
        try (Connection connection = sql2o.open()) {
            rankings = connection.createQuery(query)
                    .addParameter("id_tarea", id_tarea)
                    .executeAndFetch(Ranking.class);
            return rankings;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Ranking save(Ranking ranking) {
        String query = "INSERT INTO ranking (id_voluntario, id_tarea) VALUES (:id_voluntario, :id_tarea)";
        try (Connection connection = sql2o.open()) {
            Integer id = (int) connection.createQuery(query, true)
                    .addParameter("id_voluntario", ranking.getId_voluntario())
                    .addParameter("id_tarea", ranking.getId_tarea())
                    .executeUpdate()
                    .getKey();
            ranking.setId_ranking(id);
            return ranking;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Ranking update(Ranking ranking) {
        String query = "UPDATE ranking SET id_voluntario = :id_voluntario, id_tarea = :id_tarea WHERE id_ranking = :id";
        try (Connection connection = sql2o.open()) {
            connection.createQuery(query, true)
                    .addParameter("id_voluntario", ranking.getId_voluntario())
                    .addParameter("id_tarea", ranking.getId_tarea())
                    .addParameter("id", ranking.getId_ranking())
                    .executeUpdate();
            return ranking;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        String sql = "DELETE FROM ranking WHERE id_ranking = :id";
        try (Connection connection = sql2o.open()) {
            connection.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
