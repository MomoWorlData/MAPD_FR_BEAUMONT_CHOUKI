package io.github.leobeaumont;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for the {@link EdgeZero} class.
 */
public class EdgeZeroTest {

    private EdgeZero edge;

    /**
     * Tests the constructors of {@link EdgeZero}.
     * <p>
     * Verifies that:
     * <ul>
     *     <li>The default constructor initializes {@code origin} and {@code arrival} to {@code null}.</li>
     *     <li>The parameterized constructor correctly assigns the given {@link Place} and {@link Transition}.</li>
     * </ul>
     * </p>
     */
    @Test
    void constructorTest() {
        // Tests uninitialized constructor
        edge = new EdgeZero();
        assertNull(edge.getOrigin());
        assertNull(edge.getArrival());

        // Tests initialized constructor
        Place place = new Place();
        Transition transition = new Transition();
        edge = new EdgeZero(place, transition);
        assertSame(edge.getOrigin(), place);
        assertSame(edge.getArrival(), transition);
    }

    /**
     * Tests the {@link EdgeZero#isActivable()} method.
     * <p>
     * Verifies that an {@code EdgeZero} instance is activable only when its origin {@link Place}
     * contains zero tokens, and becomes non-activable when tokens are added.
     * </p>
     */
    @Test
    void isActivableTest() {
        Place place = new Place();
        edge = new EdgeZero();
        edge.setOrigin(place);

        assertTrue(edge.isActivable());
        place.setNbTokens(1);
        assertFalse(edge.isActivable());
    }
}
