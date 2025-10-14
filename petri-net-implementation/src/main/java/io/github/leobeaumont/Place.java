package io.github.leobeaumont;

public class Place {
    /*
    This implement the Place class, that are mainly used to store tokens.
    */

    private int nbTokens;

    public Place() {
        /*
        Constructor for Place
        */
        setNbTokens(0);
    }

    public Place(int nbTokens) {
        /*
        Constructor for Place

        Args:
            nbTokens (int): Number of tokens at creation (default to 0 if nbTokens < 0).
        */
        if (nbTokens >= 0){
            setNbTokens(nbTokens);
        } else {
            System.out.printf("Place -- Invalid nbTokens: ", nbTokens, "(nbTokens defaulted to 0)\n");
            setNbTokens(0);
        } 
    }

    public void removeTokens(int amount) throws IllegalArgumentException {
        /*
        Remove a certain amount of tokens from the Place.
        
        Args:
            amount (int): Amount of tokens to remove

        Throws:
            IllegalArgumentException: If amount if negative.
            IllegalArgumentException: If amount is greater than the amount of tokens in the place.
        */
        if (amount < 0){
            throw new IllegalArgumentException(String.format("Place.removeTokens(%d) -- The argument amount (%d) is negative", amount, amount));
        }

        int tokens = getNbTokens();
        if (tokens >= amount){
            this.nbTokens -= amount;
        } else {
            throw new IllegalArgumentException(String.format("Place.removeTokens(%d) -- The argument amount (%d) is greater than nbTokens (%d)", amount, amount, tokens));
        }
    }

    public void addTokens(int amount) {
        /*
        Add a certain amount of tokens to the Place.
        
        Args:
            amount (int): Amount of tokens to remove

        Throws:
            IllegalArgumentException: If amount if negative.        
        */
        if (amount < 0){
            throw new IllegalArgumentException(String.format("Place.removeTokens(%d) -- The argument amount (%d) is negative", amount, amount));
        }

        this.nbTokens += amount;
    }

    public int getNbTokens() {
        return nbTokens;
    }

    public void setNbTokens(int nbTokens) {
        this.nbTokens = nbTokens;
    }
}
