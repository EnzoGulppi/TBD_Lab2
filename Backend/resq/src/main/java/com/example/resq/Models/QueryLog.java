package com.example.resq.Models;

import java.time.LocalDateTime;

public class QueryLog {
    private Integer id;
    private String usuario;
    private String query;
    private String tipoOperacion;
    private String tabla;
    private LocalDateTime tiempo;

    //Constructor

    public QueryLog(Integer id, String usuario, String query,
                    String tipoOperacion, String tabla, LocalDateTime tiempo) {
        this.id = id;
        this.usuario = usuario;
        this.query = query;
        this.tipoOperacion = tipoOperacion;
        this.tabla = tabla;
        this.tiempo = tiempo;
    }
    //Getter y Setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public LocalDateTime getTiempo() {
        return tiempo;
    }

    public void setTiempo(LocalDateTime tiempo) {
        this.tiempo = tiempo;
    }
}
