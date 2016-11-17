package edu.upc.eetac.dsa;


import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MainDao
{
    public static void main( String[] args ) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, SQLException {
        User user = new User(9,"lola","bcn");
        User user1 = new User(1,"aitor","upc");
        User user2 = new User(2,"oriol","andorra");
        User user3 = new User(3,"copito","lloret de dalt");
        User user4 = new User(4,"rosa","lloret");
        User user5 = new User(6,"marina","fenals");
        User user6 = new User(10,"marini","fenals");

        //user4.insert();
        //user6.update(); //per actualitzar poses el user q vols modificar
        //user.select(2); //el select es fa pel (id) no pel numero de user
        user1.delete(); //per borrar poses el user q vols borrar



        //user6.select2("marina","fenals");
        /*
        System.out.println("\n**********************************************************");
        System.out.println("\nFunció seleccionar:");

        Dept departamento = new Dept(1,4,"finances","departament de comptabilitat");
        System.out.println("\n**********************************************************");

        //departamento.insert();
        user4.select(3);
        //user5.update(6);
        List<User> lista = new ArrayList<User>();
        user.getAllUsers();*/
        System.out.println("\n**********************************************************");
        List<User> l = DAO.getAllUsers();
    }
}