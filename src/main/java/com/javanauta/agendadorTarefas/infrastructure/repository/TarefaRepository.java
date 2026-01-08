package com.javanauta.agendadorTarefas.infrastructure.repository;

import com.javanauta.agendadorTarefas.infrastructure.entity.TarefasEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends MongoRepository<TarefasEntity, String> {

}
