package com.mycompany.Swing.Menu.auxiliary;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

public class MenuItem extends JPanel {

    private final List<EventMenuSelected> events = new ArrayList<>();
    private final int Indice;
    private final Color TextColorSelected = new Color(255, 0, 0);

    public MenuItem(ModelMenuItem menuitem, int Indice, MigLayout layout) {
        this.Indice = Indice;
        init(menuitem);

    }

    private void init(ModelMenuItem menuitem) {
        setOpaque(false);
        setForeground(TextColorSelected);
        setLayout(new MigLayout("wrap,fillx,inset 0", "[fill]", "[fill,45!]"));
        //setLayout(new MigLayout("wrap,fillx,insets 0 10 0 0", "[fill]", "[fill,35!]"));
        ButtonItem menu = new ButtonItem();

        menu.setIcon(menuitem.getIcon());

        menu.setText("        " + menuitem.getMenuName());
        Font newFont = new Font("SansSerif"/*"Arial"*/, Font.BOLD, 16);
        menu.setFont(newFont);

        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                runEvent(Indice);

            }
        });

        add(menu);
    }

    public void addEvent(EventMenuSelected event) {
        this.events.add(event);
    }

    private void runEvent(int index) {
        for (EventMenuSelected evnet : events) {
            evnet.menuSelected(index);
        }
    }

    public int getIndex() {
        return Indice;
    }

    public void clearSelected() {
        setForeground(TextColorSelected);
        for (Component com : getComponents()) {
            ButtonItem item = (ButtonItem) com;
            item.setSelected(false);
        }
    }

    public void setSelected() {

        for (Component com : getComponents()) {
            ButtonItem item = (ButtonItem) com;

            item.setSelected(true);

        }

    }

}
