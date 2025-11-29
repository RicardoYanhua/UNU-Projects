package com.mycompany.Menu_4;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.mycompany.Scroll.ScrollPaneWin11;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

public class Menu extends JPanel {

    private int index = -1;
    private int IconSize = 20;
    private final List<EventMenuSelected> events = new ArrayList<>();

    public Menu() {
        init();
    }

    private void init() {
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        JScrollPane scroll = createScroll();
        panelMenu = createPanelMenu();
        scroll.setViewportView(panelMenu);
        scroll.getViewport().setOpaque(false);
        scroll.setViewportBorder(null);
        add(scroll);
        addTitle("MAIN");
        addMenuItem(new ModelMenuItem(new FlatSVGIcon("svg/user.svg", IconSize, IconSize), "Dashboard"));
        addTitle("WEB APPS");
        addMenuItem(new ModelMenuItem(new FlatSVGIcon("svg/user.svg", IconSize, IconSize), "Email", "Inbox", "Read", "Compose"));
        addMenuItem(new ModelMenuItem(new FlatSVGIcon("svg/user.svg", IconSize, IconSize), "Chat"));
        addMenuItem(new ModelMenuItem(new FlatSVGIcon("svg/user.svg", IconSize, IconSize), "Calendar"));
        addTitle("COMPONENT");
        addMenuItem(new ModelMenuItem(new FlatSVGIcon("svg/user.svg", IconSize, IconSize), "UI Kit", "Accordion", "Alerts", "Badges", "Breadcrumbs", "Buttons", "Button group"));
        addMenuItem(new ModelMenuItem(new FlatSVGIcon("svg/user.svg", IconSize, IconSize), "Advanced UI", "Cropper", "Owl Carousel", "Sweet Alert"));
        addMenuItem(new ModelMenuItem(new FlatSVGIcon("svg/user.svg", IconSize, IconSize), "Forms", "Basic Elements", "Advanced Elements", "SEditors", "Wizard"));
        addMenuItem(new ModelMenuItem(new FlatSVGIcon("svg/user.svg", IconSize, IconSize), "Charts", "Apex", "Flot", "Peity", "Sparkline"));
        addMenuItem(new ModelMenuItem(new FlatSVGIcon("svg/user.svg", IconSize, IconSize), "Table", "Basic Tables", "Data Table"));
        addMenuItem(new ModelMenuItem(new FlatSVGIcon("svg/user.svg", IconSize, IconSize), "Icons", "Feather Icons", "Flag Icons", "Mdi Icons"));
        addTitle("PAGES");
        addMenuItem(new ModelMenuItem(new FlatSVGIcon("svg/user.svg", IconSize, IconSize), "Special Pages", "Blank page", "Faq", "Invoice", "Profile", "Pricing", "Timeline"));
        addMenuItem(new ModelMenuItem(new FlatSVGIcon("svg/user.svg", IconSize, IconSize), "Authentication", "Login", "Register"));
        addMenuItem(new ModelMenuItem(new FlatSVGIcon("svg/user.svg", IconSize, IconSize), "Error", "404", "500"));
    }
    
     private JScrollPane createScroll() {
        ScrollPaneWin11 ScrolllPanaelMenu = new ScrollPaneWin11(Color.BLUE,false);
        ScrolllPanaelMenu.setBorder(null);
        ScrolllPanaelMenu.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        ScrolllPanaelMenu.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panelMenu = createPanelMenu();
        ScrolllPanaelMenu.setViewportView(panelMenu);
        ScrolllPanaelMenu.getViewport().setOpaque(false);
        ScrolllPanaelMenu.setViewportBorder(null);
        return ScrolllPanaelMenu;
    }

   
    private JPanel createPanelMenu() {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        menuLayout = new MigLayout("wrap,fillx,inset 0,gapy 0", "[fill]");
        panel.setLayout(menuLayout);

        return panel;
    }

    private JPanel createMenuItem(ModelMenuItem item) {
        MenuItem menuItem = new MenuItem(item, ++index, menuLayout);
        menuItem.addEvent(new EventMenuSelected() {
            @Override
            public void menuSelected(int index, int indexSubMenu) {
                if (!menuItem.isHasSubMenu() || indexSubMenu != 0) {
                    clearSelected();
                    setSelectedIndex(index, indexSubMenu);
                }
            }
        });
        return menuItem;
    }

    private void runEvent(int index, int indexSubMenu) {
        for (EventMenuSelected event : events) {
            event.menuSelected(index, indexSubMenu);
        }
    }

    //  Public Method
    public void addMenuItem(ModelMenuItem menu) {
        panelMenu.add(createMenuItem(menu), "h 35!");
    }

    public void addTitle(String title) {
        JLabel label = new JLabel(title);
        label.setBorder(new EmptyBorder(15, 20, 5, 5));
        label.setFont(label.getFont().deriveFont(Font.BOLD));
        label.setForeground(new Color(170, 170, 170));
        panelMenu.add(label);
    }

    public void addSpace(int size) {
        panelMenu.add(new JLabel(), "h " + size + "!");
    }

    public void setSelectedIndex(int index, int indexSubMenu) {
        for (Component com : panelMenu.getComponents()) {
            if (com instanceof MenuItem) {
                MenuItem item = (MenuItem) com;
                if (item.getIndex() == index) {
                    item.setSelectedIndex(indexSubMenu);
                    runEvent(index, indexSubMenu);
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
}
