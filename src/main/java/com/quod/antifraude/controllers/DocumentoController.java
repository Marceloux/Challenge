package com.quod.antifraude.controllers;

import com.quod.antifraude.dto.DocumentoRequest;
import com.quod.antifraude.services.BiometriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/documento")
public class DocumentoController {

    private final BiometriaService biometriaService;

    public DocumentoController(BiometriaService biometriaService) {
        this.biometriaService = biometriaService;
    }

    @PostMapping("/validar")
    public ResponseEntity<String> validarDocumento(@RequestBody DocumentoRequest request) {
        boolean valido = biometriaService.validarDocumento(request);
        return ResponseEntity.ok("Documento " + (valido ? "válido" : "inválido"));
    }
}