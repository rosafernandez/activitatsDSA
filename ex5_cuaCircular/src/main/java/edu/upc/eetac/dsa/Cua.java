package edu.upc.eetac.dsa;

public class Cua {
    public static class CuaCircular {
        static int max = 4; //capacitat de la cua de 4 elements
        static int cuacircular[]= new int [max]; //creació de la cua
        static int inici, fi; /*indicadors per marcar el inici (posició del primer element) i
        el final (posició del ultim element) de la cua */

        CuaCircular(){
            inici =-1; //si no hi ha cap element els dos indicadors estaran a la posició -1. La primera posició a ocupar es la 0.
            fi =-1;
            System.out.println("cua inicialitzada ");
        }

        //mitjançant un menú es donaran diferentes opcions:

        //Inserir element
        public static void insertar(int element){
            //casos en els que NO es podria insertar pq la cua està plena:
            if((fi ==max-1&& inici ==0)|| (fi +1== inici))
            {
                System.out.println("\nL'element no s'ha pogut insertar perquè la cua està plena. ");
                return;
            }
            //cas on SI es podria fer la inserció
            if(fi ==max-1&& inici !=0){ //la posició 0 estaria buida i l'index fi avança una posició.
                inici =0;
            }
            else fi++;
            cuacircular[fi]=element;
            if(inici ==-1){
                inici =0;
            }
            System.out.println("\nEl valor "+element+" s'ha posat en la posició "+ fi);
        }

        //Eliminar element: esborra el element que s'ha introduït primer (FIFO)
        public static void eliminar() {
            System.out.println("\n\nEliminació del primer element de la cua: ");
            //casos en els q NO podrem eliminar pq la cuida està buida.
            if(inici ==-1) {
                System.out.println("No es pot eleminar cap element perquè la cua està buida.");
                return;
            }
            //cas on SI podrem eliminar. S'elimina l'element que es troba en la posició del indicador inici.
            System.out.println("element eliminat = "+ cuacircular[inici]);
            if(inici == fi) {
                inici =-1; fi =-1;
                return;
            }
            if(inici ==max) {
                inici = 0;
            }
            else {
                inici++;
            }
        }

        //Veure l'estat de la cua
        public static void veureCua(){
            int i=0;
            System.out.println("la cua conté: ");
            if (inici == -1){
                System.out.println("\n1" +
                        "la cua circular està buida ");
            }
            else{
                i= inici;
                for(i= inici; i!= fi +1; i++){//recorro la cua fins a la posició on no hi hagi res (fi +1)
                    System.out.println("a la posició ["+i+"] hi ha l'element= "+ cuacircular[i]);
                    if(i==max&& inici > fi)
                    {
                        i=0; //reiniciem el contador pq torni a començar
                    }
                }
                System.out.println("inici= "+ inici);
                System.out.println("fi= "+ fi);
                System.out.println("max= "+max);
            }
        }
    }
}


