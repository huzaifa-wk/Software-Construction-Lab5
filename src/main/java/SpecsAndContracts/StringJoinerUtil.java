/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpecsAndContracts;

import java.util.List;
/**
 *
 * @author codez
 */
public class StringJoinerUtil {

    /*
     * BAD / OPERATIONAL JAVADOC
     *
     * This describes HOW the method works internally rather than
     * describing the behavior expected by the client.
     *
     * /**
     * Joins the strings by using a for loop to go through each
     * element of the list. For every iteration, the current string
     * is added to a result string. An if-statement checks whether
     * the current element is the last element in the list. If it
     * is not the last element, the delimiter is concatenated to
     * the result string. This prevents a trailing delimiter from
     * being added after the final element. The strings and
     * delimiters are concatenated step by step until all elements
     * have been processed.
     *
     * @param words the list of strings
     * @param delimiter the delimiter used between strings
     * @return the resulting joined string
     */
    /**
     * GOOD / DECLARATIVE JAVADOC
     *
     * Returns the concatenation of the elements in order, with the delimiter
     * inserted between each adjacent pair.
     *
     * @param words the list of strings to concatenate
     * @param delimiter the delimiter inserted between adjacent elements
     * @return a string containing all elements in order with the delimiter
     * between adjacent elements
     */
    public static String joinStrings(List<String> words, String delimiter) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.size(); i++) {
            result.append(words.get(i));

            if (i < words.size() - 1) {
                result.append(delimiter);
            }
        }

        return result.toString();
    }
}

