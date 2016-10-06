package edu.upc.eetac.dsa;

/**
 * Created by rosa on 22/09/2016.
 */
public class Triangulo extends FiguraAbstract{
    private double b;
    private double h;

    public Triangulo (double b, double h){
        this.b=b;
        this.h=h;
    }

    public double area(){
        return b*h/2;
    }
}