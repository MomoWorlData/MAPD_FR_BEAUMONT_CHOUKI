package io.github.leobeaumont;

import org.junit.jupiter.api.Test;

import io.github.leobeaumont.Edges.WeightedEdgeIn;
import io.github.leobeaumont.Nodes.Place;
import io.github.leobeaumont.Nodes.Transition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for the {@link WeightedEdgeIn} class.
 */
public class WeightedEdgeInTest {

    private static final int PLACE_TOKENS = 3;
    private WeightedEdgeIn edge;

    /**
     * Tests the constructors of {@link WeightedEdgeIn}.
     * <p>
     * Verifies that:
     * <ul>
     *     <li>The constructor with only a weight initializes {@code origin} and {@code arrival} to {@code null}.</li>
     *     <li>The constructor with {@link Place}, {@link Transition}, and weight assigns the given arguments.</li>
     * </ul>
     * </p>
     */
    @Test
    void constructorTest() {
        // Tests uninitialized constructor
        edge = new WeightedEdgeIn(2);
        assertNull(edge.getOrigin());
        assertNull(edge.getArrival());

        // Tests initialized constructor
        Place place = new Place();
        Transition transition = new Transition();
        edge = new WeightedEdgeIn(place, transition, 2);
        assertSame(edge.getOrigin(), place);
        assertSame(edge.getArrival(), transition);
    }

    /**
     * Tests the {@link WeightedEdgeIn#isActivable()} method.
     * <p>
     * Verifies that an edge is activable only when its origin {@link Place}
     * contains at least as many tokens as its weight.
     * </p>
     */
    @Test
    void isActivableTest() {
        Place place = new Place();
        edge = new WeightedEdgeIn(2);
        edge.setOrigin(place);

        assertFalse(edge.isActivable());
        place.setNbTokens(2);
        assertTrue(edge.isActivable());
    }

    /**
     * Tests the {@link WeightedEdgeIn#activate()} method.
     * <p>
     * Verifies that activating a {@code WeightedEdgeIn} removes
     * a number of tokens equal to its weight from its origin {@link Place}.
     * </p>
     */
    @Test
    void activateTest() {
        Place place = new Place(PLACE_TOKENS);
        edge = new WeightedEdgeIn(2);
        edge.setOrigin(place);

        edge.activate();
        assertEquals(place.getNbTokens(), 1);
    }
}
