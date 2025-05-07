package com.quod.antifraude.controllers;

import com.quod.antifraude.dto.BiometriaFacialRequest;
import com.quod.antifraude.services.BiometriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/biometria")
public class BiometriaFacialController {

    private final BiometriaService biometriaService;

    public BiometriaFacialController(BiometriaService biometriaService) {
        this.biometriaService = biometriaService;
    }

    @PostMapping("/facial")
    public ResponseEntity<?> validarBiometriaFacial(@RequestBody BiometriaFacialRequest request) {
        boolean valido = biometriaService.validarFacial(request);
        return ResponseEntity.ok().body("Biometria facial " + (valido ? "válida" : "inválida"));
    }
}
