package com.quod.antifraude.services;

import com.quod.antifraude.models.RegistroValidacao;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificacaoService {

    private final RestTemplate rest = new RestTemplate();
    private final String QUOD_URL = "https://monitoramento.quod.com.br/api/fraudes";

    /**
     * Envia um POST para o sistema da QUOD com os dados do registro de fraude.
     * Retorna a referência (ID) que o QUOD deu para esse evento.
     */
    public String notificarFraude(RegistroValidacao registro) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<RegistroValidacao> payload = new HttpEntity<>(registro, headers);
        QuodResponse response = rest.postForObject(QUOD_URL, payload, QuodResponse.class);
        return response != null ? response.ref() : null;
    }

    /**
     * Classe interna imutável para desserialização da resposta do QUOD.
     */
    public static record QuodResponse(String ref) {}
}
