package polyglot.ms.test.transaction.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.springframework.data.mongodb.core.index.Indexed;
import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Document(collection = "transaction")
public class TransactionModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @BsonId
    private String id;

    @Indexed(unique = true) // asegura unicidad en MongoDB
    private Integer id_transaction;
    
    private Integer id_invoice;
    private double amount;
    private String date;
    
    public TransactionModel(Integer id_transaction, Integer id_invoice, double amount) {

        String uniqueID = UUID.randomUUID().toString();
        this.id = uniqueID;
        
        this.id_transaction = id_transaction;
        this.id_invoice = id_invoice;
        this.amount = amount;

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.date = dateFormat.format(date);
    }
}