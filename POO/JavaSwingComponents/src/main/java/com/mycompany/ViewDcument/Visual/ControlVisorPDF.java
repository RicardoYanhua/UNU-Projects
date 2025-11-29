/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ViewDcument.Visual;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;

public class ControlVisorPDF {

    public int NumeroPaginasTotal;
    public int NumberListView;
    public int ZoomPagDocument=0;

    private PanelVisor PanelPag;
    private File file = null;
    public ArrayList<byte[]> ListaPaginasIMG = new ArrayList<>(); 

    public ControlVisorPDF(PanelVisor jpanel) {
        this.PanelPag = jpanel;
    }

    public void MostrarPrimeraPag() {

        if (!ListaPaginasIMG.isEmpty()) {
            this.PanelPag.setImagen(ListaPaginasIMG.get(0));
            NumberListView = 0;
            adaptar_vista();
        }
    }
    public void ViewAumentarZoom(){
        if (!ListaPaginasIMG.isEmpty()) {
            this.PanelPag.aumentar();
            ZoomPagDocument = ZoomPagDocument + 1;
        } 
    }
    public void ViewDisminuirZoom(){
        if (!ListaPaginasIMG.isEmpty()) {
            this.PanelPag.disminuir();
            ZoomPagDocument = ZoomPagDocument - 1;

        }
    }

    public void ViewPaginaAnterior() {
        if (!ListaPaginasIMG.isEmpty()) {

            this.NumberListView -= 1;
            if (this.NumberListView < 0) {
                this.NumberListView = (this.ListaPaginasIMG.size() - 1);
            }
            this.PanelPag.setImagen(ListaPaginasIMG.get(NumberListView));
            adaptar_vista();
        }
    }

    public void ViewPaginaSiguiente() {

        if (!ListaPaginasIMG.isEmpty()) {
            this.NumberListView += 1;

            if (this.NumberListView >= this.ListaPaginasIMG.size()) {
                this.NumberListView = 0;
            }
            this.PanelPag.setImagen(ListaPaginasIMG.get(NumberListView));
            adaptar_vista();
        }
    }
    
     public void adaptar_vista() {
        if (ZoomPagDocument > 0) {
            for (int i = 0; i <= ZoomPagDocument; i++) {
                this.PanelPag.aumentar();
            }
        }
        if (ZoomPagDocument < 0) {
            String z = String.valueOf(ZoomPagDocument);
            z = z.replace("-", "");
            int zz = Integer.parseInt(z);
            for (int j = 0; j <= zz; j++) {
                this.PanelPag.disminuir();
            }
        }

    }

    public void leerPDF(String rutaPDF) {
        file = new File(rutaPDF);
        byte[] bi = null;
        ListaPaginasIMG = new ArrayList<>();
        try {
            RandomAccessFile raf = new RandomAccessFile(file, "r");
            //ReadableByteChannel ch = Channels.newChannel(new FileInputStream(file));
            FileChannel channel = raf.getChannel();
            ByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
            PDFFile pdffile = new PDFFile(buf);
            //   get number of pages
            int numpag = pdffile.getNumPages();
            //  iterate through the number of pages
            //----------------------
            ByteArrayOutputStream baos = null;
            for (int i = 1; i <= numpag; i++) {
                PDFPage page = pdffile.getPage(i);
                //  create new image
                Rectangle rect = new Rectangle(0, 0,
                        (int) page.getBBox().getWidth(),
                        (int) page.getBBox().getHeight());
                Image img = page.getImage(
                        rect.width * 2, rect.height * 2, //width & height
                        rect, // clip rect
                        null, // null for the ImageObserver
                        true, // fill background with white
                        true // block until drawing is done
                );

                BufferedImage bufferedImage = new BufferedImage(rect.width * 2, rect.height * 2, BufferedImage.TYPE_INT_ARGB);
                Graphics g = bufferedImage.createGraphics();
                g.drawImage(img, 0, 0, null);
                g.dispose();

                baos = new ByteArrayOutputStream();
                //ImageIO.write(bufferedImage, "jpg", Base64.getEncoder().wrap(baos));
                //---------------------------------------

                //---------------------------------------
                ImageIO.write(bufferedImage, "PNG", baos);
                bi = baos.toByteArray();

                
                ListaPaginasIMG.add(bi);
                //-----

            }
            NumeroPaginasTotal = ListaPaginasIMG.size();
            
            
            baos.close();
            buf.clear();
            channel.close();
            raf.close();
            
            MostrarPrimeraPag();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
