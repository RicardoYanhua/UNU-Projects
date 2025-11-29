package ScrollWidget.Objeto;

import com.formdev.flatlaf.extras.FlatSVGIcon;

public abstract class Document {

    private String Codigo;
    private String Importe;
    private String Fecha;

    public Document() {
    }

    public Document(String Codigo, String Importe, String Fecha) {
        this.Codigo = Codigo;
        this.Importe = Importe;
        this.Fecha = Fecha;
    }

    public String getCodigo() {
        return Codigo;
    }
    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }
    public String getImporte() {
        return Importe;
    }
    public void setImporte(String Importe) {
        this.Importe = Importe;
    }
    public String getFecha() {
        return Fecha;
    }
    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

}

