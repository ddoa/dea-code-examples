package nl.ddoa.example.dice;

import java.util.Observable;
import java.util.Observer;

public class DobbelsteenConsoleView implements Observer {
    private int dobbelWaarde;

    public DobbelsteenConsoleView() {
    }

    public void setDobbelwaarde(int waarde) {
        this.dobbelWaarde = waarde;
    }

    public void showMe() {
        switch (dobbelWaarde) {
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

    public void update(Observable o, Object arg) {
        if (arg instanceof Dobbelsteen) {
            this.setDobbelwaarde(((Dobbelsteen) arg).getWaarde());
            this.showMe();
        }
    }
}
