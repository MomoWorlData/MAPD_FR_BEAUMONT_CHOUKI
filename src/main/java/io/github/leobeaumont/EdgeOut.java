package io.github.leobeaumont;

public abstract class EdgeOut extends Edge {
    /*
    This implement the abstract class EdgeOut, that is a special Edge that goes from a Transition to a Place.
    This class is abstract because the EdgeOut don't tell the simulation how it interacts with tokens. 
    */

    private Transition origin;
    private Place arrival;

    public EdgeOut(Transition origin, Place arrival) {
        /*
        Constructor for the EdgeOut class.

        Args:
            origin (Transition): Origin of the edge.
            arrival (Place): Arrival of the edge.
        */
        this.setOrigin(origin);
        this.setArrival(arrival);

        // Inform the origin transition it has a new EgdeOut
        origin.newEdgeOut(this);
    }

    public EdgeOut() {
        /*
        Constructor for the EdgeOut class.
        */
    }

    public Transition getOrigin() {
        return this.origin;
    }

    public void setOrigin(Transition origin) {
        // Inform previous origin it lost an EdgeOut
        if (this.origin != null) {
            this.origin.removeEdgeOut(this);
        }

        this.origin = origin;

        // Inform new origin it has a new EdgeOut
        origin.newEdgeOut(this);
    }

    public Place getArrival() {
        return this.arrival;
    }

    public void setArrival(Place arrival) {
        this.arrival = arrival;
    }
}
