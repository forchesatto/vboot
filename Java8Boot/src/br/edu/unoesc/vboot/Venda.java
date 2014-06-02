package br.edu.unoesc.vboot;

import java.time.LocalDate;

public class Venda {

	private LocalDate dataVenda;
	private Double valorTotal;

	public Venda() {
	}

	public Venda(LocalDate dataVenda, Double valorTotal) {
		super();
		this.dataVenda = dataVenda;
		this.valorTotal = valorTotal;
	}

	public LocalDate getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDate dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

}
