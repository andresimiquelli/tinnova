package com.andresimiquelli.tinnovaveiculos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.andresimiquelli.tinnovaveiculos.entities.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

	List<Veiculo> findByAno(int ano);
	
	List<Veiculo> findByMarca(String marca);
	
	List<Veiculo> findByCor(String cor);
	
	List<Veiculo> findByAnoAndMarca(int ano, String marca);
	
	List<Veiculo> findByAnoAndCor(int ano, String cor);
	
	List<Veiculo> findByMarcaAndCor(String marca, String cor);
	
	List<Veiculo> findByAnoAndMarcaAndCor(int ano, String marca, String cor); 
	
	int countByVendido(boolean vendido);
	
	@Query("SELECT MAX(ano) FROM Veiculo")
	int maxAno();
	
	@Query("SELECT MIN(ano) FROM Veiculo")
	int minAno();
	
	@Query("SELECT COUNT(*) FROM Veiculo WHERE ano >= ?1 AND ano <= ?2")
	int countByAno(int start, int end);
	
	int countByMarca(String marca);
}
