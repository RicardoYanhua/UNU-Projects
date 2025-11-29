package com.mycompany.Option;

import java.awt.*;

/**
 * This class for modal dialog option
 *
 * @author Raven
 */
public class Option {

    public static Option getDefault() {
        return new Option();
    }

    public LayoutOption getLayoutOption() {
        return layoutOption;
    }

    public BackgroundClickType getBackgroundClickType() {
        return backgroundClickType;
    }

    public boolean isAnimationEnabled() {
        return animationEnabled;
    }

    public boolean isCloseOnPressedEscape() {
        return closeOnPressedEscape;
    }

    public Color getBackground() {
        return background;
    }

    

    

    public float getOpacity() {
        return opacity;
    }

    public int getDuration() {
        return duration;
    }

    private LayoutOption layoutOption = LayoutOption.getDefault();
    private BackgroundClickType backgroundClickType = BackgroundClickType.CLOSE_MODAL;
    private boolean animationEnabled = true;
    private boolean closeOnPressedEscape = true;
    private Color background;
    private float opacity = 0.5f;
    private int duration = 250;

    private Option(LayoutOption layoutOption, BackgroundClickType backgroundClickType, boolean animationEnabled, boolean closeOnPressedEscape, Color background, float opacity, int duration) {
        this.layoutOption = layoutOption;
        this.backgroundClickType = backgroundClickType;
        this.animationEnabled = animationEnabled;
        this.closeOnPressedEscape = closeOnPressedEscape;
        this.background = background;
        this.opacity = opacity;
        this.duration = duration;
    }

    public Option() {
    }

    public Option setLayoutOption(LayoutOption layoutOption) {
        this.layoutOption = layoutOption;
        return this;
    }

    public Option setBackgroundClickType(BackgroundClickType backgroundClickType) {
        this.backgroundClickType = backgroundClickType;
        return this;
    }

    public Option setAnimationEnabled(boolean animationEnabled) {
        this.animationEnabled = animationEnabled;
        return this;
    }

    public Option setCloseOnPressedEscape(boolean closeOnPressedEscape) {
        this.closeOnPressedEscape = closeOnPressedEscape;
        return this;
    }

    public Option setBackground(Color color) {
        this.background = color;
        return this;
    }

  

   

    public Option setOpacity(float opacity) {
        this.opacity = opacity;
        return this;
    }

    public Option setDuration(int duration) {
        this.duration = duration;
        return this;
    }

    public enum BackgroundClickType {
        CLOSE_MODAL, BLOCK, NONE
    }

    public Option copy() {
        return new Option(layoutOption.copy(), backgroundClickType, animationEnabled, closeOnPressedEscape, background, opacity, duration);
    }
}
