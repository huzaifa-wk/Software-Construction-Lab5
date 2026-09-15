/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpecsAndContracts;

/**
 *
 * @author codez
 */
public class ArraySearcher {

    /**
     * Finds a value in an array.
     * @param arr array to search, requires that val occurs exactly once in arr
     * @param val value to search for
     * @return index i such that arr[i] = val
     * @throws IllegalArgumentException if the precondition is violated 
     * (val does not occur exactly once)
     */
   
     public static int findExactlyOne(int[] arr, int val)
     {
         int count = 0;
         int foundIndex = -1;
         
        // Checking teh precondition to "fail fast"
        
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i] == val)
            {
                count++;
                foundIndex = i;
            }
        }
        
        if (count != 1)
        {
            // The client violated the precondition.We choose to fail fast.
            
            throw new IllegalArgumentException(
            "Precondition violated: val must occur exactly once.");
        }
        
        return foundIndex;
     }
     
}
