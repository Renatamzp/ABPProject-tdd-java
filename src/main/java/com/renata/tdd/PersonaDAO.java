package com.renata.tdd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class PersonaDAO {
    private final List<Persona> personas = new ArrayList<>();

    // METODOS CRUD

    public boolean crear(Persona persona) {
        validarPersonaNoNula(persona);
        validarDuplicados(persona);
        return personas.add(persona);
    }

    public boolean actualizar(Persona persona) {
        validarPersonaNoNula(persona);
        validarDuplicadosActualizacion(persona);

        OptionalInt index = IntStream.range(0, personas.size())
                .filter(i -> personas.get(i).getId() == persona.getId())
                .findFirst();

        if (index.isPresent()) {
            personas.set(index.getAsInt(), persona);
            return true;
        }
        return false;
    }

    public boolean eliminar(int id) {
        validarIdPositivo(id);
        return personas.removeIf(p -> p.getId() == id);
    }

    public List<Persona> listar() {
        return personas.isEmpty()
                ? Collections.emptyList()
                : personas.stream()
                .sorted(Comparator.comparingInt(Persona::getId))
                .collect(Collectors.toUnmodifiableList());
    }

    //METODOS DE APOYO

    private void validarPersonaNoNula(Persona persona) {
        if (persona == null) {
            throw new IllegalArgumentException("Persona no puede ser nula");
        }
    }

    private void validarDuplicados(Persona persona) {
        personas.stream()
                .filter(p -> p.getId() == persona.getId() || p.getEmail().equals(persona.getEmail()))
                .findFirst()
                .ifPresent(p -> {
                    throw new IllegalArgumentException(
                            p.getId() == persona.getId()
                                    ? "ID duplicado: " + persona.getId()
                                    : "Email duplicado: " + persona.getEmail());
                });
    }

    private void validarDuplicadosActualizacion(Persona persona) {
        personas.stream()
                .filter(p -> p.getId() != persona.getId() && p.getEmail().equals(persona.getEmail()))
                .findFirst()
                .ifPresent(p -> {
                    throw new IllegalArgumentException("Email duplicado: " + persona.getEmail());
                });
    }

    private void validarIdPositivo(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID debe ser mayor que 0");
        }
    }
}
