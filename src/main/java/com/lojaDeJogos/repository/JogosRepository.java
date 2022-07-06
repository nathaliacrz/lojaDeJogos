package com.lojaDeJogos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lojaDeJogos.model.Jogos;

@Repository
public interface JogosRepository extends JpaRepository<Jogos, Integer>{

	public List<Jogos> findAllByNomeContainingIgnoreCase(String jogos);
}
