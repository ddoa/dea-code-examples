package observer.pattern;

import observer.CourseRecord;
import observer.LayoutConstants;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

/**
 * This class represents a pie chart view of a vector of data. Uses the Observer
 * pattern.
 */
@SuppressWarnings("serial")
public class PieChartObserver extends JPanel implements Observer {
	/**
	 * Creates a BarChartObserver object
	 *
	 * @param courseData
	 */
	public PieChartObserver(Vector<CourseRecord> courseData) {
		this.courseData = courseData;
		this.setPreferredSize(new Dimension(2 * LayoutConstants.xOffset
				+ (LayoutConstants.barSpacing + LayoutConstants.barWidth)
				* this.courseData.size(), LayoutConstants.graphHeight + 2
				* LayoutConstants.yOffset));
		this.setBackground(Color.white);
	}

	/**
	 * Paint method
	 * 
	 * @param g
	 *            a Graphics object on which to paint
	 */
	public void paint(Graphics g) {
		super.paint(g);
		double startAngle = 0.0;
		double total = getTotalNumberOfStudents(courseData);
		for (int i = 0; i < courseData.size(); i++) {
			int radius = 100;
			CourseRecord record = courseData.elementAt(i);
			double ratio = (record.getNumOfStudents() / total) * 360.0;
			g.setColor(LayoutConstants.courseColours[i % LayoutConstants.courseColours.length]);
			g.fillArc(LayoutConstants.xOffset, LayoutConstants.yOffset, 2 * radius, 2 * radius, (int) startAngle, (int) ratio);
			startAngle += ratio;
		}
	}

	private double getTotalNumberOfStudents(Vector<CourseRecord> courseDataList) {
		double total = 0;
		for(CourseRecord courseData:courseDataList)
		{
			total += courseData.getNumOfStudents();
		}
		return total;
	}

	/**
	 * Informs this observer that the observed CourseData object has changed
	 * 
	 * @param o
	 *            the observed CourseData object that has changed
	 */
	public void update(Observable o, Object arg) {
		CourseRecord courseRecord = (CourseRecord) arg;

		updateRecordWhenFoundOrElseAddRecord(courseRecord);

		// this.courseData = (Vector<CourseRecord>) arg;

		this.setPreferredSize(new Dimension(2 * LayoutConstants.xOffset
				+ (LayoutConstants.barSpacing + LayoutConstants.barWidth)
				* this.courseData.size(), LayoutConstants.graphHeight + 2
				* LayoutConstants.yOffset));
		this.revalidate();
		this.repaint();
	}

	private void updateRecordWhenFoundOrElseAddRecord(CourseRecord courseRecord) {
		boolean found = false;
		for(int i=0;i< courseData.size();i++)
		{
			CourseRecord cr = courseData.elementAt(i);
			if (cr.getName().equals(courseRecord.getName()))
			{
				courseData.set(i, courseRecord);
				found = true;
			}
		}
		if (!found) courseData.add(courseRecord);
	}

	private Vector<CourseRecord> courseData;
}