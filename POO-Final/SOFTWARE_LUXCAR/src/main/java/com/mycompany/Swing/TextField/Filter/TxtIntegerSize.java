package com.mycompany.Swing.TextField.Filter;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public abstract class TxtIntegerSize extends PlainDocument {

    private int LimitText;
    private int TextSize = 0;

    public TxtIntegerSize(int size) {
        this.LimitText = size;
    }

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if (str == null) {
            return;
            
        } else if (str.length() > 1) {
            TextSize = str.length();
            super.insertString(offs, str, a);
            
        } else if(str.length() == 1){
            char[] digits = str.toCharArray();

            for (char digit : digits) {
                if (!Character.isDigit(digit)) {
                    return; // No se inserta si no es un dígito
                }
                if (TextSize >= this.LimitText) {
                    return;
                } else {
                    TextSize++;
                }
            }
            super.insertString(offs, str, a);
        }
    }

    @Override
    public void remove(int offs, int len) throws BadLocationException {
        TextSize = TextSize - len;
        super.remove(offs, len);
    }
}
