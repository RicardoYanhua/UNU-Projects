package Swing.table.AuxTable;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class TableHeader extends JLabel {

    private boolean ActivedBorder = false;
    private String Text = "";

    public TableHeader(String text, boolean actived) {
        super(text);
        setOpaque(true);
        setBackground(Color.WHITE);
        setFont(new Font("sansserif", 1, 16));
        ActivedBorder = actived;
        Text = text;

        setForeground(new Color(102, 102, 102));
        if (ActivedBorder) {
            setForeground(new Color(255, 0, 0));
        }

        setBorder(new EmptyBorder(20, 5, 7, 5));

    }

    @Override
    protected void paintComponent(Graphics grphcs) {

        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //Dibujar Bordes
        if (ActivedBorder) {
            super.paintComponent(grphcs);
            g2.setColor(new Color(0, 0, 0));
            g2.fillRect(0, 0, getWidth() - 1, getHeight() - 1);

            g2.setColor(new Color(255, 255, 255));

            Insets ins = getInsets();
            FontMetrics fm = g2.getFontMetrics();

            g2.drawString(Text, ((getWidth() - fm.stringWidth(Text)) / 2), getHeight() / 2 + fm.getAscent() / 2 - 2);

        } else {
            super.paintComponent(grphcs);
            g2.setColor(new Color(0, 0, 0));
            g2.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);
        }

    }
}
