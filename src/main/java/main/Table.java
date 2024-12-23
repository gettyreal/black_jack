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
        g2.drawLine(gp.maxWidht / 2 - 125, gp.maxHeight / 2, gp.maxWidht / 2 + 125, gp.maxHeight / 2);

        //draws table rules text
        g2.setFont(gp.courier16);
        drawText(g2, "BlackJack pays 3 to 2", gp.maxWidht / 2, gp.maxHeight / 2 - 10);
        drawText(g2, "Insurance pays 2 to 1", gp.maxWidht / 2, gp.maxHeight / 2 + 20);
    }

    public void drawText(Graphics2D g2, String text, int x, int y) {
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        x = x - length / 2;
        g2.drawString(text, x, y);
    }
}
