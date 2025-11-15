package io.github.leobeaumont;

import org.junit.jupiter.api.Test;

import io.github.leobeaumont.Edges.EdgeEmpty;
import io.github.leobeaumont.Edges.EdgeIn;
import io.github.leobeaumont.Edges.EdgeOut;
import io.github.leobeaumont.Edges.EdgeZero;
import io.github.leobeaumont.Edges.WeightedEdgeIn;
import io.github.leobeaumont.Edges.WeightedEdgeOut;
import io.github.leobeaumont.Nodes.Place;
import io.github.leobeaumont.Nodes.Transition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for the {@link Transition} class.
 */
public class TransitionTest {

    private Transition transition;

    /**
     * Tests the constructor of {@link Transition}.
     * <p>
     * Verifies that the edgesIn and edgesOut lists are initialized and empty.
     * </p>
     */
    @Test
    void constructorTest() {
        transition = new Transition();

        assertNotNull(transition.getEdgesIn());
        assertNotNull(transition.getEdgesOut());

        assertEquals(transition.getEdgesIn().size(), 0);
        assertEquals(transition.getEdgesOut().size(), 0);
    }

    /**
     * Tests the {@link Transition#newEdgeIn(EdgeIn)} and
     * {@link Transition#removeEdgeIn(EdgeIn)} methods.
     * <p>
     * Verifies that edges can be added and removed correctly, and that
     * removing an edge not present does not affect the list.
     * </p>
     */
    @Test
    void edgeInModifiersTest() {
        transition = new Transition();
        EdgeIn edge1 = new WeightedEdgeIn(0);
        EdgeIn edge2 = new WeightedEdgeIn(0);

        // Tests for newEdgeIn
        assertEquals(transition.getEdgesIn().size(), 0);
        transition.newEdgeIn(edge1);
        assertEquals(transition.getEdgesIn().size(), 1);

        // Tests for removeEdgeIn
        transition.removeEdgeIn(edge2);
        assertEquals(transition.getEdgesIn().size(), 1);
        transition.removeEdgeIn(edge1);
        assertEquals(transition.getEdgesIn().size(), 0);
    }

    /**
     * Tests the {@link Transition#newEdgeOut(EdgeOut)} and
     * {@link Transition#removeEdgeOut(EdgeOut)} methods.
     * <p>
     * Verifies that outgoing edges can be added and removed correctly,
     * and that removing an edge not present does not affect the list.
     * </p>
     */
    @Test
    void edgeOutModifiersTest() {
        transition = new Transition();
        EdgeOut edge1 = new WeightedEdgeOut(0);
        EdgeOut edge2 = new WeightedEdgeOut(0);

        // Tests for newEdgeOut
        assertEquals(transition.getEdgesOut().size(), 0);
        transition.newEdgeOut(edge1);
        assertEquals(transition.getEdgesOut().size(), 1);

        // Tests for removeEdgeOut
        transition.removeEdgeOut(edge2);
        assertEquals(transition.getEdgesOut().size(), 1);
        transition.removeEdgeOut(edge1);
        assertEquals(transition.getEdgesOut().size(), 0);
    }

    /**
     * Tests the {@link Transition#isDrawable()} method.
     * <p>
     * Verifies the conditions under which a transition is considered drawable
     * for different types of incoming edges, including multiple edges.
     * </p>
     */
    @Test
    void isDrawableTest() {
        EdgeIn edge1 = new WeightedEdgeIn(1);
        EdgeIn edge2 = new EdgeZero();
        EdgeIn edge3 = new EdgeEmpty();
        Place emptyPlace = new Place(0);
        Place unitPlace = new Place(1);

        // Tests with WeightedEdgeIn
        transition = new Transition();
        edge1.setArrival(transition);
        edge1.setOrigin(emptyPlace);
        assertFalse(transition.isDrawable());
        edge1.setOrigin(unitPlace);
        assertTrue(transition.isDrawable());

        // Tests with EdgeZero
        transition = new Transition();
        edge2.setArrival(transition);
        edge2.setOrigin(unitPlace);
        assertFalse(transition.isDrawable());
        edge2.setOrigin(emptyPlace);
        assertTrue(transition.isDrawable());

        // Tests with EdgeEmpty
        transition = new Transition();
        edge3.setArrival(transition);
        edge3.setOrigin(emptyPlace);
        assertFalse(transition.isDrawable());
        edge3.setOrigin(unitPlace);
        assertTrue(transition.isDrawable());

        // Tests with multiple edges
        transition = new Transition();
        edge1.setArrival(transition);
        edge2.setArrival(transition);
        edge3.setArrival(transition);
        edge1.setOrigin(unitPlace);
        edge2.setOrigin(emptyPlace);
        edge3.setOrigin(unitPlace);
        assertTrue(transition.isDrawable());
        edge2.setOrigin(unitPlace);
        assertFalse(transition.isDrawable());
    }

    /**
     * Tests the {@link Transition#draw()} method.
     * <p>
     * Verifies that all connected incoming and outgoing edges are activated correctly,
     * and that token counts are updated as expected.
     * </p>
     */
    @Test
    void drawTest() {
        // Tests with all edges (except EdgeEmpty because its activation does nothing)
        transition = new Transition();
        EdgeIn edge1 = new WeightedEdgeIn(1);
        EdgeOut edge2 = new WeightedEdgeOut(1);
        EdgeIn edge3 = new EdgeEmpty();
        Place place1 = new Place(1);
        Place place2 = new Place(1);
        Place place3 = new Place(2);

        edge1.setOrigin(place1);
        edge1.setArrival(transition);

        edge2.setOrigin(transition);
        edge2.setArrival(place2);

        edge3.setOrigin(place3);
        edge3.setArrival(transition);

        transition.draw();

        assertEquals(place1.getNbTokens(), 0);
        assertEquals(place2.getNbTokens(), 2);
        assertEquals(place3.getNbTokens(), 0);
    }
}
