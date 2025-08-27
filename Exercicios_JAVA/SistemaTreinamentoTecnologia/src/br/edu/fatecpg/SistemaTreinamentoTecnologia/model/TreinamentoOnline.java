package br.edu.fatecpg.SistemaTreinamentoTecnologia.model;
import java.util.ArrayList;
import java.util.List;

public class TreinamentoOnline extends Treinamento{

	private String linkAcesso;
	
	
	public TreinamentoOnline(int id, String nomeInstrutor, String liguagemEnsinada) {
		super(id, nomeInstrutor, liguagemEnsinada);
		this.linkAcesso = linkAcesso;
	}




	public void setLinkAcesso(String linkAcesso) {
		this.linkAcesso = linkAcesso;
	}


	public void addAluno(Aluno aluno3) {
		
		
	}



	public Aluno[] getAlunos() {
		// TODO Auto-generated method stub
		return null;
	}




	public String getLinkAcesso() {
		// TODO Auto-generated method stub
		return null;
	}




	
	
}
