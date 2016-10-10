package edu.upc.etaac.dsa;


public class StackImpl <E> implements Stack <E>{
    private int count=0;
    private E[] elements;
    private int lem;

    public StackImpl (int lem){
        Object[] v = new Object[lem];
        this.elements = (E[]) v;
        this.lem = lem;
    }
    public void push (E e) throws PilaPlena{
        if ( count >= lem ) throw new PilaPlena();
        this.elements[count++]=e;
    }
    public E pop() throws PilaBuida{
        if ( count == 0) throw new PilaBuida();
        return elements[--count];

    }
    public int size(){

        return count;
    }
}
