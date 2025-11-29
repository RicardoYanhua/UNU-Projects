package Util.Glasspanepopup;

import java.awt.Color;
import java.awt.Component;

public class DefaultOption implements Option {

    private float animate;

    @Override
    public String getLayout(Component parent, float animate) {
        float an;
        int window_width = 1200;

        an = 20f / window_width;

        float space = 0.5f + an - (animate * an);
        return "pos 0.5al " + space + "al";
    }

    @Override
    public boolean useSnapshot() {
        return true;
    }

    @Override
    public boolean closeWhenPressedEsc() {
        return true;
    }

    @Override
    public boolean closeWhenClickOutside() {
        return true;
    }

    @Override
    public boolean blockBackground() {
        return true;
    }

    @Override
    public Color background() {
        return new Color(255, 255, 255);
    }

    @Override
    public float opacity() {
        return 0.1f;
    }

    @Override
    public int duration() {
        return 200;
    }

    @Override
    public float getAnimate() {
        return animate;
    }

    @Override
    public void setAnimate(float animate) {
        this.animate = animate;
    }
}
