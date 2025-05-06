package com.quod.antifraude.models;

public class ValidaImagemRequest {
    private String nomeArquivo;
    private String imagemBase64;

    // Construtor
    public ValidaImagemRequest(String nomeArquivo, String imagemBase64) {
        this.nomeArquivo = nomeArquivo;
        this.imagemBase64 = imagemBase64;
    }

    // Getters
    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public String getImagemBase64() {
        return imagemBase64;
    }

    // Setters
    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public void setImagemBase64(String imagemBase64) {
        this.imagemBase64 = imagemBase64;
    }
}
