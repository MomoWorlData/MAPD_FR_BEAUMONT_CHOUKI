package io.github.leobeaumont;

import java.util.List;

/**
 * Defines the contract for a Petri net simulation.
 * <p>
 * This interface specifies all necessary methods for managing and simulating
 * the behavior of a Petri net, including manipulation of places, transitions, and edges.
 * </p>
 */
public interface IPretriNet {

    /**
     * Executes one simulation step for the specified {@link Transition}.
     *
     * @param transition the transition to activate during the simulation step.
     */
    public void stepSimulation(Transition transition);

    /**
     * Adds a new {@link Place} to the Petri net with a specified number of tokens.
     *
     * @param nbTokens the initial number of tokens to assign to the place.
     */
    public void addPlace(int nbTokens);

    /**
     * Adds a new incoming {@link Edge} from a {@link Place} to a {@link Transition}.
     *
     * @param weight  the weight of the edge (number of tokens transferred).
     * @param origin  the origin place.
     * @param arrival the arrival transition.
     */
    public void addEdge(int weight, Place origin, Transition arrival);

    /**
     * Adds a new outgoing {@link Edge} from a {@link Transition} to a {@link Place}.
     *
     * @param weight  the weight of the edge (number of tokens transferred).
     * @param origin  the origin transition.
     * @param arrival the arrival place.
     */
    public void addEdge(int weight, Transition origin, Place arrival);

    /**
     * Adds a new {@link Transition} to the Petri net.
     */
    public void addTransition();

    /**
     * Removes a {@link Place} from the Petri net.
     *
     * @param place the place to remove.
     */
    public void removePlace(Place place);

    /**
     * Removes an {@link Edge} from the Petri net.
     *
     * @param edge the edge to remove.
     */
    public void removeEdge(Edge edge);

    /**
     * Removes a {@link Transition} from the Petri net.
     *
     * @param transition the transition to remove.
     */
    public void removeTransition(Transition transition);

    /**
     * Sets the number of tokens in a specific {@link Place}.
     *
     * @param place    the place whose tokens will be updated.
     * @param nbTokens the new number of tokens to assign.
     */
    public void setTokens(Place place, int nbTokens);

    /**
     * Sets the weight of a specific {@link Edge}.
     *
     * @param edge the edge whose weight will be updated.
     */
    public void setWeight(Edge edge);

    /**
     * Returns the list of {@link Transition}s that can currently fire.
     *
     * @return a list of firable transitions.
     */
    public List<Transition> firable();

    /**
     * Launches the Petri net simulation for a given number of steps.
     *
     * @param steps the number of simulation steps to execute.
     */
    public void launchSimulation(int steps);
}
