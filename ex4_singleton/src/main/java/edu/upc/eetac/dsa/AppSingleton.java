package edu.upc.eetac.dsa;
public class AppSingleton
{
    public static void main( String[] args )
    {
        try {
            Factory.getInstance().getCommand("C1").execute();
            Factory.getInstance().getCommand("C2").execute();
            Factory.getInstance().getCommand("C3").execute();
            Factory.getInstance().getCommand("C1").execute();
            Factory.getInstance().getCommand("C4").execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
