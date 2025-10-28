package br.edu.fatecpg.sistema_inventario.view;

import br.edu.fatecpg.sistema_inventario.controller.*;
import br.edu.fatecpg.sistema_inventario.model.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class SistemaView {
    private final SistemaController controller;
    private final Scanner scanner;

    public SistemaView(SistemaController controller){
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void carregarDadosIniciais(){
        controller.carregarDados();
        System.out.println("Dados carregados.");
    }

    public void salvarDadosFinais(){
        controller.salvarDados();
        scanner.close();
        System.out.println("Sistema encerrado. Dados salvos.");
    }

    public void iniciar(){
        boolean executando = true;
        while(executando){
            System.out.println("\n--- Sistema de Gerenciamento ---");
            System.out.println("1. Adicionar/Atualizar Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Buscar Produto por ID");
            System.out.println("4. Criar Pedido");
            System.out.println("5. Listar Pedidos");
            System.out.println("6. Ver Detalhes do Pedido");
            System.out.println("7. Atualizar Status do Pedido");
            System.out.println("0. Sair");
            System.out.println("Escolha uma opção: ");

            try{
                int opcao = Integer.parseInt(scanner.nextLine());
                switch(opcao){
                    case 1:
                        menuAdicionarProduto();
                        break;
                    case 2:
                        menuListarProdutos();
                        break;
                    case 3:
                        menuBuscarProdutos();
                        break;
                    case 4:
                        menuCriarPedido();
                        break;
                    case 5:
                        menuListarPedidos();
                        break;
                    case 6:
                        menuDetalhesPedido();
                        break;
                    case 7:
                        menuAtualizarStatusPedido();
                        break;
                    case 0:
                        executando = false;
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (NumberFormatException e){
                System.out.println("Erro: Entrada inválida. Digite um número.");
            }
        }
    }

    private void menuAdicionarProduto(){
        try{
            System.out.println("ID do Produto: ");
            String id = scanner.nextLine();
            System.out.println("Nome do Produto: ");
            String nome = scanner.nextLine();
            System.out.println("Preço: ");
            double preco = Double.parseDouble(scanner.nextLine());
            System.out.println("Quantidade em Estoque: ");
            int qtd = Integer.parseInt(scanner.nextLine());

            String resultado = controller.adicionarProduto(id, nome, preco, qtd);
            System.out.println(resultado);
        } catch (NumberFormatException e){
            System.out.println("Erro: Preço ou quantidade inválidos.");
        }
    }

    public void menuListarProdutos(){
        Collection<Produto> produtos = controller.getTodosProdutos();
        if(produtos.isEmpty()){
            System.out.println("Nenhum produto cadastrado");
            return;
        }
        System.out.println("\n--- Lista de Produtos ---");
        produtos.forEach(System.out::println);
    }

    public void menuBuscarProdutos(){
        System.out.println("Digite o ID do produto: ");
        String id = scanner.nextLine();

        Optional<Produto> produtoOpt = controller.buscarProdutoPorId(id);

        produtoOpt.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Produto com ID '" + id + "' não encontrado.")
        );
    }

    public void menuCriarPedido(){
        System.out.println("Nome do Cliente: ");
        String nomeCliente = scanner.nextLine();

        String emailCliente;
        do{
            System.out.println("E-mail do Cliente: ");
            emailCliente = scanner.nextLine();

            if(!controller.validarEmail(emailCliente)){
                System.out.println("E-mail inválido. Tente novamente.");
            }
        } while(!controller.validarEmail(emailCliente));

        List<ItemPedido> itens = new ArrayList<>();
        boolean adicionandoItens = true;

        System.out.println("--- Adicionando Itens ao Pedido ---");
        while(adicionandoItens){
            System.out.println("ID do Produto (ou 'fim' para encerrar): ");
            String produtoId = scanner.nextLine();

            if("fim".equalsIgnoreCase(produtoId)){
                adicionandoItens = false;
                continue;
            }

            Optional<Produto> produtoOpt = controller.buscarProdutoPorId(produtoId);

            if(produtoOpt.isEmpty()){
                System.out.println("Produto não encontrado.");
                continue;
            }

            Produto produto = produtoOpt.get();
            try{
                System.out.print("Quantidade desejada (Estoque: " + produto.getQtdEstoque() + "): ");
                int qtd = Integer.parseInt(scanner.nextLine());

                if(qtd <= 0){
                    System.out.println("Quantidade deve ser positiva.");
                } else if(qtd > produto.getQtdEstoque()){
                    System.out.println("Estoque insuficiente.");
                } else{
                    itens.add(new ItemPedido(produto, qtd));
                    System.out.println("Item adicionado.");
                }
            } catch (NumberFormatException e){
                System.out.println("Item adicionado.");
            }
        }
        if(itens.isEmpty()){
            System.out.println("Pedido cancelado (nenhum item adicionado).");
            return;
        }
        String novoPedidoId = controller.criarPedido(nomeCliente, emailCliente, itens);
        System.out.println("Pedido criado com sucesso! ID: " + novoPedidoId);
    }

    private void menuListarPedidos(){
        Collection<Pedido> pedidos = controller.getTodosPedidos();
        if(pedidos.isEmpty()){
            System.out.println("Nenhum pedido cadastrado.");
            return;
        }
        System.out.println("\n--- Resumo de Pedidos ---");
        pedidos.forEach(p -> System.out.println(p.getResumo()));
    }

    private void menuDetalhesPedido(){
        System.out.println("Digite o ID do Pedido: ");
        String id = scanner.nextLine();

        controller.buscarPedidoPorId(id).ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Pedido com ID '" + id + "' não encontrado.")
        );
    }

    private void menuAtualizarStatusPedido(){
        System.out.println("Digite o ID do Pedido: ");
        String id = scanner.nextLine();

        Optional<Pedido> pedidoOpt = controller.buscarPedidoPorId(id);

        if(pedidoOpt.isEmpty()){
            System.out.println("Pedido não encontrado.");
            return;
        }
        Pedido pedido = pedidoOpt.get();
        System.out.println("Status atual: " + pedido.getStatus().getDescricao());
        System.out.println("Selecione o novo status:");

        StatusPedido.exibirOpcoes();
        System.out.println("Opção: ");

        try{
            int escolha = Integer.parseInt(scanner.nextLine());
            boolean sucesso = controller.atualizarStatusPedido(pedido, escolha);

            if(sucesso){
                System.out.println("Status atualizado para: " + pedido.getStatus().getDescricao());
            } else{
                System.out.println("Opção de status inválida.");
            }
        } catch(NumberFormatException e){
            System.out.println("Entrada inválida");
        }
    }
}
