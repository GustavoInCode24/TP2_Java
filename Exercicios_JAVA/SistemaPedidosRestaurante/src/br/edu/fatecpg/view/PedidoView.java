package br.edu.fatecpg.view;
import br.edu.fatecpg.model.*;
import java.util.ArrayList;

public class PedidoView {
	public void exibirPedidos(ArrayList<ItemPedido> itens_pedido) {
		for(ItemPedido i : itens_pedido) {
			System.out.println("Produto: " + i.getNomeDoPrato() + " | Quantidade: " + i.getQuantidade() + 
					" | Preço: " + i.getPrecoUnitario());
		}
	}
	
	public void exibirListaPedidos(ArrayList<Pedido> pedidos) {
		if(pedidos.isEmpty()) {
			System.out.println("Não há pedidos no sistema.");
		} else {				
				for(Pedido p : pedidos) {
					System.out.println("Pedido Nº" + p.getNumero() + ":");
					exibirPedidos(p.getItensPedido());
					System.out.println("");
			}
		}
	}
}
