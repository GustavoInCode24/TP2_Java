package br.edu.fatecpg;
import br.edu.fatecpg.model.*;
import br.edu.fatecpg.view.*;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		// Instanciando pedidos 1
		Pedido p1 = new Pedido(1);
		ItemPedido item1 = new ItemPedido("Lanche", 5, 50.0);
		p1.adicionarItem(item1);
		
		ItemPedido item2 = new ItemPedido("Pizza", 1, 70.0);
		p1.adicionarItem(item2);
		p1.removerItem(item1);
		System.out.println("");
		
		ItemPedido item3 = new ItemPedido("Refri", 5, 7.0);
		p1.adicionarItem(item3);
		System.out.println("");
		
		// Instanciando pedidos 2
		Pedido p2 = new Pedido(2);
		ItemPedido item4 = new ItemPedido("Pastel Salgado", 3, 7.50);
		ItemPedido item5 = new ItemPedido("Pastel Doce", 3, 12.50);
		
		p2.adicionarItem(item4);
		p2.adicionarItem(item5);
		System.out.println("");
		
		// Pegando lista de itens do pedido
		ArrayList<ItemPedido> itensDoPedido1 = p1.getItensPedido();
		ArrayList<ItemPedido> itensDoPedido2 = p2.getItensPedido();
		
		// Exibindo Lista de Pedidos - VIEW
		PedidoView view = new PedidoView();
		view.exibirPedidos(itensDoPedido1);
		System.out.println("Total: " + p1.calcularTotalPedido());
		System.out.println("");
		
		view.exibirPedidos(itensDoPedido2);
		System.out.println("Total: " + p2.calcularTotalPedido());
		System.out.println("");
		
		// Verificando reserva de mesas
		Restaurante r = new Restaurante(10); // Adicionando qtd de mesas
		r.reservarMesa(2);
		r.reservarMesa(11);
		r.reservarMesa(2);
		r.adicionarPedidos(p1);
		r.adicionarPedidos(p2);
		System.out.println("");
		
		ArrayList<Pedido> listaPedidos = r.getPedidos();
		view.exibirListaPedidos(listaPedidos);
		
		
		
		
	
	}
}
