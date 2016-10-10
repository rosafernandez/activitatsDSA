package edu.upc.eetac.dsa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AppCuaCircular extends Cua {
    static CuaCircular Cua = new CuaCircular(); //creem un constructor per cridar a la classe Cua

    public static void main(String[] args) throws IOException {
        int opcio=-1; //num per inicialitzar q cumpleixi el while
        while(opcio!=4) {
            System.out.println("\nSeleccioni la opció desitjada:");
            System.out.println("\n1.- Inserir element");
            System.out.println("2.- Eliminar element");
            System.out.println("3.- Veure cua");
            System.out.println("4.- Sortir");

            opcio=getInt();
            switch(opcio) {
                case 1 : insertar();
                    break;
                case 2 : Cua.eliminar();
                    break;
                case 3 : Cua.veureCua();
                    break;
            }
        }
    }
    //insertar
    public static void insertar() throws IOException {
        int element;
        System.out.println("\nInserció de l'element a la cua: ");
        System.out.print("Element que es vol inserir: ");
        element=getInt();
        Cua.insertar(element);
    }

    // funció per capturar una cadena de dades desde el teclat.
    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    // Funcio per capturar un enter desde el teclat.
    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
}
