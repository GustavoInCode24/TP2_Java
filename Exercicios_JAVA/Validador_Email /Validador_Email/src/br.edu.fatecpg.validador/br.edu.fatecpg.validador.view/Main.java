package br.edu.fatecpg.validador.view;
import br.edu.fatecpg.validador.controller.ValidadorController;
import br.edu.fatecpg.validador.model.ValidadorEmail;

public class Main {
    public static void main(String[] args){
        ValidadorEmail model = new ValidadorEmail();
        ValidadorView view = new ValidadorView();
        ValidadorController controller = new ValidadorController(model, view);

        // Controlador faz o processo de validação e exibe os resultados
        controller.validarExibir();
    }
}
