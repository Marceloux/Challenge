package com.quod.antifraude.controllers;

import com.quod.antifraude.dto.BiometriaFacialRequest;
import com.quod.antifraude.services.BiometriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/biometria/facial")
public class BiometriaFacialController {

    private final BiometriaService biometriaService;

    public BiometriaFacialController(BiometriaService biometriaService) {
        this.biometriaService = biometriaService;
    }

    @PostMapping("/validar")
    public ResponseEntity<String> validarBiometriaFacial(@RequestBody BiometriaFacialRequest request) {
        boolean valido = biometriaService.validarFacial(request);
        return ResponseEntity.ok("Biometria facial " + (valido ? "válida" : "inválida"));
    }
}