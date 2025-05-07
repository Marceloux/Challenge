package com.quod.antifraude.services;

import com.quod.antifraude.models.ValidaImagemRequest;
import org.springframework.stereotype.Service;

@Service
public class ValidacaoService {

    public void validarImagem(ValidaImagemRequest request) {
        // Agora o valor de usuarioId será utilizado
        Long usuarioId = request.getUsuarioId();
        // Aqui você pode adicionar a lógica para validação, por exemplo:
        if (usuarioId == null) {
            throw new IllegalArgumentException("Usuário não encontrado!");
        }
        // Realiza a validação com o usuarioId
    }

    public Long obterUsuarioId(String usuarioIdString) {
        // Corrigindo a chamada para Long.valueOf()
        return Long.valueOf(usuarioIdString);
    }
}
