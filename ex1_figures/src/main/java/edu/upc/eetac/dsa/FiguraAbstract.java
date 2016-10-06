package edu.upc.eetac.dsa;

/**
 * Created by rosa on 22/09/2016.
 */

public abstract class FiguraAbstract implements Figura, Comparable<Figura>{

    public int compareTo(Figura f) {
        return (int) (this.area() - f.area());
    }
}