package edu.upc.eetac.dsa;

import java.io.IOException;

/**
 * Created by rosa on 10/11/2016.
 */
public class MainServidor {
    public static void main(String[] args) throws IOException {
        Servidor servidor = new Servidor();
        System.out.println("Inicialitzant el servidor\n");
        servidor.startServer();
    }
}
