package com.renata.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonaDAOTest {


    @Test
    void testCrearRegistro() {
        PersonaDAO dao = new PersonaDAO();
        Persona persona = new Persona(1,"Renata", "r@example.com");

        boolean resultado = dao.crear(persona);
        assertTrue(resultado, "El registro debería crearse correctamente");
    }
}
