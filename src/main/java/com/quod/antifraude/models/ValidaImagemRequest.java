package com.quod.antifraude.models;

public class ValidaImagemRequest {
    private String nomeArquivo;
    private String imagemBase64;

    // Construtor padrão (obrigatório para frameworks como Jackson e para instanciar sem parâmetros)
    public ValidaImagemRequest() {
    }

    // Construtor completo
    public ValidaImagemRequest(String nomeArquivo, String imagemBase64) {
        this.nomeArquivo = nomeArquivo;
        this.imagemBase64 = imagemBase64;
    }

    // Getters e Setters
    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public String getImagemBase64() {
        return imagemBase64;
    }

    public void setImagemBase64(String imagemBase64) {
        this.imagemBase64 = imagemBase64;
    }
}
