package com.sprint_two.ronanclancy.slaughtered;

import com.sprint_two.ronanclancy.slaughtered.models.Sheep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void name_a_sheep() throws Exception{
        Sheep sheep = new Sheep();
        sheep.name = "Dolly";

        assertEquals("Dolly", sheep.getName());
    }
}