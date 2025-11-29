package com.mycompany.ViewDcument.Visual;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.swing.JPanel;

public class PanelVisor
        extends JPanel
        implements Printable {

    private float zoom;
    public static int ancho;
    public static int alto;
    private BufferedImage bufferImagen;
    private Image imagen;
    private Image imagenAux;
    private boolean hayFoto = false;

    public PanelVisor() {
        this.zoom = 0F;
        setBounds(0, 0, 630, 891);
        setOpaque(false);
        setVisible(true);
    }

    public void setImagen(byte[] vi) {
        this.zoom = 0.0F;
        try {
            ByteArrayInputStream in = new ByteArrayInputStream(vi);
            this.bufferImagen = ImageIO.read(in);
            this.imagen = this.bufferImagen;
            this.imagenAux = this.imagen;
            this.hayFoto = true;

            this.ancho = this.imagen.getWidth(this);
            this.alto = this.imagen.getHeight(this);
            resize();
            repaint();revalidate();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paint(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if (this.hayFoto) {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.translate(getWidth() *0.5f , getHeight()*0.5f );
            g2d.translate(-this.ancho *0.5f , -this.alto *0.5f );
            g2d.drawImage(this.imagenAux, 0, 0, this.ancho, this.alto, this);
        } 

    }

    public void aumentar() {
        this.zoom = ((float) (this.zoom + 0.1D));

        this.ancho = ((int) (this.imagen.getWidth(this) * (this.zoom + 1.0F)));
        this.alto = ((int) (this.imagen.getHeight(this) * (this.zoom + 1.0F)));
        this.imagenAux = this.imagen.getScaledInstance(this.ancho, this.alto, 16);
        resize();
        repaint();revalidate();
    }

    public void disminuir() {
        this.zoom = ((float) (this.zoom - 0.1D));
        this.ancho = ((int) (this.imagen.getWidth(this) * (this.zoom + 1.0F)));
        this.alto = ((int) (this.imagen.getHeight(this) * (this.zoom + 1.0F)));
        this.imagenAux = this.imagen.getScaledInstance(this.ancho, this.alto, 16);
        resize();
        repaint();
    }

    public void resize() {
        setPreferredSize(new Dimension(this.ancho, this.alto));
        resize(this.ancho, this.alto);
    }

    public int print(Graphics g, PageFormat pf, int indexPage)
            throws PrinterException {
        if (indexPage == 0) {
            g.clearRect(0, 0, getWidth(), getHeight());
            g.drawImage(this.imagen, 0, 0, (int) pf.getWidth(), (int) pf.getHeight(), this);
            return 0;
        }
        return 1;
    }

    public void imprimir() {
        // Obtener la lista de impresoras disponibles
        PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);

        // Buscar la impresora por nombre
        PrintService selectedPrintService = null;
        for (PrintService printService : printServices) {
            if (printService.getName().equalsIgnoreCase("Brother DCP-T520W Printer (Copiar 1)")) {
                selectedPrintService = printService;
                break;
            }
        }

        if (selectedPrintService != null) {
            PrinterJob job = PrinterJob.getPrinterJob();

            // Configurar el formato de página para A4 con márgenes por defecto
            PageFormat pageFormat = job.defaultPage();

            Paper paper = pageFormat.getPaper();
            double width = paper.getWidth();
            double height = paper.getHeight();

            paper.setImageableArea(0, 0, width, height);
            pageFormat.setPaper(paper);

            job.setPrintable(this, pageFormat);

            try {
                // Establecer la impresora seleccionada y imprimir
                job.setPrintService(selectedPrintService);
                job.print();
            } catch (PrinterException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No se encontró una impresora con el nombre: " + "Brother DCP-T520W Printer");
        }

    }

}
