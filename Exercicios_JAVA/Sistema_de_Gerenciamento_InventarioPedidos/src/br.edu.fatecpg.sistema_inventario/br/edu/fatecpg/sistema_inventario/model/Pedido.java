package br.edu.fatecpg.sistema_inventario.model;
import java.util.List;
import java.util.UUID;

public class Pedido {
    private String idPedido;
    private String nomeCliente;
    private String emailCliente;
    private List<ItemPedido> itens;
    private StatusPedido status;
    private double valorTotal;

    public Pedido(){

    }
    public Pedido(String nomeCliente, String emailCliente, List<ItemPedido> itens){
        this.idPedido = UUID.randomUUID().toString();
        this.nomeCliente = nomeCliente;
        this.emailCliente = emailCliente;
        this.itens = itens;
        this.status = StatusPedido.NOVO;
        this.calcularValorTotal();
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void calcularValorTotal(){
        this.valorTotal = itens.stream().mapToDouble(ItemPedido::getSubtotal).sum();
    }

    public String getResumo(){
        return String.format("ID: %s | Cliente: %s | Status: %s | Total: R$:%.2f", idPedido, nomeCliente, status.getDescricao(), valorTotal);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("--- Detalhes do Pedido ---\n");
        sb.append("ID:").append(idPedido).append("\n");
        sb.append("Cliente: ").append(nomeCliente).append("(").append(emailCliente).append(")\n");
        sb.append("Status: ").append(status.getDescricao()).append("\n");
        sb.append("Itens:\n");
        itens.forEach(item -> sb.append(item.toString()).append("\n"));
        sb.append("----------------------------\n");
        sb.append(String.format("VALOR TOTAL: R$:%.2f%n", valorTotal));
        sb.append("----------------------------\n");
        return sb.toString();
    }
}
