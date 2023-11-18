package com.example.resq.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Emergencia {
    @JsonProperty("id_emergencia")
    private Integer id_emergencia;
    private String nombre;
    private String gravedad;
    private String fecha;
    private String estado;
    private String region;
    private String geom;
    private Double latitud;
    private Double longitud;
    private String id_institucion;


    //Constructor

    public Emergencia(Integer id_emergencia, String nombre, String gravedad, String fecha, String estado,
                      String region, String geom, Double latitud, Double longitud, String id_institucion) {
        this.id_emergencia = id_emergencia;
        this.nombre = nombre;
        this.gravedad = gravedad;
        this.fecha = fecha;
        this.estado = estado;
        this.region = region;
        this.geom = geom;
        this.latitud = latitud;
        this.longitud = longitud;
        this.id_institucion = id_institucion;
    }

    //Getter y Setter
    //Getter

    public Integer getId_emergencia() {
        return id_emergencia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGravedad() {
        return gravedad;
    }

    public String getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public String getRegion() {
        return region;
    }

    public String getGeom() {
        return geom;
    }

    public Double getLatitud() {
        return latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public String getId_institucion() {
        return id_institucion;
    }

    //Setter

    public void setId_emergencia(Integer id_emergencia) {
        this.id_emergencia = id_emergencia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setGravedad(String gravedad) {
        this.gravedad = gravedad;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setGeom(String geom) {
        this.geom = geom;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public void setId_institucion(String id_institucion) {
        this.id_institucion = id_institucion;
    }
}
