package polyglot.ms.test.transaction.service;

import java.util.List;

import polyglot.ms.test.transaction.dto.TransactionRequestUpdate;
import polyglot.ms.test.transaction.model.TransactionModel;
import polyglot.ms.test.transaction.repository.ITransactionRepository;

public interface ITransactionService {
    public TransactionModel add (TransactionModel transaction);
    public Iterable<TransactionModel> findByIdInvoice (Integer id_invoice);
	public Iterable<TransactionModel>  findAll() ;
    public TransactionModel findByIdTransaction(Integer id_transaction);
    public TransactionModel findById(String id);
    public TransactionModel update(Integer id_transaction, TransactionRequestUpdate transactionDetails);
    public void deleteByIdTransaction(Integer id_transaction);

    public ITransactionRepository.SummaryResult getAmountSummary();
    public List<TransactionModel> getByAmountRange(double min, double max);

    

}