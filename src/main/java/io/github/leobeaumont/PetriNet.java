package io.github.leobeaumont;

import java.util.ArrayList;
import java.util.List;

public class PetriNet implements IPretriNet {

    private List<Edge> edges;
    private List<Place> places;
    private List<Transition> transitions;

    public PetriNet() {
        /* ArrayList is faster/memory effficient in this case because:
        - We won't remove elements often from the middle of the list.
        - Most of the time we iterate through the list.
        - When we add an element we can put it at the end of the list. */
        this.edges = new ArrayList<Edge>();
        this.places = new ArrayList<Place>();
        this.transitions = new ArrayList<Transition>();
    }

    public void stepSimulation(Transition transition) throws IllegalArgumentException {
        if (transition.isDrawable()) {
            transition.draw();
        } else {
            throw new IllegalArgumentException(
                "PetriNet.stepSimulation(transition) -- The argument transition can't be drawn.");
        }
    }

    public void addPlace(int nbTokens) {
        Place place = new Place(nbTokens);
        this.places.add(place);
    }

    public void addEdge(int weight, Place origin, Transition arrival) {
        WeightedEdgeIn edge = new WeightedEdgeIn(origin, arrival, weight);
        this.edges.add(edge);
    }

    public void addEdge(int weight, Transition origin, Place arrival) {
        WeightedEdgeOut edge = new WeightedEdgeOut(origin, arrival, weight);
        this.edges.add(edge);
    }

    public void addWeightedEdgeIn(int weight) {
        WeightedEdgeIn edge = new WeightedEdgeIn(weight);
        this.edges.add(edge);
    }

    public void addWeightedEdgeOut(int weight) {
        WeightedEdgeOut edge = new WeightedEdgeOut(weight);
        this.edges.add(edge);
    }

    public void addEdgeEmpty(Place origin, Transition  arrival) {
        EdgeEmpty edge = new EdgeEmpty(origin, arrival);
        this.edges.add(edge);
    }

    public void addEdgeEmpty() {
        EdgeEmpty edge = new EdgeEmpty();
        this.edges.add(edge);
    }

    public void addEdgeZero(Place origin, Transition arrival) {
        EdgeZero edge = new EdgeZero(origin, arrival);
        this.edges.add(edge);
    }

    public void addEdgeZero() {
        EdgeZero edge = new EdgeZero();
        this.edges.add(edge);
    }

}
