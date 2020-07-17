package com.example.dokterrkuu.Model;

public class Articles {
    private String Foto_Article;
    private String Judul_Artikel;
    private String Preview_Artikel;
    private String Foto_Artikel;

    public Articles() {
    }

    public Articles(String foto_Article, String judul_Artikel, String preview_Artikel, String foto_Artikel) {
        Foto_Article = foto_Article;
        Judul_Artikel = judul_Artikel;
        Preview_Artikel = preview_Artikel;
        Foto_Artikel = foto_Artikel;
    }

    public String getFoto_Article() {
        return Foto_Article;
    }

    public void setFoto_Article(String foto_Article) {
        Foto_Article = foto_Article;
    }

    public String getJudul_Artikel() {
        return Judul_Artikel;
    }

    public void setJudul_Artikel(String judul_Artikel) {
        Judul_Artikel = judul_Artikel;
    }

    public String getPreview_Artikel() {
        return Preview_Artikel;
    }

    public void setPreview_Artikel(String preview_Artikel) {
        Preview_Artikel = preview_Artikel;
    }

    public String getFoto_Artikel() {
        return Foto_Artikel;
    }

    public void setFoto_Artikel(String foto_Artikel) {
        Foto_Artikel = foto_Artikel;
    }
}
