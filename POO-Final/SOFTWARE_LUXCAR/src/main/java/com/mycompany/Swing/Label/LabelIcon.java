package com.mycompany.Swing.Label;

import java.awt.Color;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import javax.swing.Icon;

public class LabelIcon extends javax.swing.JLabel {

    private boolean IconColorFilterActived = false;
    private FlatSVGIcon Icon;
    Color IconColorFilter = new Color(255, 255, 255);
    FlatSVGIcon.ColorFilter colorFilter = new FlatSVGIcon.ColorFilter(color -> IconColorFilter);

    public LabelIcon() {
        setForeground(new Color(80, 80, 80));
    }

    public Icon getIcon() {
        return Icon;
    }

    public void setIcon(FlatSVGIcon Icon) {
        this.Icon = Icon;
        if (IconColorFilterActived) {
            this.Icon.setColorFilter(this.colorFilter);
        }
    }

    public Color getIconColorFilter() {
        return IconColorFilter;
    }

    public void setIconColorFilter(Color IconColorFilter) {

        this.IconColorFilter = IconColorFilter;
    }

    public boolean isIconColorFilterActived() {
        return IconColorFilterActived;
    }

    public void setIconColorFilterActived(boolean IconColorFilterActived) {
        this.IconColorFilterActived = IconColorFilterActived;
    }

}
