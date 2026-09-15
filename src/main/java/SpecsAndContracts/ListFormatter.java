/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpecsAndContracts;

/**
 *
 * @author codez
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListFormatter {

    /**
     * Sorts the given list in place.
     *
     * @param lst the list to be sorted
     * @requires lst != null
     * @modifies lst
     */
    public static void sortInPlace(List<String> lst) {
        Collections.sort(lst);
    }

    /**
     * Returns a new list containing the lowercase versions of all strings in
     * the given list.
     *
     * @param lst the original list
     * @requires lst != null
     * @ensures the original list remains unchanged
     * @return a new list containing lowercase strings
     */
    public static List<String> toLowerCase(List<String> lst) {
        List<String> result = new ArrayList<>();

        for (String str : lst) {
            result.add(str.toLowerCase());
        }

        return result;
    }
}
