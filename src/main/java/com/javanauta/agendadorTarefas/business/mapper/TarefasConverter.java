package com.javanauta.agendadorTarefas.business.mapper;


import com.javanauta.agendadorTarefas.business.dto.TarefasDTO;
import com.javanauta.agendadorTarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefasConverter {

    TarefasEntity paraTarefaEntity(TarefasDTO dto);

    TarefasDTO paraTarefaDTO(TarefasEntity entity);
}
