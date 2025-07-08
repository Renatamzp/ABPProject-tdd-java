package com.renata.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonaListRepository implements PersonaRepository {
    private final List<Persona> personas = new ArrayList<>();

    @Override
    public boolean crear(Persona persona) {
        return personas.add(persona);
    }

    @Override
    public Optional<Persona> buscarPorId(int id) {
        return personas.stream().filter(p -> p.getId() == id).findFirst();
    }

    @Override
    public Optional<Persona> buscarPorEmail(String email) {
        return personas.stream().filter(p -> p.getEmail().equals(email)).findFirst();
    }

    @Override
    public boolean actualizar(Persona persona) {
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getId() == persona.getId()) {
                personas.set(i, persona);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        return personas.removeIf(p -> p.getId() == id);
    }

    @Override
    public List<Persona> listar() {
        return new ArrayList<>(personas);
    }
}