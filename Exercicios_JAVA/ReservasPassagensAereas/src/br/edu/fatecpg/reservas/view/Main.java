package br.edu.fatecpg.reservas.view;

import br.edu.fatecpg.reservas.control.VooControler;

public class Main {
    public static void main(String[] args) {
        VooControler vc = new VooControler();

        // Adicionando voos
        vc.setVoo("1", "Praia Grande", "São Paulo", 50);
        vc.setVoo("2", "Santos", "Mogi das Cruzes", 100);

        // Mostrando todos os voos
        System.out.println("=== Lista de Voos ===");
        System.out.println(vc.mostrarTudo());

        // Verificar disponibilidade
        System.out.println("=== Verificando disponibilidade do voo 0 (assentos: 30) ===");
        vc.verificarDisponibilidade(0, 30); // Esperado: disponível

        // Realizar reserva
        System.out.println("=== Realizando reserva de 30 assentos no voo 0 ===");
        vc.realizarReserva(0, 30);

        // Mostrar voo após reserva
        System.out.println("=== Voo 0 após a reserva ===");
        System.out.println(vc.mostrarPassagem(0));

        // Calcular pagamento
        boolean tipoViagem = true;         // true = internacional (100), false = nacional (50)
        boolean pontosTuristicos = true;   // true = +100
        int valor = vc.realizarPagamento(tipoViagem, pontosTuristicos);
        System.out.println("=== Valor da passagem: R$" + valor + " ===");

        // Remover voo
        System.out.println("=== Removendo voo 1 ===");
        vc.removerVoo(1);

        // Mostrar todos os voos após remoção
        System.out.println("=== Lista de Voos Atualizada ===");
        System.out.println(vc.mostrarTudo());
    }
}
