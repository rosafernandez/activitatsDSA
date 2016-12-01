package edu.upc.eetac.dsa;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by rosa on 17/11/2016.
 */
public class UserDAO {

    public static Connection getConnection() {
        Connection con=null;
        try
        {
            String host = "localhost";
            int port = 3306;
            String database = "bbdd"; //posar el nom d la bbdd q faci servir!!!!
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
            Properties info = new Properties();
            info.setProperty("user", "root");
            info.setProperty("password", "root");
            info.setProperty("useSSL", "false");
            info.setProperty("serverTimezone", "UTC");
            con = DriverManager.getConnection(url, info);
            System.out.println("Conexion creada.\n");
        }
        catch (Exception e)
        {e.printStackTrace();}

        return con;
    }

    //la funció getValors agafa els valos dels getters i setters

    public String getValors (Field f) {
        String res=null;
        try {
            Method m = this.getClass().getMethod(getUpper(f.getName()), null);
            res = m.invoke(this, null).toString();
        }
        catch (NoSuchMethodException e1) {
            e1.printStackTrace();
        }
        catch (IllegalAccessException e1) {
            e1.printStackTrace();
        }
        catch (InvocationTargetException e1) {
            e1.printStackTrace();
        }
        return res;
    }

    //la funció insterarElementos insereix els valors en els "?"

    public void insertarElementos (PreparedStatement preparedStatement) throws NoSuchMethodException, SQLException, InvocationTargetException, IllegalAccessException {
        int i = 1;
        Field[] fields = this.getClass().getFields();

        for (Field f : fields) {
            String res = getValors(f);
            preparedStatement.setObject(i, res);
            i++;
        }
    }

    //la funció getUpper et modifica la primera lletra en majucules per poder accedir als getters
    public String getUpper(String m) {
        String result = Character.toUpperCase(m.charAt(0))+m.substring(1);
        return "get".concat(result);
    }


    //funció per INSERTAR elements a les taules

    public void insertUser() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        StringBuffer sb = new StringBuffer();
        sb.append("INSERT INTO User (id,name,address) VALUES (?,?,?)");

        System.out.println("QUERY: "+sb.toString()+"\n");

        //estableixes la conexió i fas el INSERT
        Connection con = getConnection();
        try{
            PreparedStatement preparedStatement = con.prepareStatement(sb.toString());
            insertarElementos(preparedStatement);
            preparedStatement.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //SELECT d'un departament o un usuari filtrant per el id
    public void selectUser(int id){
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM User WHERE ID = ").append(id);
        System.out.println("QUERY: "+sb.toString());

        Connection con = getConnection();

        try {

            Statement stmt= con.createStatement();
            ResultSet rs= stmt.executeQuery(sb.toString());
            ResultSetMetaData rsmd=rs.getMetaData();
            rs.next();
            for(int i=1; i<rsmd.getColumnCount()+1;i++){ //lo ejecuto el numero de veces de columnas que tenga en la tabla
                try {
                    if (rsmd.getColumnTypeName(i).equals("INT")) {//para la columna i,si es del tipo int
                        System.out.println(rsmd.getColumnLabel(i) + " = " + rs.getInt(i)); //obtengo la etiqueta de la columna y el entero (id=1...)
                    }
                    if (rsmd.getColumnTypeName(i).equals("VARCHAR")) { //si es del tipovarchar, obtengo lo que es tambien
                        System.out.println(rsmd.getColumnLabel(i) + " = " + rs.getString(i));
                    }
                    if (i == rsmd.getColumnCount()) { //cuando i=numero de columnas, voy al siguiente y salgo del bucle,reiniciando i
                        rs.next();
                        i = 0;
                    }
                }
                catch(Exception e){
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //SELECT un usuari filtrant per name i address

    public void select2User(String name, String address){
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM User WHERE NAME = '").append(name).append("' AND ADDRESS = '").append(address).append("'");

        //si hi hagues un altre camp q fos edat (tipus int) va sense comes simples. (" WHERE EDAT = ").append(edat);
        System.out.println("QUERY: "+sb.toString());

        Connection con = getConnection();

        try {

            Statement stmt= con.createStatement();
            ResultSet rs= stmt.executeQuery(sb.toString());
            ResultSetMetaData rsmd=rs.getMetaData();
            rs.next();
            for(int i=1; i<rsmd.getColumnCount()+1;i++){ //lo ejecuto el numero de veces de columnas que tenga en la tabla
                try {
                    if (rsmd.getColumnTypeName(i).equals("INT")) {//para la columna i,si es del tipo int
                        System.out.println(rsmd.getColumnLabel(i) + " = " + rs.getInt(i)); //obtengo la etiqueta de la columna y el entero (id=1...)
                    }
                    if (rsmd.getColumnTypeName(i).equals("VARCHAR")) { //si es del tipovarchar, obtengo lo que es tambien
                        System.out.println(rsmd.getColumnLabel(i) + " = " + rs.getString(i));
                    }
                    if (i == rsmd.getColumnCount()) { //cuando i=numero de columnas, voy al siguiente y salgo del bucle,reiniciando i
                        rs.next();
                        i = 0;
                    }
                }
                catch(Exception e){
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //UPDATE: actualitzar un departament o un usuari filtrant per id
    public void updateUser() {
        StringBuffer sb = new StringBuffer();
        sb.append("UPDATE User SET id=?,name=?,address=? WHERE id=");

        Field[] fields = this.getClass().getDeclaredFields(); //campos--> obtener campos declarados en esta clase:id, name, address
        int id = Integer.parseInt(getValors(fields[0])); //convertir el string corresponent a la [0] de fields q fa referencia al id a int
        sb.append(id);
        //si fos per name: sb.append (" WHERE name=" + nom);

        System.out.println("QUERY: " + sb.toString());

        Connection con = getConnection();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sb.toString());
            insertarElementos(preparedStatement);
            preparedStatement.execute();

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //DELETE: eliminar un usuari o un departament filtrant per id
    public void deleteUser(){
        StringBuffer sb = new StringBuffer();
        Field[] fields = this.getClass().getDeclaredFields();
        int id = Integer.parseInt(getValors(fields[0]));
        sb.append("DELETE FROM User WHERE ID=").append(id);
        System.out.println("QUERY: "+sb.toString());
        Connection con = getConnection();

        try {
            Statement stmt=con.createStatement();
            stmt.execute(sb.toString());
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //funció getAllUsers q retorna tots els usuaris en una llista ordenants pel nom
    public static List<User> getAllUsers() throws SQLException {
        Connection con = getConnection();
        Statement stmt= null;
        try {
            stmt = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet rs= stmt.executeQuery("SELECT * FROM User ORDER BY name");
        List<User> lista = new ArrayList<User>();
        while (rs.next()){
            User user = new User(rs.getInt("id"),rs.getString("name"),rs.getString("address"));
            lista.add(user);
        }
        //System.out.println(lista);
        for (User u:lista){
            System.out.println(u+ "\n");
        }
        return lista;
    }
}

