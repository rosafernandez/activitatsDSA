package edu.upc.eetac.dsa;

import java.util.Arrays;

public class AppFigures
{
    public static void main( String[] args )
    {
        Figura [] ll = new Figura[4];
        ll[0] = new Cuadrado(3);
        ll[1] = new Triangulo(2,1);
        ll[2] = new Rectangulo(5,4);
        ll[3] = new Circulo(8);

        Arrays.sort(ll);

        double sum=0;
        for (Figura f:ll){
            sum=sum+f.area();
            System.out.println("El área del " + f.getClass().getSimpleName() + " es " + f.area());
        }
        System.out.println();
        System.out.println("La suma de las áreas es " + sum);
    }
}