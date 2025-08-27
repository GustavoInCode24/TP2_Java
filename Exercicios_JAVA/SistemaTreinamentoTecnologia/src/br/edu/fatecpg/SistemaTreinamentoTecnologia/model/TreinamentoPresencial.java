package br.edu.fatecpg.SistemaTreinamentoTecnologia.model;
import java.util.ArrayList;
import java.util.List;

public class TreinamentoPresencial extends Treinamento{

	private String local;
	
	
	public TreinamentoPresencial(int id, String nomeInstrutor, String liguagemEnsinada,String local) {
		super(id, nomeInstrutor, liguagemEnsinada);
		this.local = local;
	}


	public String getLocal() {
		return local;
	}


	public void setLocal(String local) {
		this.local = local;
	}


	public void addAluno(Aluno aluno1) {
		// TODO Auto-generated method stub
		
	}


	public Aluno[] getAlunos() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
