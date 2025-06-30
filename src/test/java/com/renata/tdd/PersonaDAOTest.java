package com.renata.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonaDAOTest {


    @Test
    void testCrearRegistroExitoso() {
        PersonaDAO dao = new PersonaDAO();
        Persona persona = new Persona(1,"Renata", "r@example.com");
        assertTrue(dao.crear(persona)); //Test pasa si se añade una persona a la lista y retorna TRUE
    }

    @Test

    void  testCrearRegistroPersonaNula(){
        PersonaDAO dao = new PersonaDAO();
        assertThrows(IllegalArgumentException.class, ()-> dao.crear(null));
        //Test pasa si metodo maneja nulos y retorna una excepción.
    }
}
