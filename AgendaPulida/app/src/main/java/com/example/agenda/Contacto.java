package com.example.agenda;

import java.io.Serializable;

public class Contacto implements Serializable{

    String nombre;
    String telefono;
    String email;


    public Contacto(String nombre, String telefono, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;

    }
}
