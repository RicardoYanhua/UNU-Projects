package polyglot.ms.test.transaction.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TransactionRequestCreate {
    private Integer id_transaction;
    private Integer id_invoice;
    private double amount;
    public TransactionRequestCreate(Integer id_transaction, Integer id_invoice, double amount) {
        this.id_transaction = id_transaction;
        this.id_invoice = id_invoice;
        this.amount = amount;
    }
}