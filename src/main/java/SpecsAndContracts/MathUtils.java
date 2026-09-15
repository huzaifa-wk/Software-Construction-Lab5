/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpecsAndContracts;

/**
 *  
 * @author codez
 */
public class MathUtils {

    /**
     * Calculates gravitational potential energy.
     *
     * @param mass mass of the object in kilograms
     * @param altitude altitude in meters relative to sea level. Requires
     * altitude >= 0.
     * @return gravitational potential energy in joules
     */
    public static double calculateGravitationalPotentialEnergy(
            double mass, double altitude) {

        if (altitude < 0) {
            throw new IllegalArgumentException(
                    "Altitude cannot be negative.");
        }

        double g = 9.81;
        return mass * g * altitude;
    }
}
