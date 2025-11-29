package polyglot.ms.test.transaction.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequest {
    private Integer id_transaction;    
    private Integer id_operation;
    private Integer id_invoice;
	private double amount;
    private String date;
}