package com.renata.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AppTest {

    @Test
    void sumaBasica() {
        int resultado = 2 + 3;
        assertEquals(5, resultado);
    }
}