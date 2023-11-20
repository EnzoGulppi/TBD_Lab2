package com.example.resq.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.beans.JavaBean;

public class Region {
    @JsonProperty("id_region")
    private Integer id_region;
    private String nombre_region;
    private String geom;

    public Integer getId_region(){return id_region;}
    public String getNombre_region(){return nombre_region;}
    public String getGeom(){return geom;}
    public void setId_region(Integer id_region){this.id_region = id_region;}
    public void setNombre_region(String nombre_region){this.nombre_region = nombre_region;}
    public void setGeom(String geom){this.geom = geom;}
}


