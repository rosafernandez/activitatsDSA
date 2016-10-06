package edu.upc.eetac.dsa;


public interface Stack <E> {

    public void push(E e) throws PilaPlena;
    public E pop() throws PilaBuida;
    public int size();

}
