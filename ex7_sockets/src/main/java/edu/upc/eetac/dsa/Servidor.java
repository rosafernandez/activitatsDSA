package edu.upc.eetac.dsa;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;


/* El servidor atendera peticiones por el puerto 1234 en TCP y retornara lo mismo que haya recibido pero pasandolo a mayusculas.
   El cliente leera una linea de consola, enviara el texto al servidor y esperara el retorno que sera el mismo texto en mayusculas.
  En este punto ambos programas cerraran la conexion y el Cliente acabara su ejecucion.
  */

/* amb el métode accept() el servidor espera la conexió del client, un cop establerta la conexió, envía un missatge de confimació amb
el writeUTF() i llegeix tots els missatges desde el client mitjançant el readLine(). Finalment, es tenca la conexió amb el close () */

public class Servidor extends Conexio //Es una extensió de conexió per poder fer ús dels sockets.
{
    public Servidor() throws IOException{super("servidor");}

    //iniciem el servidor
    public void startServer() {
        try {
            System.out.println("Esperant la conexió...");
            cs = ss.accept(); //accept comença el socket i espera una conexió desde un client
            System.out.println("Client en línia");

            //S'obté el fluxe de sortida del client per enviar-li missatges
            sortidaClient = new DataOutputStream(cs.getOutputStream());

            //S'obté el fluxe entrant desde el client
            BufferedReader entrada = new BufferedReader(new InputStreamReader(cs.getInputStream()));

            while((missatgeServidor = entrada.readLine()) != null) //Mentres hi hagi missatges en el client
            {
                sortidaClient.writeUTF(missatgeServidor.toUpperCase()); //posem en majuscules el missatge
            }

            System.out.println("Fi de la conexió");

            ss.close();//Se finaliza la conexión con el cliente
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
