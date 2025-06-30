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
        return personas.add(persona);
    }

}

