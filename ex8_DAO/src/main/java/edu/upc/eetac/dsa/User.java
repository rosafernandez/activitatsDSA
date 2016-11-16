package edu.upc.eetac.dsa;

/**
 * Created by rosa on 10/10/2016.
 */
//code-generate-gettersandsetters
public class User {
    public String Name;
    public String Address;
    public int Id;

    public User(String Name, String Address, int Id) {
        this.Name = Name; //name negre el q li pases per parametre, name lila el d la clase.
        this.Address = Address;
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}


