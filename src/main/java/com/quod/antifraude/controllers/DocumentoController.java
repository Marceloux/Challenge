package com.quod.antifraude.controllers;

import com.quod.antifraude.dto.DocumentoRequest;
import com.quod.antifraude.services.BiometriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/documento")
public class DocumentoController {

    @Autowired
    private BiometriaService biometriaService;

    @PostMapping("/validar")
    public ResponseEntity<?> validarDocumento(@RequestBody DocumentoRequest request) {
        boolean isValido = biometriaService.validarDocumento(request);
        return ResponseEntity.ok(isValido ? "Documento válido" : "Documento inválido");
    }
}
