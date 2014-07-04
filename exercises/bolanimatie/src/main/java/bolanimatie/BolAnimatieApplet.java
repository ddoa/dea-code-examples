package bolanimatie;

/*
 * Animatie met stuiterend balletje
 *
 * @author Paul Bergervoet
 *
 */
 
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;

public class BolAnimatieApplet extends JApplet 
{	// Componenten
	BolAnimatie bolanim;
	AnimatieRegelaar animreg;

	// initialize applet
	public void init()
	{	
		setSize(650, 400);
		Container mypane = getContentPane();
		mypane.setLayout(null);

		bolanim = new BolAnimatie();
		bolanim.setLocation(25, 25);		// grootte ster: 350x350
		mypane.add(bolanim);

		animreg = new AnimatieRegelaar(bolanim, new Color(255, 255, 204));
		animreg.setLocation(400, 0);		// grootte regelaar: 250x400
		mypane.add(animreg);
		
		mypane.setBackground(new Color(255, 255, 51));
		setVisible(true);
	}
	
}
