package com.yanhua.ms.operacion.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yanhua.ms.operacion.constans.ApiRoutes;
import com.yanhua.ms.operacion.dto.OperacionMapper;
import com.yanhua.ms.operacion.dto.OperacionRequest;
import com.yanhua.ms.operacion.dto.OperacionResponse;
import com.yanhua.ms.operacion.model.OperacionModel;
import com.yanhua.ms.operacion.service.IOperacionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

@Tag(name = "Operaciones", description = "Operaciones relacionadas con transacciones")
@RestController
@RequestMapping(ApiRoutes.Operacion.BASE)
public class OperacionController {

        @Autowired
        IOperacionService operacionService;

        @Autowired
        OperacionMapper operacionMapper;

        private static final Logger logger = LoggerFactory.getLogger(OperacionController.class);

        @PostMapping(ApiRoutes.Operacion.REGISTRAR)
        public ResponseEntity<OperacionResponse> RegistrarOperacion(@RequestBody OperacionRequest request) {
                logger.info("Solicitud de registro de operación para el cliente ID: {}", request.getIdCliente());
               
                OperacionModel model = operacionMapper.toEntity(request);
                model = operacionService.Registrar(model);
                OperacionResponse response = operacionMapper.toResponse(model);
                
                return new ResponseEntity<>(response, HttpStatus.CREATED);
        }

        @GetMapping(ApiRoutes.Operacion.LISTAR)
        public ResponseEntity<List<OperacionModel>> ListarOperacion() {
                logger.info("Solicitud de listado de operaciones");
                List<OperacionModel> result = operacionService.Listar();
                return new ResponseEntity<>(result, HttpStatus.OK);
        }

}
