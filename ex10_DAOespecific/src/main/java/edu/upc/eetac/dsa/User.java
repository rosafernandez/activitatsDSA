package edu.upc.eetac.dsa;

/**
 * Created by rosa on 10/10/2016.
 */
//creo la classe User amb els seus atributs, el constructor i els getters i setters (code-> generate)
public class User extends UserDAO{
    public int id;
    public String name, address;

    public User(int id, String name, String address) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("id: ").append(this.getId());
        sb.append("\nname: ").append(this.getName());
        sb.append("\naddress: ").append(this.getAddress());
        return sb.toString();
    }
}

