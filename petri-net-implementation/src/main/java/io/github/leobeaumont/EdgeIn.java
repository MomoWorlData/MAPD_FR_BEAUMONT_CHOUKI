package io.github.leobeaumont;

public abstract class EdgeIn extends Edge {

    private Place origin;
    private Transition arrival;

    public Place getOrigin() {
        return this.origin;
    }

    public Transition getArrival() {
        return this.arrival;
    }
}
