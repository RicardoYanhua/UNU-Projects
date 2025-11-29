/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Swing;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author ricar
 */
public class Panel extends JPanel {

    public Panel() {
        
        setLayout(new MigLayout("wrap,fillx,insets 7 10 7 10,gapy 50", "[fill,center][fill]", "[fill]"));
        JPanel pan = new JPanel();
        pan.setBackground(Color.red);
        JPanel pan1 = new JPanel();
        pan1.setBackground(Color.GREEN);
        JPanel pan2 = new JPanel();
        pan2.setBackground(Color.YELLOW);
        
        add(pan,"width 100::200,h 70!");
        add(pan1,"width 100!");
        add(pan2,"width 100!,h 100!");
        //revalidate();
        //repaint();

        putClientProperty(FlatClientProperties.STYLE, ""
                + "arc: 15 "
        );

    }

}
