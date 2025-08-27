package br.edu.fatecpg.SistemaTreinamentoTecnologia.model;


public class Aluno {
	private double horasFeitas;
	private String nomeAluno;
	private double notaFinal;
	
	//Construtor
	public Aluno(String nomeAluno,double notaFinal,double horasFeitas) {
		this.nomeAluno = nomeAluno;
		this.notaFinal = notaFinal;
		this.horasFeitas=horasFeitas;
	}
	
	//get e set
	
	public void setNomeAluno(String nomeAluno) {
		
		this.nomeAluno = nomeAluno;
		
	}
	
	public void setNotaFinal(double notaFinal) {
		
		this.notaFinal = notaFinal;
	}
	
	public double getNotaFinal() {
		return notaFinal;
	}
	
	public String getNomeAluno() {
		return nomeAluno;
	}
	public void setHorasFeitas(double horasFeitas) {
		this.horasFeitas=horasFeitas;
		
	}
	public double getHorasFeitas() {
		return horasFeitas;
	}
	
	
	
}
