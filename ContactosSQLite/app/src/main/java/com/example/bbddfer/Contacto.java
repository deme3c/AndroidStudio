package com.example.bbddfer;

import java.io.Serializable;

public class Contacto implements Serializable {

    private int id;
    private String nombre;
    private String movil;
    private String email;

    public Contacto(int id, String nombre, String movil, String email) {
        this.id = id;
        this.nombre = nombre;
        this.movil = movil;
        this.email = email;
    }


    //getters

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMovil() {
        return movil;
    }

    public String getEmail() {
        return email;
    }
}
