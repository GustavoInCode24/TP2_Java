package br.edu.fatecpg.consomeapi.view;
import br.edu.fatecpg.consomeapi.model.Endereco;
import br.edu.fatecpg.consomeapi.service.BuscaEndereco;
import br.edu.fatecpg.consomeapi.Controller.EnderecoController;
import com.google.gson.Gson;
import java.util.Scanner;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scan = new Scanner(System.in);
        BuscaEndereco bE = new BuscaEndereco();
        Gson gson = new Gson();
        EnderecoController endCon = new EnderecoController();
        int opcao;
        do{
            System.out.println("Sistema de busca de endereço: ");
            System.out.println("1 - Buscar CEP");
            System.out.println("2 - Listar CEPs");
            System.out.println("3 - Excluir CEP");
            System.out.print("Opção: ");
            opcao = scan.nextInt();
            scan.nextLine();

            switch(opcao){
                case 1:
                    System.out.print("Digite o cep: ");
                    String cep = scan.nextLine();

                    //JSON
                    String end = bE.obterEndereco(cep);

                    //ToString
                    Endereco novoEnd = gson.fromJson(end, Endereco.class);

                    System.out.println(end);
                    System.out.println(novoEnd);

                    System.out.print("Deseja salvar este endereço? (sim/não): ");
                    String salvar = scan.nextLine();
                    if(salvar.toLowerCase().equals("sim")){
                        endCon.inseriredereco(novoEnd);
                        System.out.println("Endereço salvo com sucesso!");
                    }
                    break;
                case 2:
                    System.out.println("Listar endereços:");
                    String listarenderecos = endCon.exibirendereco();
                    System.out.println(listarenderecos);
                    break;
                case 3:
                    System.out.println("Excluir endereços:");
                    System.out.print("Digite o CEP para exclusão: ");
                    String cepExcluir = scan.nextLine();  // Ler o CEP a ser excluído

                    String excluirenderecos = endCon.excluirEndereco(cepExcluir);
                    System.out.println(excluirenderecos);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while(opcao != 0);
        scan.close();




    }
}
