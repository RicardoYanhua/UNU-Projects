package Swing.table;

import Swing.table.AuxTable.TableCellAction;
import Swing.table.AuxTable.TableHeader;
import Swing.table.AuxAction.ModelAction;
import Swing.table.AuxAction.Action;
import Util.Scroll.ScrollBar;
import java.awt.Color;
import java.awt.Component;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumnModel;

public class Table extends JTable {

    public Table() {

        setShowHorizontalLines(true);
        setGridColor(new Color(230, 230, 230));
        setRowHeight(55);
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {

                //Ordenar la pos de los titulos de la tabla
                TableHeader header = new TableHeader(o + "",false);
                /*if (i1 == 0) {
                    header.setHorizontalAlignment(SwingConstants.RIGHT);
                }*/

                if (i1 == 4) {
                    header.setHorizontalAlignment(JLabel.CENTER);
                }
                return header;
            }
        });

        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean selected, boolean focus, int i, int i1) {
                if (o instanceof ModelAction) {
                    ModelAction data = (ModelAction) o;
                    Action cell = new Action(data);

                    if (selected) {
                        cell.setBackground(new Color(239, 244, 255));
                    } else {
                        cell.setBackground(Color.WHITE);
                    }
                    return cell;
                } else {
                    Component com = super.getTableCellRendererComponent(jtable, o, selected, focus, i, i1);

                    setBorder(noFocusBorder);

                    com.setForeground(new Color(102, 102, 102));
                    if (selected) {
                        com.setBackground(new Color(239, 244, 255));
                    } else {
                        com.setBackground(Color.WHITE);
                    }

                    //Posicion de los textos de las columnas- confiurar segun el numero de columnas
                    if (i1 == 0) {
                        setHorizontalAlignment(SwingConstants.CENTER);
                    } else if (i1 == 1) {
                        setHorizontalAlignment(SwingConstants.CENTER);
                    } else if (i1 == 2) {
                        setHorizontalAlignment(SwingConstants.RIGHT);
                    } else if (i1 == 3) {
                        setHorizontalAlignment(SwingConstants.RIGHT);
                    } else {
                        setHorizontalAlignment(SwingConstants.LEFT);
                    }

                    return com;
                }

            }
        });
        

    }

    @Override

    public TableCellEditor getCellEditor(int row, int col) {
        if (col == 4) {
            return new TableCellAction();
        } else {
            return super.getCellEditor(row, col);
        }
    }

    public void addRow(Object[] row) {
        DefaultTableModel mod = (DefaultTableModel) getModel();
        mod.addRow(row);
    }

    public void fixTable(JScrollPane scroll) {
        scroll.getViewport().setBackground(Color.WHITE);
        scroll.setVerticalScrollBar(new ScrollBar());
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        scroll.setBorder(new EmptyBorder(5, 10, 5, 10));
    }
}
