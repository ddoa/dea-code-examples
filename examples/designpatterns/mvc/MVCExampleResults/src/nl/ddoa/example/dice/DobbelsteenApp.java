package nl.ddoa.example.dice;

public class DobbelsteenApp
{
    public void start()
    {
        Dobbelsteen ds = new Dobbelsteen();
        DobbelsteenConsoleView dcv = new DobbelsteenConsoleView();
        DobbelsteenSwingView dsv = new DobbelsteenSwingView();
        ds.addObserver(dcv);
        ds.addObserver(dsv);        
        ds.dobbel();
    }

    public static void main(String[] args)
    {
        DobbelsteenApp da = new DobbelsteenApp();
        da.start();
    }

}
