package com.renata.tdd;

import java.util.ArrayList;
import java.util.List;

// Operaciones CRUD

public class PersonaDAO {
    private final List<Persona> personas = new ArrayList<>();

    public boolean crear(Persona persona) {
        if (persona == null) {
            throw new IllegalArgumentException("Persona no puede ser nula");
        }
        //Validaciones para datos duplicados

        for (Persona p : personas) {
            if (p.getId() == persona.getId()){
                throw new IllegalArgumentException("ID duplicado: " + persona.getId());
            }
            if (p.getEmail().equals(persona.getEmail())){
                throw new IllegalArgumentException("Email duplicado: " + persona.getEmail());
            }
        }
        return personas.add(persona);
    }

    public boolean actualizar(Persona persona) { return false; } // Placeholder
    public boolean eliminar(int id) { return false; } // Placeholder
    public List<Persona> listar() { return new ArrayList<>(); } // Placeholder

}

