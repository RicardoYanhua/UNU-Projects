/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Menu;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.mycompany.AvatarIocn.BackgroundImage;
import com.mycompany.Ripple.RippleEffect;
import com.mycompany.Scroll.ScrollPaneWin11;
import com.mycompany.Shadow.ShadowRenderer;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author ricar
 */
public class Menu extends JPanel {

    private JPanel PanelBotones;
    private JPanel Header;
    private JButton ButtonSesion;

    private Color Menu_BackgroundColor_1 = new Color(250, 250, 255);
    private Color Menu_BackgroundColor_2 = new Color(250, 250, 255);
    private Color Menu_ButtonColorIconandTextDefault = new Color(0, 0, 0);
    private Color Menu_ColorSeparator = new Color(170, 170, 170);
    private Color Menu_ScrollColor = new Color(53,53,53);

    private Font Menu_Font = new Font(FlatRobotoFont.FAMILY, Font.BOLD, 13);
    private int Menu_Round = 15;
    private int IconSize = 30;
    private boolean showMenu = true;
    private int IndexButton = -1;
    private int IndexSelected = -2;

    private final List<EventMenuSelected> events = new ArrayList<>();

    public Menu() {
        setOpaque(false);
        setFont(Menu_Font);
        InitLayoutMenu();

        add(CreateHeader(new FlatSVGIcon("svg/logo.svg")));
        add(CreateLine());
        add(CreateScrollMenu());
        addButton(new FlatSVGIcon("svg/user.svg", IconSize, IconSize));
        addButton(new FlatSVGIcon("svg/user.svg", IconSize, IconSize));
        addButton(new FlatSVGIcon("svg/user.svg", IconSize, IconSize));
        addButton(new FlatSVGIcon("svg/user.svg", IconSize, IconSize));
        addButton(new FlatSVGIcon("svg/user.svg", IconSize, IconSize));
        addButton(new FlatSVGIcon("svg/user.svg", IconSize, IconSize));
        addButton(new FlatSVGIcon("svg/user.svg", IconSize, IconSize));
        addButton(new FlatSVGIcon("svg/user.svg", IconSize, IconSize));
        addButton(new FlatSVGIcon("svg/user.svg", IconSize, IconSize));
        addButton(new FlatSVGIcon("svg/user.svg", IconSize, IconSize));
        add(CreateLine());
        add(CreateFooter());

    }

    private void InitLayoutMenu() {
        setLayout(new MigLayout("wrap,fillx, insets 20 0 10 0,gapy 0", "[fill,85:85:85]", "[fill][fill][fill,grow][fill][fill]"));
        setBounds(0, 0, 85, 85);
    }

    public JPanel CreateHeader(Icon icon) {
        JPanel ContentHeader = new JPanel(new MigLayout("wrap 1, fill, insets 5 10 20 10", "[fill,grow]"));
        ContentHeader.setOpaque(false);
        Header = new JPanel();
        Header.setOpaque(false);
        Header.setLayout(new MigLayout("wrap , fill, insets 0", "[fill,grow]", "[fill]"));

        BackgroundImage img = new BackgroundImage();
        img.setBackground(Menu_BackgroundColor_1);
        img.setBackground_Image(icon);
        img.setBackground_ImgMaxMin(false);

        Header.add(img, "w 60:: , h 60!");
        ContentHeader.add(Header);

        return ContentHeader;
    }

    private JScrollPane CreateScrollMenu() {
        ScrollPaneWin11 ScrolllPanaelMenu = new ScrollPaneWin11(Menu_ScrollColor,false);
        ScrolllPanaelMenu.setBorder(null);
        ScrolllPanaelMenu.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        ScrolllPanaelMenu.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        PanelBotones = CreatePanelMenu();
        ScrolllPanaelMenu.setViewportView(PanelBotones);
        ScrolllPanaelMenu.getViewport().setOpaque(false);
        ScrolllPanaelMenu.setViewportBorder(null);
        return ScrolllPanaelMenu;
    }

    private JPanel CreatePanelMenu() {
        JPanel PanelMenu = new JPanel();
        PanelMenu.setOpaque(false);
        PanelMenu.setLayout(new MigLayout("wrap, fillx,insets 10 7 10 7", "[fill]"));
        return PanelMenu;
    }

    private void addButton(FlatSVGIcon icon) {
        ButtonItemMenu itembutton = new ButtonItemMenu(icon, Menu_ButtonColorIconandTextDefault, ++IndexButton);
        itembutton.addActionListener(e -> runEvent(itembutton.getIndex()));
        PanelBotones.add(itembutton, "h 55!");
    }

    public JPanel CreateLine() {
        JPanel panel = new JPanel(new MigLayout("wrap,fillX,insets 3 0 3 0", "[fill]", "[fill]"));
        panel.setOpaque(false);
        JSeparator line = new CustomSeparator(Menu_ColorSeparator);
        panel.add(line);
        return panel;
    }

    public JPanel CreateFooter() {
        JPanel panel = new JPanel(new MigLayout("wrap,fillx,insets 15 15 5 15", "[fill,center]", "[center]"));
        panel.setOpaque(false);

        ButtonSesion = new ButtonSesion();
        panel.add(ButtonSesion, "w 55! , h 55!");
        return panel;
    }

    public void setEventAction(ActionListener event) {
        ButtonSesion.addActionListener(event);
    }

    public void clearSelected() {
        for (Component com : PanelBotones.getComponents()) {
            if (com instanceof ButtonItemMenu) {
                ButtonItemMenu item = (ButtonItemMenu) com;
                item.setSelected(false);
            }
        }
    }

    public void addEvent(EventMenuSelected event) {
        events.add(event);
    }

    private void runEvent(int index) {
        if (index == this.IndexSelected) {
            return;
        }
        clearSelected();
        for (EventMenuSelected event : events) {
            event.MenuSelected(index);
            setSelectedIndex(index);
        }
    }

    public void setSelectedIndex(int index) {
        for (Component com : PanelBotones.getComponents()) {
            if (com instanceof ButtonItemMenu) {
                ButtonItemMenu item = (ButtonItemMenu) com;
                if (item.getIndex() == index) {
                    item.setSelected(true);
                    this.IndexSelected = index;
                    break;
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        GradientPaint gradientPaint = new GradientPaint(
                getWidth() / 2, 0,
                Menu_BackgroundColor_1,
                getWidth() / 2, getHeight(),
                Menu_BackgroundColor_2
        );
        g2.setPaint(gradientPaint);

        g2.fillRoundRect(0, 0, getWidth(), getHeight(), Menu_Round, Menu_Round);

        super.paintComponent(g);
    }

    class CustomSeparator extends JSeparator {

        private Color lineColor;

        public CustomSeparator(Color lineColor) {
            this.lineColor = lineColor;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(lineColor);
            g2.fillRect(0, getHeight() / 2 - 1, getWidth(), 2);
        }

    }

    class ButtonSesion extends JButton {

        private int Round = 15;
        private int Shadow_size = 5;
        private float Shadow_Opacity = 0.5f;
        private boolean MouseEntered = false;
        private Color ShadowColor = new Color(0, 0, 0);
        private Color Background = new Color(38, 38, 38);
        private final RippleEffect Button_ClickedEffect = new RippleEffect(this);

        public ButtonSesion() {
            setOpaque(false);
            setContentAreaFilled(false);
            setIcon(new FlatSVGIcon("svg/login.svg", 35, 35).setColorFilter(new FlatSVGIcon.ColorFilter(color -> new Color(255, 255, 255))));
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

        @Override
        protected void paintComponent(Graphics graphics) {

            Graphics2D g2 = (Graphics2D) graphics;
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
            if (MouseEntered) {
                g.setColor(new Color(51, 51, 51));
                g.fillRoundRect(0, 0, Width, Height, Round, Round);
            } else {
                g.setColor(Background);
                g.fillRoundRect(0, 0, Width, Height, Round, Round);
            }

            //  Create Shadow
            ShadowRenderer render = new ShadowRenderer(Shadow_size, Shadow_Opacity, ShadowColor);
            g2.drawImage(render.createShadow(img), 0, 0, null);

            g2.drawImage(img, X, Y, null);

            Area area = new Area(new RoundRectangle2D.Double(X, Y, Width, Height, Round, Round));
            Button_ClickedEffect.reder(graphics, area);
            super.paintComponent(graphics);

        }

    }

}
