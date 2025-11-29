package polyglot.ms.test.invoice.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "invoice")
public class InvoiceModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_operation")
    private Integer idOperation;

    @Column(name = "id_invoice")
    private String idInvoice;

    @Column(name = "amount")
    private double amount;

    @Column(name = "state")
    private Integer state;

     @Column(name = "date")
    private String date;

    public InvoiceModel(double amount, Integer state) {
        String uniqueID = UUID.randomUUID().toString();
        this.idInvoice = uniqueID;

        this.amount = amount;
        this.state = state;

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.date = dateFormat.format(date);
    }

}
