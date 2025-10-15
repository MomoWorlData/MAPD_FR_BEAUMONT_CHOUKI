package io.github.leobeaumont;

public class EdgeZero extends EdgeIn {
    /*
    This implement the class EdgeEmpty, which is an EdgeIn that empty it's origin on activation.
    EdgeEmpty can activate if there is at leist one token in its Place of origin.
    */

    public EdgeZero(Place origin, Transition arrival) {
        /*
        Constructor for the EdgeZero class.

        Args:
            origin (Place): Origin of the edge.
            arrival (Transition): Arrival of the edge.
        */
        super(origin, arrival);
    }

    public EdgeZero() {
        /*
        Constructor for the EdgeZero class.
        */
        super();
    }

    public boolean isActivable() {
        /*
        Tells if the Edge can be activated. EdgeZero can be activated if its place of origin has no token.

        Returns:
            (boolean): If the Edge can be activated.
        */
        Place originPlace = this.getOrigin();
        return (originPlace.getNbTokens() == 0);
    }

    public void activate() {
        /*
        Activate the Edge. For EdgeZero, this does nothing.
        */
    }
}
