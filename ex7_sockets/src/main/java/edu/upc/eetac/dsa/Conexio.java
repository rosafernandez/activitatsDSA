package edu.upc.eetac.dsa;

import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Conexio
{
    private final int PORT = 1234; //Port per la conexió
    private final String HOST = "localhost"; //Host per la conexió
    protected String missatgeServidor; //Missatges entrants (rebuts) en el servidor
    protected ServerSocket ss; //Socket del servidor
    protected Socket cs; //Socket del client
    protected DataOutputStream sortidaServidor, sortidaClient; //Fluxe de dades de sortida
    protected DataInputStream entradaServidor;

    //constructor
    public Conexio(String tipo) throws IOException {

        if(tipo.equalsIgnoreCase("servidor")) //si tipo es igual a servidor entra i fa el ss i cs.
        {
            ss = new ServerSocket(PORT);//es crea el socket pel servidor en el port 1234
            cs = new Socket(); //Socket pel client
        }
        else
        {
            cs = new Socket(HOST, PORT); //Socket pel client en localhost en el port 1234
        }
    }
}