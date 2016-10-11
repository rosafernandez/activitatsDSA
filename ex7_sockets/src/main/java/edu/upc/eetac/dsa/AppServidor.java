package edu.upc.eetac.dsa;

import java.io.IOException;


//ClasSe principal que farà ús del servidor
public class AppServidor
{
    public static void main(String[] args) throws IOException
    {
        Servidor servidor = new Servidor(); //creem el servidor

        System.out.println("Inicialitzant servidor\n");
        servidor.startServer(); //S'inicialitza el servidor
    }
}
