package edu.upc.eetac.dsa;

import java.util.HashMap;
import org.apache.log4j.Logger;

/**
 * Created by rosa on 03/10/2016.
 */
public class Factory {
    final static Logger logger = Logger.getLogger (Factory.class);
    private static Factory instance;
    private HashMap <String, Command> cache;
    private Factory (){
        cache=new HashMap<String, Command>();
    }
    public static Factory getInstance (){
        if (instance == null) instance= new Factory();
        return instance;
    }
    public Command getCommand (String cmd) throws IllegalAccessException, InstantiationException {
        Command c= cache.get (cmd);
        if (c== null){ //si es el primer cop q s'executa i no está a la memoria, es creará una nova.
            Class cl= null; //busques quina classe executar
            try {
                cl = Class.forName ("edu.upc.eetac.dsa."+cmd);
            } catch (ClassNotFoundException e) {
                //e.printStackTrace();
                logger.error(cmd+" no existeix");
            }
            c= (Command) cl.newInstance ();
            logger.info("cmd creat");
            cache.put(cmd,c);
            logger.info("cmd afegit a la caché");
        }
        return c;

    }

}
