package br.edu.fatecpg.model;
import java.util.ArrayList;

public class Restaurante {
	private ArrayList<Pedido> pedidos;
	private boolean[] mesasReservadas;
	
	public Restaurante(int totalMesas) {
		this.mesasReservadas = new boolean[totalMesas];
		this.pedidos = new ArrayList<>();
	}
	
	public ArrayList<Pedido> getPedidos(){
		return pedidos;
	}
	
	//Método para reservar mesa
	public boolean reservarMesa(int numeroMesa) {
		if(numeroMesa < 0 || numeroMesa > mesasReservadas.length){
			System.out.println("Mesa: " + numeroMesa + " não existe.");
			return false;
		} else if(mesasReservadas[numeroMesa]) {
			System.out.println("Mesa: " + numeroMesa + " já está reservada!");
			return false;
		} else {
			mesasReservadas[numeroMesa] = true;
			System.out.println("Mesa: " + numeroMesa + " reservada com sucesso!");
			return true;
		}
	}
	
	// Métodos para pedidos
	public void adicionarPedidos(Pedido pedido) {
		pedidos.add(pedido);
		System.out.println("Pedido: " + pedido.getNumero() + " adicionado a lista de pedidos.");
	}
	public void removerPedidos(Pedido pedido) {
		if(pedidos.remove(pedido)) {
			System.out.println("Pedido Nº" + pedido.getNumero() + " removido da lista de pedidos.");
		} else {
			System.out.println("Pedido não encontrado.");
		}
	}
	
	
	
}
