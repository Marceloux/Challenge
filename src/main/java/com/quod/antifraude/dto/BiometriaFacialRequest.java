package com.quod.antifraude.dto;

public class BiometriaFacialRequest {
    
}
package com.quod.antifraude.dto;

public class BiometriaFacialRequest {

    private String imagemBase64;
    private String idUsuario;

    public String getImagemBase64() {
        return imagemBase64;
    }

    public void setImagemBase64(String imagemBase64) {
        this.imagemBase64 = imagemBase64;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
}
