package com.andresimiquelli.tinnovaveiculos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andresimiquelli.tinnovaveiculos.dtos.VeiculoPostDTO;
import com.andresimiquelli.tinnovaveiculos.entities.Veiculo;
import com.andresimiquelli.tinnovaveiculos.repositories.VeiculoRepository;

@Service
public class VeiculoService {

	@Autowired
	private VeiculoRepository repository;
	
	public List<Veiculo> listAll() {
		List<Veiculo> result = repository.findAll();
		return result;
	}
	
	public Veiculo find(Long id) {
		Veiculo veiculo = repository.findById(id).get();
		return veiculo;
	}
	
	public Veiculo store(VeiculoPostDTO veiculo) {
		Veiculo newVeiculo = fromDTO(veiculo);
		newVeiculo = repository.save(newVeiculo);
		return newVeiculo;
	}
	
	private Veiculo fromDTO(VeiculoPostDTO data) {
		Veiculo veiculo = new Veiculo();
		
		veiculo.setVeiculo(data.getVeiculo());
		veiculo.setMarca(data.getMarca());
		veiculo.setAno(data.getAno());
		veiculo.setDescricao(data.getDescricao());
		veiculo.setVendido(data.getVendido());
		
		return veiculo;
	}
}
