package io.github.leobeaumont;

public abstract class Edge {
    /*
    This implement the abstract class Edge, that are used to connect a Place and a Transition.
    This class is abstract because and Edge in itself is not enougth to be used in the simulation.
    */

    // This method has to be implemented in the classes that inherits from Edge
    public abstract void activate();
    
}
