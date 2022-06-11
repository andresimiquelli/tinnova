package com.andresimiquelli.tinnovaveiculos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andresimiquelli.tinnovaveiculos.entities.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

}
