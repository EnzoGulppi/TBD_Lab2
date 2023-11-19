package com.example.resq.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Voluntario {
    @JsonProperty("id")
    private Integer id;
    private String rut;
    private String nombres;
    private String apellidos;
    private Date fecha_nac;
    private String disponibilidad;
    private String telefono;
    private String rol;
    private String contrasena;
    private String region;
    private String geom;
    private Double latitud;
    private Double longitud;

    //Contructor
    public Voluntario(Integer id, String rut, String nombres, String apellidos, Date fecha_nac,
                      String disponibilidad, String telefono, String rol,
                      String contrasena, String region, String geom,
                      Double latitud, Double longitud) {
        this.id = id;
        this.rut = rut;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fecha_nac = fecha_nac;
        this.disponibilidad = disponibilidad;
        this.telefono = telefono;
        this.rol = rol;
        this.contrasena = contrasena;
        this.region = region;
        this.geom = geom;
        this.latitud = latitud;
        this.longitud = longitud;
    }
    //Getter y setter

    //Getter
    public Integer getId() {
        return id;
    }

    public String getRut() {
        return rut;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getRol() {
        return rol;
    }

    public String getContrasena() {
        return contrasena;
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
    //Setter

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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
}
