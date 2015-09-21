package observer;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

/**
 	Represents some constants for the drawing of graphs in this example.
*/
public class LayoutConstants {

	public static final int xOffset = 350;

	public static final int yOffset = 30;

	public static final int graphHeight = 210;

	public static final int maxValue = 100;

	public static final int barHeight = 200;

	public static final int barWidth = 50;

	public static final int barSpacing = 20;

	public static final Color[] courseColours = { Color.BLUE, Color.RED,
			Color.YELLOW, Color.GREEN, Color.BLACK, Color.CYAN, Color.MAGENTA,
			Color.ORANGE, Color.PINK };
	
	public static void paintBarChartOutline(Graphics g, int noOfBars) {
		g.setColor(Color.black);
		g.drawString("Num of Students", LayoutConstants.xOffset - 120, 150);
		g.drawLine(LayoutConstants.xOffset, LayoutConstants.yOffset,
				LayoutConstants.xOffset, LayoutConstants.graphHeight
						+ LayoutConstants.yOffset);
		g.drawLine(LayoutConstants.xOffset, LayoutConstants.graphHeight
				+ LayoutConstants.yOffset, LayoutConstants.xOffset
				+ (LayoutConstants.barSpacing + LayoutConstants.barWidth)
				* noOfBars, LayoutConstants.graphHeight
				+ LayoutConstants.yOffset);
	}
}
