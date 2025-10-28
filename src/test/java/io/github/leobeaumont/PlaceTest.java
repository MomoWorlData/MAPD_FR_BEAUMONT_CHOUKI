package io.github.leobeaumont;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Unit tests for the {@link Place} class.
 */
public class PlaceTest {

    private Place place;

    /**
     * Tests the constructors of the {@link Place} class.
     * <p>
     * Verifies that:
     * <ul>
     *     <li>The default constructor initializes the token count to 0.</li>
     *     <li>Negative initial token counts default to 0.</li>
     *     <li>Positive initial token counts are set correctly.</li>
     * </ul>
     * </p>
     */
    @Test
    void constructorTest() {
        place = new Place();
        assertEquals(place.getNbTokens(), 0);

        place = new Place(-1);
        assertEquals(place.getNbTokens(), 0);

        place = new Place(1);
        assertEquals(place.getNbTokens(), 1);
    }

    /**
     * Tests the {@link Place#removeTokens(int)} method.
     * <p>
     * Verifies that:
     * <ul>
     *     <li>Removing a negative number of tokens throws {@link IllegalArgumentException}.</li>
     *     <li>Removing more tokens than available throws {@link IllegalArgumentException}.</li>
     *     <li>Removing a valid number of tokens updates the token count correctly.</li>
     * </ul>
     * </p>
     */
    @Test
    void removeTokensTest() {
        place = new Place(1);

        // Check for exception cases
        assertThrows(IllegalArgumentException.class, () -> place.removeTokens(-1));
        assertThrows(IllegalArgumentException.class, () -> place.removeTokens(2));

        // Check behavior
        place.removeTokens(1);
        assertEquals(place.getNbTokens(), 0);
    }

    /**
     * Tests the {@link Place#addTokens(int)} method.
     * <p>
     * Verifies that:
     * <ul>
     *     <li>Adding a negative number of tokens throws {@link IllegalArgumentException}.</li>
     *     <li>Adding a valid number of tokens updates the token count correctly.</li>
     * </ul>
     * </p>
     */
    @Test
    void addTokensTest() {
        place = new Place();

        // Check for exception cases
        assertThrows(IllegalArgumentException.class, () -> place.addTokens(-1));

        // Check behavior
        place.addTokens(1);
        assertEquals(place.getNbTokens(), 1);
    }
}
