package br.edu.fatecpg.sistema_inventario.model;
import java.util.Objects;

public class Produto {
    private String id;
    private String nome;
    private double preco;
    private int qtdEstoque;

    public Produto(){

    }
    public Produto(String id, String nome, double preco, int qtdEstoque){
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    @Override
    public String toString(){
        return String.format("ID: %s | Nome: %s | Preço: R$%.2f | Estoque: %d", id, nome, preco, qtdEstoque);
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}
