package com.mycompany.Swing.TextField.Filter;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public abstract class TxtDecimalSize extends PlainDocument {

    boolean hasDecimalPoint = false;
    int Decimales = 0;
    int Decimal_Limit;
    int Size = 0;

    

    public TxtDecimalSize(int DecimalSize) {
        this.Decimal_Limit = DecimalSize;
    }

    public  String CompletarCeros(String stringDecimal) {
        String[] partes = stringDecimal.split("\\.");

        // Si hay más de 2 partes, tomamos solo las dos primeras
        if (partes.length > 2) {
            partes = new String[]{partes[0], partes[1]};
        }

        // Si la parte decimal tiene más de 3 caracteres, la truncamos a 3
        if (partes.length == 2 && partes[1].length() > Decimal_Limit) {
            partes[1] = partes[1].substring(0, Decimal_Limit);
        }

        // Si la parte decimal tiene menos de 3 caracteres, la completamos con "0"
        while (partes.length == 2 && partes[1].length() < Decimal_Limit) {
            partes[1] += "0";
        }

        // Unimos las partes y devolvemos el resultado
        return String.join(".", partes);
    }

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if (str == null) {
            return;

        } else if (str.length() > 1) {

            String txt = CompletarCeros(str);
            Size = txt.length();
            hasDecimalPoint = true;
            Decimales = Decimal_Limit;

            super.insertString(offs, txt, a);

        } else {
            char[] input = str.toCharArray();
            for (char c : input) {

                if (!Character.isDigit(c) && c != '.') {

                    return; // No se inserta si no es un dígito ni un punto
                }

                if ((c == '.' && Size == 0) || ((c == '.' && hasDecimalPoint)) || Decimales == Decimal_Limit) {

                    return;
                } else {

                    Size++;
                    if (hasDecimalPoint) {
                        Decimales++;
                    }

                    if (c == '.' && Size > 0) {
                        hasDecimalPoint = true;
                    }
                }

            }
            super.insertString(offs, str, a);

        }

    }

    @Override
    public void remove(int offs, int len) throws BadLocationException {
        String currentText = getText(0, getLength());
        StringBuilder builder = new StringBuilder(currentText);

        if (currentText.substring(offs, offs + len).contains(".")) {

            hasDecimalPoint = false;
            Size--;
            Decimales = 0;

        } else {
            Size--;
            if (hasDecimalPoint) {
                Decimales--;
            } else {
                Decimales = 0;
            }
        }

        builder.delete(offs, offs + len);

        super.remove(offs, len);
    }

}
