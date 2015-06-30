package kleurapplet.grnuminput;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

/**
 * class Slider: draws bar & slider
 */

class Slider extends Canvas
 {	double huidigePos;						// position, value from 0 to 1
	private Color enabledSliderColor = Color.red;
	private Color disabledSliderColor = Color.gray;
	Color sliderColor = enabledSliderColor;
	Dimension dd;

	public Slider(double initp)					// initial position
	{	setSize(100,20);					// for now fixed size (not needed for functionality)
		dd = getSize();
		huidigePos = initp;
	}

	public void paint(Graphics g)
	{	dd = getSize();
		g.drawRect(1, 7, dd.width-2, 6);		// bar
		g.setColor(sliderColor);
		g.fillOval((int)Math.round( huidigePos*(dd.width-7) ), 1, 7, 20);		
									// -7 because of width oval (=7)
	}
	
	protected double getPos( int mousepos )		// working width of bar for scaling MouseEvents
	{	return ((double)(mousepos-3)) / (dd.width-7);
	}

	protected void setSlide(double p)	// set position to p, 0<=p<=1
	{	huidigePos = p;
		repaint();
	}

	public void setEnabled(boolean ena)
	{	if ( ena )						// Color only, NumberSlider handles events
		{	sliderColor = enabledSliderColor;
		} else
		{	sliderColor = disabledSliderColor;
		}
		repaint();						// eigenlijk onnodig
	}

	protected void setDisabledSliderColor(Color c)
	{	disabledSliderColor = c;				// call to repaint() in NumberSlider
	}

	protected void setEnabledSliderColor(Color c)
	{	enabledSliderColor = c;
	}

 }

/**
 * NumberSlider is a component for input of numbers. It consists of a 
 * TextField for keyboards entry of numbers plus a 'slider' that can be dragged
 * across a bar representing the possible range of values.
 * <br>
 * Values are doubles, precision can be indicated by specifying the number of decimals.
 * The meaning of the number must be specified by 'parameter name' also on display.
 * Also, a units label can be given.
 * <br>
 * Display:
 * <p><tt>
 * 		| Parameter name		|
 *		| min				max	|
 *		|   --- Slider ---------  |
 *		|   Value 	 Units		|
 *
 * </tt><p>
 * Use is like standard AWT-components:
 * <br>
 *	- Listener must implement interface NumberListener
 * <br>
 *	- Listeners register with 'addNumberListener'
 * <br>
 *	- void numberChanged(String, double) will be called by NumberSlider
 *		(String == parameter name, double holds new value
 *
 * @author Paul Bergervoet, additions bij Joost Rommes
 * @version 3.2  18 februari 2000
 * @since JDK 1.1
 *
 * @see NumberListener
 */

public class NumberSlider extends Panel
		implements NumberListener, MouseListener, MouseMotionListener
 {	private double waarde;				// current value
	private double initw;				// initial value
	private double minw;				// smallest value
	private double maxw;				// biggest value
	private String grootheid;			// name of parameter
	private String eenheid;			// unit name

	private int decimals;				// number of decimals
	private long truncator;			// intermediate when fixing decimals
	private double fact;				// = Math.pow(10,decimals)

	private NumOnlyField wtekst;
	private Slider wschuif; 
	private Label lgh;
	private Label leh;
	private Label lmin;
	private Label lmax;

	private boolean enabled = true;
	private Vector listeners;

/**
 * Constructor for NumberSlider.
 *
 * @param mn minimum value of the NumberSlider
 * @param mx maximum value of the NumberSlider
 * @param w  initial value
 * @param dec number of decimals (precision) of value
 * @param gh  parameter name
 * @param eh  parameter unit
 */
	public NumberSlider(	double mn, double mx, // min, max
					double w, 			// value == initial value
					int dec,			// number of decimals
					String gh, String eh	// parameter name and unit
				)
	{	minw = mn;
		maxw = mx;
		waarde = w;
		initw = w;
		decimals = dec;
		grootheid = gh;
		eenheid = eh;
		fact = Math.pow(10,decimals);
		listeners = new Vector();
		
		// set up lay out
		GridBagLayout gridbag = new GridBagLayout();	// set up data-area
		GridBagConstraints c = new GridBagConstraints();
		setLayout(gridbag);

		// component, Label: parameter name
		c.gridwidth = GridBagConstraints.REMAINDER; 	// line holding Name
		c.anchor = GridBagConstraints.WEST; 			// left
		lgh = new Label(grootheid);
		gridbag.setConstraints(lgh, c);
		add(lgh);

		// components, Labels: min and max value, show rounded values, min and max should be ints
		c.gridwidth = 1;
		c.anchor = GridBagConstraints.WEST; 			// left
		lmin = new Label( String.valueOf((int)Math.round(minw)) );
		gridbag.setConstraints(lmin, c);
		add(lmin);
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.anchor = GridBagConstraints.EAST; 			// right
		lmax = new Label( String.valueOf((int)Math.round(maxw)) );
		gridbag.setConstraints(lmax, c);
		add(lmax);
		
		// component slide bar
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.HORIZONTAL;
		wschuif = new Slider( valToPos(waarde) );
		wschuif.addMouseListener(this);
		wschuif.addMouseMotionListener(this);
		gridbag.setConstraints(wschuif, c);
		add(wschuif);

		// components: NumOnlyField and Units
		c.gridwidth = 1 ;	
		c.insets = new Insets(5, 0, 0, 0); 		// space above TextField
		c.anchor = GridBagConstraints.EAST; 
		c.fill = GridBagConstraints.NONE;
		wtekst = new NumOnlyField( minw, maxw, waarde, dec);	// no width! (columns)
		wtekst.setEnabled(true);				// also sets color....
		wtekst.addNumberListener(this);			// NumberSlider listen to NumOnlyField!
		gridbag.setConstraints(wtekst, c);
		add(wtekst);	
		c.anchor = GridBagConstraints.WEST; 		// put left
		leh = new Label(eenheid);
		gridbag.setConstraints(leh, c);
		add(leh);
	}

 /**
  * Add a listener to the NumberSlider.
  *
  * @param l NumberListener to be added.
  */
	public void addNumberListener(NumberListener l)
	{	listeners.addElement(l);
	}
	
	private void tellListeners()
	{	for ( int i=0; i<listeners.size(); i++ )
		{	( (NumberListener)listeners.elementAt(i) ).numberChanged(grootheid, waarde);
		}
	}
	
/* calculate slider position from value.
 */
	private double valToPos(double val)			// 0<=p<=1
	{   	return (val-minw) / (maxw-minw);
	}

/* calculate value from slider position.
 */
	private double setDecimals(double val)			// returns val, truncated to
	{	truncator = Math.round( val*fact );		// required number of decimals
		return ((double)truncator) / fact;
	}

/* calculate value and slider position from mouse position.
 */
	private void processSliderChange(int mousepos)
	{	double relpos = wschuif.getPos(mousepos);
		if (relpos < 0 ) { relpos = 0; }
		if (relpos > 1 ) { relpos = 1; }
		waarde = setDecimals( minw + relpos*(maxw-minw) );
		wschuif.setSlide( valToPos(waarde) );
		wtekst.setValue( waarde );
		tellListeners();
	}
	
// Public methods: Enable/disable, setValue, getValue

/**
 * Enables or disables the NumberSlider. When disabled it becomes disabledSliderColor.
 *
 * @param b True to enable the textfield, False to disable it.
 */
	public void setEnabled(boolean b)
	{	enabled = b;
		wtekst.setEnabled(b);
		wschuif.setEnabled(b);
		repaint();
	}

/**
 * Find out if the NumberSlider is enabled.
 *
 * @return boolean indicating if the component is enabled.
 */
 	public boolean isEnabled()
 	{	return enabled;
 	}

/**
 * Sets the value to be displayed in the number textfield & slider.
 * <br>
 * Note: Does not tell listeners!!!!
 *
 * @param newval The new double value to be displayed.
 */
	public void setValue(double newval)
	{	if ( newval > maxw )
		{ 	waarde = maxw;
		} else if (newval < minw )
		{ 	waarde = minw;
		} else
		{ 	waarde = setDecimals(newval);		// truncate 
		}
		wtekst.setValue( waarde );
		wschuif.setSlide( valToPos(waarde) );
	}

/**
 * SetValue with int value.
 *
 * @param newval The new int value to be displayed.
 *
 * @see NumberSlider#setValue(double newval)
 */
	public void setValue(int newval)
	{	setValue((double)newval);
	}

/**
 * Resets the value of the NumberSlider to the initial value.
 * <br>
 * Note: Does not tell listeners!!!!
 *
 */
	public void setInitValue()
	{	setValue(initw);
	}

 /**
  * The value of the NumberSlider is returned as double.
  *
  * @return value of NumberSlider.
  */
	public double getValue()
	{	return waarde;
	}

 /**
  * Force NumberSlider to check whether the value has changed.
  *
  * NumberSlider will check the number value of the textfield. If the value is different
  * from the current value, the Listeners will be informed in the normal way, using numberChanged.
  * <br>
  * Note: useful when you don't want to force the user to press ENTER after typing a new value. 
  * When the user moves to another textfield after typing something, this is noticed through focusLost().
  * However, when the user moves the mouse and clicks a button, no loss of keyboard focus occurs.
  * In this case you may want to check if the value has changed explicitly.
  */
	public void checkValue()
	{	wtekst.checkValue();
	}

// overriding default settings

/**
 * Sets the number of colums of the textfield of the NumberSlider.
 * <br>
 * Note: by default the width of the TextField will be calculated from the min and max values:
 * number of digits needed + 1.
 *
 * @param n New number of colums of the textfield.
 */
	public void setColumns(int n)
	{	wtekst.setColumns(n);
	}
	
/**
  * Set the color the handle must have when the NumberSlider is disabled.
  *
  * @param c The preferred color.
  */
	public void setDisabledSliderColor(Color c)
	{	wschuif.setDisabledSliderColor( c);
		repaint();
	}

/**
  * Set the color the handle must have when the NumberSlider is enabled.
  *
  * @param c The preferred color.
  */
	public void setEnabledSliderColor(Color c)
	{	wschuif.setEnabledSliderColor( c);
		repaint();
	}
	
/**
 * Set the font of the labels: parameter name, min, max and units.
 *
 * @param f The preferred font.
 */
 	public void setLabelFont(Font f)
	{	lgh.setFont( f);
		leh.setFont( f);
		lmin.setFont( f);
		lmax.setFont( f);
		repaint();
	}

/**
 * Set the font of the value in the TextField
 *
 * @param f The preferred font.
 */
 	public void setValueFont(Font f)
	{	wtekst.setFont( f);
		repaint();
	}

/**
 * Set the foregroundcolor of the labels: parameter name, min, max and units.
 *
 * @param c The preferred color.
 */
 	public void setLabelForeground( Color c )
	{	
	    lgh.setForeground( c ) ;
		leh.setForeground( c ) ;
		lmin.setForeground( c ) ;
		lmax.setForeground( c ) ;
		repaint();
	}

/**
 * Set the color of the value in the TextField
 *
 * @param c The preferred color.
 */
 	public void setValueColor( Color c )
	{	
	    wtekst.setForeground( c ) ;
		repaint();
	}

// Event handling
  // 1. MouseListener

/**
 * Invoked when mouse button is pressed on the NumberSlider.
 * Move slide to click location.
 */
	public void mousePressed(MouseEvent e)
	{	processSliderChange( e.getX() );
		// System.out.println("pressed, new value is "+waarde );
	}

 /**
  * Invoked when mouse button is released over the NumberSlider.
  * Does nothing.
  */
	public void mouseReleased(MouseEvent e)
	{	// do nothing
	}
	
 /**
  * Invoked when mouse button is clicked on the NumberSlider.
  * Does nothing.
  */
	public void mouseClicked(MouseEvent e)
	{	// do nothing
	}
	
 /**
  * Invoked when mouse has entered the NumberSlider.
  * Does nothing.
  */
	public void mouseEntered(MouseEvent e)
	{	// do nothing
	}
	
 /**
  * Invoked when mouse has exited  the NumberSlider.
  * Does nothing.
  */
	public void mouseExited(MouseEvent e)
	{	// do nothing
	}
	
  // 2. MouseMotionListener
  
 /**
  * Invoked when mouse is dragged the NumberSlider.
  * Move slide to drag location.
  */
	public void mouseDragged(MouseEvent e)
	{	processSliderChange( e.getX() );
		// System.out.println("dragged, new value is "+waarde );
	}
	
 /**
  * Invoked when mouse is moved the NumberSlider.
  * Does nothing.
  */
	public void mouseMoved(MouseEvent e)
	{	// do nothing
	}
	  
// 3. NumberListener: react to change in NumOnlyField
 
/**
 * Invoked when the number in the textfield has changed.
 *
 * @param s Dummy string: name of the NumOnlyTextField.
 * @param w Double value of the textfield.
 */
	public void numberChanged(String s, double w)	// String s doesn't matter, it's the NumOnlyField
	{	waarde = w;
		wschuif.setSlide( valToPos(waarde) );
		tellListeners();
	}
}
