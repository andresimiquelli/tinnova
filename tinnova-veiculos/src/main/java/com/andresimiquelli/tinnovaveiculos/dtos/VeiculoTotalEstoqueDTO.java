package com.andresimiquelli.tinnovaveiculos.dtos;

public class VeiculoTotalEstoqueDTO {

	private int total;
	
	public VeiculoTotalEstoqueDTO() {}

	public VeiculoTotalEstoqueDTO(int total) {
		super();
		this.total = total;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}
