package com.mycompany.Menu_3;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.mycompany.Ripple.RippleEffect;
import com.mycompany.Shadow.ShadowRenderer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import net.miginfocom.swing.MigLayout;

public class ButtonItemMenu extends JButton {

    private int Shadow_size = 3;
    private float Shadow_Opacity = 0.0f;
    private Color ShadowColor = new Color(0, 0, 0);

    private final Color TextColorDefaultForeground = new Color(0, 0, 0);
    public boolean IsSelected = false;
    private final Color ColorIconDefault;
    private final Color ColorIconSelected = new Color(255, 255, 255);
    private final int Round = 7;
    private final int Index;
    private final FlatSVGIcon Icon;
    private boolean MouseEntered = false;
    private final RippleEffect Button_ClickedEffect = new RippleEffect(this);

    public ButtonItemMenu(FlatSVGIcon icon, Color colorFilter,String text, int index) {
        this.Index = index;
        this.ColorIconDefault = colorFilter;
        this.Icon = icon;
        this.Icon.setColorFilter(new FlatSVGIcon.ColorFilter(color -> ColorIconDefault));

        setForeground(ColorIconDefault);
        setIcon(icon);
        setText(text);
        setHorizontalAlignment(SwingConstants.LEFT);
        setMargin(new Insets(0,10,0,20));
        setPreferredSize(new Dimension(220, 220));
        setMinimumSize(new Dimension(220, 220));
        setIconTextGap(15);

        init();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                MouseEntered = true;
            }

            @Override
            public void mouseExited(MouseEvent e) {
                MouseEntered = false;
                
            }

        });

    }

    private void init() {
        setContentAreaFilled(false);
        setForeground(TextColorDefaultForeground);
        setLayout(new MigLayout("wrap,fillx,insets 30"));
    }

    @Override
    protected void paintComponent(Graphics gra) {
        Graphics2D g2 = (Graphics2D) gra;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int size = Shadow_size * 2;
        int X = Shadow_size;
        int Y = Shadow_size;
        int Width = getWidth() - size;
        int Height = getHeight() - size;

        BufferedImage img = new BufferedImage(Width, Height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Create Content
        if (IsSelected) {
            g.setColor(new Color(0, 0, 0));
            g.fillRoundRect(0, 0, Width, Height, Round, Round);

            this.Icon.setColorFilter(new FlatSVGIcon.ColorFilter(color -> ColorIconSelected));

        } else {
            this.Icon.setColorFilter(new FlatSVGIcon.ColorFilter(color -> ColorIconDefault));
            g.setColor(new Color(255, 255, 255));
            g.fillRoundRect(0, 0, Width - 1, Height - 1, Round, Round);
            if (MouseEntered) {
                g.setColor(new Color(220, 220, 220, 70));
                g.fillRoundRect(0, 0, Width, Height, Round, Round);
            }
        }
        //  Create Shadow
        ShadowRenderer render = new ShadowRenderer(Shadow_size, Shadow_Opacity, ShadowColor);
        g2.drawImage(render.createShadow(img), 0, 0, null);

        g2.drawImage(img, X, Y, null);

        Area area = new Area(new RoundRectangle2D.Double(X, Y, Width, Height, Round, Round));
        Button_ClickedEffect.reder(gra, area);
        super.paintComponent(gra);

    }

    public void addEvent(EventMenuSelected event) {
        this.addActionListener((ActionListener) event);
    }

    @Override
    public void setSelected(boolean b) {
        super.setSelected(b);
        this.IsSelected = b;
        
        if(b){
            setForeground(ColorIconSelected);
            Shadow_Opacity = 0.3f;
        }else{
            setForeground(ColorIconDefault);
            Shadow_Opacity = 0f;
        }

    }

    public int getIndex() {
        return Index;
    }

}
