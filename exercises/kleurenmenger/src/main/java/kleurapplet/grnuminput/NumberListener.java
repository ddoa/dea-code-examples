package kleurapplet.grnuminput;

/** 
 * Listener interface for objects who listen to NumberSlider and/or NumberArrow components.
 *
 * @author Paul Bergervoet
 * @version 3.1  22 februari 1999
 * @since JDK 1.1
 */

public interface NumberListener
{	
/**
 * Invoked when a number value has been changed.
 * The component passes on the new value and also the 'parameter name', so that Listeners
 * who listen to several components using a single 'numberChanged' method can
 * distinguish between them.
 *
 * @param name The name of the numinput component.
 * @param val The new value.
 */
	public void numberChanged(String name, double val);
}
