package edu.upc.eetac.dsa;

/**
 * Created by rosa on 22/09/2016.
 */

public class Circulo extends FiguraAbstract{
    private double r;

    public Circulo (double r){
        this.r=r;
    }

    public double area(){
        return Math.PI*r*r;
    }
}