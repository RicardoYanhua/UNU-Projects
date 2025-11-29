/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Forms;

import Factura.FACTURA_IMPRIMIR;
import Mesaage.Close;
import Mesaage.ConfDelete;
import Mesaage.EditItem;
import Mesaage.ViewItem;
import Mesaage.ViewItemLastVenta;
import ScrollWidget.auxiliary.EventItem;
import ScrollWidget.Objeto.CardBoleta;
import ScrollWidget.Objeto.Document;
import ScrollWidget.Objeto.DocumentBoleta;
import ScrollWidget.Objeto.DocumentFactura;
import Swing.Card.CardDoc;
import Swing.table.AuxAction.EventAction;
import Swing.table.Objeto.Data;
import Util.Glasspanepopup.GlassPanePopup;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ricar
 */
public class Home extends javax.swing.JPanel {

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        initTableData();
        initScrollNotice();

    }

    private Document itemSelected;

    private void initScrollNotice() {

        formScrollItems1.setEvent(new EventItem() {
            @Override
            public void itemClick(Component com, Document item) {

                if (itemSelected != item) {
                    System.out.println("Click en el item : " + item.getCodigo());
                    /*
                    ViewItemLastVenta obj = new ViewItemLastVenta();
                    //Pasardatos
                    obj.setTxt(item.getImporte());
                    //Pasardatos

                    GlassPanePopup.showPopup(obj);
                
                     */
                    FACTURA_IMPRIMIR obj = new FACTURA_IMPRIMIR();
                    //Pasardatos
                    //obj.setTxt(item.getImporte());
                    //Pasardatos

                    GlassPanePopup.showPopup(obj);

                }
            }
        });

        String number;

        DecimalFormat df = new DecimalFormat("###.00");
        for (int i = 0; i < 5; i++) {
            number = String.valueOf(df.format(Math.random() * 1000));

            Document CARD_Boleta = new DocumentBoleta(
                    "74377525", "F3-00002", "S/. " + number, "04/24/2014 hh:mm:ss");

            number = String.valueOf(df.format(Math.random() * 1000));
            formScrollItems1.addItem(CARD_Boleta);
            Document CARD_Factura = new DocumentFactura(
                    "10000023423", "EB-00001", "S/. " + number, "04/24/2014 hh:mm:ss");

            formScrollItems1.addItem(CARD_Factura);

        }

    }

    private void initTableData() {

        table.fixTable(jScrollPane1);

        EventAction eventAction = new EventAction() {
            @Override
            public void delete(Data student) {
                System.out.println("Delete");
                /*
                if (table.isEditing()) {
                    table.getCellEditor().stopCellEditing();
                }
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.removeRow(row);
                 */
                ConfDelete obj = new ConfDelete();

                //Pasardatos
                obj.setTextName(student.getName());
                //Pasardatos

                obj.eventOK(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {

                        /*Elimancion de datos Confirmado
                        
                        DefaultTableModel modelo = (DefaultTableModel) table1.getModel();
                        int filaAEliminar = 0; 
                        modelo.removeRow(filaAEliminar);*/
                        GlassPanePopup.closePopupLast();

                    }
                });
                GlassPanePopup.showPopup(obj);
            }

            @Override
            public void update(Data student) {

                System.out.println("Update");

                EditItem obj = new EditItem();
                //Pasardatos
                obj.setTextName(student.getName());
                //Pasardatos

                obj.eventOK(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {

                        //Guardar datos actualizados
                        GlassPanePopup.closePopupLast();
                    }
                });

                GlassPanePopup.showPopup(obj);

            }

            @Override
            public void view(Data student) {
                System.out.println("View");

                ViewItem obj = new ViewItem();
                //Pasardatos
                obj.setTxt(student.getName());
                //Pasardatos

                GlassPanePopup.showPopup(obj);
            }
        };

        for (int i = 0; i < 1; i++) {
            table.addRow(new Data("1", "asd", "123", 100).toRowTable(eventAction));
            table.addRow(new Data("2", "asd", "123", 200).toRowTable(eventAction));
            table.addRow(new Data("3", "asd", "123", 300).toRowTable(eventAction));
            table.addRow(new Data("4", "Maale", "123", 400).toRowTable(eventAction));
            table.addRow(new Data("5", "asd", "123123", 500).toRowTable(eventAction));
            table.addRow(new Data("6", "asd", "123", 600).toRowTable(eventAction));
            table.addRow(new Data("7", "asd", "123123", 700).toRowTable(eventAction));
            table.addRow(new Data("8", "asd", "123", 800).toRowTable(eventAction));

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new Swing.Panel.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new Swing.table.Table();
        formScrollItems1 = new ScrollWidget.FormScrollItems();

        setOpaque(false);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cantidad", "Nombre", "Precio Unitario", "Importe", "Accion"
            }
        ));
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1137, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1)
                .addGap(20, 20, 20))
        );

        formScrollItems1.setTitulo("Ultimas Ventas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addComponent(formScrollItems1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(formScrollItems1, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ScrollWidget.FormScrollItems formScrollItems1;
    private Swing.Panel.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private Swing.table.Table table;
    // End of variables declaration//GEN-END:variables
}
