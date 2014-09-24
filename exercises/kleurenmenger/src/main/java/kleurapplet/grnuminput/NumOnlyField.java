package kleurapplet.grnuminput;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.Vector;

/**
 * Class NumOnlyField assist the main components of the grnuminput package.
 * It provides a TextField with number checking features. It tells its users of changes
 * using the NumberListener interface.
 */


class NumOnlyField extends TextField 
	  implements KeyListener, FocusListener
{	private double waarde;
	private double initw;				// initial value
	private double minw;	
	private double maxw;
	private int decimals;				// number of decimals
	private long truncator;			// intermediate when fixing decimals
	private double fact;				// = Math.pow(10,decimals)
	private DecimalFormat df;

	private boolean enabled = true;
	private static Color enabledValueColor = Color.black;
	private static Color disabledValueColor = Color.gray;
	
	private Vector listeners;			// too much, there will be only one
	
	public NumOnlyField(double mn, double mx, double val, int dec)
	{	super();
		addKeyListener(this);
		addFocusListener(this);
		listeners = new Vector();
		
		setBackground(Color.white);
		setForeground(enabledValueColor);
		
		waarde = val;
		initw = val;
		minw = mn;
		maxw = mx;
		decimals = dec;
		fact = Math.pow(10,decimals);
		String dfstring;					// create template-string for number formatting
		if ( dec == 0 )
		{	dfstring = "0";
		} else
		{	dfstring = "0.";
			for ( int i=0; i<dec; i++ )		// append zero for every decimal
			{	dfstring = dfstring.concat("0");
			}
		}
		df = new DecimalFormat(dfstring);
		int mnl = df.format(minw).length();	// determine width, will be the max of
		int mxl = df.format(maxw).length();	// lengths minw and maxw + 1
		setColumns(Math.max(mnl, mxl)+1);
		setValue(val);					// sets Text, needs df
	}

	public void addNumberListener(NumberListener l)
	{	listeners.addElement(l);
	}
	
	private void tellListeners()				// passes empty string name!!!
	{	for ( int i=0; i<listeners.size(); i++ )
		{	( (NumberListener)listeners.elementAt(i) ).numberChanged("", waarde);
		}
	}
	
	// Public methods: enable, set-, getValue....
	
	public void setEnabled(boolean b)
	{	enabled = b;
		setEditable(b);
		if ( b )
		{	setForeground(enabledValueColor);
		} else
		{	setForeground(disabledValueColor);
		}
	}

	public void setValue(double newval)
	{	if ( newval > maxw )
		{ 	waarde = maxw;
		} else if (newval < minw )
		{ 	waarde = minw;
		} else
		{ 	waarde = setDecimals(newval);		// truncate 
		}
		setText( df.format(waarde) );
	}

	public double getValue()
	{	return waarde;
	}
	
	// private help methods: convert string to number, 
	// truncate number to required number of decimals
	
	private double setDecimals(double val)			// returns val, truncated to
	{	truncator = Math.round( val*fact );		// required number of decimals
		return ((double)truncator) / fact;
	}

	private void processTextChange(String s)
	{	try						// no need to test 'enabled', user can't type then
		{	Number f = df.parse( s.trim() );
			double w = f.doubleValue();
			if ( w < minw )
			{   throw new NumberFormatException("getal te klein");
			}
			if ( w > maxw )
			{   throw new NumberFormatException("getal te groot");
			}
			w = setDecimals(w);
			if ( w != waarde )				// only when value changed!
			{	waarde = w;
				setText( df.format(waarde) );
				tellListeners();
			}
		}
		catch (Exception exc)
		{	setText( df.format(waarde) );
			// just reset previous input
		}
	}
	
	public void checkValue()
	{	processTextChange( getText() );
	}

	// Listeners, KeyListener (check out adapters later, compiler freeze on first try!!! 
	
	public void keyReleased(KeyEvent e)
	{	if ( e.getKeyCode() == KeyEvent.VK_ENTER )		// Is it 'virtual key' Enter?
		{	processTextChange( getText() );
		}
	}
	
	public void keyTyped(KeyEvent e)
	{ 	// don't react
	}
	
	public void keyPressed(KeyEvent e)
	{ 	// don't react
	}
			
	// Listeners, FocusListener 
	public void focusLost(FocusEvent e)
	{	if ( !e.isTemporary() )
		{	processTextChange( getText() );
		}
	}
	
	public void focusGained(FocusEvent e)
	{ 	// don't react
	}
	

}
	


    
