package br.edu.fatecpg.sistema_inventario.view;

import br.edu.fatecpg.sistema_inventario.controller.*;

public class Main {

    public static void main(String[] args) {
        SistemaController controller = new SistemaController();
        SistemaView view = new SistemaView(controller);

        view.carregarDadosIniciais();

        view.iniciar();

        view.salvarDadosFinais();
    }
}
