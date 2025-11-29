package polyglot.ms.test.pay.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import polyglot.ms.test.pay.constans.ApiRoutes;


import io.swagger.v3.oas.annotations.tags.Tag;
import polyglot.ms.test.pay.dto.PayRequest;
import polyglot.ms.test.pay.model.PayModel;
import polyglot.ms.test.pay.service.IPayService;

@RestController
@RequestMapping(ApiRoutes.Pay.BASE)
@Tag(name = "Facturas", description = "Endpoints para la gestión y consulta de facturas del sistema")
public class PayController {


        @Autowired
        IPayService payService;

        // @Autowired
        // PayMessagePublish messageEvent;

        Logger logger = LoggerFactory.getLogger(PayController.class);

        @PostMapping("/register")
        public ResponseEntity<?> register(@RequestBody PayRequest request) throws Exception {

                logger.info("Post: InvoiceId {} - Ammount {}", request.getId_invoice(), request.getAmount());
                PayModel payModel = new PayModel();
                payModel.setId_invoice(request.getId_invoice());
                payModel.setAmount(request.getAmount());
                payModel = payService.add(payModel);
                logger.info("transactionModel {}", payModel);
                // messageEvent.sendDepositEvent(payModel);                
                return ResponseEntity.status(HttpStatus.CREATED).body(payModel);
        }

}
