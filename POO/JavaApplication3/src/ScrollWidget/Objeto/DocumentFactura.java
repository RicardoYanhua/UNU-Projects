/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ScrollWidget.Objeto;

/**
 *
 * @author ricar
 */
public class DocumentFactura extends Document{

    private String RUC;

    public DocumentFactura() {
    }

    public DocumentFactura(String RUC, String Codigo, String Importe, String Fecha) {
        super(Codigo, Importe, Fecha);
        this.RUC = RUC;
    }

    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }
}
