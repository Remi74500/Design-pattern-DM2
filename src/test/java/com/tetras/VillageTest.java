package com.tetras;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class VillageTest {

    @Test
    public void testEntre() {
        Schtroumpf schtroumpfDeGarde = new Schtroumpf();
        Animal pingouin = new Animal("pingouin");
        //
        assertEquals("Bonjour pingouin", schtroumpfDeGarde.saluer(pingouin));
    }
}