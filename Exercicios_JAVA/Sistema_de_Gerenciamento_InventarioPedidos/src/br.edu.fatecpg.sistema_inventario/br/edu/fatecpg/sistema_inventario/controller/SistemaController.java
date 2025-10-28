package br.edu.fatecpg.sistema_inventario.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import br.edu.fatecpg.sistema_inventario.model.*;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class SistemaController {
    private static final String ARQUIVO_PRODUTOS = "produtos.json";
    private static final String ARQUIVO_PEDIDOS = "pedidos.json";
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    private final Map<String, Produto> inventario;
    private final Map<String, Pedido> pedidos;
    private final ObjectMapper objectMapper;

    public SistemaController(){
        this.inventario = new HashMap<>();
        this.pedidos = new HashMap<>();
        this.objectMapper = new ObjectMapper();
        this.objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public String adicionarProduto(String id, String nome, double preco, int qtd){
        Optional<Produto> produtoOpt = buscarProdutoPorId(id);

        if(produtoOpt.isPresent()){
            Produto produto = produtoOpt.get();
            produto.setQtdEstoque(produto.getQtdEstoque() + qtd);
            salvarProdutos();
            return "Estoque do produto '" + produto.getNome() +"' atualizado.";
        } else{
            Produto novoProduto = new Produto(id, nome, preco, qtd);
            inventario.put(id, novoProduto);
            salvarProdutos();
            return "Produto '" + novoProduto.getNome() + "' adicionado.";
        }
    }

    public Collection<Produto> getTodosProdutos(){
        return inventario.values();
    }

    public Optional<Produto> buscarProdutoPorId(String id){
        return Optional.ofNullable(inventario.get(id));
    }

    public String criarPedido(String nomeCliente, String emailCliente, List<ItemPedido> itens){
        Pedido novoPedido = new Pedido(nomeCliente, emailCliente, itens);
        pedidos.put(novoPedido.getIdPedido(), novoPedido);

        for(ItemPedido item : itens){
            Produto produto = item.getProduto();
            produto.setQtdEstoque(produto.getQtdEstoque() - item.getQuantidade());
        }

        salvarPedidos();
        salvarProdutos();

        return novoPedido.getIdPedido();
    }

    public Collection<Pedido> getTodosPedidos(){
        return pedidos.values();
    }

    public Optional<Pedido> buscarPedidoPorId(String id){
        return Optional.ofNullable(pedidos.get(id));
    }

    public boolean atualizarStatusPedido(Pedido pedido, int statusIndex){
        StatusPedido novoStatus = StatusPedido.obterPorIndice(statusIndex);
        if(novoStatus != null){
            pedido.setStatus(novoStatus);
            salvarPedidos();
            return true;
        }
        return false;
    }

    public boolean validarEmail(String email){
        if(email == null){
            return false;
        }
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }

    public void carregarDados(){
        carregarProdutos();
        carregarPedidos();
    }
    public void salvarDados(){
        salvarProdutos();
        salvarPedidos();
    }

    private void carregarProdutos(){
        File arquivo = new File(ARQUIVO_PRODUTOS);
        if(!arquivo.exists()){
            System.out.println("[Controller] " + ARQUIVO_PRODUTOS + " não encontrado. Iniciando vazio.");
            return;
        }
        try{
            JsonNode rootNode = objectMapper.readTree(arquivo);
            if(rootNode.isArray()){
                for(JsonNode produtoNode : rootNode){
                    Produto produto = objectMapper.treeToValue(produtoNode, Produto.class);
                    inventario.put(produto.getId(), produto);
                }
            }
        } catch (IOException e){
            System.err.println("[Controller] Erro ao carregar produtos: " + e.getMessage());
        }
    }

    private void carregarPedidos(){
        File arquivo = new File(ARQUIVO_PEDIDOS);
        if(!arquivo.exists()){
            System.out.println("[Controller] " + ARQUIVO_PEDIDOS + " não encontrado. Iniciando vazio.");
            return;
        }
        try{
            Map<String, Pedido> pedidosCarregados = objectMapper.readValue(arquivo, new TypeReference<Map<String, Pedido>>() {});
            pedidos.putAll(pedidosCarregados);
        } catch (IOException e){
            System.err.println("[Controller] Erro ao carregar pedidos: " + e.getMessage());
        }
    }

    private void salvarPedidos(){
        try{
            objectMapper.writeValue(new File(ARQUIVO_PRODUTOS), inventario.values());
        } catch(IOException e){
            System.err.println("[Controller] Erro ao salvar os produtos: " + e.getMessage());
        }
    }

    private void salvarProdutos(){
        try{
            objectMapper.writeValue(new File(ARQUIVO_PRODUTOS), pedidos);
        } catch(IOException e){
            System.err.println("[Controller] Erro ao salvar os pedidos: " + e.getMessage());
        }
    }
}
