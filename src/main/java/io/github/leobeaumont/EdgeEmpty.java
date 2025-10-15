package io.github.leobeaumont;

public class EdgeEmpty extends EdgeIn {
    /*
    This implement the class EdgeEmpty, which is an EdgeIn that empty it's origin on activation.
    EdgeEmpty can activate if there is at leist one token in its Place of origin.
    */

    public EdgeEmpty(Place origin, Transition arrival) {
        /*
        Constructor for the EdgeEmpty class.

        Args:
            origin (Place): Origin of the edge.
            arrival (Transition): Arrival of the edge.
        */
        super(origin, arrival);
    }

    public EdgeEmpty() {
        /*
        Constructor for the EdgeEmpty class.
        */
        super();
    }

    public boolean isActivable() {
        /*
        Tells if the Edge can be activated. EdgeEmpty can be activated if its place of origin has at leist one token.

        Returns:
            (boolean): If the Edge can be activated.
        */
        Place originPlace = this.getOrigin();
        return (originPlace.getNbTokens() > 0);
    }

    public void activate() {
        /*
        Activate the Edge. For EdgeEmpty, this empty the Place of origin.
        */
        Place originPlace = this.getOrigin();
        originPlace.setNbTokens(0);
    }
}
