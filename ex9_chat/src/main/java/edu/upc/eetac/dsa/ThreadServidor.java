package edu.upc.eetac.dsa;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.List;

/**
 * Created by rosa on 10/11/2016.
 */
public class ThreadServidor extends Thread {
    Socket cs;
    List<Socket> llistaSockets;
    protected DataOutputStream sortidaClient;
    BufferedReader entrada;
    String missatgeClient;

    public ThreadServidor(Socket cs, List<Socket> llistaSockets){
        this.cs=cs;
        this.llistaSockets=llistaSockets;
    }
    public void run() {
        try {
            entrada = new BufferedReader(new InputStreamReader(cs.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                missatgeClient= entrada.readLine();
                System.out.println(missatgeClient);//missatge rebut del client
                for(int i=0;i<llistaSockets.size();i++) {
                    if(cs == llistaSockets.get(i))
                        continue; /*el servidor enviarà els textos rebuts a totes les conexions de la seva llista excepte
                                    a la conexió per on ha rebut el text. Aixo evitarà que un client rebi el mateix text q acaba de enviar */

                    sortidaClient = new DataOutputStream(llistaSockets.get(i).getOutputStream());
                    sortidaClient.writeUTF(missatgeClient);
                }
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
