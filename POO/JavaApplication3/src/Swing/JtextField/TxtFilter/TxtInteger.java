package Swing.JtextField.TxtFilter;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public abstract class TxtInteger extends PlainDocument {

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
        }

        super.insertString(offs, str, a);
    }
}