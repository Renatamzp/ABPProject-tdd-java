package com.renata.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonaDAOTest {


    @Test
    void testCrearRegistro() {
        PersonaDAO dao = new PersonaDAO();
        Persona persona = new Persona(1,"Renata", "r@example.com");

        boolean resultado = dao.crear(persona);
        assertTrue(resultado, "La persona debería crearse correctamente");
    }
}
