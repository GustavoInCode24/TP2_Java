package br.edu.fatecpg.noticiaapi.service;

import br.edu.fatecpg.noticiaapi.model.*;

import java.net.http.*;
import java.net.URI;
import com.google.gson.Gson;

public class buscaNoticia {

    private static final String API_KEY = "7f8a6851dc52479eb3e0a41a2ee9ab46";

    public NewsResponse buscarNoticias(String tema, int noticias) {
        try {
            String url = "https://newsapi.org/v2/everything?q=" + tema + "&language=pt&apiKey=" + API_KEY + "&pageSize=" + noticias;
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Imprimir a resposta bruta para depuração
            System.out.println(response.body());

            Gson gson = new Gson();
            NewsResponse newsResponse = gson.fromJson(response.body(), NewsResponse.class);

            // Verificar se o campo "articles" está presente
            if (newsResponse != null && newsResponse.articles != null) {
                return newsResponse;
            } else {
                System.out.println("Resposta da API não contém artigos.");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
