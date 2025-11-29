package com.yanhua.backend.springboot.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserGoogleRegister {
	
	@NotBlank(message = "El nombre es obligatorio.")
    private String perfilNombres;

    @NotBlank(message = "El apellido paterno es obligatorio.")
    private String perfilPaterno;

    @NotBlank(message = "El apellido materno es obligatorio.")
    private String perfilMaterno;

    @NotBlank(message = "El celular es obligatorio.")
    @Pattern(regexp = "\\d{9}", message = "El celular debe contener exactamente 9 dígitos numéricos.")
    private String perfilCelular;

    @NotBlank(message = "El DNI es obligatorio.")
    @Pattern(regexp = "\\d{8}", message = "El DNI debe contener exactamente 8 dígitos numéricos.")
    private String perfilDni;

    @NotBlank(message = "El correo electrónico es obligatorio.")
    @Email(message = " Ingrese un correo electrónico válido.")
    private String username;
    
    private String picture;
}