package br.edu.fatecpg.noticiaapi.controller;
import br.edu.fatecpg.noticiaapi.model.*;
import br.edu.fatecpg.noticiaapi.service.*;

public class noticiaController {
    private final buscaNoticia buscaNoticia;

    public noticiaController() {
        this.buscaNoticia = new buscaNoticia();
    }

    public void mostrarNoticias(String termoBusca, int noticias) {
        NewsResponse response = buscaNoticia.buscarNoticias(termoBusca, noticias);

        if (response != null && "ok".equals(response.status) && response.articles != null) {
            System.out.println("Total de artigos: " + response.totalResults);
            for (Artigo article : response.articles) {
                System.out.println("Fonte: " + article.source.name);
                System.out.println("Título: " + article.title);
                System.out.println("Descrição: " + article.description);
                System.out.println("URL: " + article.url);
                System.out.println("--------------------------------------");
            }
        } else {
            System.out.println("Erro ao buscar notícias.");
        }
    }
}
