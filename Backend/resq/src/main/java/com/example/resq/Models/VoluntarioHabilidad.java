package com.example.resq.Models;

public class VoluntarioHabilidad {
    private int idVoluntarioHabilidad;
    private int idvoluntario;
    private int idHabilidad;

    //Contructor

    public VoluntarioHabilidad(int idVoluntarioHabilidad, int idvoluntario, int idHabilidad) {
        this.idVoluntarioHabilidad = idVoluntarioHabilidad;
        this.idvoluntario = idvoluntario;
        this.idHabilidad = idHabilidad;
    }

    //Getter y Setter

    public int getIdVoluntarioHabilidad() {
        return idVoluntarioHabilidad;
    }

    public void setIdVoluntarioHabilidad(int idVoluntarioHabilidad) {
        this.idVoluntarioHabilidad = idVoluntarioHabilidad;
    }

    public int getIdvoluntario() {
        return idvoluntario;
    }

    public void setIdvoluntario(int idvoluntario) {
        this.idvoluntario = idvoluntario;
    }

    public int getIdHabilidad() {
        return idHabilidad;
    }

    public void setIdHabilidad(int idHabilidad) {
        this.idHabilidad = idHabilidad;
    }
}
