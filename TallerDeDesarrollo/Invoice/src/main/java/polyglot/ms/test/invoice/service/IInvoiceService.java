package polyglot.ms.test.invoice.service;
 
import java.util.List;

import polyglot.ms.test.invoice.dto.InvoiceRequestUpdate;
import polyglot.ms.test.invoice.model.InvoiceModel;

 
public interface IInvoiceService {
   
    public InvoiceModel add (InvoiceModel invoice);
    public List<InvoiceModel> findAll();
    public InvoiceModel findById (Integer id_operation);
    public InvoiceModel update(Integer id_operation, InvoiceRequestUpdate invoiceModel);
    public void deleteById(Integer id);
}



