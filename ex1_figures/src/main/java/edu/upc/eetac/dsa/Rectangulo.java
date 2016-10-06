package edu.upc.eetac.dsa;

/**
 * Created by rosa on 22/09/2016.
 */
public class Rectangulo extends FiguraAbstract{

    private double l1;
    private double l2;

    public Rectangulo(double l1, double l2){

        this.l1=l1;
        this.l2=l2;
    }

    public double area(){
        return l1*l2;
    }
}