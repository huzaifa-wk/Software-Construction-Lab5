/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpecsAndContracts;

/**
 *
 * @author codez
 */
import java.util.HashMap;
import java.util.Map;

public class Authenticator {

    private final Map<String, char[]> mitIdCache = new HashMap<>();

    /**
     * Returns a 9-digit MIT ID as a mutable character array.
     *
     * @param username the username of the client
     * @return the cached MIT ID as a character array
     */
    public char[] getMitId(String username) {

        if (!mitIdCache.containsKey(username)) {
            mitIdCache.put(username, "123456789".toCharArray());
        }

        return mitIdCache.get(username);
    }

    /**
     * Returns a 9-digit MIT ID as an immutable String.
     *
     * @param username the username of the client
     * @return the MIT ID as a String
     */
    public String getMitIdSecure(String username) {

        if (!mitIdCache.containsKey(username)) {
            mitIdCache.put(username, "123456789".toCharArray());
        }

        return new String(mitIdCache.get(username));
    }
}
