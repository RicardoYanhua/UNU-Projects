package polyglot.ms.test.invoice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import polyglot.ms.test.invoice.model.InvoiceModel;

@Repository
public interface IInvoiceRepository extends CrudRepository<InvoiceModel,Integer> {
   

    public InvoiceModel findByIdOperation(Integer id_operation);



}



