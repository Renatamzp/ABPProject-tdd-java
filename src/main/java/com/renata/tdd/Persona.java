package com.renata.tdd;

public class Persona {
    private int id;
    private String nombre;
    private String email;

    public Persona(int id, String nombre, String email){
        this.id = id;
        this.nombre = nombre ;
        this.email = email;
    }

    public int getId(){
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }
}
