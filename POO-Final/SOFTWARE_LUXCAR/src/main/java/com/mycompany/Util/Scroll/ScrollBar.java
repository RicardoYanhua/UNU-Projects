package com.mycompany.Util.Scroll;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

public class ScrollBar extends JScrollBar {

    public ScrollBar(Color scrollColor) {
        setUI(new ModernScrollBarUI(scrollColor));
        setPreferredSize(new Dimension(3, 3));
        setOpaque(false);
        setUnitIncrement(20);
    }
}
