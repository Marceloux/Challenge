package com.quod.antifraude.services;

import com.quod.antifraude.dto.BiometriaDigitalRequest;
import com.quod.antifraude.models.RegistroValidacao;
import com.quod.antifraude.repositories.RegistroRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class BiometriaServiceTest {

    @Test
    void deveValidarBiometriaDigitalComBase64Valida() {
        RegistroRepository repository = Mockito.mock(RegistroRepository.class);
        BiometriaService service = new BiometriaService(repository);

        BiometriaDigitalRequest request = new BiometriaDigitalRequest();
        request.setIdUsuario("123");
        request.setImagemBase64("a".repeat(101)); // Simula base64 válida

        boolean resultado = service.validarDigital(request);

        assertTrue(resultado);
        Mockito.verify(repository, Mockito.times(1)).save(Mockito.any(RegistroValidacao.class));
    }

    @Test
    void deveInvalidarBiometriaDigitalComBase64Curta() {
        RegistroRepository repository = Mockito.mock(RegistroRepository.class);
        BiometriaService service = new BiometriaService(repository);

        BiometriaDigitalRequest request = new BiometriaDigitalRequest();
        request.setIdUsuario("123");
        request.setImagemBase64("abc"); // Simula base64 inválida

        boolean resultado = service.validarDigital(request);

        assertFalse(resultado);
    }
}

