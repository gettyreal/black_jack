package main;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable, Colors{
    //input handlers
    public KeyHandler keyH = new KeyHandler();

    //panel assets
    public int maxWidht = 900;
    public int maxHeight = 600;

    //game assets
    final int fps = 60;
    Table table = new Table(this);

    // game thread
    Thread gameThread; // for clock

    //fonts
    Font courier;
    Font courier16;

    //constructor
    public GamePanel() {
        setPanelAttributes();
        setFonts();
    }

    private void setPanelAttributes() {
        this.setPreferredSize(new Dimension(maxWidht, maxHeight));
        this.setBackground(Colors.tableGreen);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    private void setFonts() {
        // fonts
        try {
            InputStream is = getClass().getResourceAsStream("/fonts/CourierPrime-Bold.ttf");
            this.courier = Font.createFont(Font.TRUETYPE_FONT, is);
            this.courier16 = courier.deriveFont(Font.BOLD, 16f);
            
            is.close();
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    //method to start the game
    //called in main method
    public void startGameThread() {
        gameThread = new Thread(this); // gamepanel passed to thread
        gameThread.start();
    }

    @Override
    public void run() { // game loop = core of the game using sleep method
        double drawInterval = 1000000000 / fps; // 1second : fps = 60fps
        double nextDrawTime = System.nanoTime() + drawInterval; // next fps
    
        while (gameThread != null) { // repeat of the process
            update(); // 1) update information
            repaint(); // call paintComponent , 2) draw on the screen information
    
            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1000000; // convert nano in milli.
                if (remainingTime < 0) {
                    remainingTime = 0; // makes thread not sleep.
                }
                Thread.sleep((long) remainingTime); // pause the game loop
                nextDrawTime += drawInterval; // set new drawtime
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        this.table.draw(g2);
    }
}
