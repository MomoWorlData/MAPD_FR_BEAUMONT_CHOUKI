package io.github.leobeaumont;

public abstract class EdgeIn extends Edge {
    /*
    This implement the abstract class EdgeIn, that are special Edge that goes from a Place to a Transition.
    This class is abstract because the EdgeIn don't tell the simulation how it interacts with tokens. 
    */

    // This method has to be implemented in the classes that inherits from Edge
    public abstract boolean isActivable();
    
    private Place origin;
    private Transition arrival;

        public EdgeIn(Place origin, Transition arrival) {
        /*
        Constructor for the EdgeIn class.

        Args:
            origin (Place): Origin of the edge.
            arrival (Transition): Arrival of the edge.
        */
        this.setOrigin(origin);
        this.setArrival(arrival);

        // Inform the arrival transition it has a new EgdeIn
        arrival.newEdgeIn(this);
    }

    public EdgeIn() {
        /*
        Constructor for the EdgeIn class.
        */
    }

    public Place getOrigin() {
        return this.origin;
    }

    public void setOrigin(Place origin) {
        this.origin = origin;
    }

    public Transition getArrival() {
        return this.arrival;
    }

    public void setArrival(Transition arrival) {
        // Inform previous arrival it lost an EdgeIn
        if (this.arrival != null) {
            this.arrival.removeEdgeIn(this);
        }

        this.arrival = arrival;

        // Inform new arrival it has a new EdgeIn
        arrival.newEdgeIn(this);
    }
}
