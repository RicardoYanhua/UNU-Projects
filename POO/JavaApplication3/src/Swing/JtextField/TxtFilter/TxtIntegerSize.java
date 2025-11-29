package Swing.JtextField.TxtFilter;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public abstract class TxtIntegerSize extends PlainDocument {

    private int SizeInteger;
    private int count = 0;

    public TxtIntegerSize(int size) {
        this.SizeInteger = size;
    }

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if (str == null) {
            return;
        }

        char[] digits = str.toCharArray();
        for (char digit : digits) {
            if (!Character.isDigit(digit)) {
                return; // No se inserta si no es un dígito
            }

            if (count >= this.SizeInteger) {
                return;
            } else {
                count++;
            }

        }

        super.insertString(offs, str, a);
    }

    @Override
    public void remove(int offs, int len) throws BadLocationException {
        count--;
        super.remove(offs, len);
    }
}
