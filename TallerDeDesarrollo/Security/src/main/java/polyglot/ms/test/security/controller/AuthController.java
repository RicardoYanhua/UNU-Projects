package polyglot.ms.test.security.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import polyglot.ms.test.security.dto.AuthRequest;
import polyglot.ms.test.security.dto.AuthResponse;
import polyglot.ms.test.security.jwt.JwtToken;
import polyglot.ms.test.security.model.AccessModel;
import polyglot.ms.test.security.service.AuthService;
import polyglot.ms.test.security.constans.ApiRoutes;

@RestController
@RequestMapping(ApiRoutes.Seguridad.BASE)
@Tag(name = "Auth", description = "Endpoints para la gestión y consulta de autentificacion")
public class AuthController {

    @Autowired
    AuthService authService;

    @Autowired
    private JwtToken jwtTokenCross;

    Logger logger = LoggerFactory.getLogger(AuthController.class);

    @GetMapping(ApiRoutes.Seguridad.LISTAR)
    public List<AccessModel> get() {
        return authService.getAcces();
    }

    @PostMapping(ApiRoutes.Seguridad.AUTH)
    public ResponseEntity<?> post(@RequestBody AuthRequest request) throws Exception {
        logger.info("Post: Username {} - Password {}", request.getUsername(), request.getPassword());

        if (!authService.validatedCredentials(request.getUsername(), request.getPassword())) {
            return new ResponseEntity<String>("INVALID_CREDENTIALS", HttpStatus.UNAUTHORIZED);
        }

        String token = jwtTokenCross.generateToken(request);
        AuthResponse response = new AuthResponse(token, request.getUsername(), "1d");

        return ResponseEntity.ok(response);
    }

}
