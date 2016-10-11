package edu.upc.eetac.dsa;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

/* El servidor atendera peticiones por el puerto 1234 en TCP y retornara lo mismo que haya recibido pero pasandolo a mayusculas.
   El cliente leera una linea de consola, enviara el texto al servidor y esperara el retorno que sera el mismo texto en mayusculas.
  En este punto ambos programas cerraran la conexion y el Cliente acabara su ejecucion.
  */
    public class Client extends Conexio {
    public String frase = new String();
    public Scanner scan = new Scanner (System.in); //funció per llegir la frase q se li passa
    public String resposta = ""; //inicialitzo el que torna pero ho deixo buit

    public Client() throws IOException{super("client");} //s'utilitza el constructor pel Client de Conexio

    public void startClient() //Métode q inicialitza el client
    {
        try
        {
            //Flux de dades cap al servidor
            sortidaServidor = new DataOutputStream(cs.getOutputStream());
            entradaServidor = new DataInputStream(cs.getInputStream());

            //En el cas de voler enviar mes de un missatge (10 missatges): for (i=0; i<10;i++)

           System.out.print ("Escriu el missatge que vols enviar: ");
                //S'escriu en el servidor fent servir el seu fluxe de dades
            this.frase = scan.nextLine();
            sortidaServidor.writeUTF(frase + "\n");

            //Llegim la resposta del servidor i la escrivim per pantalla
            resposta = entradaServidor.readUTF();
            System.out.println(resposta);

            cs.close();//Fi de la conexió
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}