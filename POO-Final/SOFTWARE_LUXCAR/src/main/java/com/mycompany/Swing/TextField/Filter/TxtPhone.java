/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Swing.TextField.Filter;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author ricar
 */
public abstract class TxtPhone extends PlainDocument {

    int TextLentgh = 0;

    public TxtPhone() {

        try {
            insertString(0, "+51 ", null);
        } catch (BadLocationException ex) {
            Logger.getLogger(TxtPhone.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String separarNumero(String telefono) {
        return telefono.replaceAll("(\\d{3})(\\d{3})(\\d{3})", "$1 $2 $3");
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null) {
            return;
        } else if (str.length() == 4) {
            super.insertString(offset, str, attr);
        } else if (str.length() == 9) {
            TextLentgh = 11;

            String currentText = getText(0, getLength());
            StringBuilder builder = new StringBuilder(currentText);
            
            str = str.replace(" ", "");
            str = separarNumero(str);
            if (currentText.startsWith("+51 ")) {
                builder.insert(4, str);
            } else {
                builder.append(str);
            }
            super.remove(0, getLength());
            super.insertString(0, builder.toString(), attr);
        } else {
            if (offset < 4) {
                offset = 4;
            }

            if (TextLentgh == 11) {
                return;
            }

            char[] digits = str.toCharArray();
            for (char digit : digits) {
                if (!Character.isDigit(digit)) {
                    return;
                }
            }
            TextLentgh++;

            String currentText = str;
            StringBuilder builder = new StringBuilder(currentText);
            if (TextLentgh == 3 || TextLentgh == 7) {
                builder.append(" ");
                TextLentgh++;
                str = builder.toString();
            } else if (TextLentgh == 4 || TextLentgh == 8) {
                builder.insert(0, " ");
                TextLentgh++;
                str = builder.toString();
            }

            super.insertString(offset, str, attr);
        }

    }

    @Override
    public void remove(int offs, int len) throws BadLocationException {
        if (offs < 4) {
            if (offs + len <= 4) {
                return; // Si la selección de borrado está completamente dentro de los primeros 4 caracteres, no hacer nada
            } else {
                // Ajustar el inicio de la selección para no incluir los primeros 4 caracteres
                len -= (4 - offs);
                offs = 4;
            }
        }

        String currentText = getText(0, getLength());
        StringBuilder builder = new StringBuilder(currentText);
        if (TextLentgh == 9) {
            builder.delete(builder.length() - 2, builder.length());
            TextLentgh = 7;
            super.remove(builder.length(), 2);

        } else if (TextLentgh == 5) {
            builder.delete(builder.length() - 2, builder.length());
            TextLentgh = 3;
            super.remove(builder.length(), 2);

        } else {
            TextLentgh = TextLentgh - len;
            super.remove(offs, len);
        }

    }

}
