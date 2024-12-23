package main;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Colors{
    //input handlers
    public KeyHandler keyH = new KeyHandler();

    //fonts
    Font courier;
    Font courier16;

    //constructor
    public GamePanel() {
        setPanelAttributes();
        setFonts();
    }

    private void setPanelAttributes() {
        this.setPreferredSize(new Dimension(900, 600));
        this.setBackground(Colors.tableGreen);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    private void setFonts() {
        // fonts
        try {
            InputStream is = getClass().getResourceAsStream("/fonts/CourirPrime-Bold.ttf");
            this.courier = Font.createFont(Font.TRUETYPE_FONT, is);
            this.courier16 = courier16.deriveFont(Font.BOLD, 16f);
            
            is.close();
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }
}
