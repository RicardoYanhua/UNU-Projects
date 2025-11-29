package Menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javaswingdev.GoogleMaterialDesignIcon;
import Util.Scroll.ScrollBar;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

public class Menu_2 extends JPanel {

    private int index = -1;
    private final List<EventMenuSelected> events = new ArrayList<>();

    public Menu_2() {
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
        
        
        addTitle("HOME");
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.DASHBOARD, "Lobby"));

        addSpace(20);
        addTitle("CONTROL");
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.STORE, "Inventario" , "asdasd"));
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.CHECK_BOX_OUTLINE_BLANK, "Producto"));
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.PERSON, "Cliente"));
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.LOCAL_SHIPPING, "Proveedor"));
        addSpace(20);
        addTitle("CONTROL");
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.STORE, "Inventario"));
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.CHECK_BOX_OUTLINE_BLANK, "Producto"));
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.PERSON, "Cliente"));
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.LOCAL_SHIPPING, "Proveedor"));
        addSpace(20);
        addTitle("CONTROL");
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.STORE, "Inventario"));
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.CHECK_BOX_OUTLINE_BLANK, "Producto"));
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.PERSON, "Cliente"));
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.LOCAL_SHIPPING, "Proveedor"));

        addSpace(20);
        addTitle("COMPROBANTE DE PAGO");
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.NOTE, "Nota de Venta"));
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.DESCRIPTION, "Boleta Electronico"));
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.DESCRIPTION, "Factura Electronico"));

        addSpace(20);
        addTitle("ESTADISTICA");
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.PIE_CHART, "Chart"));
        addSpace(20);

    }

    private JScrollPane createScroll() {
        JScrollPane scroll = new JScrollPane();
        scroll.setBorder(null);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBar(new ScrollBar());
        return scroll;
    }

    private JPanel createPanelMenu() {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        menuLayout = new MigLayout("wrap,fillx,inset 15,gapy 0", "[fill]");
        panel.setLayout(menuLayout);

        return panel;
    }
    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        GradientPaint degradado = new GradientPaint( getWidth() / 2, 0, getBackground() ,getWidth() / 2, getHeight(), getForeground());
        g2.setPaint(degradado);

        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 0, 0);

        super.paintComponent(g);
    }
    
    

    private JPanel createMenuItem(ModelMenuItem item) {
        MenuItem menuItem = new MenuItem(item, ++index, menuLayout);
       

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

    //  Public Method
    public void addMenuItem(ModelMenuItem menu) {
        panelMenu.add(createMenuItem(menu), "h 35!");

    }

    public void addTitle(String title) {
        JLabel label = new JLabel(title);
        label.setBorder(new EmptyBorder(15, 10, 5, 5));
        label.setFont(label.getFont().deriveFont(Font.BOLD));
        label.setForeground(new Color(245, 245, 255));
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
                    item.setSelectedIndex(index);
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

}
