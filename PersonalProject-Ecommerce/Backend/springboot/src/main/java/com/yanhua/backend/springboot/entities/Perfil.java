package com.yanhua.backend.springboot.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "perfil")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "perfilId")
    private Integer perfilId;

    @Column(name = "perfilNombres")
    private String perfilNombres;

    @Column(name = "perfilPaterno")
    private String perfilPaterno;

    @Column(name = "perfilMaterno")
    private String perfilMaterno;

    @Column(name = "perfilCelular")
    private String perfilCelular;
   
    @Column(name = "perfilDni", nullable = false, unique = true, length = 8)
    private String perfilDni;
    
    @OneToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User usuario;
    
    @Column(name = "perfilRegisterDate")
    private LocalDateTime perfilRegisterDate;
}
