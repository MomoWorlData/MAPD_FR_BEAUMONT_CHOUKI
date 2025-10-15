package io.github.leobeaumont;

public class WeightedEdgeIn extends EdgeIn {
    /*
    This implement the class EdgeEmpty, which is an EdgeIn that empty it's origin on activation.
    EdgeEmpty can activate if there is at leist one token in its Place of origin.
    */

    private int weight;

    public WeightedEdgeIn(Place origin, Transition arrival, int weight) throws IllegalArgumentException {
        /*
        Constructor for the WeightedEdgeIn class.

        Args:
            origin (Place): Origin of the edge.
            arrival (Transition): Arrival of the edge.
            weight (int): Weight of the edge.
        
        Throws:
            IllegalArgumentException: If weight is negative.
        */
        super(origin, arrival);
        if (weight < 0) {
            throw new IllegalArgumentException(String.format("WeightedEdgeIn(%d) -- The argument weight (%d) can't be negative", weight, weight));
        }
        this.setWeight(weight);
    }

    public WeightedEdgeIn(int weight) {
        /*
        Constructor for the WeightedEdgeIn class.

        Args:
            weight (int): Weight of the edge.

        Throws:
            IllegalArgumentException: If weight is negative.
        */
        super();
        if (weight < 0) {
            throw new IllegalArgumentException(String.format("WeightedEdgeIn(%d) -- The argument weight (%d) can't be negative", weight, weight));
        }
        this.setWeight(weight);
    }

    public boolean isActivable() {
        /*
        Tells if the Edge can be activated.
        WeightedEdgeIn can be activated if its place of origin has at leist N tokens, where N is the weight of the edge.

        Returns:
            (boolean): If the Edge can be activated.
        */
        Place originPlace = this.getOrigin();
        int tokenInPlace = originPlace.getNbTokens();
        return (tokenInPlace >= this.getWeight());
    }

    public void activate() {
        /*
        Activate the Edge.
        For WeightedEdgeIn, this removes N tokens on the Place of origin where N is the weight of the edge.
        */
        Place originPlace = this.getOrigin();
        originPlace.removeTokens(this.getWeight());
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
