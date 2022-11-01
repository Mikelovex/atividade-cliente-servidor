package com.atividade.atividade.repositories;

import org.springframework.data.repository.CrudRepository;

import com.atividade.atividade.models.Categoria;

public interface CategoriaRepository
        extends CrudRepository<Categoria, Integer> {

}
