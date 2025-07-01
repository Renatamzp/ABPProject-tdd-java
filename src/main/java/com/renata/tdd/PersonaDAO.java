package com.renata.tdd;

import java.util.ArrayList;
import java.util.List;

public class PersonaDAO {
    private final List<Persona> personas = new ArrayList<>();

    public boolean crear(Persona persona) {
        if (persona == null) {
            throw new IllegalArgumentException("Persona no puede ser nula");
        }
        //Validaciones para datos duplicados
        for (Persona p : personas) {
            if (p.getId() == persona.getId()) {
                throw new IllegalArgumentException("ID duplicado: " + persona.getId());
            }
            if (p.getEmail().equals(persona.getEmail())) {
                throw new IllegalArgumentException("Email duplicado: " + persona.getEmail());
            }
        }
        return personas.add(persona);
    }

    public boolean actualizar(Persona persona) {
        if (persona == null) {
            throw new IllegalArgumentException("Persona no puede ser nula");
        }
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getId() == persona.getId()) {
                personas.set(i, persona);
                return true;
            }
        }
        return false;
    }

    public boolean eliminar(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID debe ser mayor que 0");
        }
        return personas.removeIf(p -> p.getId() == id);
    }

    public List<Persona> listar() {
        return new ArrayList<>();
    }
}
