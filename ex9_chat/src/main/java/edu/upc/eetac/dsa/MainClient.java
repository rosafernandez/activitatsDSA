package edu.upc.eetac.dsa;

import java.io.IOException;

/**
 * Created by rosa on 10/11/2016.
 */
public class MainClient {
    public static void main(String[] args) throws IOException {
        Client client = new Client();
        System.out.println("Inicialitzant el client.\n\nEscriu aquí:");
        client.startClient();
    }
}
