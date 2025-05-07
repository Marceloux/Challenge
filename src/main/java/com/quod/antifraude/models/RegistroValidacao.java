package com.quod.antifraude.models;

import com.quod.antifraude.models.ValidaImagemRequest;

public class RegistroValidacao {

    private String usuarioId;
    private String tipo;
    private boolean valido;
    private ValidaImagemRequest imagem;
    private String origem;

    public RegistroValidacao() {}

    public RegistroValidacao(String usuarioId, String tipo, boolean valido, ValidaImagemRequest imagem, String origem) {
        this.usuarioId = usuarioId;
        this.tipo = tipo;
        this.valido = valido;
        this.imagem = imagem;
        this.origem = origem;
    }

    // Getters e Setters
    public String getUsuarioId() { return usuarioId; }
    public void setUsuarioId(String usuarioId) { this.usuarioId = usuarioId; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public boolean isValido() { return valido; }
    public void setValido(boolean valido) { this.valido = valido; }

    public ValidaImagemRequest getImagem() { return imagem; }
    public void setImagem(ValidaImagemRequest imagem) { this.imagem = imagem; }

    public String getOrigem() { return origem; }
    public void setOrigem(String origem) { this.origem = origem; }
}
