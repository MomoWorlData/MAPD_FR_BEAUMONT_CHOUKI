package io.github.leobeaumont;

import org.junit.jupiter.api.Test;

import io.github.leobeaumont.Edges.WeightedEdgeOut;
import io.github.leobeaumont.Nodes.Place;
import io.github.leobeaumont.Nodes.Transition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * Unit tests for the {@link WeightedEdgeOut} class.
 */
public class WeightedEdgeOutTest {

    private WeightedEdgeOut edge;

    /**
     * Tests the constructors of {@link WeightedEdgeOut}.
     * <p>
     * Verifies that:
     * <ul>
     *     <li>The constructor with only a weight initializes {@code origin} and {@code arrival} to {@code null}.</li>
     *     <li>The constructor with {@link Transition}, {@link Place}, and weight assigns the given arguments.</li>
     * </ul>
     * </p>
     */
    @Test
    void constructorTest() {
        // Tests uninitialized constructor
        edge = new WeightedEdgeOut(2);
        assertNull(edge.getOrigin());
        assertNull(edge.getArrival());

        // Tests initialized constructor
        Place place = new Place();
        Transition transition = new Transition();
        edge = new WeightedEdgeOut(transition, place, 2);
        assertSame(edge.getOrigin(), transition);
        assertSame(edge.getArrival(), place);
    }

    /**
     * Tests the {@link WeightedEdgeOut#activate()} method.
     * <p>
     * Verifies that activating a {@code WeightedEdgeOut} adds
     * a number of tokens equal to its weight to its arrival {@link Place}.
     * </p>
     */
    @Test
    void activateTest() {
        Place place = new Place();
        edge = new WeightedEdgeOut(2);
        edge.setArrival(place);

        edge.activate();
        assertEquals(place.getNbTokens(), 2);
    }
}
