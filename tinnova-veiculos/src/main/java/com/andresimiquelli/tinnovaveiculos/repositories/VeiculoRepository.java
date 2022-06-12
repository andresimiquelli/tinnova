package com.andresimiquelli.tinnovaveiculos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andresimiquelli.tinnovaveiculos.entities.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

	List<Veiculo> findByAno(int ano);
	
	List<Veiculo> findByMarca(String marca);
	
	List<Veiculo> findByCor(String cor);
	
	List<Veiculo> findByAnoAndMarca(int ano, String marca);
	
	List<Veiculo> findByAnoAndCor(int ano, String cor);
	
	List<Veiculo> findByMarcaAndCor(String marca, String cor);
	
	List<Veiculo> findByAnoAndMarcaAndCor(int ano, String marca, String cor); 
}
