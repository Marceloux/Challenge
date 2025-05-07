package com.quod.antifraude.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "validacoes")
public class RegistroValidacao {

    @Id
    private String id;

    private Long usuarioId; // Alterado para Long
    private String tipo;
    private boolean valido;
    private ValidaImagemRequest imagem;
    private String origem;

    public RegistroValidacao() {}

    public RegistroValidacao(Long usuarioId, String tipo, boolean valido, ValidaImagemRequest imagem, String origem) {
        this.usuarioId = usuarioId;
        this.tipo = tipo;
        this.valido = valido;
        this.imagem = imagem;
        this.origem = origem;
    }

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Long getUsuarioId() { return usuarioId; } // Alterado para Long
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; } // Alterado para Long

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public boolean isValido() { return valido; }
    public void setValido(boolean valido) { this.valido = valido; }

    public ValidaImagemRequest getImagem() { return imagem; }
    public void setImagem(ValidaImagemRequest imagem) { this.imagem = imagem; }

    public String getOrigem() { return origem; }
    public void setOrigem(String origem) { this.origem = origem; }
}
