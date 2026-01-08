package com.javanauta.agendadorTarefas.business;

import com.javanauta.agendadorTarefas.business.dto.TarefasDTO;
import com.javanauta.agendadorTarefas.business.mapper.TarefasConverter;
import com.javanauta.agendadorTarefas.infrastructure.entity.TarefasEntity;
import com.javanauta.agendadorTarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.javanauta.agendadorTarefas.infrastructure.repository.TarefaRepository;
import com.javanauta.agendadorTarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefaRepository tarefaRepository;
    private final TarefasConverter tarefasConverter;
    private final JwtUtil jwtUtil;

    public TarefasDTO gravarTarefa(String token, TarefasDTO dto) {
        String email = jwtUtil.extractUsername(token.substring(7));

        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNotificacao(StatusNotificacaoEnum.PENDENTE);
        dto.setEmailUsuario(email);

        TarefasEntity entity = tarefasConverter.paraTarefaEntity(dto);

        return tarefasConverter.paraTarefaDTO(tarefaRepository.save(entity));
    }
}
