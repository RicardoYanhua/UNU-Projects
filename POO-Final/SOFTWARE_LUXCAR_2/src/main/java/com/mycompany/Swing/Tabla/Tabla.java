package com.mycompany.Swing.Tabla;

import com.mycompany.Util.Scroll.ScrollBar;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

public class Tabla extends JTable {

    private Color Header_BorderColor = new Color(0, 0, 0);
    private Color Header_BackgroundColor = new Color(0, 0, 0);
    private Color Header_ForegroundColor = new Color(0, 0, 0);
    private Border Header_Border = new EmptyBorder(10, 0, 10, 0);
    private boolean Header_BorderActived = true;
    private int Header_Round = 0;

    private Border Row_Border = new EmptyBorder(0, 10, 0, 10);
    private Color Row_ForegroundColor = new Color(51, 51, 51);
    private Color Row_SelectedColor = new Color(209, 214, 255);
    private Color Row_BackgroundColor = new Color(255, 255, 255);
    private Font Row_Font = new Font("sansserif", Font.PLAIN, 15);

    private Border Table_Border = new LineBorder(Header_BorderColor);
    private Color Table_GridLineColor = Header_BorderColor;
    private boolean Tabla_ActivedLinesH = true;
    private boolean Tabla_ActivedLinesV = true;
    private Font Header_Font = new Font("sansserif", Font.BOLD, 15);

    private int[] HorizontalTextPosition = {
        SwingConstants.LEFT,
        SwingConstants.LEFT,
        SwingConstants.LEFT,
        SwingConstants.LEFT,
        SwingConstants.LEFT,
        SwingConstants.LEFT,
        SwingConstants.LEFT,
        SwingConstants.LEFT,
        SwingConstants.LEFT,
        SwingConstants.LEFT,
        SwingConstants.LEFT,
        SwingConstants.LEFT,
        SwingConstants.LEFT

    };
    private int[] HorizontalTextPositionHeader = {
        SwingConstants.LEFT,
        SwingConstants.LEFT,
        SwingConstants.LEFT,
        SwingConstants.LEFT,
        SwingConstants.LEFT,
        SwingConstants.LEFT,
        SwingConstants.LEFT,
        SwingConstants.LEFT,
        SwingConstants.LEFT,
        SwingConstants.LEFT,
        SwingConstants.LEFT,
        SwingConstants.LEFT,
        SwingConstants.LEFT

    };

    public boolean isHeader_BorderActived() {
        return Header_BorderActived;
    }

    public void setHeader_BorderActived(boolean Header_BorderActived) {
        this.Header_BorderActived = Header_BorderActived;
    }

    public int getHeader_Round() {
        return Header_Round;
    }

    public void setHeader_Round(int Header_Round) {
        this.Header_Round = Header_Round;
    }

    public void setHorizontalTextPosition(int[] tetxtposition) {
        HorizontalTextPosition = tetxtposition;
    }

    public void setHorizontalTextPositionHeader(int[] tetxtposition) {
        HorizontalTextPositionHeader = tetxtposition;
    }

    private TableHeader InsertPositionTextHeader(int Columna, TableHeader header) {
        switch (HorizontalTextPositionHeader[Columna]) {
            case SwingConstants.LEFT:
                header.setHorizontalAlignment(SwingConstants.LEFT);
                break;
            case SwingConstants.CENTER:
                header.setHorizontalAlignment(SwingConstants.CENTER);
                break;
            case SwingConstants.RIGHT:
                header.setHorizontalAlignment(SwingConstants.RIGHT);
                break;
            default:
                header.setHorizontalAlignment(SwingConstants.LEFT);
        }
        return header;
    }

    public Color getHeader_BorderColor() {
        return Header_BorderColor;
    }

    public void setHeader_BorderColor(Color Header_BorderColor) {
        this.Header_BorderColor = Header_BorderColor;
    }

    public Color getHeader_BackgroundColor() {
        return Header_BackgroundColor;
    }

    public void setHeader_BackgroundColor(Color Header_BackgroundColor) {
        this.Header_BackgroundColor = Header_BackgroundColor;
    }

    public Color getHeader_ForegroundColor() {
        return Header_ForegroundColor;
    }

    public void setHeader_ForegroundColor(Color Header_ForegroundColor) {
        this.Header_ForegroundColor = Header_ForegroundColor;
    }

    public Border getHeader_Border() {
        return Header_Border;
    }

    public void setHeader_Border(Border Header_Border) {
        this.Header_Border = Header_Border;
    }

    public Border getRow_Border() {
        return Row_Border;
    }

    public void setRow_Border(Border Row_Border) {
        this.Row_Border = Row_Border;
    }

    public Color getRow_ForegroundColor() {
        return Row_ForegroundColor;
    }

    public void setRow_ForegroundColor(Color Row_ForegroundColor) {
        this.Row_ForegroundColor = Row_ForegroundColor;
    }

    public Color getRow_SelectedColor() {
        return Row_SelectedColor;
    }

    public void setRow_SelectedColor(Color Row_SelectedColor) {
        this.Row_SelectedColor = Row_SelectedColor;
    }

    public Color getRow_BackgroundColor() {
        return Row_BackgroundColor;
    }

    public void setRow_BackgroundColor(Color Row_BackgroundColor) {
        this.Row_BackgroundColor = Row_BackgroundColor;
    }

    public Font getRow_Font() {
        return Row_Font;
    }

    public void setRow_Font(Font Row_Font) {
        this.Row_Font = Row_Font;
    }

    public Border getTable_Border() {
        return Table_Border;
    }

    public void setTable_Border(Border Table_Border) {
        this.Table_Border = Table_Border;
        setBorder(Table_Border);
    }

    public Color getTable_GridLineColor() {
        return Table_GridLineColor;
    }

    public void setTable_GridLineColor(Color Table_GridLineColor) {
        this.Table_GridLineColor = Table_GridLineColor;
        setGridColor(Table_GridLineColor);
    }

    public boolean isTabla_ActivedLinesH() {
        return Tabla_ActivedLinesH;
    }

    public void setTabla_ActivedLinesH(boolean Tabla_ActivedLinesH) {
        this.Tabla_ActivedLinesH = Tabla_ActivedLinesH;
        setShowHorizontalLines(Tabla_ActivedLinesH);
    }

    public boolean isTabla_ActivedLinesV() {
        return Tabla_ActivedLinesV;
    }

    public void setTabla_ActivedLinesV(boolean Tabla_ActivedLinesV) {
        this.Tabla_ActivedLinesV = Tabla_ActivedLinesV;
        setShowVerticalLines(Tabla_ActivedLinesV);
    }

    public Font getHeader_Font() {
        return Header_Font;
    }

    public void setHeader_Font(Font Header_Font) {
        this.Header_Font = Header_Font;
    }
    

    public Tabla() {
        setShowHorizontalLines(Tabla_ActivedLinesH);
        setShowVerticalLines(Tabla_ActivedLinesV);
        Header_BackgroundColor = getBackground();
        Header_ForegroundColor = getForeground();
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setBorder(Table_Border);
        setGridColor(Table_GridLineColor);
        setRowHeight(45);
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                TableHeader header = new TableHeader(o + "");
                header.setBackground(Header_BackgroundColor);
                header.setForeground(Header_ForegroundColor);
                header.setBorderColor(Header_BorderColor);
                header.setBorder(Header_Border);
                header.setBorderActived(Header_BorderActived);
                header.setRound(Header_Round);
                header.setFontHeader(Header_Font);
                return InsertPositionTextHeader(i1, header);
            }
        });

        setDefaultRenderer(Object.class,
                new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean selected, boolean focus, int i, int Columna) {
                Component com = super.getTableCellRendererComponent(jtable, o, selected, focus, i, Columna);
                setBorder(Row_Border);
                com.setForeground(Row_ForegroundColor);

                if (selected) {
                    com.setBackground(Row_SelectedColor);
                } else {
                    com.setBackground(Row_BackgroundColor);
                }

                com.setFont(Row_Font);

                switch (HorizontalTextPosition[Columna]) {
                    case SwingConstants.LEFT:
                        setHorizontalAlignment(SwingConstants.LEFT);
                        break;
                    case SwingConstants.CENTER:
                        setHorizontalAlignment(SwingConstants.CENTER);
                        break;
                    case SwingConstants.RIGHT:
                        setHorizontalAlignment(SwingConstants.RIGHT);
                        break;
                    default:
                        setHorizontalAlignment(SwingConstants.LEFT);
                }
                return com;

            }
        }
        );
    }

    public void setColumnWidths(int[] widths) {
        for (int i = 0; i < widths.length; i++) {
            if (i < getColumnModel().getColumnCount()) {
                getColumnModel().getColumn(i).setPreferredWidth(widths[i]);
            }
        }
    }

    @Override

    public TableCellEditor getCellEditor(int row, int col) {
        return super.getCellEditor(row, col);
    }

    public void addRow(Object[] row) {
        DefaultTableModel mod = (DefaultTableModel) getModel();
        mod.addRow(row);
    }

    public void FixScroll(JScrollPane scroll) {

        scroll.getViewport().setBackground(Row_BackgroundColor);
        scroll.setVerticalScrollBar(new ScrollBar(Header_BackgroundColor));

        JPanel p = new JPanel();
        p.setBackground(Row_BackgroundColor);
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        scroll.setBorder(new EmptyBorder(0, 2, 0, 2));

    }
}
