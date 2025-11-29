package polyglot.ms.test.transaction.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.v3.oas.annotations.tags.Tag;
import polyglot.ms.test.transaction.model.TransactionModel;
import polyglot.ms.test.transaction.dto.TransactionRequestCreate;
import polyglot.ms.test.transaction.repository.ITransactionRepository;
import polyglot.ms.test.transaction.service.ITransactionService;
import polyglot.ms.test.transaction.constans.ApiRoutes;
import polyglot.ms.test.transaction.dto.TransactionRequestUpdate;

@RestController
@RequestMapping(ApiRoutes.Transacciones.BASE)
@Tag(name = "Transacciones", description = "Endpoints para la gestión y consulta de transacciones financieras del sistema")
public class TransactionController {

    @Autowired
    private ITransactionService transactionService;

    private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);

    /**
     * CREATE - Crea una nueva transacción.
     * @param transaction DTO con los datos de la transacción a crear.
     * @return ResponseEntity con la transacción creada o código de error.
     */
    @PostMapping(ApiRoutes.Transacciones.CREAR)
    public ResponseEntity<TransactionModel> crear(@RequestBody TransactionRequestCreate transaction) {
        long startTime = System.currentTimeMillis();
        logger.info("[TransactionController][POST][CREAR] → Inicio de creación de transacción: id_invoice={}, id_transaction={}, amount={}",
                transaction.getId_invoice(), transaction.getId_transaction(), transaction.getAmount());

       
            TransactionModel model = new TransactionModel(
                    transaction.getId_transaction(),
                    transaction.getId_invoice(),
                    transaction.getAmount());

            TransactionModel newTransaction = transactionService.add(model);

            logger.info("[TransactionController][POST][CREAR][SUCCESS] → Transacción creada correctamente con ID asignado: {} (Tiempo: {} ms)",
                    newTransaction.getId(), System.currentTimeMillis() - startTime);

            return new ResponseEntity<>(newTransaction, HttpStatus.CREATED);
        
    }

    /**
     * READ - Obtiene una transacción por su ID único.
     * @param id_transaction Identificador único de la transacción.
     * @return ResponseEntity con la transacción encontrada o 404 si no existe.
     */
    @GetMapping(ApiRoutes.Transacciones.ID_TRANSACTION)
    public ResponseEntity<TransactionModel> getTransactionById(@PathVariable Integer id_transaction) {
        logger.info("[TransactionController][GET][READ] → Buscando transacción por id_transaction={}", id_transaction);

        TransactionModel transaction = transactionService.findByIdTransaction(id_transaction);

        if (transaction == null) {
            logger.warn("[TransactionController][GET][READ][NOT_FOUND] → No se encontró la transacción con id_transaction={}", id_transaction);
            return ResponseEntity.notFound().build();
        }

        logger.info("[TransactionController][GET][READ][SUCCESS] → Transacción encontrada: id_transaction={}", id_transaction);
        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }

    /**
     * UPDATE - Actualiza una transacción existente.
     * @param id_transaction ID de la transacción a actualizar.
     * @param transactionDetails DTO con los nuevos valores.
     * @return ResponseEntity con la transacción actualizada o 404 si no se encontró.
     */
    @PutMapping(ApiRoutes.Transacciones.UPDATE)
    public ResponseEntity<TransactionModel> updateTransaction(
            @PathVariable Integer id_transaction,
            @RequestBody TransactionRequestUpdate transactionDetails) {

        long startTime = System.currentTimeMillis();
        logger.info("[TransactionController][PUT][UPDATE] → Inicio de actualización de transacción con id_transaction={}", id_transaction);

       
            TransactionModel updatedTransaction = transactionService.update(id_transaction, transactionDetails);

            if (updatedTransaction == null) {
                logger.warn("[TransactionController][PUT][UPDATE][NOT_FOUND] → No se encontró transacción para actualizar: id_transaction={}", id_transaction);
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            logger.info("[TransactionController][PUT][UPDATE][SUCCESS] → Transacción actualizada correctamente: id_transaction={} (Tiempo: {} ms)",
                    id_transaction, System.currentTimeMillis() - startTime);
            return new ResponseEntity<>(updatedTransaction, HttpStatus.OK);
       
    }

    /**
     * DELETE - Elimina una transacción por su ID.
     * @param id_transaction ID de la transacción a eliminar.
     * @return ResponseEntity con el estado de la operación.
     */
    @DeleteMapping(ApiRoutes.Transacciones.DELETE)
    public ResponseEntity<Void> deleteTransaction(@PathVariable Integer id_transaction) {
        logger.info("[TransactionController][DELETE][REMOVE] → Solicitud de eliminación de transacción con id_transaction={}", id_transaction);

        TransactionModel existing = transactionService.findByIdTransaction(id_transaction);
        if (existing == null) {
            logger.warn("[TransactionController][DELETE][REMOVE][NOT_FOUND] → No se encontró transacción a eliminar: id_transaction={}", id_transaction);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

       
            transactionService.deleteByIdTransaction(id_transaction);
            logger.info("[TransactionController][DELETE][REMOVE][SUCCESS] → Transacción eliminada exitosamente: id_transaction={}", id_transaction);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       
    }

    /**
     * LISTAR - Devuelve todas las transacciones registradas.
     * @return Lista de todas las transacciones.
     */
    @GetMapping(value = ApiRoutes.Transacciones.LISTAR)
    public List<TransactionModel> listar() {
        logger.info("[TransactionController][GET][LIST] → Solicitando listado completo de transacciones");

        List<TransactionModel> transactions = (List<TransactionModel>) transactionService.findAll();

        logger.info("[TransactionController][GET][LIST][SUCCESS] → Total de transacciones encontradas: {}", transactions.size());
        return transactions;
    }

    /**
     * SEARCH - Obtiene todas las transacciones asociadas a un id_invoice.
     * @param id_invoice ID de la factura a consultar.
     * @return Lista de transacciones asociadas o 404 si no hay resultados.
     */
    @GetMapping(value = ApiRoutes.Transacciones.ID_INVOICE)
    public ResponseEntity<?> getByIdInvoice(@PathVariable Integer id_invoice) {
        logger.info("[TransactionController][GET][SEARCH] → Buscando transacciones por id_invoice={}", id_invoice);

        Iterable<TransactionModel> transactions = transactionService.findByIdInvoice(id_invoice);
        if (!transactions.iterator().hasNext()) {
            logger.warn("[TransactionController][GET][SEARCH][NOT_FOUND] → No se encontraron transacciones para id_invoice={}", id_invoice);
            return ResponseEntity.notFound().build();
        }

        logger.info("[TransactionController][GET][SEARCH][SUCCESS] → Transacciones encontradas para id_invoice={}", id_invoice);
        return ResponseEntity.ok(transactions);
    }

    /**
     * Obtener resumen de amount total de todas las transacciones.
     */
    @GetMapping("/amountSummary")
    public ResponseEntity<ITransactionRepository.SummaryResult> getAmountSummary() {
        logger.info("[TransactionController][GET][SUMMARY] → Solicitando resumen de montos de transacciones");
        ITransactionRepository.SummaryResult summary = transactionService.getAmountSummary();
        logger.info("[TransactionController][GET][SUMMARY][SUCCESS] → Resumen obtenido correctamente");
        return ResponseEntity.ok(summary);
    }

    /**
     * Buscar transacciones dentro de un rango de amount.
     * @param min valor mínimo
     * @param max valor máximo
     * @return Lista de transacciones dentro del rango.
     */
    @GetMapping("/amountRange")
    public ResponseEntity<List<TransactionModel>> getByAmountRange(@RequestParam double min, @RequestParam double max) {
        logger.info("[TransactionController][GET][RANGE] → Buscando transacciones con amount entre {} y {}", min, max);
        List<TransactionModel> list = transactionService.getByAmountRange(min, max);
        logger.info("[TransactionController][GET][RANGE][SUCCESS] → Total de transacciones encontradas: {}", list.size());
        return ResponseEntity.ok(list);
    }
}
