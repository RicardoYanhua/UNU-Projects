/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ViewDcument.Modfi;
import com.aspose.words.Document;
import com.aspose.words.SaveFormat;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

public class ProcesarDocumentos {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        File carpetaDeDocumentos = new File(projectPath, "CarpetaDeDocumentos");

        if (!carpetaDeDocumentos.exists()) {
            carpetaDeDocumentos.mkdir();
        }

        String inputPath = new File(carpetaDeDocumentos, "documento.docx").getAbsolutePath();
        List<String> usuarios = List.of("Juan", "Maria", "Pedro");

        for (String usuario : usuarios) {
            String outputPathPdf = new File(carpetaDeDocumentos, usuario + "_documento_modificado.pdf").getAbsolutePath();

            // Modificar el documento Word para cada usuario
            try (XWPFDocument doc = new XWPFDocument(new FileInputStream(inputPath))) {
                for (XWPFParagraph p : doc.getParagraphs()) {
                    for (XWPFRun run : p.getRuns()) {
                        String text = run.getText(0);
                        if (text != null && text.contains("NombreDeUsuario")) {
                            text = text.replace("NombreDeUsuario", usuario);
                            run.setText(text, 0);
                        }
                    }
                }

                // Guardar el documento modificado en un ByteArrayOutputStream en lugar de un archivo
                try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
                    doc.write(baos);
                    baos.flush();

                    // Convertir el documento modificado a PDF usando Aspose.Words directamente desde el ByteArrayOutputStream
                    try (ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray())) {
                        Document asposeDoc = new Document(bais);
                        asposeDoc.save(outputPathPdf, SaveFormat.PDF);
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

