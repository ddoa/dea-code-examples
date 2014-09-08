package nl.ddoa.example.dice;


import java.awt.Container;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author rodmidde
 *
 */
public class DobbelsteenSwingView extends JFrame 
{
    private int dobbelwaarde;

    public DobbelsteenSwingView()
    {
        setLocation(500, 500);
        setSize(100, 100);
        setVisible(true);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    }

    public void setDobbelwaarde(int waarde)
    {
        this.dobbelwaarde = waarde;
    }

    public void showMe()
    {
        Container ctr = this.getContentPane();
        URL fileLoc = ClassLoader.getSystemResource(dobbelwaarde + ".jpg");
        JLabel jl = new JLabel(new ImageIcon(fileLoc));
        ctr.add(jl);
        validate();
    }
}
