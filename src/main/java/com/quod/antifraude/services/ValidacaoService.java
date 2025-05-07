package com.quod.antifraude.services;

import com.quod.antifraude.models.ValidaImagemRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ValidacaoService {

    public ResponseEntity<String> processarValidacao(String tipo, ValidaImagemRequest request) {
        boolean fraude = request.getNomeArquivo().toLowerCase().contains("fake");
        return ResponseEntity.ok((fraude ? "[FRAUDE]" : "[VALIDO]") + " " + tipo);
    }
}