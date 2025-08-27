package br.edu.fatecpg.gestaotarefas.model;

public class Consulta {

    private String nome ;
    private String categoria ;
    private boolean status;
    private String data;
    //private int id;


    public Consulta(String nome, String categoria, String nmCategoria, boolean status, String data) {
        this.nome = nome;
        this.categoria = categoria;
        this.status = status;
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public String getData() {
        return data;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


    public boolean isStatus() {
        return status;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    public void setData(String data) {
        this.data = data;
    }

    public String toString() {
        return "Consulta{" +
                "nome='" + nome + '\'' +
                ", categoria='" + categoria + '\'' +
                ", status=" + status +
                ", data='" + data + '\'' +
                '}';
    }
}
