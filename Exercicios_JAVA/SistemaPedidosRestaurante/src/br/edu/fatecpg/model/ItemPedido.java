package br.edu.fatecpg.model;

public class ItemPedido {
	private String nomeDoPrato;
	private int quantidade;
	private double precoUnitario;
	
	public ItemPedido(String nomeDoPrato, int quantidade, double precoUnitario) {
		this.nomeDoPrato = nomeDoPrato;
		this.quantidade = quantidade;
		this.precoUnitario = precoUnitario;
	}
	
	public String getNomeDoPrato() {
		return nomeDoPrato;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public double getPrecoUnitario() {
		return precoUnitario;
	}
	
	public void setNomeDoPrato(String nomeDoPrato) {
		this.nomeDoPrato = nomeDoPrato;
	}
	public void setQuantidade(int quantidade) {
		if(quantidade <= 0) {
			System.out.println("Não há quantidade deste item!");
		} else {			
			this.quantidade = quantidade;
		}
	}
	public void setPrecoUnitario(double precoUnitario) {
		if(precoUnitario <= 0) {
			System.out.println("Indique o preço deste item!");
		} else {			
			this.precoUnitario = precoUnitario;
		}
	}
	
	@Override
	public String toString() {
	    return "ItemPedido [nomeDoPrato=" + nomeDoPrato + ", quantidade=" + quantidade + ", precoUnitario=" + precoUnitario + "]";
	}
	
}
