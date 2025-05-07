package com.quod.antifraude.services;

import com.quod.antifraude.dto.BiometriaDigitalRequest;
import com.quod.antifraude.dto.BiometriaFacialRequest;
import com.quod.antifraude.dto.DocumentoRequest;
import org.springframework.stereotype.Service;

@Service
public class BiometriaService {

    /**
     * Valida a biometria digital baseada no conteúdo base64 da digital.
     */
    public boolean validarDigital(BiometriaDigitalRequest request) {
        return request.getDigital() != null && !request.getDigital().isEmpty();
    }

    /**
     * Valida a biometria facial baseada no conteúdo base64 da imagem.
     */
    public boolean validarFacial(BiometriaFacialRequest request) {
        return request.getImagemBase64() != null && !request.getImagemBase64().isEmpty();
    }

    /**
     * Valida um documento baseado no seu conteúdo.
     */
    public boolean validarDocumento(DocumentoRequest request) {
        return request.getDocumento() != null && !request.getDocumento().isEmpty();
    }
}