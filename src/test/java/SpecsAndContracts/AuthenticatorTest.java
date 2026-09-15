/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package SpecsAndContracts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AuthenticatorTest {

    @Test
    void testMutableReturnCorruptsCachedVersion() {

        Authenticator authenticator = new Authenticator();

        char[] mitId = authenticator.getMitId("huzaifa");

        // Client unintentionally modifies the returned array
        for (int i = 0; i < 5; i++) {
            mitId[i] = '*';
        }

        // The cached version has also been corrupted
        char[] cachedId = authenticator.getMitId("huzaifa");

        assertEquals(
                "*****6789",
                new String(cachedId)
        );
    }

    @Test
    void testSecureMethodProtectsCachedVersion() {

        Authenticator authenticator = new Authenticator();

        String mitId = authenticator.getMitIdSecure("huzaifa");

        // Strings are immutable, so the client cannot modify
        // the returned String itself.
        String modifiedId = "*****6789";

        assertEquals("123456789", mitId);
        assertEquals("*****6789", modifiedId);

        // The cached ID is still correct
        char[] cachedId = authenticator.getMitId("huzaifa");

        assertEquals(
                "123456789",
                new String(cachedId)
        );
    }
}
