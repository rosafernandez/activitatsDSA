package edu.upc.eetac.dsa;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rosa on 10/11/2016.
 */
public class Servidor {

    private int port=1234;
    ServerSocket ss=new ServerSocket(port); //el servidor atendrà peticions pel port 1234
    Socket cs=null;
    DataOutputStream sortidaClient;
    List<Socket> llistaSockets=new ArrayList<Socket>(); //cada conexió dels diferents clients s'emmagatzema en una llista

    public Servidor() throws IOException {
    }

    public void startServer() throws IOException {
        int i=0;
        System.out.println("Esperant...");
        while (true) { //el servidor accepta tantes conexions simultaneas com clients hi hagi.
            i++;
            cs = ss.accept(); //comença el socket
            if (i==1)
                System.out.println("Nou client. "+i+ " client conectat!");
            else
                System.out.println("Nou client. "+i+ " clients conectats!");
            llistaSockets.add(cs);
            ThreadServidor th1 = new ThreadServidor(cs, llistaSockets);
            th1.start();
        }
    }
}
