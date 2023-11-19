package com.example.resq.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tarea {
    @JsonProperty("id_tarea")
    private Integer id_tarea;
    private String nombre;
    private String descripcion;
    private String region;
    private Double latitud;
    private Double longitud;

    //FK
    private Integer id_estado;

    @JsonProperty("id_emergencia")
    private Integer id_emergencia;

    //Constructor


    /*public Tarea(Integer id_tarea, String nombre, String descripcion,
                 String region, Double latitud, Double longitud,
                 Integer id_estado, Integer id_emergencia) {
        this.id_tarea = id_tarea;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.region = region;
        this.latitud = latitud;
        this.longitud = longitud;
        this.id_estado = id_estado;
        this.id_emergencia = id_emergencia;
    }*/

    //Getter y Setter
    public Integer getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(Integer id_tarea) {
        this.id_tarea = id_tarea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Integer getId_estado() {
        return id_estado;
    }

    public void setId_estado(Integer id_estado) {
        this.id_estado = id_estado;
    }

    public Integer getId_emergencia() {
        return id_emergencia;
    }

    public void setId_emergencia(Integer id_emergencia) {
        this.id_emergencia = id_emergencia;
    }
}
