package edu.upc.eetac.dsa;

/**
 * Created by rosa on 22/09/2016.
 */
public class MiEscribidor extends Thread {
    private int numero;

    public MiEscribidor (int numero){
        this.numero=numero;
    }

    public void run(){
        for(int i=1; i<11;i++){
            System.out.println( "Soy el thread número "+ numero + " y el contador es " + i);


        }
    }
}
