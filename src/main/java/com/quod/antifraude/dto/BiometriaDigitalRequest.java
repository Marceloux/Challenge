package com.quod.antifraude.dto;

public class BiometriaDigitalRequest {
    private Long idUsuario;
    private String digital;

    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }

    public String getDigital() { return digital; }
    public void setDigital(String digital) { this.digital = digital; }
}