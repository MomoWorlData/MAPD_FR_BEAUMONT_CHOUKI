package io.github.leobeaumont;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Transition {
    /*
    This implement the class Transition, that moves tokens from place to place using edges.
    */

    private List<EdgeIn> edgesIn;
    private List<EdgeOut> edgesOut;

    public Transition() {
        // ArrayList is the best choice for iteration speed and memory usage
        edgesIn = new ArrayList<EdgeIn>();
        edgesOut = new ArrayList<EdgeOut>();
    }

    public boolean isDrawable() {
        /*
        Tells if the transition can be drawn.

        Returns:
            (boolean): If the transition can be drawn.
        */

        // Create an iterator for incoming edges
        List<EdgeIn> edgesToTest = this.getEdgesIn();
        Iterator<EdgeIn> edgeIterator = edgesToTest.iterator();

        // If any incoming edge can't be activated, the transition can't be drawn
        while (edgeIterator.hasNext()) {
            EdgeIn edge = edgeIterator.next();
            if (!edge.isActivable()) {
                return false;
            }
        }
        return true;
    }

    public void draw() {
        /*
        Draw the transition. This calls the activate method of all connected edges.
        */

        // Create iterators for all edges
        List<EdgeIn> edgesIn = this.getEdgesIn();
        Iterator<EdgeIn> edgesInIterator = edgesIn.iterator();

        List<EdgeOut> edgesOut = this .getEdgesOut();
        Iterator<EdgeOut> edgesOutIterator = edgesOut.iterator();

        // Activate all edges
        while (edgesInIterator.hasNext()) {
            EdgeIn edge = edgesInIterator.next();
            edge.activate();
        }

        while (edgesOutIterator.hasNext()) {
            EdgeOut edge = edgesOutIterator.next();
            edge.activate();
        }
    }

    public void newEdgeIn(EdgeIn edge) {
        /*
        Add an EdgeIn in the list edgesIn.
        
        Args:
            edge (EdgeIn): Edge to add to the list.
        */
        List<EdgeIn> edgesIn = this.getEdgesIn();
        edgesIn.add(edge);
    }

    public void removeEdgeIn(EdgeIn edge) {
        /*
        Remove an EdgeIn from the list edgesIn.

        Args:
            edge (EdgeIn): Edge to remove from the list.
        */
        List<EdgeIn> edgesIn = this.getEdgesIn();
        edgesIn.remove(edge);
    }

    public void newEdgeOut(EdgeOut edge) {
        /*
        Add an EdgeOut in the list edgesOut.
        
        Args:
            edge (EdgeOut): Edge to add to the list.
        */
        List<EdgeOut> edgesOut = this.getEdgesOut();
        edgesOut.add(edge);
    }

    public void removeEdgeOut(EdgeOut edge) {
        /*
        Remove an EdgeOut from the list edgesOut.

        Args:
            edge (EdgeOut): Edge to remove from the list.
        */
        List<EdgeOut> edgesOut = this.getEdgesOut();
        edgesOut.remove(edge);
    }

    public List<EdgeIn> getEdgesIn() {
        return edgesIn;
    }

    public void setEdgesIn(List<EdgeIn> edgesIn) {
        this.edgesIn = edgesIn;
    }

    public List<EdgeOut> getEdgesOut() {
        return edgesOut;
    }

    public void setEdgesOut(List<EdgeOut> edgesOut) {
        this.edgesOut = edgesOut;
    }
}
