package polyglot.ms.test.invoice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import polyglot.ms.test.invoice.dto.InvoiceRequestUpdate;
import polyglot.ms.test.invoice.model.InvoiceModel;
import polyglot.ms.test.invoice.repository.IInvoiceRepository;

@Service
public class InvoiceService implements IInvoiceService {
 
    @Autowired
    IInvoiceRepository invoiceRepository;
 
    @Override
    public List<InvoiceModel> findAll() {
        return  (List<InvoiceModel>)invoiceRepository.findAll();
    }
 
    @Override
    public InvoiceModel update(Integer id_operation, InvoiceRequestUpdate accountModel) {

        InvoiceModel invoice = invoiceRepository.findByIdOperation(id_operation);

        if (invoice == null) {
            return null;
        }	
        
        invoice.setAmount(accountModel.getAmount());
        invoice.setState(accountModel.getState());
		
        return invoiceRepository.save(invoice);
    }
 
    @Override
    public InvoiceModel findById(Integer id_operation) {
        return (InvoiceModel)invoiceRepository.findById(id_operation).orElse(null);

    }

    @Override
    public void deleteById(Integer id) {
        invoiceRepository.deleteById(id);
    }

    @Override
    public InvoiceModel add(InvoiceModel invoice) {
        return invoiceRepository.save(invoice);
    }
   
}



