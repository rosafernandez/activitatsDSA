package edu.upc.etaac.dsa;

/**
 * Hello world!
 *
 */
public class AppListaTests
{
    public static void main( String[] args )
    {
        StackImpl <Integer> st1 = new StackImpl<Integer>(9); //capacitat de la llista
        try{
            for (int i=0; i<10; i++) { //estic posant 10 elements
                st1.push(i+1);
            }
        } catch(PilaPlena e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        try {
            for (int j = 0; j<10; j++) {
                System.out.println(st1.pop());
            }
        }catch(PilaBuida e){
            System.out.println(e.getMessage());
        }
    }
}