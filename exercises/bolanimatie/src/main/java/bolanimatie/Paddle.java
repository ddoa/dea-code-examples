package bolanimatie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Paddle extends JPanel implements MouseMotionListener {
    public static final int WIDTH = 50;
    public static final int HEIGHT = 10;
    public static final int MARGIN_FROM_BOTTOM = 30;

    private BolAnimatie bolAnimatie;
    private int xPos;
    private int yPos;

    public Paddle(BolAnimatie bolAnimatie){
        this.bolAnimatie = bolAnimatie;
        this.yPos = bolAnimatie.SIZE - MARGIN_FROM_BOTTOM;
        this.xPos = bolAnimatie.SIZE - WIDTH;
    }

    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(xPos, yPos, WIDTH, HEIGHT);
    }

    public void mouseDragged(MouseEvent e) {}

    public void mouseMoved(MouseEvent e) {
        if (e.getX() >= 0 && e.getX() < bolAnimatie.SIZE - WIDTH)
            this.xPos = e.getX();
        repaint();
    }


    public boolean collides(double xPosBal, double yPosBal) {
        Point centerOfBall = new Point((int)xPosBal+10, (int)yPosBal+10);
        return centerOfBall.x >= xPos && centerOfBall.x <= xPos + WIDTH && Math.abs(centerOfBall.y-yPos) <= 15 ;
    }
}
