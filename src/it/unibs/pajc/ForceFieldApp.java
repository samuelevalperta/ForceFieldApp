package it.unibs.pajc;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.EventQueue;

public class ForceFieldApp extends JFrame {

    private PnlForceField MainPanel = new PnlForceField();

    public ForceFieldApp() {
        setTitle("Title");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        add(MainPanel);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ForceFieldApp frame = new ForceFieldApp();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
