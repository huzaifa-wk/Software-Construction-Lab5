/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package SpecsAndContracts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ListFormatterTest {

    @Test
    void testSortInPlaceMutatesOriginalList() {

        List<String> list = new ArrayList<>(
                Arrays.asList("Banana", "Apple", "Cherry")
        );

        ListFormatter.sortInPlace(list);

        assertEquals(
                Arrays.asList("Apple", "Banana", "Cherry"),
                list
        );
    }

    @Test
    void testToLowerCaseDoesNotMutateOriginalList() {

        List<String> original = new ArrayList<>(
                Arrays.asList("Hello", "WORLD", "Java")
        );

        List<String> result = ListFormatter.toLowerCase(original);

        assertEquals(
                Arrays.asList("Hello", "WORLD", "Java"),
                original
        );

        assertEquals(
                Arrays.asList("hello", "world", "java"),
                result
        );

        assertNotSame(original, result);
    }
}
