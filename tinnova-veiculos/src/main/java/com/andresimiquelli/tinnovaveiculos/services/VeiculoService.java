package com.andresimiquelli.tinnovaveiculos.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andresimiquelli.tinnovaveiculos.dtos.VeiculoDTO;
import com.andresimiquelli.tinnovaveiculos.dtos.VeiculoPostDTO;
import com.andresimiquelli.tinnovaveiculos.entities.Veiculo;
import com.andresimiquelli.tinnovaveiculos.repositories.VeiculoRepository;

@Service
public class VeiculoService {

	@Autowired
	private VeiculoRepository repository;
	
	public List<VeiculoDTO> listAll() {
		List<Veiculo> result = repository.findAll();
		List<VeiculoDTO> list = result.stream().map(item -> new VeiculoDTO(item)).collect(Collectors.toList());
		return list;
	}
	
	public VeiculoDTO find(Long id) {
		Veiculo result = repository.findById(id).get();
		return new VeiculoDTO(result);
	}
	
	public VeiculoDTO store(VeiculoPostDTO veiculo) {
		Veiculo newVeiculo = fromDTO(veiculo);
		newVeiculo = repository.save(newVeiculo);
		return new VeiculoDTO(newVeiculo);
	}
	
	public VeiculoDTO update(Long id, VeiculoPostDTO veiculo) {
		Veiculo exists = repository.findById(id).get();
		exists = fromDTO(exists, veiculo);
		exists = repository.save(exists);
		return new VeiculoDTO(exists);
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
	
	private Veiculo fromDTO(Veiculo veiculo, VeiculoPostDTO data) {
		
		veiculo.setVeiculo(data.getVeiculo());
		veiculo.setMarca(data.getMarca());
		veiculo.setAno(data.getAno());
		veiculo.setDescricao(data.getDescricao());
		veiculo.setVendido(data.getVendido());
		
		return veiculo;
	}
}
