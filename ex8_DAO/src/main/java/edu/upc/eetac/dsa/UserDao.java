package edu.upc.eetac.dsa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao
{
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;


    //READ:metode q busca tots els usuaris i els torna amb una llista
    public List<User> getAllUsers() throws Exception {
        // This will load the MySQL driver, each DB has its own driver
        Class.forName("com.mysql.jdbc.Driver");
        // Setup the connection with the DB
        connect = DriverManager
                .getConnection("jdbc:mysql://localhost/feedback?"
                        + "user=sqluser&password=sqluserpw");

        // Statements allow to issue SQL queries to the database
        statement = connect.createStatement();

        //FINS QUI TOT IGUAL


        // Result set get the result of the SQL query
        resultSet = statement
                .executeQuery("select * from Users ");

        List<User> llista = new ArrayList<User>(); //creem la llista de usuaris
        while (resultSet.next()) { //per recuperar tots els registres
            User user = new User("rosa","castelldefels",1); //creem un usuari

            String name = resultSet.getString("Name"); //lo verd es el nom de la columna i lo gris els atributs
            user.setName(name);
            int id = resultSet.getInt("Id");
            String address = resultSet.getString("Address");

            llista.add(user);
        }

        return llista;
    }





// UPDATE: metode q afegeix la adreça al usuari passat com a parametre mitjançant el id


    public void addId (User user) throws Exception {
        // This will load the MySQL driver, each DB has its own driver
        Class.forName("com.mysql.jdbc.Driver");
        // Setup the connection with the DB
        connect = DriverManager
                .getConnection("jdbc:mysql://localhost/feedback?"
                        + "user=sqluser&password=sqluserpw");

        // Statements allow to issue SQL queries to the database
        statement = connect.createStatement();

        //FINS QUI TOT IGUAL


        // Result set get the result of the SQL query
        preparedStatement = connect
                .prepareStatement("update Users set Address=? WHERE Id=?"); //els ? els omplenes amb dades q poses a continuació
        // "myuser, webpage, datum, summery, COMMENTS from feedback.comments");
        // Parameters start with 1
        preparedStatement.setString(1, user.getAddress());
        preparedStatement.setInt(2, user.getId());
        preparedStatement.executeUpdate();


    }

    // DELETE: metodo que borra el usuari passat com a parametre
    public void deleteUser (User user) throws Exception {
        // This will load the MySQL driver, each DB has its own driver
        Class.forName("com.mysql.jdbc.Driver");
        // Setup the connection with the DB
        connect = DriverManager
                .getConnection("jdbc:mysql://localhost/feedback?"
                        + "user=sqluser&password=sqluserpw");

        // Statements allow to issue SQL queries to the database
        statement = connect.createStatement();

        //FINS QUI TOT IGUAL


        // Result set get the result of the SQL query
        preparedStatement = connect
                .prepareStatement("delete from Users WHERE Id=?"); //els ? els omplenes amb dades q poses a continuació
        // "myuser, webpage, datum, summery, COMMENTS from feedback.comments");
        // Parameters start with 1
        preparedStatement.setInt(1, user.getId());
        preparedStatement.executeUpdate();


    }



}