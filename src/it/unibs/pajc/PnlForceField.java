package it.unibs.pajc;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;

public class PnlForceField extends JPanel {
    private double angle = 0;
    public void stepNext(){
        angle+=Math.PI/180;
        repaint();
    }

    public PnlForceField(){
        javax.swing.Timer timer = new Timer(10, e -> stepNext());
        timer.start();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        int w = getWidth();
        int h = getHeight();

        fillArrow(g2, w/2, h/2, 100, angle);

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
}
