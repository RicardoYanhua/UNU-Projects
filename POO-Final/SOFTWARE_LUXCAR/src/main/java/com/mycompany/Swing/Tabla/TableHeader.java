package com.mycompany.Swing.Tabla;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class TableHeader extends JLabel {

    private String Text = "";
    private boolean ActivedBorder = true;
    private Color BorderColor;
    private int Round = 0;
    private Font font  =  new Font("sansserif", Font.BOLD, 15);

    public TableHeader(String text) {
        super(text);
        Text = text;
        setOpaque(false);
        setFont(font);
        setFocusable(false);

    }
    public void setFontHeader(Font font){
        setFont(font);
    }

    public void setBorderColor(Color b) {
        BorderColor = b;
    }

    public void setBorderActived(boolean b) {
        ActivedBorder = b;
    }

    public void setRound(int r) {
        Round = r;
    }

    @Override
    protected void paintComponent(Graphics grphcs) {

        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (!ActivedBorder) {
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth() - 1, getHeight(), Round, Round);
        } else {
            g2.setColor(getBackground());
            g2.fillRect(0, 0, getWidth() - 1, getHeight());
        }

        if (ActivedBorder) {
            g2.setColor(BorderColor);
            g2.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
        }

        g2.setColor(getForeground());
        FontMetrics fm = g2.getFontMetrics();
        switch (getHorizontalAlignment()) {
            case SwingConstants.CENTER:
                g2.drawString(Text, ((getWidth() - fm.stringWidth(Text)) / 2), getHeight() / 2 + fm.getAscent() / 2 - 2);
                break;
            case SwingConstants.LEFT:
                g2.drawString(Text, 10, getHeight() / 2 + fm.getAscent() / 2 - 2);
                break;
            case SwingConstants.RIGHT:
                g2.drawString(Text, getWidth() - fm.stringWidth(Text) - 10, getHeight() / 2 + fm.getAscent() / 2 - 2);
                break;
            default:
                g2.drawString(Text, ((getWidth() - fm.stringWidth(Text)) / 2), getHeight() / 2 + fm.getAscent() / 2 - 2);
                break;
        }
    }

}
