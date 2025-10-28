package io.github.leobeaumont;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for the {@link EdgeEmpty} class.
 */
public class EdgeEmptyTest {

    private static final int PLACE_TOKENS = 666;
    private EdgeEmpty edge;

    /**
     * Tests the constructors of {@link EdgeEmpty}.
     * <p>
     * Verifies that:
     * <ul>
     *     <li>The default constructor initializes {@code origin} and {@code arrival} to {@code null}.</li>
     *     <li>The parameterized constructor correctly assigns the provided {@link Place} and {@link Transition}.</li>
     * </ul>
     * </p>
     */
    @Test
    void constructorTest() {
        // Tests uninitialized constructor
        edge = new EdgeEmpty();
        assertNull(edge.getOrigin());
        assertNull(edge.getArrival());

        // Tests initialized constructor
        Place place = new Place();
        Transition transition = new Transition();
        edge = new EdgeEmpty(place, transition);
        assertSame(edge.getOrigin(), place);
        assertSame(edge.getArrival(), transition);
    }

    /**
     * Tests the {@link EdgeEmpty#isActivable()} method.
     * <p>
     * Verifies that an {@code EdgeEmpty} instance is activable only when its origin {@link Place}
     * contains at least one token.
     * </p>
     */
    @Test
    void isActivableTest() {
        Place place = new Place();
        edge = new EdgeEmpty();
        edge.setOrigin(place);

        assertFalse(edge.isActivable());
        place.setNbTokens(1);
        assertTrue(edge.isActivable());
    }

    /**
     * Tests the {@link EdgeEmpty#activate()} method.
     * <p>
     * Verifies that activating an {@code EdgeEmpty} instance empties its origin {@link Place}.
     * </p>
     */
    @Test
    void activateTest() {
        Place place = new Place(PLACE_TOKENS);
        edge = new EdgeEmpty();
        edge.setOrigin(place);

        edge.activate();
        assertEquals(place.getNbTokens(), 0);
    }
}
