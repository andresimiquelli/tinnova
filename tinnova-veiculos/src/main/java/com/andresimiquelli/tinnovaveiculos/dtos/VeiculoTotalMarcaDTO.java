package com.andresimiquelli.tinnovaveiculos.dtos;

public class VeiculoTotalMarcaDTO {

	private String marca;
	private Long total;
	
	public VeiculoTotalMarcaDTO() {}

	public VeiculoTotalMarcaDTO(String marca, Long total) {
		super();
		this.marca = marca;
		this.total = total;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}
	
}
