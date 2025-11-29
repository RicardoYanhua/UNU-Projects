package com.mycompany.Swing.Menu.auxiliary;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class ButtonItem extends JButton {

    private final Color TextColorSelected = new Color(15, 71, 128);
    private final Color TextColorDefaultForeground = new Color(255, 255, 255);

    public static boolean OpenMenu = false;

    private final Color IcontColorSelected = new Color(15, 71, 128);
    private final Color IconColorDefault = new Color(255, 255, 255);

    private final Color BackgroundColorSelected = new Color(253, 229, 93);
    private final Color BackgroundColorDefault = new Color(20, 92, 166);
    private boolean mouseEnter;
    private FlatSVGIcon Icon;
    private Color IconColorFilter = IconColorDefault;
    private FlatSVGIcon.ColorFilter colorFilter = new FlatSVGIcon.ColorFilter(color -> IconColorFilter);

    public ButtonItem() {
        init();
    }

    public Color getIconColorFilter() {
        return IconColorFilter;
    }

    public void setIconColorFilter(Color IconColorFilter) {

        this.IconColorFilter = IconColorFilter;
    }

    public FlatSVGIcon getIcon() {
        return Icon;
    }

    public void setIcon(FlatSVGIcon Icon) {
        this.Icon = Icon;
        this.Icon.setColorFilter(this.colorFilter);
    }

    private void init() {
        setContentAreaFilled(false);
        setHorizontalAlignment(JButton.LEFT);
        setForeground(TextColorDefaultForeground);

        setBorder(new EmptyBorder(0, 28, 0, 0));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {

                if (isSelected()) {
                    setForeground(TextColorSelected);
                    setIconColorFilter(IcontColorSelected);

                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!isSelected()) {
                    setForeground(TextColorDefaultForeground);
                    setIconColorFilter(IconColorDefault);
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (isSelected()) {

            if (OpenMenu) {
                g2.setColor(BackgroundColorSelected);
                g2.fillRoundRect(10, 0, getWidth() - 10, 45, 15, 15);
            } else {
                g2.setColor(BackgroundColorSelected);
                g2.fillRoundRect(10, 0, 65, getHeight(), 15, 15);
            }
            g2.dispose();
        } else {

            if (OpenMenu) {
                g2.setColor(BackgroundColorDefault);
                g2.fillRoundRect(10, 0, getWidth() - 10, 45, 15, 15);
            } else {
                g2.setColor(BackgroundColorDefault);
                g2.fillRoundRect(10, 0, 65, getHeight(), 15, 15);
            }

            g2.dispose();
        }
        super.paintComponent(g);
    }

    @Override
    public void setSelected(boolean b) {
        super.setSelected(b);
        if (b || mouseEnter) {
            setForeground(TextColorSelected);
            setIconColorFilter(IcontColorSelected);
        } else {
            setForeground(TextColorDefaultForeground);
            setIconColorFilter(IconColorDefault);
        }
    }

}
