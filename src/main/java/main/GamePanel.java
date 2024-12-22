package main;

import java.awt.Dimension;
import javax.swing.JPanel;

import java.awt.Color;

public class GamePanel extends JPanel{
    public KeyHandler keyH = new KeyHandler();

    //constructor
    public GamePanel() {
        this.setPreferredSize(new Dimension(500, 350));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
}
