package com.quod.antifraude.controllers;

import com.quod.antifraude.dto.BiometriaDigitalRequest;
import com.quod.antifraude.dto.BiometriaFacialRequest;
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
    public ResponseEntity<String> validarBiometriaDigital(@RequestBody BiometriaDigitalRequest request) {
        boolean valido = biometriaService.validarDigital(request);
        return ResponseEntity.ok("Biometria digital " + (valido ? "válida" : "inválida"));
    }

    @PostMapping("/facial")
    public ResponseEntity<String> validarBiometriaFacial(@RequestBody BiometriaFacialRequest request) {
        boolean valido = biometriaService.validarFacial(request);
        return ResponseEntity.ok("Biometria facial " + (valido ? "válida" : "inválida"));
    }
}