package edu.upc.eetac.dsa;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by rosa on 10/11/2016.
 */
public class EscripturaClient extends Thread{
    Socket cs;
    public EscripturaClient (Socket cs){
        this.cs=cs;
    }
    protected DataOutputStream sortidaClient;
    String missatge;
    Scanner scanner = new Scanner(System.in);

    public void run() { //el client estableix una conexió amb el servidor i mostra per pantalla tot el q li envii el servidor.
        while (true) {
            try {
                sortidaClient = new DataOutputStream(cs.getOutputStream());
                missatge = scanner.nextLine();
                sortidaClient.writeBytes(missatge + "\n"); //envío mensaje al servidor
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

