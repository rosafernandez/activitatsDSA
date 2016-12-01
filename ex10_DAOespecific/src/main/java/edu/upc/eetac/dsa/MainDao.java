package edu.upc.eetac.dsa;


import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;


public class MainDao
{
    public static void main( String[] args ) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, SQLException {
        User user = new User(9,"lola","bcn");
        User user1 = new User(1,"aitor","upc");
        User user2 = new User(2,"oriol","andorra");
        User user3 = new User(3,"copito","lloret de dalt");
        User user4 = new User(4,"rosita","lloret");
        User user5 = new User(6,"marina","fenals");
        User user6 = new User(10,"marini","fenals");

        //user4.insertUser();
        //user2.insertUser();
        //user3.insertUser();
        //user4.updateUser(); //per actualitzar poses el user q vols modificar
        //user.selectUser(4); //el select es fa pel (id) no pel numero de user
        //user.select2User("rosa","lloret"); //el select es fa pel (name i address) no pel numero de user
        //user4.deleteUser(); //per borrar poses el user q vols borrar
        System.out.println("\n**********************************************************");
        List<User> l = UserDAO.getAllUsers();



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

    }
}