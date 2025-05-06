package com.quod.antifraude.controllers;

import com.quod.antifraude.models.ValidaImagemRequest;
import com.quod.antifraude.services.ValidacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/biometria")
public class BiometriaController {

    @Autowired
    private ValidacaoService validacaoService;

    @PostMapping("/facial")
    public ResponseEntity<?> validarFacial(@RequestBody ValidaImagemRequest request) {
        return validacaoService.processarValidacao("facial", request);
    }

    @PostMapping("/digital")
    public ResponseEntity<?> validarDigital(@RequestBody ValidaImagemRequest request) {
        return validacaoService.processarValidacao("digital", request);
    }
}
