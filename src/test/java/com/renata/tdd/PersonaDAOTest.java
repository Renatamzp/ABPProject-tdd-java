package com.renata.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonaDAOTest {
    private PersonaDAO dao;

    @BeforeEach
    void setUp() {
        dao = new PersonaDAO();

    }

    // TEST ASOCIADOS A NUEVO REGISTRO

   @Test
    void testCrearRegistroExitoso() {
        Persona persona = new Persona(1,"Renata", "r@example.com");
        assertTrue(dao.crear(persona)); //Test pasa si se añade una persona y retorna TRUE ✅
    }

    @Test

    void  testCrearRegistroPersonaNula(){
        assertThrows(IllegalArgumentException.class, ()-> dao.crear(null));
        //Test pasa si metodo maneja nulos y retorna una excepción ✅
    }

    @Test
    void testCrearRegistroIdDuplicado(){    //Primer registro ya existente
        Persona persona1 = new Persona (1,"Ana", "ana@ejemplo.com");
        dao.crear(persona1);

        //Segundo registro con mismo ID
        Persona persona2 = new Persona(1, "Ana Duplicada", "ana2@ejemplo.com");
        assertThrows(IllegalArgumentException.class, () -> dao.crear(persona2));
    }

    @Test
    void testCrearRegistroEmailDuplicado() {   // Primer registro ya existente
        Persona persona1 = new Persona(1, "Ana", "ana@ejemplo.com");
        dao.crear(persona1);

        //Segundo registro con mismo email
        Persona persona2 = new Persona(2, "Ana Duplicada", "ana@ejemplo.com");
        assertThrows(IllegalArgumentException.class, () -> dao.crear(persona2));
    }
/*    // TEST ASOCIADOS A UNA ACTUALIZACIÓN

    @Test  //Precondición: Persona existe
    void testActualizarRegistroExistente(){
        PersonaDAO dao = new PersonaDAO();
        Persona personaInicial = new Persona(1, "Ana","ana@ejemplo.com");
        dao.crear(personaInicial);

        Persona personaActualizada = new Persona(1, "Ana Perez","ana.perez@ejemplo.com");
        assertTrue(dao.actualizar(personaActualizada), "Se actualizo el registro existente");
    }

    @Test
    void testActualizarRegistroInexistente() {
        PersonaDAO dao = new PersonaDAO();
        Persona personaInexistente = new Persona(200,"No existe","no@existe");
        assertFalse(dao.actualizar(personaInexistente), "La persona no existe");
    }

    @Test
    void testActualizarRegistroPersonaNula() {
        PersonaDAO dao = new PersonaDAO();
        assertThrows(IllegalArgumentException.class, ()-> dao.actualizar(null));
    }


    // TEST ASOCIADOS A ELIMINACIÓN

    @Test   //Precondición: persona existe
    void testEliminarRegistroExistente() {
        PersonaDAO dao = new PersonaDAO();
        Persona persona = new Persona(1,"Luis","luis@ejemplo.com");
        dao.crear(persona);

        assertTrue(dao.eliminar(1), "Se ha eliminado el registro existente");
    }

    @Test
    void testEliminarRegistroInexistente(){
        PersonaDAO dao = new PersonaDAO();
        assertFalse(dao.eliminar(999),"El ID no existe en el registro");
    }

    @Test
    void testEliminarConIdInvalido() {
        PersonaDAO dao = new PersonaDAO();
        assertThrows(IllegalArgumentException.class, () -> dao.eliminar(0));
    }

    // TEST ASOCIADOS A LISTAR

    @Test
    void testListarRegistrosVacios() {
        PersonaDAO dao = new PersonaDAO();
        assertTrue(dao.listar().isEmpty(), "No existen registros");
    }

    @Test
    void testListarRegistroExitoso() {
        PersonaDAO dao = new PersonaDAO();
        dao.crear(new Persona(1, "Ana", "ana@ejemplo.com"));
        dao.crear(persona);

        List<Persona> personas = dao.listar();
        assertEquals(1, personas.size());
        assertEquals(persona, personas.get(0));
    }

    @Test
    void testListarRegistrosOrdenadosPorId() {
        PersonaDAO dao = new PersonaDAO();
        dao.crear(new Persona(2, "B", "b@ejemplo.com"));
        dao.crear(new Persona(1, "A", "a@ejemplo.com"));
        assertEquals(1, dao.listar().get(0).getId());
    }*/



}
