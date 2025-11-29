/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ScrollWidget.Objeto;

/**
 *
 * @author ricar
 */
public class DocumentBoleta extends Document{

    private String DNI;

    public DocumentBoleta() {
    }

    public DocumentBoleta(String DNI, String Codigo, String Importe, String Fecha) {
        super(Codigo, Importe, Fecha);
        this.DNI = DNI;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;

    }
}
