package io.github.leobeaumont;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

/**
 * Unit tests for the {@link PetriNet} class.
 * <p>
 * These tests verify the basic behavior of the PetriNet implementation,
 * including the addition and removal of places, transitions, and edges,
 * as well as correct handling of weights, tokens, and simulation execution.
 * </p>
 *
 * <p>Each test creates a new {@link PetriNet} instance to ensure independence.</p>
 */
public class PetriNetTest {

    private PetriNet petriNet;

    /**
     * Tests that places can be added and retrieved correctly.
     * Verifies that the place count and token values are as expected.
     */
    @Test
    void testAddAndGetPlaces() {
        petriNet = new PetriNet();
        petriNet.addPlace(3);
        List<Place> places = petriNet.getPlaces();

        assertEquals(1, places.size());
        assertEquals(3, places.get(0).getNbTokens());
    }

    /**
     * Tests that transitions can be added and retrieved correctly.
     * Ensures that the created transition is not null and correctly stored.
     */
    @Test
    void testAddAndGetTransitions() {
        petriNet = new PetriNet();
        petriNet.addTransition();
        List<Transition> transitions = petriNet.getTransitions();

        assertEquals(1, transitions.size());
        assertNotNull(transitions.get(0));
    }

    /**
     * Tests adding weighted input and output edges between places and transitions.
     * Verifies that edges are correctly created and typed.
     */
    @Test
    void testAddWeightedEdges() {
        petriNet = new PetriNet();
        Place place = new Place(2);
        Transition transition = new Transition();

        petriNet.addEdge(3, place, transition); // WeightedEdgeIn
        petriNet.addEdge(2, transition, place); // WeightedEdgeOut

        List<Edge> edges = petriNet.getEdges();
        assertEquals(2, edges.size());
        assertTrue(edges.get(0) instanceof WeightedEdgeIn);
        assertTrue(edges.get(1) instanceof WeightedEdgeOut);
    }

    /**
     * Tests that places, transitions, and edges can be removed from the Petri net.
     * Ensures that lists are empty after removals.
     */
    @Test
    void testRemoveElements() {
        petriNet = new PetriNet();
        Place place = new Place(1);
        Transition transition = new Transition();
        WeightedEdgeIn edge = new WeightedEdgeIn(place, transition, 2);

        petriNet.getPlaces().add(place);
        petriNet.getTransitions().add(transition);
        petriNet.getEdges().add(edge);

        petriNet.removePlace(place);
        petriNet.removeTransition(transition);
        petriNet.removeEdge(edge);

        assertTrue(petriNet.getPlaces().isEmpty());
        assertTrue(petriNet.getTransitions().isEmpty());
        assertTrue(petriNet.getEdges().isEmpty());
    }

    /**
     * Tests the {@link PetriNet#setTokens(Place, int)} method.
     * Verifies that the token count of a place is updated correctly.
     */
    @Test
    void testSetTokens() {
        petriNet = new PetriNet();
        Place place = new Place(5);
        petriNet.setTokens(place, 10);

        assertEquals(10, place.getNbTokens());
    }

    /**
     * Tests that the {@link PetriNet#setWeight(WeightedEdgeIn, int)} and
     * {@link PetriNet#setWeight(WeightedEdgeOut, int)} methods correctly update edge weights.
     */
    @Test
    void testSetWeightOnWeightedEdges() {
        petriNet = new PetriNet();
        WeightedEdgeIn edgeIn = new WeightedEdgeIn(2);
        WeightedEdgeOut edgeOut = new WeightedEdgeOut(3);

        petriNet.setWeight(edgeIn, 5);
        petriNet.setWeight(edgeOut, 7);

        assertEquals(5, edgeIn.getWeight());
        assertEquals(7, edgeOut.getWeight());
    }

    /**
     * Tests that setting a weight on a non-weighted edge throws an {@link IllegalArgumentException}.
     */
    @Test
    void testSetWeightThrowsOnInvalidEdge() {
        petriNet = new PetriNet();
        EdgeEmpty invalidEdge = new EdgeEmpty();

        Exception ex = assertThrows(IllegalArgumentException.class, () ->
            petriNet.setWeight(invalidEdge, 4)
        );
        assertTrue(ex.getMessage().contains("not a weighted edge"));
    }

    /**
     * Tests that the {@link PetriNet#drawable()} method returns a non-null list.
     * Ensures transitions can be retrieved even when none are drawable.
     */
    @Test
    void testDrawableTransitions() {
        petriNet = new PetriNet();
        Transition transition = new Transition();
        petriNet.getTransitions().add(transition);

        List<Transition> drawable = petriNet.drawable();
        assertNotNull(drawable);
    }

    /**
     * Tests getters and setters for edges, places, and transitions.
     * Ensures assigned lists are properly retrieved.
     */
    @Test
    void testGettersAndSetters() {
        petriNet = new PetriNet();
        List<Edge> edges = List.of(new WeightedEdgeIn(2));
        List<Place> places = List.of(new Place(3));
        List<Transition> transitions = List.of(new Transition());

        petriNet.setEdges(edges);
        petriNet.setPlaces(places);
        petriNet.setTransitions(transitions);

        assertEquals(edges, petriNet.getEdges());
        assertEquals(places, petriNet.getPlaces());
        assertEquals(transitions, petriNet.getTransitions());
    }

    /**
     * Tests that the {@link PetriNet#launchSimulation(int)} method
     * can run without throwing exceptions when valid transitions exist.
     */
    @Test
    void testLaunchSimulationDoesNotCrash() {
        petriNet = new PetriNet();
        Place place = new Place(3);
        Transition transition = new Transition();
        WeightedEdgeIn edgeIn = new WeightedEdgeIn(place, transition, 1);
        WeightedEdgeOut edgeOut = new WeightedEdgeOut(transition, place, 1);

        petriNet.getPlaces().add(place);
        petriNet.getTransitions().add(transition);
        petriNet.getEdges().add(edgeIn);
        petriNet.getEdges().add(edgeOut);

        // Should not throw even if random selection occurs
        assertDoesNotThrow(() -> petriNet.launchSimulation(1));
    }
}
