package br.edu.fatecpg.model;
import java.util.ArrayList;

public class Pedido {
	private int numero;
	private ArrayList<ItemPedido> itens_pedido;
	
	public Pedido(int numero) {
		this.numero = numero;
		this.itens_pedido = new ArrayList<>();
	}
	
	public int getNumero() {
		return numero;
	}
	public ArrayList<ItemPedido> getItensPedido(){
		return itens_pedido;
	}
	public void setNumero(int numero) {
		if(this.numero <= 0) {
			System.out.println("Não é possível guardar este pedido!");
		} else {			
			this.numero = numero;
		}
	}
	
	// Métodos - irei passar para o controller caso não seja regra de negócio!
	public void adicionarItem(ItemPedido item) {
		itens_pedido.add(item);
		System.out.println("Item adicionado: " + item.getNomeDoPrato() + " - " + item.getQuantidade() + " unidades");
		
	}
	public void removerItem(ItemPedido item) {
		itens_pedido.remove(item);
		System.out.println("Item removido: " + item.getNomeDoPrato());
	}
	
	public double calcularTotalPedido() {
		double precoTotal = 0.0;
		for(ItemPedido item : this.itens_pedido) {
			precoTotal += item.getPrecoUnitario() * item.getQuantidade();
		}
		return precoTotal;
	}
	
}
