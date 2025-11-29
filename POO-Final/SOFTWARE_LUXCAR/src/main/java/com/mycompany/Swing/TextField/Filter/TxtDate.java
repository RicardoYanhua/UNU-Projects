/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Swing.TextField.Filter;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author ricar
 */
public class TxtDate extends PlainDocument {

    int TextLentgh = 0;

    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null) {
            return;
        } else if (str.length() == 14) {
            TextLentgh = 14;
            super.insertString(offset, str, attr);

        } else {
            if (TextLentgh == 14) {
                return;
            }

            char[] digits = str.toCharArray();
            for (char digit : digits) {
                if (!Character.isDigit(digit)) {
                    return;
                }

            }
            TextLentgh++;

            if (TextLentgh == 2 || TextLentgh == 7) {
                String currentText = str;
                StringBuilder builder = new StringBuilder(currentText);
                builder.append(" / ");
                TextLentgh = TextLentgh + 3;
                str = builder.toString();

            }
            if (TextLentgh == 3 || TextLentgh == 8) {
                String currentText = str;
                StringBuilder builder = new StringBuilder(currentText);
                builder.insert(0, " / ");
                TextLentgh = TextLentgh + 3;
                str = builder.toString();
            }
            super.insertString(offset, str, attr);
        }

    }

    @Override
    public void remove(int offs, int len) throws BadLocationException {

        String currentText = getText(0, getLength());
        StringBuilder builder = new StringBuilder(currentText);

        if (TextLentgh == 11) {

            builder.delete(builder.length() - 4, builder.length());
            TextLentgh = 7;
            super.remove(builder.length(), 4);

        } else if (TextLentgh == 6) {
            builder.delete(builder.length() - 4, builder.length());
            TextLentgh = 2;
            super.remove(builder.length(), 4);

        } else {
            TextLentgh = TextLentgh - len;
            super.remove(offs, len);
        }

    }

}
