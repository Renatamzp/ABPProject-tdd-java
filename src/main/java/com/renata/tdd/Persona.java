package com.renata.tdd;

import java.util.Objects;

public class Persona {
    private int id;
    private String nombre;
    private String email;

    public Persona(int id, String nombre, String email){
        this.id = id;
        this.nombre = Objects.requireNonNull(nombre, "Nombre no puede ser nulo");
        this.email = Objects.requireNonNull(email, "Email no puede ser nulo");
    }

    public int getId() {return id;}
    public String getNombre() {return nombre;}
    public String getEmail() {return email;}

    @Override

    public String toString() {
        return String.format("Persona{id=%d, nombre='%s', email='%s'}", id, nombre, email);
        }

    }
