package edu.upc.eetac.dsa;

import java.io.*;
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
    int client1;

    public ThreadServidor(Socket cs, List<Socket> llistaSockets){
        this.cs=cs;
        this.llistaSockets=llistaSockets;
    }
    private int client() {
        for (int i=0; i< llistaSockets.size(); i++){
            if (cs == llistaSockets.get(i)){
                client1= i+1;
            }
        }
        return client1;
    }

    public void run() {
        try {
            entrada = new BufferedReader(new InputStreamReader(cs.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                int client;
                int a=1;
                missatgeClient= entrada.readLine();
                for (int i=0; i< llistaSockets.size();i++){
                    client = client();
                    if (llistaSockets.size()==1){
                        System.out.println("client 1: " + missatgeClient);
                        continue;
                    }
                    else if(cs == llistaSockets.get(i)){
                        continue;} /*el servidor enviarà els textos rebuts a totes les conexions de la seva llista excepte
                                    a la conexió per on ha rebut el text. Aixo evitarà que un client rebi el mateix text q acaba de enviar */
                    String st= Integer.toString(client);
                    sortidaClient = new DataOutputStream(llistaSockets.get(i).getOutputStream());
                    sortidaClient.writeUTF("client "+st+": "+missatgeClient);
                    if (a==1) {
                        System.out.println("client " + st + ": " + missatgeClient);
                        a++;
                    }
                }
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
