package com.quod.antifraude.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "validacoes")
public class RegistroValidacao {

    @Id
    private String id;

    private Long usuarioId;
    private String tipo;
    private boolean valido;
    private ValidaImagemRequest imagem;
    private String origem;
    private String referenciaNotificacao;  // referência do sistema QUOD
    private LocalDateTime dataRegistro;   // timestamp de registro

    public RegistroValidacao() {}

    public RegistroValidacao(Long usuarioId, String tipo, boolean valido,
                              ValidaImagemRequest imagem, String origem,
                              String referenciaNotificacao, LocalDateTime dataRegistro) {
        this.usuarioId = usuarioId;
        this.tipo = tipo;
        this.valido = valido;
        this.imagem = imagem;
        this.origem = origem;
        this.referenciaNotificacao = referenciaNotificacao;
        this.dataRegistro = dataRegistro;
    }

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }

    public ValidaImagemRequest getImagem() {
        return imagem;
    }

    public void setImagem(ValidaImagemRequest imagem) {
        this.imagem = imagem;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getReferenciaNotificacao() {
        return referenciaNotificacao;
    }

    public void setReferenciaNotificacao(String referenciaNotificacao) {
        this.referenciaNotificacao = referenciaNotificacao;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }
}