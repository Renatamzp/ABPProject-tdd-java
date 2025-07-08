package com.renata.tdd;

import java.util.List;
import java.util.Optional;

public interface PersonaRepository {

    boolean crear(Persona persona);

    Optional<Persona> buscarPorId(int id);

    boolean actualizar(Persona persona);

    boolean eliminar(int id);


    List<Persona> listar();

}
