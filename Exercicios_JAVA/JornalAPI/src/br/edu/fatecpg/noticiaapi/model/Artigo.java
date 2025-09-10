package br.edu.fatecpg.noticiaapi.model;

public class Artigo {
    public Source source;
    public String author;
    public String title;
    public String description;
    public String url;

    public Artigo(Source source, String author, String title, String description, String url) {
        this.source = source;
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
