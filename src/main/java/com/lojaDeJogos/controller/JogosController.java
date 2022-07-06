package com.lojaDeJogos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lojaDeJogos.model.Jogos;
import com.lojaDeJogos.repository.JogosRepository;

@RestController
@RequestMapping("/jogos")
@CrossOrigin("*")
public class JogosController {

	@Autowired
	public JogosRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Jogos>> getlAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Jogos>> getByNome(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Jogos> getById(@PathVariable Integer id) {
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Jogos> post(@RequestBody Jogos jogos) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(jogos));
	}
	
	@PutMapping
	public ResponseEntity<Jogos> put(@RequestBody Jogos jogos) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(jogos));
	}
	
	@DeleteMapping("{id}")
	public void deleteById(@PathVariable Integer id) {
		repository.deleteById(id);
	}
}
