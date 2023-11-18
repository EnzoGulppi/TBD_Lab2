package com.example.resq.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Estado {
    @JsonProperty("id_estado")
    private Integer id_Estado;
    private String nombre;

    //Getter y Setter
    public Integer getId_Estado() {
        return id_Estado;
    }

    public void setId_Estado(Integer id_Estado) {
        this.id_Estado = id_Estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
