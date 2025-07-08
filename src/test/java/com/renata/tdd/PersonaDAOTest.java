package com.renata.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class PersonaDAOTest {
    private PersonaDAO dao;
    private PersonaListRepository repository;

    @BeforeEach
    void setUp() {
        repository = new PersonaListRepository();
        dao = new PersonaDAO(repository);
    }

    //TEST CON MOCKITO

    @Test
    void crear_conMockito_debeValidarDuplicados() {
        // Configurar mock - no existe id - no existe email.
        PersonaRepository mockRepo = mock(PersonaRepository.class);
        when(mockRepo.buscarPorId(1)).thenReturn(Optional.empty());
        when(mockRepo.buscarPorEmail("a@b.com")).thenReturn(Optional.empty());
        when(mockRepo.crear(any())).thenReturn(true);

        // Ejecutar
        PersonaDAO dao = new PersonaDAO(mockRepo);
        boolean resultado = dao.crear(new Persona(1, "Ana", "a@b.com"));

        // Verificar
        assertTrue(resultado);
        verify(mockRepo).buscarPorId(1);
        verify(mockRepo).buscarPorEmail("a@b.com");
        verify(mockRepo).crear(any());
    }

    // TEST ASOCIADOS A NUEVO REGISTRO

   @Test
    void testCrearRegistroExitoso() {
        Persona persona = new Persona(1,"Renata", "r@example.com");
        assertTrue(dao.crear(persona)); //Test pasa si se añade una persona y retorna TRUE
    }

    @Test

    void  testCrearRegistroPersonaNula(){
        assertThrows(IllegalArgumentException.class, ()-> dao.crear(null));
        //Test pasa si metodo maneja nulos y retorna una excepción
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
    // TEST ASOCIADOS A UNA ACTUALIZACIÓN

    @Test  //Precondición: Persona existe
    void testActualizarRegistroExistente(){
        Persona personaInicial = new Persona(1, "Ana","ana@ejemplo.com");
        dao.crear(personaInicial);

        Persona personaActualizada = new Persona(1, "Ana Perez","ana.perez@ejemplo.com");
        assertTrue(dao.actualizar(personaActualizada), "Se actualizo el registro existente");
    }

    @Test
    void testActualizarRegistroInexistente() {
        Persona personaInexistente = new Persona(200,"No existe","no@existe");
        assertFalse(dao.actualizar(personaInexistente), "La persona no existe");
    }

    @Test
    void testActualizarRegistroPersonaNula() {
        assertThrows(IllegalArgumentException.class, ()-> dao.actualizar(null));
    }


    // TEST ASOCIADOS A ELIMINACIÓN

    @Test   //Precondición: persona existe
    void testEliminarRegistroExistente() {
        Persona persona = new Persona(1,"Luis","luis@ejemplo.com");
        dao.crear(persona);

        assertTrue(dao.eliminar(1), "Se ha eliminado el registro existente");
    }

    @Test
    void testEliminarRegistroInexistente(){
        assertFalse(dao.eliminar(999),"El ID no existe en el registro");
    }

    @Test
    void testEliminarConIdInvalido() {
        assertThrows(IllegalArgumentException.class, () -> dao.eliminar(0));
    }

    // TEST ASOCIADOS A LISTAR

    @Test
    void testListarRegistrosVacios() {
        assertTrue(dao.listar().isEmpty(), "No existen registros");
    }

    @Test
    void testListarRegistroExitoso() {
        Persona persona = new Persona(1, "Ana", "ana@ejemplo.com");
        dao.crear(persona);

        List<Persona> personas = dao.listar();
        assertEquals(1, personas.size());
        assertEquals(persona, personas.get(0));
    }

    @Test
    void testListarRegistrosOrdenadosPorId() {
        dao.crear(new Persona(2, "Ana", "Ana@ejemplo.com"));
        dao.crear(new Persona(1, "Emilia", "Emilia@ejemplo.com"));
        assertEquals(1, dao.listar().get(0).getId()); //El primero en la lista debe tener ID 1
    }

}
