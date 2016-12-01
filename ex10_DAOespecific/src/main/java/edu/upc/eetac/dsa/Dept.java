package edu.upc.eetac.dsa;

/**
 * Created by rosa on 17/11/2016.
 */

//creo la classe departament amb els seus atributs, el constructor i els getters i setters (code-> generate)
public class Dept extends DeptDAO{
    public int id, numEmpl;
    public String name, description;

    public Dept(int id, int numEmpl, String name, String description) {
        this.id = id;
        this.numEmpl = numEmpl;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumEmpl() {
        return numEmpl;
    }

    public void setNumEmpl(int numEmpl) {
        this.numEmpl = numEmpl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


