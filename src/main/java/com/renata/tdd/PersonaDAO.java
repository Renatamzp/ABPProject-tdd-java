package com.renata.tdd;

import java.util.ArrayList;
import java.util.List;

// Operaciones CRUD

public class PersonaDAO {
    private final List<Persona> personas = new ArrayList<>();

    public boolean crear(Persona persona) {
        if (persona == null) {
            throw new IllegalArgumentException("La persona no puede ser nula");
        }
        return personas.add(persona);
    }
    // Metodos pendientes


    public boolean actualizar(Persona persona) { /* Pendiente */ return false; }
    public boolean eliminar(int id) { /* Pendiente */ return false; }
    public List<Persona> listar() { return new ArrayList<>(personas); }
}