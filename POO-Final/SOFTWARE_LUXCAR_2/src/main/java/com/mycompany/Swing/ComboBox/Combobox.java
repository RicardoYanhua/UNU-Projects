package com.mycompany.Swing.ComboBox;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.mycompany.Luxcar.Main;
import com.mycompany.LuxcarForm.FormsTrabajador.PopupRegistrarTrabajador;
import com.mycompany.Util.Scroll.ScrollBar;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

public class Combobox<E> extends JComboBox<E> {

    @Override
    public void updateUI() {
        super.updateUI();
        installUI();
    }

    private void installUI() {
        setUI(new ComboUI(this));
        setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> jlist, Object o, int i, boolean bln, boolean bln1) {
                Component com = super.getListCellRendererComponent(jlist, o, i, bln, bln1);
                setBorder(new EmptyBorder(5, 10, 5, 10));
                if (bln) {
                    com.setBackground(new Color(16, 78, 128, 20));
                }
                return com;
            }
        });
    }

    public Combobox() {
        setBackground(Color.WHITE);
        setBorder(new EmptyBorder(15, 3, 5, 3));
        installUI();
    }

    private class ComboUI extends BasicComboBoxUI {

        public ComboUI(Combobox combo) {
            setBorder(new LineBorder(new Color(200, 200, 200), 1));
        }

        @Override
        public void paintCurrentValueBackground(Graphics grphcs, Rectangle rctngl, boolean bln) {

        }

        @Override
        protected JButton createArrowButton() {
            return new ArrowButton();
        }

        @Override
        protected ComboPopup createPopup() {
            BasicComboPopup pop = new BasicComboPopup(comboBox) {
                @Override
                protected JScrollPane createScroller() {
                    list.setFixedCellHeight(30);
                    JScrollPane scroll = new JScrollPane(list);
                    scroll.setBackground(Color.WHITE);

                    ScrollBar sb = new ScrollBar(new Color(16, 78, 128));
                    sb.setUnitIncrement(30);
                    sb.setForeground(new Color(180, 180, 180));
                    scroll.setVerticalScrollBar(sb);
                    return scroll;
                }
            };
           
            //pop.setComponentZOrder(editor, 0);
            pop.setBorder(new LineBorder(new Color(16, 78, 128), 1));
            return pop;
        }

        private class ArrowButton extends JButton {

            private Color Button_IconColorFilter = new Color(0, 0, 0);
            private FlatSVGIcon.ColorFilter Filter = new FlatSVGIcon.ColorFilter(color -> Button_IconColorFilter);

            private int IconSize = 25;

            public ArrowButton() {
                setContentAreaFilled(false);
                setVerticalAlignment(CENTER);
                setCursor(new Cursor(Cursor.HAND_CURSOR));
                setBorder(new EmptyBorder(5, 5, 5, 5));
                setBackground(new Color(150, 150, 150));
                setIcon(new FlatSVGIcon("svg/arrow.svg", IconSize, IconSize).setColorFilter(Filter));

                addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        Button_IconColorFilter = new Color(16, 78, 128);
                        setIcon(new FlatSVGIcon("svg/arrow.svg", IconSize, IconSize).setColorFilter(Filter));
                        repaint();
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        Button_IconColorFilter = new Color(0, 0, 0);
                        setIcon(new FlatSVGIcon("svg/arrow.svg", IconSize, IconSize).setColorFilter(Filter));
                        repaint();
                    }
                });

            }
        }
    }
}
