package com.andresimiquelli.tinnovaveiculos.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.andresimiquelli.tinnovaveiculos.dtos.VeiculoDTO;
import com.andresimiquelli.tinnovaveiculos.dtos.VeiculoPostDTO;
import com.andresimiquelli.tinnovaveiculos.entities.Veiculo;
import com.andresimiquelli.tinnovaveiculos.repositories.VeiculoRepository;
import com.andresimiquelli.tinnovaveiculos.services.VeiculoService;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoResource {

	@Autowired
	VeiculoService service;
	
	@GetMapping
	public ResponseEntity<List<VeiculoDTO>> findAll() {
		List<VeiculoDTO> list = service.listAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<VeiculoDTO> find(@PathVariable Long id) {
		VeiculoDTO veiculo = service.find(id);
		return ResponseEntity.ok(veiculo);
	}
	
	@PostMapping
	public ResponseEntity<VeiculoDTO> insert(@RequestBody VeiculoPostDTO veiculo) {
		VeiculoDTO newVeiculo = service.store(veiculo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(newVeiculo.getId()).toUri();
		return ResponseEntity.created(uri).body(newVeiculo);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<VeiculoDTO> update(@PathVariable Long id, @RequestBody VeiculoPostDTO veiculo) {
		VeiculoDTO updated = service.update(id, veiculo);
		return ResponseEntity.ok(updated);
	}
}
