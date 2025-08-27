package br.edu.fatecpg.reservas.model;
import br.edu.fatecpg.reservas.*;
import java.util.List;
import java.util.ArrayList;

public class Voo {
	private String numeroVoo;
	private String cidadeOrigem;
	private String cidadeDestino;
	private int assentosDisponiveis;
	
	public Voo(String numeroVoo, String cidadeOrigem, String cidadeDestino, int assentosDisponiveis) {
		this.numeroVoo = numeroVoo;
		this.cidadeOrigem = cidadeOrigem;
		this.cidadeDestino = cidadeDestino;
		this.assentosDisponiveis = assentosDisponiveis;
	}

	public String getNumeroVoo() {
		return numeroVoo;
	}

	public void setNumeroVoo(String numeroVoo) {
		this.numeroVoo = numeroVoo;
	}

	public String getCidadeOrigem() {
		return cidadeOrigem;
	}

	public void setCidadeOrigem(String cidadeOrigem) {
		this.cidadeOrigem = cidadeOrigem;
	}

	public String getCidadeDestino() {
		return cidadeDestino;
	}

	public void setCidadeDestino(String cidadeDestino) {
		this.cidadeDestino = cidadeDestino;
	}

	public int getAssentosDisponiveis() {
		return assentosDisponiveis;
	}

	public void setAssentosDisponiveis(int assentosDisponiveis) {
		this.assentosDisponiveis = assentosDisponiveis;
	}

	@Override
	public String toString() {
		return "Voo [numeroVoo=" + numeroVoo + ", cidadeOrigem=" + cidadeOrigem + ", cidadeDestino=" + cidadeDestino
				+ ", assentosDisponiveis=" + assentosDisponiveis + "]";
	}
	
}
