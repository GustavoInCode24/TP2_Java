package br.edu.fatecpg.sistema_inventario.model;

public enum StatusPedido {
    NOVO("Novo Pedido"),
    PROCESSANDO("Em processamento"),
    ENVIADO("Enviado para o Cliente"),
    ENTREGUE("Pedido entregue"),
    CANCELADO("Pedido cancelado");

    private final String descricao;

    StatusPedido(String descricao){
        this.descricao = descricao;
    }
    public String getDescricao(){
        return descricao;
    }

    public static void exibirOpcoes(){
        for(int i = 0; i < values().length; i++){
            System.out.printf("%d. %s%n", (i + 1), values()[i].getDescricao());
        }
    }

    public static StatusPedido obterPorIndice(int indice){
        if(indice > 0 && indice <= values().length){
            return values()[indice - 1];
        }
        return null;
    }
}
