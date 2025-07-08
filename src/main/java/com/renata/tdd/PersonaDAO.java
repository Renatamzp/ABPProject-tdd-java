package com.renata.tdd;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class PersonaDAO {
    private final PersonaRepository repository;

    public PersonaDAO(PersonaRepository repository) {
        this.repository = repository;
    }

    // METODOS CRUD --> Delegar al repository

    public boolean crear(Persona persona) {
        validarPersonaNoNula(persona);
        validarDuplicados(persona);
        return repository.crear(persona);
    }

    public boolean actualizar(Persona persona) {
        validarPersonaNoNula(persona);
        validarDuplicadosActualizacion(persona);
        return repository.actualizar(persona);
    }

    public boolean eliminar(int id) {
        validarIdPositivo(id);
        return repository.eliminar(id);
    }

    public List<Persona> listar() {
        List<Persona> personas = repository.listar();
        return personas.isEmpty()
                ? Collections.emptyList()
                : personas.stream()
                .sorted(Comparator.comparingInt(Persona::getId))
                .collect(Collectors.toUnmodifiableList());
    }

    //METODOS DE VALIDACION

    private void validarPersonaNoNula(Persona persona) {
        if (persona == null) {
            throw new IllegalArgumentException("Persona no puede ser nula");
        }
    }

    private void validarDuplicados(Persona persona) {
        if (repository.buscarPorId(persona.getId()).isPresent()) {
            throw new IllegalArgumentException("ID duplicado");
        }
        if (repository.buscarPorEmail(persona.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email duplicado");
        }
    }

    private void validarDuplicadosActualizacion(Persona persona) {
        repository.listar().stream()
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
