package it.unibs.pajc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;

public class PnlForceField extends JPanel implements MouseMotionListener {
    private double angle = 0;
    public PnlForceField(){
        this.addMouseMotionListener(this);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        int w = getWidth();
        int h = getHeight();

        for (int x = 25; x <= w; x+=25) {
            for (int y = 25; y < h; y+=25) {
                angle = Math.atan2(mousePosition.y-y, mousePosition.x-x);
                fillArrow(g2, x, y, 20, angle);
            }
        }

    }

    protected void fillArrow(Graphics2D g2, int x, int y, int size, double angle){
        Path2D path = new Path2D.Double();

        path.moveTo(0, 0);
        path.lineTo(-size, size/3);
        path.lineTo(-size, -size/3);
        path.closePath();

        AffineTransform t = new AffineTransform();

        t.translate(x, y);
        t.rotate(angle);

        g2.fill(t.createTransformedShape(path));
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    private Point mousePosition = new Point(0,0);
    @Override
    public void mouseMoved(MouseEvent e) {
        mousePosition = e.getPoint();
        repaint();
    }
}
