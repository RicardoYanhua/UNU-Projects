package com.mycompany.Option.Glasspanepopup;


import java.awt.*;

/**
 * @author Raven
 */
public class FrameModalLayout implements LayoutManager {

    public LayoutManager getOldOtherComponentLayout() {
        return oldOtherComponentLayout;
    }

    public void setOtherComponent(Component otherComponent, LayoutManager oldOtherComponentLayout) {
        this.otherComponent = otherComponent;
        this.oldOtherComponentLayout = oldOtherComponentLayout;
    }

    private final Component component;
    private final Component contentPane;
    private final Component snapshot;

    private Component otherComponent;
    private LayoutManager oldOtherComponentLayout;

    public FrameModalLayout(Component component, Component contentPane, Component snapshot) {
        this.component = component;
        this.contentPane = contentPane;
        this.snapshot = snapshot;
    }

    @Override
    public void addLayoutComponent(String name, Component comp) {
    }

    @Override
    public void removeLayoutComponent(Component comp) {
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        synchronized (parent.getTreeLock()) {
            return new Dimension(0, 0);
        }
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        synchronized (parent.getTreeLock()) {
            return new Dimension(0, 0);
        }
    }

    @Override
    public void layoutContainer(Container parent) {
        synchronized (parent.getTreeLock()) {
            Insets insets = parent.getInsets();
            int x = insets.left;
            int y = contentPane.getY();
            int width = parent.getWidth() - (insets.left + insets.right);
            int height = contentPane.getHeight();
            component.setBounds(x, y, width, height);
            snapshot.setBounds(x, y, width, height);

            // do layout other component
            if (otherComponent != null) {
                int fw = parent.getWidth() - (insets.left + insets.right);
                int fh = parent.getHeight() - (insets.top + insets.bottom);
                otherComponent.setBounds(insets.left, insets.top, fw, fh);
            }
        }
    }

}
