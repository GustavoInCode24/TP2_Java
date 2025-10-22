package br.edu.fatecpg.validador.controller;
import br.edu.fatecpg.validador.model.ValidadorEmail;
import br.edu.fatecpg.validador.view.ValidadorView;

import java.util.List;

public class ValidadorController {
    private ValidadorEmail model;
    private ValidadorView view;

    public ValidadorController(ValidadorEmail model, ValidadorView view) {
        this.model = model;
        this.view = view;
    }
    public void validarExibir() {
        // Busca os e-mails da API
        List<String> emails = model.juncaoEmails();

        // Valida os e-mails
        int[] counts = model.validarEmails(emails);
        int validCount = counts[0];
        int invalidCount = counts[1];

        // Exibe os resultados através da View
        view.resultado(validCount, invalidCount);
    }
}
