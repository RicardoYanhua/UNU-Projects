package com.mycompany.Swing.Menu;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.mycompany.Swing.Menu.auxiliary.EventMenuSelected;
import com.mycompany.Swing.Menu.auxiliary.MenuItem;
import com.mycompany.Swing.Menu.auxiliary.ModelMenuItem;
import com.mycompany.Util.Scroll.ScrollBar;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

public class Menu extends JPanel {

    private int index = -1;
    private final List<EventMenuSelected> events = new ArrayList<>();
    
    
    private int AllIconSize = 30;

    public Menu() {
        init();
    }

    private void init() {
        setOpaque(false);
        setLayout(new BorderLayout());
        JScrollPane scroll = createScroll();
        panelMenu = createPanelMenu();
        scroll.setViewportView(panelMenu);
        scroll.getViewport().setOpaque(false);
        scroll.setViewportBorder(null);
        add(scroll);

        addSpace(30);
        addMenuItem(new ModelMenuItem(new FlatSVGIcon("svg/home_icon.svg", AllIconSize, AllIconSize), "Home"));

        
        addSpace(5);
        addMenuItem(new ModelMenuItem(new FlatSVGIcon("svg/Worker.svg", AllIconSize, AllIconSize), "Trabajador"));
        addSpace(5);
        addMenuItem(new ModelMenuItem(new FlatSVGIcon("svg/user.svg", AllIconSize, AllIconSize), "Usuarios"));
        
        addSpace(5);
        addMenuItem(new ModelMenuItem(new FlatSVGIcon("svg/service.svg", AllIconSize, AllIconSize), "Servicios"));
        
        addSpace(5);
        addMenuItem(new ModelMenuItem(new FlatSVGIcon("svg/object.svg", AllIconSize, AllIconSize), "Materiales"));
        addSpace(5);
        addMenuItem(new ModelMenuItem(new FlatSVGIcon("svg/object.svg", AllIconSize, AllIconSize), "Actividad"));
        
    }

    private JScrollPane createScroll() {
        JScrollPane scroll = new JScrollPane();
        scroll.setBorder(null);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBar(new ScrollBar(new Color(253, 229, 93)));

        return scroll;
    }

    private JPanel createPanelMenu() {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        menuLayout = new MigLayout("wrap,fillx,inset 5,gapy 7", "[fill]");
        //menuLayout = new MigLayout("wrap,fillx,inset 15,gapy 7", "[fill]");
        panel.setLayout(menuLayout);

        return panel;
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        GradientPaint degradado = new GradientPaint(getWidth() / 2, 0, getBackground(), getWidth() / 2, getHeight(), getForeground());
        g2.setPaint(degradado);

        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 0, 0);

        super.paintComponent(g);
    }

    public void addMenuItem(ModelMenuItem menu) {
        panelMenu.add(createMenuItem(menu), "h 45!");
    }

    private JPanel createMenuItem(ModelMenuItem modelmenu) {
        MenuItem menuItem = new MenuItem(modelmenu, ++index, menuLayout);
        menuItem.addEvent(new EventMenuSelected() {
            @Override
            public void menuSelected(int index) {
                clearSelected();
                setSelectedIndex(index);
            }
        });
        return menuItem;
    }

    private void runEvent(int index) {
        for (EventMenuSelected event : events) {
            event.menuSelected(index);
        }
    }

    public void addTitle(String title) {
        JLabel label = new JLabel(title);
        label.setBorder(new EmptyBorder(15,10, 5, 5));
        Font newFont = new Font("SansSerif", Font.BOLD, 16);
        label.setFont(newFont);
        label.setForeground(new Color(255, 255, 255));
        panelMenu.add(label);
    }

    public void addSpace(int size) {
        panelMenu.add(new JLabel(), "h " + size + "!");
    }

    public void setSelectedIndex(int index) {
        for (Component com : panelMenu.getComponents()) {
            if (com instanceof MenuItem) {
                MenuItem item = (MenuItem) com;
                if (item.getIndex() == index) {
                    item.setSelected();
                    runEvent(index);
                    break;
                }
            }
        }
    }

    public void clearSelected() {
        for (Component com : panelMenu.getComponents()) {
            if (com instanceof MenuItem) {
                MenuItem item = (MenuItem) com;
                item.clearSelected();
            }
        }
    }

    public void addEvent(EventMenuSelected event) {
        events.add(event);
    }

    private MigLayout menuLayout;
    private JPanel panelMenu;

    public int getAllIconSize() {
        return AllIconSize;
    }

    public void setAllIconSize(int AllIconSize) {
        this.AllIconSize = AllIconSize;
    }
    
    

}
