package br.edu.fatecpg.SistemaTreinamentoTecnologia.model;
import java.util.ArrayList;
import java.util.List;



public class Treinamento {
	
	private int id;
	private String nomeInstrutor;
	private String linguagemEnsinada;
	private List<Aluno> alunos;
	
	//construtor
	public Treinamento(int id,String nomeInstrutor,String liguagemEnsinada) {
		this.id = id;
		this.linguagemEnsinada = linguagemEnsinada;
		this.nomeInstrutor = nomeInstrutor;
		this.alunos = new ArrayList<Aluno>();
	}
	
	
	
	//get e set
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNomeInstrutor(String nomeInstrutor) {
		this.nomeInstrutor = nomeInstrutor;
		
	}
	 
	public void setLinguagemEnsinada(String linguagemEnsinada) {
		
		this.linguagemEnsinada = linguagemEnsinada;
	}
	
	
	public int getId() {
		return id; 
	}
	
	public String getNomeInstrutor() {
		return nomeInstrutor;
		
	}
	
	public String getLinguagemEnsinada() {
		return linguagemEnsinada;
	}



	
}
