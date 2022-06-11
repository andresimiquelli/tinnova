package com.andresimiquelli.tinnovaveiculos.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andresimiquelli.tinnovaveiculos.entities.Veiculo;
import com.andresimiquelli.tinnovaveiculos.repositories.VeiculoRepository;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoResource {

	@Autowired
	private VeiculoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Veiculo>> findAll() {
		List<Veiculo> list = repository.findAll();
		return ResponseEntity.ok(list);
	}
}
