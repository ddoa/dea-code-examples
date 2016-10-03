/**
 * Created by Michel Koolwaaij on 29-09-16.
 */
public class Kiwi  {
    private double prijs;
    public Kiwi(boolean metSchil) {
        if (metSchil){
            prijs = 2.0;
        } else {
            prijs = 5.0;
        }
    }

    public double getPrijs() {
        return prijs;
    }
}
