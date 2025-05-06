package com.quod.antifraude.controllers;

import com.quod.antifraude.models.ValidaImagemRequest;
import com.quod.antifraude.services.ValidacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/documento")
public class DocumentoController {

    @Autowired
    private ValidacaoService validacaoService;

    @PostMapping("/validar")
    public ResponseEntity<?> validarDocumento(@RequestBody ValidaImagemRequest request) {
        return validacaoService.processarValidacao("documento", request);
    }
}
