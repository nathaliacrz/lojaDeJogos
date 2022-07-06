package com.lojaDeJogos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lojaDeJogos.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

	public List<Categoria> findAllByNomeContainingIgnoreCase(String categoria);

}
