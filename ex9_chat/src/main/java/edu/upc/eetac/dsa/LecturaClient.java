package edu.upc.eetac.dsa;

import java.io.DataInputStream;
import java.net.Socket;

/**
 * Created by rosa on 10/11/2016.
 */
public class LecturaClient extends Thread {

    DataInputStream entradaClient;
    Socket cs;
    String missatge;

    public LecturaClient(Socket cs) {

        this.cs = cs;
    }
    public void run() { //el client llegeix una linia de la consola i la envia al servidor.

        while (true) {
            try {
                entradaClient = new DataInputStream((cs.getInputStream()));
                missatge = entradaClient.readUTF();//llegeix i printa per pantalla
                System.out.println(missatge);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
