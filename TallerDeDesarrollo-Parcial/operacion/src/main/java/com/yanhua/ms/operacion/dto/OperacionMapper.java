package com.yanhua.ms.operacion.dto;


import org.mapstruct.Mapper;

import com.yanhua.ms.operacion.model.OperacionModel;

@Mapper(componentModel = "spring")
public interface OperacionMapper {

    // Request -> Modelo
    OperacionModel toEntity(OperacionRequest request);

    // Modelo -> Response
    OperacionResponse toResponse(OperacionModel model);
}