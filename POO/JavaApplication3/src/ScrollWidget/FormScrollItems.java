package ScrollWidget;

import ScrollWidget.auxiliary.WrapLayout;
import ScrollWidget.auxiliary.EventItem;
import ScrollWidget.Objeto.CardBoleta;
import ScrollWidget.Objeto.CardFactura;
import ScrollWidget.Objeto.Document;
import ScrollWidget.Objeto.DocumentBoleta;
import ScrollWidget.Objeto.DocumentFactura;
import Swing.Card.CardDoc;
import Util.Scroll.ScrollBar;
import java.awt.Color;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class FormScrollItems extends JPanel {

    public void setEvent(EventItem event) {
        this.event = event;
    }

    private EventItem event;

    public void setTitulo(String txt) {
        Titulo.setText(txt);
    }

    public void getTitulo() {
        Titulo.getText();
    }

    public FormScrollItems() {
        initComponents();
        scroll.setVerticalScrollBar(new ScrollBar());
    }

    public void addItem(Document data) {

        if (data instanceof DocumentBoleta) {
            CardBoleta item = new CardBoleta();
            item.setData((DocumentBoleta) data);
            item.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent me) {
                    if (SwingUtilities.isLeftMouseButton(me)) {
                        event.itemClick(item, data);

                    }
                }
            });
            p.add(item);
            p.repaint();
            p.revalidate();
        } else if (data instanceof DocumentFactura) {
            CardFactura item = new CardFactura();
            item.setData((DocumentFactura) data);
            item.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent me) {
                    if (SwingUtilities.isLeftMouseButton(me)) {
                        event.itemClick(item, data);

                    }
                }
            });
            p.add(item);
            p.repaint();
            p.revalidate();
        }

    }

    public void setSelected(Component item) {
        for (Component com : p.getComponents()) {

            if (com instanceof CardBoleta) {
                CardBoleta i = (CardBoleta) com;
                if (i.isSelected()) {
                    i.setSelected(false);
                }
            } else if (com instanceof CardFactura) {
                CardFactura i = (CardFactura) com;
                if (i.isSelected()) {
                    i.setSelected(false);
                }
            }

        }

        ((CardBoleta) item).setSelected(true);
        ((CardFactura) item).setSelected(true);
    }

    /*
    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2.setColor(Color.RED);
        g2.drawRect(0, 0, getWidth()-1, getHeight()-1);
        g2.dispose();
        
        super.paintComponent(grphcs);

    }*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll = new javax.swing.JScrollPane();
        p = new ScrollWidget.auxiliary.PanelScroll();
        Titulo = new javax.swing.JLabel();

        setBackground(new java.awt.Color(240, 240, 255));

        scroll.setBackground(new java.awt.Color(240, 240, 255));
        scroll.setBorder(null);
        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setViewportView(p);

        Titulo.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        Titulo.setForeground(new java.awt.Color(102, 102, 102));
        Titulo.setText("Titulo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(Titulo)
                .addGap(18, 18, 18)
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo;
    private ScrollWidget.auxiliary.PanelScroll p;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables
}
