package Menu;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javaswingdev.GoogleMaterialDesignIcon;
import javaswingdev.GoogleMaterialIcon;
import javaswingdev.GradientType;
import System.SystemColor;
import Util.Shadow.ShadowRenderer;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class Item extends JButton {

    private final Color mainColor = SystemColor.MAIN_COLOR_2;
    private final int index;
    private Animator animator;
    private GoogleMaterialDesignIcon icon;
    private final boolean mainMenu;
    private boolean mouseEnter;
    private float alpha;

    public Item(boolean mainMenu, int index) {
        this.mainMenu = mainMenu;
        this.index = index;
        init();
    }

    private void init() {
        setContentAreaFilled(false);
        setHorizontalAlignment(JButton.LEFT);
        setForeground(new Color(245, 249, 250));
        if (mainMenu) {
            setBorder(new EmptyBorder(0, 20, 0, 0));
        } else {
            setBorder(new EmptyBorder(0, 70, 0, 0));
        }
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setForeground(mainColor);
                setGoogleIcon(icon);
                if (!mainMenu) {
                    mouseEnter = true;
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!isSelected()) {
                    setForeground(new Color(245, 249, 250));
                    setGoogleIcon(icon);
                }
            }
        });
    }


    
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //createShadow(g);
            if (isSelected()) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                g2.setColor(new Color(255,255,255,10));
                g2.fillRect(0, 0, getWidth(), getHeight());
                
                g2.setPaint(new GradientPaint(0, 3, SystemColor.MAIN_COLOR_1, 3, getHeight() - 6, SystemColor.MAIN_COLOR_2));
                g2.fillRect(0, 0, 6, getHeight());
                g2.dispose();
        }
    }

    public void setGoogleIcon(GoogleMaterialDesignIcon icon) {
        if (icon != null) {
            this.icon = icon;
            setIcon(new GoogleMaterialIcon(icon, GradientType.HORIZONTAL, SystemColor.MAIN_COLOR_1, SystemColor.MAIN_COLOR_2, 19).toIcon());
        }
    }

    @Override
    public void setSelected(boolean b) {
        super.setSelected(b);
        if (b || mouseEnter) {
            setForeground(mainColor);
        } else {
            alpha = 0;
            setForeground(new Color(245, 249, 250));
        }
        setGoogleIcon(icon);
    }

    public Color getMainColor() {
        return mainColor;
    }

    public int getIndex() {
        return index;
    }

    public boolean isMainMenu() {
        return mainMenu;
    }
}
