package polyglot.ms.test.transaction.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TransactionRequestUpdate {
    private Integer id_invoice;
    private double amount;
    public TransactionRequestUpdate(Integer id_invoice, double amount) {
        this.id_invoice = id_invoice;
        this.amount = amount;
    }
}