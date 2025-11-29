package polyglot.ms.test.transaction.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import polyglot.ms.test.transaction.dto.TransactionRequestUpdate;
import polyglot.ms.test.transaction.exception.ResourceNotFoundException;
import polyglot.ms.test.transaction.model.TransactionModel;
import polyglot.ms.test.transaction.repository.ITransactionRepository;

@CacheConfig(cacheNames = "transaction")
@Service
public class TransactionService implements ITransactionService {

    private static final Logger logger = LoggerFactory.getLogger(TransactionService.class);

    @Autowired
    private ITransactionRepository transactionRepository;

    /**
     * Crea y guarda una nueva transacción en la base de datos.
     * @param transaction La transacción a crear.
     * @return La transacción creada con su ID asignado.
     */
    @Override
    public TransactionModel add(TransactionModel transaction) {
        logger.info("[TransactionService][ADD] → Creando transacción: id_transaction={}, id_invoice={}, amount={}",
                transaction.getId_transaction(), transaction.getId_invoice(), transaction.getAmount());

        TransactionModel savedTransaction = transactionRepository.save(transaction);

        logger.info("[TransactionService][ADD][SUCCESS] → Transacción creada con ID: {}", savedTransaction.getId());
        return savedTransaction;
    }

    /**
     * Busca todas las transacciones asociadas a un id_invoice.
     * @param id_invoice ID de la factura.
     * @return Lista de transacciones asociadas.
     */
    @Override
    @Cacheable(cacheNames = { "transaction" }, key = "#id_invoice")
    public List<TransactionModel> findByIdInvoice(Integer id_invoice) {
        logger.info("[TransactionService][FIND_BY_ID_INVOICE] → Buscando transacciones por id_invoice={}", id_invoice);

        List<TransactionModel> result = (List<TransactionModel>) transactionRepository.findByIdInvoice(id_invoice);

        if (result == null || result.isEmpty()) {
            logger.warn("[TransactionService][FIND_BY_ID_INVOICE][NOT_FOUND] → No se encontraron transacciones con id_invoice={}", id_invoice);
            throw new ResourceNotFoundException("No se encontraron transacciones con id_invoice: " + id_invoice);
        }

        logger.info("[TransactionService][FIND_BY_ID_INVOICE][SUCCESS] → Total encontradas: {}", result.size());
        return result;
    }

    /**
     * Devuelve todas las transacciones de la base de datos.
     * @return Iterable con todas las transacciones.
     */
    @Override
    public Iterable<TransactionModel> findAll() {
        logger.info("[TransactionService][FIND_ALL] → Obteniendo todas las transacciones");
        Iterable<TransactionModel> transactions = transactionRepository.findAll();
        logger.info("[TransactionService][FIND_ALL][SUCCESS] → Total de transacciones: {}", ((Collection<?>) transactions).size());
        return transactions;
    }

    /**
     * Elimina una transacción por su id_transaction.
     * @param id_transaction ID de la transacción a eliminar.
     */
    @Override
    public void deleteByIdTransaction(Integer id_transaction) {
        logger.info("[TransactionService][DELETE] → Eliminando transacción con id_transaction={}", id_transaction);

        TransactionModel transaction = transactionRepository.findByIdTransaction(id_transaction);
        if (transaction == null) {
            logger.warn("[TransactionService][DELETE][NOT_FOUND] → No se encontró la transacción con id_transaction={}", id_transaction);
            throw new ResourceNotFoundException("No se encontró la transacción con id_transaction: " + id_transaction);
        }

        transactionRepository.deleteByIdTransaction(id_transaction);
        logger.info("[TransactionService][DELETE][SUCCESS] → Transacción eliminada id_transaction={}", id_transaction);
    }

    /**
     * Busca una transacción por su id_transaction.
     * @param id_transaction ID de la transacción.
     * @return Transacción encontrada.
     */
    @Override
    public TransactionModel findByIdTransaction(Integer id_transaction) {
        logger.info("[TransactionService][FIND_BY_ID_TRANSACTION] → Buscando transacción id_transaction={}", id_transaction);

        TransactionModel transaction = transactionRepository.findByIdTransaction(id_transaction);
        if (transaction == null) {
            logger.warn("[TransactionService][FIND_BY_ID_TRANSACTION][NOT_FOUND] → No se encontró transacción con id_transaction={}", id_transaction);
            throw new ResourceNotFoundException("No se encontró la transacción con id_transaction: " + id_transaction);
        }

        logger.info("[TransactionService][FIND_BY_ID_TRANSACTION][SUCCESS] → Transacción encontrada id_transaction={}", id_transaction);
        return transaction;
    }

    /**
     * Actualiza una transacción existente.
     * @param id_transaction ID de la transacción a actualizar.
     * @param transactionDetails Datos nuevos de la transacción.
     * @return Transacción actualizada.
     */
    @Override
    public TransactionModel update(Integer id_transaction, TransactionRequestUpdate transactionDetails) {
        logger.info("[TransactionService][UPDATE] → Actualizando transacción id_transaction={}", id_transaction);

        TransactionModel transaction = transactionRepository.findByIdTransaction(id_transaction);
        if (transaction == null) {
            logger.warn("[TransactionService][UPDATE][NOT_FOUND] → No se encontró la transacción con id_transaction={}", id_transaction);
            throw new ResourceNotFoundException("No se encontró la transacción con id_transaction: " + id_transaction);
        }

        transaction.setId_invoice(transactionDetails.getId_invoice());
        transaction.setAmount(transactionDetails.getAmount());

        TransactionModel updatedTransaction = transactionRepository.save(transaction);
        logger.info("[TransactionService][UPDATE][SUCCESS] → Transacción actualizada id_transaction={}", id_transaction);
        return updatedTransaction;
    }

    /**
     * Busca una transacción por su ID de tipo String.
     * @param id ID de la transacción.
     * @return Transacción encontrada.
     */
    @Override
    public TransactionModel findById(String id) {
        logger.info("[TransactionService][FIND_BY_ID] → Buscando transacción id={}", id);

        Optional<TransactionModel> transaction = transactionRepository.findById(id);
        return transaction.orElseThrow(() -> {
            logger.warn("[TransactionService][FIND_BY_ID][NOT_FOUND] → No se encontró transacción id={}", id);
            return new ResourceNotFoundException("No se encontró la transacción con id: " + id);
        });
    }

    /**
     * Obtiene un resumen total del monto de todas las transacciones.
     */
    public ITransactionRepository.SummaryResult getAmountSummary() {
        logger.info("[TransactionService][SUMMARY] → Obteniendo resumen de montos");
        ITransactionRepository.SummaryResult summary = transactionRepository.getAmountSummary();
        logger.info("[TransactionService][SUMMARY][SUCCESS] → Resumen obtenido");
        return summary;
    }

    /**
     * Busca transacciones dentro de un rango de amount.
     * @param min Monto mínimo.
     * @param max Monto máximo.
     * @return Lista de transacciones dentro del rango.
     */
    public List<TransactionModel> getByAmountRange(double min, double max) {
        logger.info("[TransactionService][RANGE] → Buscando transacciones entre {} y {}", min, max);
        List<TransactionModel> list = transactionRepository.findByAmountBetween(min, max);
        logger.info("[TransactionService][RANGE][SUCCESS] → Total encontradas: {}", list.size());
        return list;
    }
}
