package com.mycompany.Swing.Spinner;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.extras.FlatSVGIcon.ColorFilter;
import com.mycompany.Swing.TextField.Filter.TxtIntegerSize;
import com.mycompany.Util.Shadow.ShadowRenderer;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicSpinnerUI;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import static javax.swing.SwingConstants.CENTER;

public class SpinnerAM_PM extends JSpinner {

    public SpinnerAM_PM() {
        setOpaque(false);
        setModel(new SpinnerListModel(new String[]{"Inicio", "A.M.", "P.M.", "Final"}));
        setValue("A.M.");
        setUI(new SpinnerUIAM_PM());
    }

    

    public void setTextEditor(String text) {
        SpinnerUIMes.Editor editor = (SpinnerUIMes.Editor) getEditor();
        editor.setText(text);
    }

    public String getTextEditor() {
        SpinnerUIMes.Editor editor = (SpinnerUIMes.Editor) getEditor();
        return editor.getText();
    }

    
}

class SpinnerUIAM_PM extends BasicSpinnerUI {

    @Override
    public void installUI(JComponent jc) {
        super.installUI(jc);
        spinner.setEditor(new Editor(spinner));
    }

    @Override
    protected Component createNextButton() {
        ArrowButton cmd = new ArrowButton(true, spinner);
        installNextButtonListeners(cmd);
        return cmd;
    }

    @Override
    protected Component createPreviousButton() {
        ArrowButton cmd = new ArrowButton(false, spinner);
        installPreviousButtonListeners(cmd);
        return cmd;
    }

    public class Editor extends CellTextUI implements ChangeListener {

        private final JSpinner spinner;

        public Editor(JSpinner spinner) {
            super();
            this.spinner = spinner;
            spinner.addChangeListener(this);
            setEditable(false);
            setFocusable(false);
            setText(spinner.getValue().toString());
        }

       

        @Override
        public void stateChanged(ChangeEvent e) {
            setText(spinner.getValue().toString());

        }
    }

    private class CellTextUI extends JTextField {

        private float TextField_ShadowOpacity = 0f;
        private int TextField_ShadowSize = 3;
        private Color TextField_ShadowColor = new Color(31, 31, 31);
        private Color TextField_BackgroundColor = new Color(255, 255, 255);
        private int TextField_Round = 7;
        private Color BorderColor = new Color(46, 100, 209);
        private boolean borderactived = false;

        public CellTextUI() {
            setBorder(new EmptyBorder(10, 7, 10, 7));
            setOpaque(false);
            setHorizontalAlignment(CENTER);
            setBackground(new Color(0, 0, 0, 0));
            setForeground(new Color(38, 38, 38));
            setFont(new Font("sansserif", Font.BOLD, 14));
            setSelectionColor(new Color(46, 100, 209));
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int Size = TextField_ShadowSize * 2;
            int X = TextField_ShadowSize;
            int Y = TextField_ShadowSize;
            int Width = getWidth() - Size;
            int Height = getHeight() - Size;

            BufferedImage img = new BufferedImage(Width, Height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g_s = img.createGraphics();
            g_s.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g_s.setColor(TextField_BackgroundColor);
            g_s.fillRoundRect(0, 0, Width, Height, TextField_Round, TextField_Round);

            if (borderactived) {
                g_s.setColor(BorderColor);
                g_s.drawRoundRect(0, 0, Width - 1, Height - 1, TextField_Round, TextField_Round);
            }
            ShadowRenderer render = new ShadowRenderer(TextField_ShadowSize, TextField_ShadowOpacity, TextField_ShadowColor);
            g2.drawImage(render.createShadow(img), 0, 0, null);
            g2.drawImage(img, X, Y, null);

            super.paintComponent(g);
        }
    }

    private class ArrowButton extends JButton {

        private int IconSize = 25;
        private Color Button_IconColorFilter = new Color(0, 0, 0);
        private FlatSVGIcon.ColorFilter Filter = new FlatSVGIcon.ColorFilter(color -> Button_IconColorFilter);

        public ArrowButton(boolean next, JSpinner spinner) {
            setContentAreaFilled(false);
            setFocusable(false);
            setBorder(new EmptyBorder(0, 0, 0, 0));

            if (next) {
                setIcon(new FlatSVGIcon("svg/arrow_up.svg", IconSize, IconSize).setColorFilter(Filter));
            } else {
                setIcon(new FlatSVGIcon("svg/arrow_down.svg", IconSize, IconSize).setColorFilter(Filter));
            }

            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent me) {
                    setSelected(true);
                    Button_IconColorFilter = new Color(16, 78, 128);

                }

                @Override
                public void mouseReleased(MouseEvent me) {
                    setSelected(false);
                    Button_IconColorFilter = new Color(0, 0, 0);

                    if (spinner.getValue().toString() == "Final" && next) {
                        spinner.setValue("A.M.");

                    } else if (spinner.getValue().toString() == "Inicio" && !next) {
                        spinner.setValue("P.M.");

                    }

                }
            });
        }
    }
}
