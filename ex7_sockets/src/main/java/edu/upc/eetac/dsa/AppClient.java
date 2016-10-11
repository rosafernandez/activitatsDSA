package edu.upc.eetac.dsa;

import java.io.IOException;


//Classe principal que farà ús del client
public class AppClient
{
    public static void main(String[] args) throws IOException
    {
        Client client = new Client(); //creem el client

        System.out.println("Inicialitzant el client\n");
        client.startClient(); //S'inicia el client
    }
}