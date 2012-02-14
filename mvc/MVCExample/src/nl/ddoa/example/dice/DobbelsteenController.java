package nl.ddoa.example.dice;

/**
 * 
 * @author rodmidde
 *
 */
public class DobbelsteenController
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // Dobbelsteen fungeert in het MVC patroon als model
        Dobbelsteen ds = new Dobbelsteen();
        
        // Twee! views
        DobbelsteenConsoleView dcv = new DobbelsteenConsoleView();
        DobbelsteenSwingView dsv = new DobbelsteenSwingView();

        // @TODO Luisteren naar wijzigingen in het model
        
        // Wordt normaliter getriggerd door een event uit de UI
        ds.dobbel();
    }

}
