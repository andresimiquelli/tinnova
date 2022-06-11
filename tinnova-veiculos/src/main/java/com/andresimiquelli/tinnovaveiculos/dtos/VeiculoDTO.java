package com.andresimiquelli.tinnovaveiculos.dtos;

import java.util.Date;

import com.andresimiquelli.tinnovaveiculos.entities.Veiculo;

public class VeiculoDTO {

	private Long id;
	private String veiculo;
	private String marca;
	private Integer ano;
	private String descricao;
	private Boolean vendido;
	private Date created;
	private Date updated;
	
	public VeiculoDTO() {}
	
	public VeiculoDTO(Veiculo veiculo) {
		id = veiculo.getId();
		this.veiculo = veiculo.getVeiculo();
		marca = veiculo.getMarca();
		ano = veiculo.getAno();
		descricao = veiculo.getDescricao();
		vendido = veiculo.getVendido();
		created = veiculo.getCreated();
		updated = veiculo.getUpdated();
	}

	public VeiculoDTO(Long id, String veiculo, String marca, Integer ano, String descricao, Boolean vendido,
			Date created, Date updated) {

		this.id = id;
		this.veiculo = veiculo;
		this.marca = marca;
		this.ano = ano;
		this.descricao = descricao;
		this.vendido = vendido;
		this.created = created;
		this.updated = updated;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}
}
