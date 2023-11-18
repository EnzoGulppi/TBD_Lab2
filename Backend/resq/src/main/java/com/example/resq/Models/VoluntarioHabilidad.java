package com.example.resq.Models;

public class VoluntarioHabilidad {
    private int idVoluntarioHabilidad;
    private int idVoluntario;
    private int idHabilidad;

    //Contructor

    public VoluntarioHabilidad(int idVoluntarioHabilidad, int idVoluntario, int idHabilidad) {
        this.idVoluntarioHabilidad = idVoluntarioHabilidad;
        this.idVoluntario = idVoluntario;
        this.idHabilidad = idHabilidad;
    }

    //Getter y Setter

    public int getIdVoluntarioHabilidad() {
        return idVoluntarioHabilidad;
    }

    public void setIdVoluntarioHabilidad(int idVoluntarioHabilidad) {
        this.idVoluntarioHabilidad = idVoluntarioHabilidad;
    }

    public int getIdVoluntario() {
        return idVoluntario;
    }

    public void setIdVoluntario(int idVoluntario) {
        this.idVoluntario = idVoluntario;
    }

    public int getIdHabilidad() {
        return idHabilidad;
    }

    public void setIdHabilidad(int idHabilidad) {
        this.idHabilidad = idHabilidad;
    }
}
