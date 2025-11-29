package polyglot.ms.test.invoice.controller;

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
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import polyglot.ms.test.invoice.constans.ApiRoutes;
import polyglot.ms.test.invoice.dto.InvoiceRequestCreate;
import polyglot.ms.test.invoice.dto.InvoiceRequestUpdate;
import polyglot.ms.test.invoice.model.InvoiceModel;
import polyglot.ms.test.invoice.service.IInvoiceService;

@RestController
@RequestMapping(ApiRoutes.Invoice.BASE)
@Tag(name = "Facturas", description = "Endpoints para la gestión y consulta de facturas del sistema")
public class InvoiceController {

    @Autowired
    private IInvoiceService invoiceService;

    private static final Logger logger = LoggerFactory.getLogger(InvoiceController.class);

    /**
     * LISTAR - Devuelve todas las facturas.
     */
    @GetMapping(ApiRoutes.Invoice.LISTAR)
    public List<InvoiceModel> get() {
        logger.info("[InvoiceController][GET][LIST] → Solicitando listado completo de facturas");
        List<InvoiceModel> invoices = invoiceService.findAll();
        logger.info("[InvoiceController][GET][LIST][SUCCESS] → Total de facturas encontradas: {}", invoices.size());
        return invoices;
    }

    /**
     * READ - Obtiene una factura por su ID.
     */
    @GetMapping(ApiRoutes.Invoice.ID_INVOICE)
    public ResponseEntity<InvoiceModel> getById(@PathVariable Integer id_operation) {
        logger.info("[InvoiceController][GET][READ] → Buscando factura por id_operation={}", id_operation);

        InvoiceModel invoice = invoiceService.findById(id_operation);
        if (invoice == null) {
            logger.warn("[InvoiceController][GET][READ][NOT_FOUND] → No se encontró factura con id_operation={}", id_operation);
            return ResponseEntity.notFound().build();
        }

        logger.info("[InvoiceController][GET][READ][SUCCESS] → Factura encontrada id_operation={}", id_operation);
        return ResponseEntity.ok(invoice);
    }

    /**
     * CREATE - Crea una nueva factura.
     */
    @PostMapping(ApiRoutes.Invoice.CREAR)
    public ResponseEntity<InvoiceModel> create(@RequestBody InvoiceRequestCreate invoice) {
        logger.info("[InvoiceController][POST][CREATE] → Creando nueva factura: amount={}, state={}", 
                invoice.getAmount(), invoice.getState());

        InvoiceModel model = new InvoiceModel(
            invoice.getAmount(),
            invoice.getState()
        );
        InvoiceModel model_insert = invoiceService.add(model);

        logger.info("[InvoiceController][POST][CREATE][SUCCESS] → Factura creada con ID={}", model_insert.getIdOperation());
        return new ResponseEntity<>(model_insert, HttpStatus.CREATED);
    }

    /**
     * UPDATE - Actualiza una factura existente.
     */
    @PutMapping(ApiRoutes.Invoice.UPDATE)
    public ResponseEntity<InvoiceModel> update(@PathVariable Integer id_operation, @RequestBody InvoiceRequestUpdate invoice) {
        logger.info("[InvoiceController][PUT][UPDATE] → Actualizando factura id_operation={}", id_operation);

        InvoiceModel updatedInvoice = invoiceService.update(id_operation, invoice);
        if (updatedInvoice == null) {
            logger.warn("[InvoiceController][PUT][UPDATE][NOT_FOUND] → No se encontró factura con id_operation={}", id_operation);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        logger.info("[InvoiceController][PUT][UPDATE][SUCCESS] → Factura actualizada id_operation={}", id_operation);
        return ResponseEntity.ok(updatedInvoice);
    }

    /**
     * DELETE - Elimina una factura por su ID.
     */
    @DeleteMapping(ApiRoutes.Invoice.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id_operation) {
        logger.info("[InvoiceController][DELETE][REMOVE] → Eliminando factura id_operation={}", id_operation);

        InvoiceModel existing = invoiceService.findById(id_operation);
        if (existing == null) {
            logger.warn("[InvoiceController][DELETE][REMOVE][NOT_FOUND] → No se encontró factura con id_operation={}", id_operation);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        invoiceService.deleteById(id_operation);
        logger.info("[InvoiceController][DELETE][REMOVE][SUCCESS] → Factura eliminada id_operation={}", id_operation);
        return ResponseEntity.noContent().build();
    }
}

