package nl.ddoa.example.dice;

/**
 * 
 * @author rodmidde
 *
 */
public class Dobbelsteen
{
    private int dobbelWaarde;

    public int getDobbelWaarde()
    {
        return dobbelWaarde;
    }
    
    public void dobbel()
    {
        dobbelWaarde = (int) (5* Math.random()) + 1;
    }
    
}
