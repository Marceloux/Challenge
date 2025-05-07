package com.quod.antifraude.dto;

public class DocumentoRequest {

    private Long idUsuario;
    private String documento;

    public DocumentoRequest() {}

    public DocumentoRequest(Long idUsuario, String documento) {
        this.idUsuario = idUsuario;
        this.documento = documento;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
}
