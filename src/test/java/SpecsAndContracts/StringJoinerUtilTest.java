/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package SpecsAndContracts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class StringJoinerUtilTest {

    @Test
    void testJoinStrings() {

        List<String> words = Arrays.asList(
                "Java",
                "Python",
                "C++"
        );

        String result
                = StringJoinerUtil.joinStrings(words, ", ");

        assertEquals(
                "Java, Python, C++",
                result
        );
    }

    @Test
    void testSingleElement() {

        List<String> words = Arrays.asList("Java");

        String result
                = StringJoinerUtil.joinStrings(words, ", ");

        assertEquals("Java", result);
    }
}
