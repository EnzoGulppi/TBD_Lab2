package com.example.resq.Services;

import com.example.resq.Models.QueryLog;
import com.example.resq.Repository.QueryLogRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/query")
public class QueryServices {
    @Autowired
    QueryLogRepository queryLogRepository;
    @GetMapping
    public List<QueryLog> findAllQueryLogs(){
        return queryLogRepository.findAll();
    }
    @GetMapping("/reporte")
    public List<Object[]> obtenerDatosReporte(){
        return queryLogRepository.obtenerDatosReporte();
    }

}
