package com.atividade.atividade.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.atividade.atividade.models.Livro;

public interface LivroRepository
		extends CrudRepository<Livro, Integer> {

	public List<Livro> findByCategoriaContaining(String categoria);

}
