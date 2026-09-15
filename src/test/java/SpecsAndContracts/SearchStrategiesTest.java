/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package SpecsAndContracts;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class SearchStrategiesTest {

    @Test
    void testDifferentResultsWithDuplicates() {
        int[] arr = {10, 20, 30, 20, 40};

        int first = SearchStrategies.findFirst(arr, 20);
        int last = SearchStrategies.findLast(arr, 20);

        assertNotEquals(first, last);

        assertEquals(1, first);
        assertEquals(3, last);
    }

    @Test
    void testSameResultWhenElementAppearsOnce() {
        int[] arr = {10, 20, 30, 40, 50};

        int first = SearchStrategies.findFirst(arr, 30);
        int last = SearchStrategies.findLast(arr, 30);

        assertEquals(first, last);
        assertEquals(2, first);
    }
}
