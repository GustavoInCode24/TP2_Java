package br.edu.fatecpg.SistemaTreinamentoTecnologia.controller;
import br.edu.fatecpg.SistemaTreinamentoTecnologia.model.*;
import java.util.ArrayList;


public class AgendaTreinamento {

	private int horas = 80;
	public Treinamento treinamento;
	public Aluno aluno;
	
	public AgendaTreinamento(Treinamento treinamento,Aluno aluno) {
		
		this.treinamento = treinamento;
		this.aluno = aluno;
	}
	
	
	public boolean verificarDisponibilidade(int id){
		
		if (id == treinamento.getId()) {
		
			System.out.println("O instrutor está disponivel");
			return true;
		}else {
			System.out.println("O instrutor não está disponivel");
			
			return false;
		}	
		
	}
	
	public void setdefinirCargaHoraria(int horas) {
		
		this.horas = horas;
		
	}
	
	public int getdefinirCargaHoraria() {
		
		return horas;
		
	}
	
		public boolean verificarUltimaAula(int horas,Aluno aluno) {
			
			
			
			if(aluno.getHorasFeitas() < 80) {
				
				System.out.println("Aula pode ser realizada");
				return true;
				
			}else {
				
				System.out.println("Limite de horas aula atingido");
				
				return false;
			}

		}
		
		public void calcularMedida(Aluno aluno) {
			double media = aluno.getNotaFinal() / 2;
			
			System.out.println("A media Fianl é " + media);
			
		}
		
			
			
		
		
	}
	

