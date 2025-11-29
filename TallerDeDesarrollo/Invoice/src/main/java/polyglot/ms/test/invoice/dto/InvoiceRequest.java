package polyglot.ms.test.invoice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvoiceRequest {

    private Integer id_operation;
    private Integer id_invoice;    
    private double amount;
    private Integer state;
     private String date;

}
