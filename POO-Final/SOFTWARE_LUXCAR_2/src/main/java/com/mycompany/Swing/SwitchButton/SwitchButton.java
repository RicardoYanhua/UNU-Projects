package com.mycompany.Swing.SwitchButton;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class SwitchButton extends Component {

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        TimerAnimation.start();
        runEvent();
    }

    private Timer TimerAnimation;
    private float OvalPosition;
    private boolean selected;
    private boolean MouseisEntered;
    private float Speed = 1.5f;
    private List<EventSwitchSelected> Events;

    public SwitchButton() {
        
        setBackground(new Color(0, 174, 255));
        setPreferredSize(new Dimension(40, 20));
        
        setForeground(Color.WHITE);
        
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        Events = new ArrayList<>();
        OvalPosition = 2;
        TimerAnimation = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (isSelected()) {
                    int endLocation = getWidth() - getHeight() + 2;
                    if (OvalPosition < endLocation) {
                        OvalPosition += Speed;
                        repaint();
                    } else {
                        TimerAnimation.stop();
                        OvalPosition = endLocation;
                        repaint();
                    }
                } else {
                    int endLocation = 2;
                    if (OvalPosition > endLocation) {
                        OvalPosition -= Speed;
                        repaint();
                    } else {
                        TimerAnimation.stop();
                        OvalPosition = endLocation;
                        repaint();
                    }
                }
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                MouseisEntered = true;
            }

            @Override
            public void mouseExited(MouseEvent me) {
                MouseisEntered = false;
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    if (MouseisEntered) {
                        selected = !selected;
                        TimerAnimation.start();
                        runEvent();
                    }
                }
            }
        });
    }

    @Override
    public void paint(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth();
        int height = getHeight();

        if (selected) {
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, width, height, 20, 20);
        } else {
            g2.setColor(new Color(51,51,51));
            g2.fillRoundRect(0, 0, width, height, 20, 20);
        }

        g2.setColor(getForeground());
        g2.setComposite(AlphaComposite.SrcOver);
        g2.fillOval((int) OvalPosition, 2, height - 4, height - 4);
        super.paint(grphcs);
    }

    private void runEvent() {
        for (EventSwitchSelected event : Events) {
            event.onSelected(selected);
        }
    }

    public void addEventSelected(EventSwitchSelected event) {
        Events.add(event);
    }
}
