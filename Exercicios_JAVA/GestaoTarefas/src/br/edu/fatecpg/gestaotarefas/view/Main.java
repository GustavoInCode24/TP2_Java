package br.edu.fatecpg.gestaotarefas.view;
import br.edu.fatecpg.gestaotarefas.model.Consulta;
import br.edu.fatecpg.gestaotarefas.model.Tarefa;
import br.edu.fatecpg.gestaotarefas.controller.TarefaController;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        TarefaController tt = new TarefaController();
        Scanner sc = new Scanner(System.in);
        boolean run = true;

        while (run){
            System.out.println("\n--Menu De Tarefas--");
            System.out.println("1- Adicionar Tarefa");
            System.out.println("2- Exibir Tarefa");
            System.out.println("3- Excluir Tarefa");
            System.out.println("4- Sair ");
            System.out.println("Escolha um opção");

            int op = sc.nextInt();

            switch (op){
                case 1:
                    System.out.println("Qual o nome da  tarefa?");
                    String nometarefa = sc.next();
                    System.out.println("Qual a categoria?");
                    String categoria = sc.nextLine();
                    sc.nextLine();
                    System.out.println("Status (true ou false)");
                    boolean  status = sc.nextBoolean();
                    System.out.println("data da tarefa (DD/MM/AAAA)");
                    String data = sc.next();

                    tt.inserirtarefa(nometarefa,categoria,status,data);
                    System.out.println("Tarefa Registrada com sucesso");
                    break;

                case 2:
                    System.out.println("Selecione uma opção: ");
                    System.out.println("1- Selecionar todas a Tarefas");
                    System.out.println("2- Selecionar por categoria ");
                    System.out.println("3- selecionar por status");
                    System.out.println("Opção: ");

                    int selectoption = sc.nextInt();
                    sc.nextLine();

                    switch (selectoption){

                        case 1:
                            System.out.println("Todas as tarefas");
                            System.out.println(tt.selecionarTarefa());
                            break;
                        case 2:
                            System.out.println("Digite sua categoria:");
                            String cat = sc.next();
                            System.out.println("Tarefas da categoria  " + cat + ": ");
                            System.out.println(tt.selecionarTarefasCategoria(cat));
                            break;

                        case 3:
                            System.out.println("Status (true ou false)");
                            boolean st = sc.nextBoolean();
                            sc.next();
                            System.out.println("Tarefas com Status " + st + ":");
                            System.out.println(tt.selecionarTarefasStatus(st));
                            break;
                        default:
                            System.out.println("Opção invalida");
                    }
                    break;

                case 3:
                    System.out.println("Digite o ID da tarefa para excluir: ");
                    int idExcluir = sc.nextInt();
                    sc.nextLine();
                    tt.excluirTarefa(idExcluir);
                    System.out.println("Tarefa Excluida (se existir)");
                    break;

                case 4:
                    run = false;
                    System.out.println("Encerrado o programa...");
                    break;
                default:
                    System.out.println("Opção invalida, tente novamente ");
            }
        }
        sc.close();




    }

}
