package kleurapplet.grnuminput;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.Vector;

/**
  * class ArrowCanvas
  * Helper class for NumberArrow, displays picture of arrows and handles events.
  */

class ArrowCanvas extends Canvas
 {	private Color disabledArrowColor = Color.gray;
	private Color enabledArrowColor = Color.red;
	private Color activeArrowColor = Color.green;
	private Dimension dd;
	
	private Polygon up;
	private boolean upActive = false;
	private Polygon down;
	private boolean downActive = false;
	private boolean enabled = true;

 /**
  * Constructor for ArrowCanvas
  * Creates Canvas with arrows drawn on it.
  */
	public ArrowCanvas()						// initial position
	{	dd = new Dimension(19, 23);			// fixed size.... ok?
		setSize(dd);	
		// triangles for up and down arrows
		up = new Polygon();
		up.addPoint(10, 2);
		up.addPoint(3, 10);
		up.addPoint(17, 10);
		down = new Polygon();
		down.addPoint(3, 13);
		down.addPoint(17, 13);
		down.addPoint(10, 21);
	}

// painting the arrows

	private void paintPolygon(Graphics g, Polygon p, boolean active)
	{	if ( enabled )
		{	if ( active )
			{	g.setColor(activeArrowColor);
			} else
			{	g.setColor(enabledArrowColor);
			}
		} else
		{	g.setColor(disabledArrowColor);
		}
		g.drawPolygon(p);				// draw and fill, will they look the same
		g.fillPolygon(p);				// using fill only, the up-arrow will be smaller!
	}
			
	public void paint(Graphics g)
	{	g.setColor(Color.black);
		g.drawRect(0, 0, dd.width-1, dd.height-1);
		g.setColor(Color.white);
		g.fillRect(1, 1, dd.width-2, dd.height-2);		// background
		paintPolygon(g, up, upActive);
		paintPolygon(g, down, downActive);
	}

// Set and get by NumberArrow

	protected int getArrow(int clicky)			// threshold down arrow
	{	int dir = 0;						// no direction (yet)
		if ( clicky > 12 )
		{	downActive = true;
			dir = -1;
			repaint();
		} else if ( clicky < 11 )
		{	upActive = true;
			dir = 1;
			repaint();
		}
		return dir;
	}
	
	protected void setInactive()
	{	upActive = false;
		downActive = false;
		repaint();
	}

/**
  * Enable or disable the NumberArrow depending on the value of b.
  * An enabled NumberArrow can respond to user input and generates events.
  * NumberArrows are enabled initially by default.
  *
  * @param b If true this NumberArrow is enabled, otherwise the arrow is disabled.
  * 
  */
	public void setEnabled(boolean b)
	{	enabled = b;
	}
	
	protected void setDisabledArrowColor(Color c)
	{	disabledArrowColor = c;				// call to repaint() in NumberArrow
	}

	protected void setEnabledArrowColor(Color c)
	{	enabledArrowColor = c;
	}
	
	protected void setActiveArrowColor(Color c)
	{	activeArrowColor = c;
	}

 }	// class ArrowCanvas
 
/**
  * class ArrowRunner
  * Helper class for NumberArrow, it will time how long arrow is being 'mouseheld'
  * and generates 'kicks' for NumberArrow 
  */
 class ArrowRunner extends Thread
 {	private NumberArrow owner;
 	private boolean running = true;
 
 	public ArrowRunner(NumberArrow o)
 	{	owner = o;
 		setDaemon(true);
 	}
 	
 	public void run()
 	{	int teller = 0;				// count how many times the thread 'kicks'
 		try
 		{	sleep(500);
 		} catch ( InterruptedException e ) { }
 		while (running)				// will be stopped by release of mouse!
 		{	teller++;				// increase count (first kick will be 1)
 			owner.kick(teller);		// pass on count (so NumberArrow can increase steps
 			try					// while 'mouse hold' lasts
 			{	sleep(250);
 			} catch ( InterruptedException e ) { }
 		}
 	}
 	
 	public void neatstop()
 	{	running = false;
 	}
 }

/**
 * 
 * NumberArrow is a component for input of numbers. It consists of a 
 * TextField for keyboards entry of numbers plus up and down arrows
 * to increase/decrease the number value in the TextField.
 * <br>
 * Values are doubles, precision can be indicated by specifying the number of decimals.
 * The step size on arrowclick can be specified. 
 * <br>
 * When an arrow is being held, the steps will increase to give an accelaration in the
 * change of value. This accelaration can be limited by setting 'MaxFactor' of steps.
 * The meaning of the number must be specified by 'parameter name' also on display.
 * Also, a units label can be given.
 * <br>
 * Display:
 * <p><tt>
 * 		| Parameter name	|
 *		|  ×  Value 	 Units	|
 *
 * </tt><p>
 * Value is Textfield holding value, × is picture with up- and down-arrow.
 * 
 * Use is like standard AWT-components:
 * <br>
 *	- Listener must implement interface NumberListener
 * <br>
 *	- Listeners register with 'addNumberListener'
 * <br>
 *	- void numberChanged(String, double) will be called by NumberArrow
 *		(String == parameter name, double holds new value
 *
 * @author Paul Bergervoet
 * @version 3.1  5 maart 1999
 * @since JDK 1.1
 *
 * @see NumberListener
 */

public class NumberArrow extends Panel
		implements NumberListener, MouseListener
 {	private double waarde;				// current value
	private double initw;				// initial value
	private double minw;				// smallest value
	private double maxw;				// biggest value
	private double stap;				// size of step +/- at arrowclick
	private String grootheid;			// name of parameter
	private String eenheid;			// unit name

	private int decimals;				// number of decimals
	private long truncator;			// intermediate when fixing decimals
	private double fact;				// = Math.pow(10,decimals)

	private NumOnlyField wtekst;
	private ArrowCanvas warrow; 
	private ArrowRunner arwr;
	private int dir;					// 1 = up, -1 = down
	private int maxStepFactor;

	private Label lgh;
	private Label leh;
	private boolean enabled = true;
	private Vector listeners;

/**
 * Constructor for NumberArrow.
 * Creates a NumberArrow with the two arrows left of the textfield.
 *
 * @param mn minimum value of the numberarrow
 * @param mx maximum value of the numberarrow
 * @param w  initial value
 * @param s  step of the number arrow (change of value at arrow click)
 * @param dec number of decimals (precision) of value
 * @param gh  parameter name
 * @param eh  parameter unit
 */
	public NumberArrow(	double mn, double mx, 	// min, max
					double w, 				// value == initial value
					double s,				// step+/-
					int dec,				// number of decimals
					String gh, String eh		// parameter name and unit
				)
	{	minw = mn;
		maxw = mx;
		waarde = w;
		initw = w;
		stap = s;
		maxStepFactor = 1;					// default, see second constructor 
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

		// components: Arrows, NumOnlyField and Units
		c.gridwidth = 1;	
		c.insets = new Insets(5, 0, 0, 0); 		// space above TextField
		c.anchor = GridBagConstraints.EAST; 
		c.fill = GridBagConstraints.NONE;
		warrow = new ArrowCanvas();
		warrow.addMouseListener(this);
		gridbag.setConstraints(warrow, c);
		add(warrow);
		wtekst = new NumOnlyField( minw, maxw, waarde, dec);	// no width! (columns)
		wtekst.setEnabled(true);				// also sets color....
		wtekst.addNumberListener(this);			// NumberArrow listen to NumOnlyField!
		gridbag.setConstraints(wtekst, c);
		add(wtekst);	
		c.anchor = GridBagConstraints.WEST; 		// put left
		c.fill = GridBagConstraints.HORIZONTAL;
		leh = new Label(eenheid);
		gridbag.setConstraints(leh, c);
		add(leh);
	}
	
 /**
  * Add a listener to the numberarrow.
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
	
	private double setDecimals(double val)			// returns val, truncated to
	{	truncator = Math.round( val*fact );		// required number of decimals
		return ((double)truncator) / fact;
	}
	
// Public methods: Enable/disable, setValue, getValue

/**
 * Enables or disables the NumberArrow. When disabled it becomes disabledArrowColor.
 *
 * @param b True to enable the textfield, False to disable it.
 */
	public void setEnabled(boolean b)
	{	enabled = b;
		wtekst.setEnabled(b);
		wtekst.repaint();
		warrow.setEnabled(b);
		warrow.repaint();
	}
	
/**
 * Find out if the NumberArrow is enabled.
 *
 * @return boolean indicating if the component is enabled
 */
 	public boolean isEnabled()
 	{	return enabled;
 	}

/**
 * Sets the value to be displayed in the number textfield.
 * Note: Does not tell listeners!!!!
 *
 * @param newval The new double value to be displayed.
 */
	public void setValue(double newval)			// NB: Does not tell listeners!!!!
	{	if ( newval > maxw )
		{ 	waarde = maxw;
		} else if (newval < minw )
		{ 	waarde = minw;
		} else
		{ 	waarde = setDecimals(newval);		// truncate 
		}
		wtekst.setValue( waarde );
	}

/**
 * SetValue with int value.
 *
 * @param newval The new int value to be displayed.
 *
 * @see NumberArrow#setValue(double newval)
 */
	public void setValue(int newval)				// int-waarde zetten
	{	setValue((double)newval);				// 
	}
	
 /**
  * Resets the value of the NumberArrow to the initial value.
  * Note: Does not tell listeners!!!!
 *
  */
	public void setInitValue()
	{	setValue(initw);
	}

 /**
  * The value of the NumberArrow is returned as double.
  *
  * @return value of NumberArrow.
  */
	public double getValue()
	{	return waarde;
	}

 /**
  * Force NumberArrow to check whether the value has changed.
  *
  * NumberArrow will check the number value of the textfield. If the value is different
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
 * Sets the number of colums of the textfield of the NumberArrow.
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
 * Sets the maximum multiplication factor of the step size to a new value.
 * <br>
 * When the arrow button is pushed in for a longer period the step size
 * is multiplied by an increasing factor: 2, 3, 4 etc..
 * Therefore the number change increases when you hold the number.
 * MaxFactor limits the increase. 
 * <br>
 * Default value is 1, meaning constant step size.
 *
 * @param m New factor value.
 */
 	public void setMaxFactor(int m)
	{	maxStepFactor = m;
	}

/**
  * Set the color the arrows must have when the NumberArrow is disabled.
  *
  * @param c The preferred color.
  * 
  */
	public void setDisabledArrowColor(Color c)
	{	warrow.setDisabledArrowColor( c);
		repaint();
	}

/**
  * Set the color the arrows must have when the NumberArrow is enabled, but not touched by the mouse.
  *
  * @param c The preferred color.
  */
	public void setEnabledArrowColor(Color c)
	{	warrow.setEnabledArrowColor( c);
		repaint();
	}
	
/**
  * Set the color of an active arrow, that is: someone is pressing the mouse on the arrow.
  *
  * @param c The preferred color.
  */
	public void setActiveArrowColor(Color c)
	{	warrow.setActiveArrowColor( c);
		repaint();
	}

/**
 * Set the font of the labels: parameter name and units.
 *
 * @param f The preferred font.
 */
 	public void setLabelFont(Font f)
	{	lgh.setFont( f);
		leh.setFont( f);
		repaint();
	}

/**
 * Set the font of the value in the TextField.
 *
 * @param f The preferred font.
 */
 	public void setValueFont(Font f)
	{	wtekst.setFont( f);
		repaint();
	}

/**
 * Set the foregroundcolor of the labels: parameter name and units.
 *
 * @param c The preferred color.
 */
 	public void setLabelForeground( Color c )
	{	lgh.setForeground( c ) ;
		leh.setForeground( c ) ;
		repaint();
	}

/**
 * Set the color of the value in the TextField
 *
 * @param c The preferred color.
 */
 	public void setValueColor( Color c )
	{    	wtekst.setForeground( c ) ;
		repaint();
	}

// Event handling
 // 1. MouseListener

	private void stopThread()
	{	if ( arwr !=null )
		{	arwr.neatstop();
			warrow.setInactive();
			arwr = null;
		}
	}

/**
 * Invoked by timer when mouse is held on an arrow.
 *
 * @param count Counter of kicks, for accelaration.
 */
	protected void kick(int count)								// mouse held
	{	setValue(waarde + dir*Math.min(count, maxStepFactor)*stap);	// 1 or -1 times count times stap		
		tellListeners();										// count at most 5
	}

/**
 * Invoked when mouse button is pressed on the NumberArrow.
 * Does step and starts ArrowRunner.
 */
	public void mousePressed(MouseEvent e)
	{	dir = warrow.getArrow( e.getY() );		// get height of click to decide up or down
		if ( enabled && dir!=0 )
		{	stopThread();					// make sure!
			setValue(waarde + dir*stap);		// 1 or -1 times stap
			tellListeners();
			arwr = new ArrowRunner(this);		// will kick as long as mouse is held
			arwr.start();
		}
		// System.out.println("pressed, new value is "+waarde );
	}

 /**
  * Invoked when mouse button is released over the NumberArrow.
  * stops ArrowRunner.
  */
	public void mouseReleased(MouseEvent e)
	{	stopThread();
	}
	
 /**
  * Invoked when mouse button is clicked on the NumberArrow.
  * Does nothing.
  */
	public void mouseClicked(MouseEvent e)
	{	// do nothing
	}
	
 /**
  * Invoked when mouse has entered the NumberArrow.
  * Does nothing.
  */
	public void mouseEntered(MouseEvent e)
	{	// do nothing
	}
	
 /**
  * Invoked when mouse has exited  the NumberArrow.
  * stops ArrowRunner.
  */
	public void mouseExited(MouseEvent e)
	{	stopThread();
	}
	
 // 2. NumberListener: react to change in NumOnlyField
 
/**
 * Invoked when the number in the textfield has changed.
 *
 * @param s Dummy string: name of the NumOnlyTextField.
 * @param w Double value of the textfield.
 */
	public void numberChanged(String s, double w)		// dummy String from NumOnlyField
	{	waarde = w;
		// no need to do anything with arrows
		tellListeners();
	}
}
 
