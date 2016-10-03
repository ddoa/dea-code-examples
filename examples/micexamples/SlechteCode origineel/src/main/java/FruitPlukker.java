/**
 * Created by Michel Koolwaaij on 29-09-16.
 */
public class FruitPlukker {

    private String fruit;

    public FruitPlukker(String fruit) {
        this.fruit = fruit;
    }

    public void printFruit(){
        double p=0;
        Banaan b=null;
        Appel a=null;
        Kiwi k=null;
        Tomaat t=null;

        switch (fruit){
            case "BANAAN": b = new Banaan();
                p=b.getPrijs();
                break;
            case "APPEL": a = new Appel();
                p=a.getPrijs();
                break;
            case "KIWIMETSCHIL": k = new Kiwi(true);
                p=k.getPrijs();
                break;
            case "KIWIZONDERSCHIL": k = new Kiwi(false);
                p=k.getPrijs();
                break;
            case "TOMAAT": t = new Tomaat();
                p=t.getPrijs();
                break;
            default: System.out.println ("Wheeee");
                break;
        }

        if (a==null&&k==null&&b==null&&t==null) return;

        // Prijs berekenen
        p = p + (p * 0.1);

        if (p > 5){
            p = p + (p * 0.2);
        }

        // string samenstellen
        String s = "Fruit: "+ fruit +" kost "+p;

        System.out.println(s);
    }

}
