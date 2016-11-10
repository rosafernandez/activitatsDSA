package edu.upc.eetac.dsa;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by rosa on 10/11/2016.
 */
public class Client {
    private final int PORT=1234; //el servidor atendrá peticions pel port 1234
    private final String HOST="localhost"; //Host per la conexió
    public Socket cs; //socket del client




    public void startClient() throws IOException {
        cs= new Socket(HOST, PORT);
        LecturaClient threadlectura =new LecturaClient(cs); //Creació del thread de lectura
        EscripturaClient threadescriptura = new EscripturaClient(cs); //creació del thread de escriptura
        threadlectura.start();
        threadescriptura.start();
    }

}

