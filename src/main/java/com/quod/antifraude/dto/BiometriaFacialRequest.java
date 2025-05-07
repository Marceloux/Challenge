package com.quod.antifraude.dto;

public class BiometriaFacialRequest {
    private Long idUsuario;
    private String imagemBase64;

    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }

    public String getImagemBase64() { return imagemBase64; }
    public void setImagemBase64(String imagemBase64) { this.imagemBase64 = imagemBase64; }
}