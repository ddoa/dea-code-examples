package nl.ddoa.example.puplets;

public class PupletLiefde
{
    public static void main(String[] args)
    {
        Tim tim = new Tim();
        Tom tom = new Tom();
        Tanja tanja = new Tanja();
        tanja.addObserver(tim);
        tanja.addObserver(tom);
        tanja.lachLief();
    }

}
