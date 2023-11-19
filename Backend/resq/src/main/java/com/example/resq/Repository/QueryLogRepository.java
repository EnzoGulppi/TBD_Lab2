package com.example.resq.Repository;

import com.example.resq.Models.QueryLog;

import java.util.List;

public interface QueryLogRepository {
    void obtenerReporte();
    List<Object[]> obtenerDatosReporte();
    void dropTabla();
    List<QueryLog> findAll();
}
