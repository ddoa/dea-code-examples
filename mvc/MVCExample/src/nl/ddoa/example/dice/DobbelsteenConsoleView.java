package nl.ddoa.example.dice;

/**
 * 
 * @author rodmidde
 *
 */
public class DobbelsteenConsoleView
{
    private int dobbelWaarde;

    public void setDobbelWaarde(int dobbelWaarde)
    {
        this.dobbelWaarde = dobbelWaarde;
    }
    
    public void showMe()
    {
        switch (dobbelWaarde)
        {
        case 1:
            System.out.println();
            System.out.println("  *  ");
            System.out.println();
            break;
        case 2:
            System.out.println("    *");
            System.out.println("     ");
            System.out.println("*    ");
            break;
        case 3:
            System.out.println("    *");
            System.out.println("  *  ");
            System.out.println("*    ");
            break;
        case 4:
            System.out.println("*   *");
            System.out.println("     ");
            System.out.println("*   *");
            break;
        case 5:
            System.out.println("*   *");
            System.out.println("  *  ");
            System.out.println("*   *");
            break;
        case 6:
            System.out.println("*   *");
            System.out.println("*   *");
            System.out.println("*   *");
            break;
        default:
            break;
        }
    }
}
