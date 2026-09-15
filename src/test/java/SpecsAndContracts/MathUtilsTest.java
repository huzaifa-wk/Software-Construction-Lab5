/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package SpecsAndContracts;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MathUtilsTest {

    @Test
    void testNegativeAltitudeThrowsException() {

        assertThrows(
                IllegalArgumentException.class,
                () -> MathUtils.calculateGravitationalPotentialEnergy(10, -5)
        );
    }

    @Test
    void testValidAltitudeCalculatesEnergy() {

        double result
                = MathUtils.calculateGravitationalPotentialEnergy(10, 100);

        assertEquals(9810.0, result, 0.001);
    }
}
