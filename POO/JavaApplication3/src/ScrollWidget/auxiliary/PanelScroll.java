package ScrollWidget.auxiliary;

import ScrollWidget.auxiliary.WrapLayout;
import java.awt.Color;
import javax.swing.JPanel;

public class PanelScroll extends JPanel {

    public PanelScroll() {
        setBackground(new Color(240,240,255));
        setLayout(new WrapLayout(WrapLayout.LEFT, 5, 5));
    }
}
