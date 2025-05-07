package com.quod.antifraude.controllers;

import com.quod.antifraude.dto.BiometriaDigitalRequest;
import com.quod.antifraude.services.BiometriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/biometria")
public class BiometriaController {

    private final BiometriaService biometriaService;

    public BiometriaController(BiometriaService biometriaService) {
        this.biometriaService = biometriaService;
    }

    @PostMapping("/digital")
    public ResponseEntity<?> validarBiometriaDigital(@RequestBody BiometriaDigitalRequest request) {
        boolean valido = biometriaService.validarDigital(request);
        return ResponseEntity.ok().body("Biometria digital " + (valido ? "válida" : "inválida"));
    }
}
