package io.github.leobeaumont;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlaceTest {
    /*
    Tests for the Place class 
    */

    private Place place;

    @Test
    void RemoveTokensTest() {
        /* 
        This tests the method RemoveToken.
        */
        place = new Place(1);

        // Check for exception cases
        assertThrows(IllegalArgumentException.class, () -> place.removeTokens(-1));
        assertThrows(IllegalArgumentException.class, () -> place.removeTokens(2));

        // Check behavior
        place.removeTokens(1);
        assertEquals(place.getNbTokens(), 0);
    }

    @Test
    void addTokensTest() {
        /* 
        This tests the method RemoveToken.
        */
        place = new Place();

        // Check for exception cases
        assertThrows(IllegalArgumentException.class, () -> place.addTokens(-1));

        // Check behavior
        place.addTokens(1);
        assertEquals(place.getNbTokens(), 1);
    }
}
