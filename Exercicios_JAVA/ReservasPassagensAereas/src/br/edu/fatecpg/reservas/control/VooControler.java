package br.edu.fatecpg.reservas.control;
import br.edu.fatecpg.reservas.*;
import br.edu.fatecpg.reservas.model.Voo;

import java.util.List;
import java.util.ArrayList;

public class VooControler {
 	private ArrayList<Voo> voos = new ArrayList<>();
	
 	public void setVoo(String numeroVoo, String cidadeOrigem, String cidadeDestino, int assentosDisponiveis) {
 		Voo v = new Voo(numeroVoo, cidadeOrigem, cidadeDestino, assentosDisponiveis);
 		voos.add(v);
 	}
	
	public void removerVoo(int id) {
		voos.remove(id);
	}
	
	public String buscarProdutos(int id){
		return voos.get(id).toString();
	}
	
	public String mostrarTudo() {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < voos.size(); i++) {
			sb.append(voos.get(i));
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	public void realizarReserva(int id, int quantidadeAssentos) {
		if(quantidadeAssentos <= voos.get(id).getAssentosDisponiveis()) {
			int assento = voos.get(id).getAssentosDisponiveis() - quantidadeAssentos;
			voos.get(id).setAssentosDisponiveis(assento);
		}
	}
	
	public void verificarDisponibilidade(int id, int quantidadeAssentos) {
		int assento = voos.get(id).getAssentosDisponiveis() - quantidadeAssentos;
		
		if(assento > -1) {
			System.out.println("Há assentos disponivéis!");
		}
		else {
			System.out.println("Não há assentos disponivéis!");
		}
	}
	
	public int realizarPagamento(boolean tipoViagem, boolean pontosTuristicos) {
		int valor = 0;
		
		if(tipoViagem) {
			valor += 100;
		}else {
			valor += 50;
		}
		
		if(pontosTuristicos) {
			valor += 100;
		}
		
		return valor;
	}
	
	public String mostrarPassagem(int id) {
		return voos.get(id).toString();
	}
	
}
