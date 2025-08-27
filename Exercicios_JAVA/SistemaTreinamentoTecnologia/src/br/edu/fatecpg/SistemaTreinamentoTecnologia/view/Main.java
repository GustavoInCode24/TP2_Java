package br.edu.fatecpg.SistemaTreinamentoTecnologia.view;
import java.util.ArrayList;
import br.edu.fatecpg.SistemaTreinamentoTecnologia.model.*;
import br.edu.fatecpg.SistemaTreinamentoTecnologia.controller.*;

public class Main {

	public static void main(String[] args) {
		
		//ArrayList<Aluno> aluno = new ArrayList<>();
		 
		//Aluno aluno1 = new Aluno("Diego",10); 
		//Aluno aluno2 = new Aluno("Zito",9);
		
		//aluno1.setNomeAluno("Diego");
		//aluno2.setNomeAluno("Zito");
		
		//aluno1.setNotaFinal(10);
		//aluno2.setNotaFinal(9);
		
		//System.out.println(aluno1.getNomeAluno());
		//System.out.println(aluno1.getNotaFinal());
		
		//System.out.println(aluno2.getNomeAluno());
		//System.out.println(aluno2.getNotaFinal());
		
		//Treinamento tt = new Treinamento(2, "Rodrigo", "PHP");
		
		//AgendaTreinamento agenda = new AgendaTreinamento(tt,null);
		
		//System.out.println(agenda.verificarDisponibilidade(2));
		//agenda.setdefinirCargaHoraria(30);
		//System.out.println(agenda.getdefinirCargaHoraria());
		
		 // Crie os alunos que serão adicionados aos treinamentos
        Aluno aluno1 = new Aluno("João Silva", 9.5, 75.0);
        Aluno aluno2 = new Aluno("Maria Oliveira", 8.0, 80.0);
        Aluno aluno3 = new Aluno("Pedro Santos", 7.5, 60.0);
        
        // --- Instanciando Treinamento Presencial ---
        
        // Crie o objeto de TreinamentoPresencial
        TreinamentoPresencial treinamentoPresencial = new TreinamentoPresencial(
            1, // ID do treinamento
            "Ana Paula", // Nome do instrutor
            "Java Avançado", // Linguagem ensinada
            "Sala 101" // Local do treinamento
        );
        
        // Adicione alunos ao treinamento presencial
        // O método 'alunos' não existe na sua classe Treinamento,
        // então adicionei um método 'addAluno' para fazer isso.
        treinamentoPresencial.addAluno(aluno1);
        treinamentoPresencial.addAluno(aluno2);
        
        System.out.println("--- Detalhes do Treinamento Presencial ---");
        System.out.println("ID: " + treinamentoPresencial.getId());
        System.out.println("Instrutor: " + treinamentoPresencial.getNomeInstrutor());
        System.out.println("Linguagem: " + treinamentoPresencial.getLinguagemEnsinada());
        System.out.println("Local: " + treinamentoPresencial.getLocal());
        System.out.println("Alunos:");
        for (Aluno aluno : treinamentoPresencial.getAlunos()) {
            System.out.println("- " + aluno.getNomeAluno());
        }
        
        System.out.println("\n");
        
        // --- Instanciando Treinamento Online ---
        
        // Crie o objeto de TreinamentoOnline
        TreinamentoOnline treinamentoOnline = new TreinamentoOnline(
            2, // ID do treinamento
            "Carlos Eduardo", // Nome do instrutor
            "Python para Dados" // Linguagem ensinada
            // O link de acesso não pode ser definido no construtor
        );
        
        // Defina o link de acesso usando o setter
        treinamentoOnline.setLinkAcesso("http://meet.google.com/python-dados-treinamento");

        // Adicione alunos ao treinamento online
        treinamentoOnline.addAluno(aluno3);

        System.out.println("--- Detalhes do Treinamento Online ---");
        System.out.println("ID: " + treinamentoOnline.getId());
        System.out.println("Instrutor: " + treinamentoOnline.getNomeInstrutor());
        System.out.println("Linguagem: " + treinamentoOnline.getLinguagemEnsinada());
        System.out.println("Link de Acesso: " + treinamentoOnline.getLinkAcesso());
        System.out.println("Alunos:");
        for (Aluno aluno : treinamentoOnline.getAlunos()) {
            System.out.println("- " + aluno.getNomeAluno());

		
		
        }          
	}
}


