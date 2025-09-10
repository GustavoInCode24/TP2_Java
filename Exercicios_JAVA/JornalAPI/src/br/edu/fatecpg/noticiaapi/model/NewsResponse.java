package br.edu.fatecpg.noticiaapi.model;

import java.util.Arrays;

public class NewsResponse {
    public String status;
    public int totalResults;
    public Artigo[] articles;

    public NewsResponse(String status, int totalResults, Artigo[] articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public Artigo[] getArtigos() {
        return articles;
    }

    public void setArtigos(Artigo[] articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "NewsResponse{" +
                "status='" + status + '\'' +
                ", totalResults=" + totalResults +
                ", artigos=" + Arrays.toString(articles) +
                '}';
    }
}
