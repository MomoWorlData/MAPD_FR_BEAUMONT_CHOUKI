package io.github.leobeaumont;

public class WeightedEdgeOut extends EdgeOut {
    /*
    This implement the class EdgeEmpty, which is an EdgeIn that empty it's origin on activation.
    EdgeEmpty can activate if there is at leist one token in its Place of origin.
    */

    private int weight;

    public WeightedEdgeOut(Transition origin, Place arrival, int weight) throws IllegalArgumentException {
        /*
        Constructor for the WeightedEdgeOut class.

        Args:
            origin (Transition): Origin of the edge.
            arrival (Place): Arrival of the edge.
            weight (int): Weight of the edge.
        
        Throws:
            IllegalArgumentException: If weight is negative.
        */
        super(origin, arrival);
        if (weight < 0) {
            throw new IllegalArgumentException(String.format("WeightedEdgeOut(%d) -- The argument weight (%d) can't be negative", weight, weight));
        }
        this.setWeight(weight);
    }

    public WeightedEdgeOut(int weight) {
        /*
        Constructor for the WeightedEdgeOut class.

        Args:
            weight (int): Weight of the edge.

        Throws:
            IllegalArgumentException: If weight is negative.
        */
        super();
        if (weight < 0) {
            throw new IllegalArgumentException(String.format("WeightedEdgeOut(%d) -- The argument weight (%d) can't be negative", weight, weight));
        }
        this.setWeight(weight);
    }

    public void activate() {
        /*
        Activate the Edge.
        For WeightedEdgeOut, this adds N tokens on the Place of arrival where N is the weight of the edge.
        */
        Place arrivalPlace = this.getArrival();
        arrivalPlace.addTokens(this.getWeight());
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
