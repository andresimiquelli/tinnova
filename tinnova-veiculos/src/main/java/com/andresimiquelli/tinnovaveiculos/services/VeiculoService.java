package com.andresimiquelli.tinnovaveiculos.services;

import java.util.ArrayList;
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
	
	public List<VeiculoDTO> listAll(String marca, Integer ano) {
		
		List<VeiculoDTO> list = new ArrayList<>();
		
		if(marca != null || ano != null) {
			
			if(marca != null && ano == null) {
				List<Veiculo> result = repository.findByMarca(marca);
				list = resultToDTOList(result);
			}
			
			if(marca == null && ano != null) {
				List<Veiculo> result = repository.findByAno(ano);
				list = resultToDTOList(result);
			}
			
			if(marca != null && ano != null) {
				List<Veiculo> result = repository.findByAnoAndMarca(ano, marca);
				list = resultToDTOList(result);
			}
			
		}else {
			List<Veiculo> result = repository.findAll();
			list = resultToDTOList(result);
		}
		
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
	
	public VeiculoDTO patchUpdate(Long id, VeiculoPostDTO veiculo) {
		Veiculo exists = repository.findById(id).get();
		exists = fromPatchDTO(exists, veiculo);
		exists = repository.save(exists);
		return new VeiculoDTO(exists);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
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
	
	private Veiculo fromPatchDTO(Veiculo veiculo, VeiculoPostDTO data) {
		
		if(data.getVeiculo() != null)
			veiculo.setVeiculo(data.getVeiculo());
		
		if(data.getMarca() != null)
			veiculo.setMarca(data.getMarca());
		
		if(data.getAno() != null)
			veiculo.setAno(data.getAno());
		
		if(data.getDescricao() != null)
			veiculo.setDescricao(data.getDescricao());
		
		if(data.getVendido() != null)
			veiculo.setVendido(data.getVendido());
		
		return veiculo;
	}
	
	private List<VeiculoDTO> resultToDTOList(List<Veiculo> result) {
		List<VeiculoDTO> list = result.stream().map(item -> new VeiculoDTO(item)).collect(Collectors.toList());
		return list;
	}
}
