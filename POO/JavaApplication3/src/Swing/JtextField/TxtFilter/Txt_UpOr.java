package Swing.JtextField.TxtFilter;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class Txt_UpOr extends PlainDocument {

    int count = 0;

    public static String capitalizeFirstLetterAndLowercaseRest(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        String lowerCaseStr = str.toLowerCase();
        char firstChar = Character.toUpperCase(lowerCaseStr.charAt(0));

        return firstChar + lowerCaseStr.substring(1);
    }

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if (str == null) {
            return;
        } else if (str.length() > 1) {

            String txt = capitalizeFirstLetterAndLowercaseRest(str);
            count = txt.length();

            super.insertString(offs, txt, a);

        } else {

            char[] input = str.toCharArray();

            for (char c : input) {

                if (count == 0) {
                    super.insertString(offs, str.toUpperCase(), a);

                } else {
                    super.insertString(offs, str.toLowerCase(), a);
                }
            }
            count++;
            System.out.println(count);
        }

        // Insertar el texto transformado
    }

    @Override
    public void remove(int offs, int len) throws BadLocationException {
        String currentText = getText(0, getLength());
        StringBuilder builder = new StringBuilder(currentText);

        count--;
        System.out.println(count);

        builder.delete(offs, offs + len);

        super.remove(offs, len);
    }
}
