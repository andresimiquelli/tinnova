package com.andresimiquelli.tinnovaveiculos.dtos;

public class VeiculoDecadaDTO {

	private int decada;
	private int total;
	
	public VeiculoDecadaDTO() {}

	public VeiculoDecadaDTO(int decada, int total) {
		super();
		this.decada = decada;
		this.total = total;
	}

	public int getDecada() {
		return decada;
	}

	public void setDecada(int decada) {
		this.decada = decada;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}
