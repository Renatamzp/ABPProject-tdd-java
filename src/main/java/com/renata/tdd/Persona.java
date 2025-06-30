package com.renata.tdd;

public class Persona {
    private int id;
    private String nombre;
    private String email;

    public Persona(int id, String nombre, String email){
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor que 0");
        }
        if (nombre == null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (email == null || !email.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) {
            throw new IllegalArgumentException("El email debe ser válido");
        }

        this.id = id;
        this.nombre = nombre ;
        this.email = email;
    }

    public int getId() {return id;}
    public String getNombre() {return nombre;}
    public String getEmail() {return email;}

    @Override

    public String toString() {
        return String.format("Persona{id=%d, nombre='%s', email='%s'}", id, nombre, email);
        }

    }
