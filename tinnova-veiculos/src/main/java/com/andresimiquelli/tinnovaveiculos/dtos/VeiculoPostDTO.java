package com.andresimiquelli.tinnovaveiculos.dtos;

import com.andresimiquelli.tinnovaveiculos.services.VeiculoPostValidation;

@VeiculoPostValidation
public class VeiculoPostDTO {

	private String veiculo;
	private String marca;
	private Integer ano;
	private String cor;
	private String descricao;
	private Boolean vendido;
	
	public VeiculoPostDTO() {}

	public VeiculoPostDTO(String veiculo, String marca, Integer ano, String cor, String descricao, Boolean vendido) {

		this.veiculo = veiculo;
		this.marca = marca;
		this.ano = ano;
		this.cor = cor;
		this.descricao = descricao;
		this.vendido = vendido;
	}

	public String getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}
	
	public String getCor() {
		return cor;
	}
	
	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getVendido() {
		return vendido;
	}

	public void setVendido(Boolean vendido) {
		this.vendido = vendido;
	}
	
	
}
