package main;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

public class Table implements Colors {
    GamePanel gp;

    public Table(GamePanel gp) {
        this.gp = gp;
    }

    public void draw(Graphics2D g2) {
        
        //draws table dividing line
        g2.setColor(Colors.white);
        g2.setStroke(new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2.drawLine(gp.maxWidht / 2 - 100, gp.maxHeight / 2, gp.maxWidht / 2 + 100, gp.maxHeight / 2);
    }
}
