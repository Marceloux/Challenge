package com.quod.antifraude.services;

import com.quod.antifraude.models.RegistroValidacao;
import com.quod.antifraude.models.ValidaImagemRequest;
import com.quod.antifraude.repositories.RegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class ValidacaoService {

    @Autowired
    private RegistroRepository repository;

    public ResponseEntity<?> processarValidacao(String tipo, ValidaImagemRequest request) {
        boolean fraudeDetectada = simularFraude(request);
        String idProcesso = UUID.randomUUID().toString();

        RegistroValidacao registro = new RegistroValidacao(
            idProcesso,
            tipo,
            fraudeDetectada,
            request,
            LocalDateTime.now().toString()
        );

        repository.save(registro);

        if (fraudeDetectada) {
            notificarQuod(registro); // Simula notificação
            return ResponseEntity.ok("[FRAUDE DETECTADA] Tipo: " + tipo + ", Processo: " + idProcesso);
        } else {
            return ResponseEntity.ok("[VALIDO] Tipo: " + tipo + ", Processo: " + idProcesso);
        }
    }

    private boolean simularFraude(ValidaImagemRequest request) {
        return request.getNomeArquivo().toLowerCase().contains("fake") ||
               request.getImagemBase64().length() < 1000;
    }

    private void notificarQuod(RegistroValidacao registro) {
        // Aqui você simularia um POST para o sistema da QUOD.
        System.out.println("Notificando QUOD: " + registro);
    }
}
