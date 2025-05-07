package com.quod.antifraude.services;

import com.quod.antifraude.dto.BiometriaDigitalRequest;
import com.quod.antifraude.dto.BiometriaFacialRequest;
import com.quod.antifraude.dto.DocumentoRequest;
import com.quod.antifraude.models.RegistroValidacao;
import com.quod.antifraude.models.ValidaImagemRequest;
import com.quod.antifraude.repositories.RegistroRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BiometriaService {

    private final RegistroRepository registroRepository;
    private final NotificacaoService notificacaoService;

    public BiometriaService(RegistroRepository registroRepository, NotificacaoService notificacaoService) {
        this.registroRepository = registroRepository;
        this.notificacaoService = notificacaoService;
    }

    /**
     * Valida a biometria digital baseada no conteúdo base64 da digital.
     */
    public boolean validarDigital(BiometriaDigitalRequest request) {
        boolean isValido = request.getDigital() != null && !request.getDigital().isEmpty();

        ValidaImagemRequest imagem = new ValidaImagemRequest();
        imagem.setUsuarioId(request.getIdUsuario());
        imagem.setNomeArquivo("digital.jpg");
        imagem.setImagemBase64(request.getDigital());

        RegistroValidacao registro = new RegistroValidacao();
        registro.setUsuarioId(request.getIdUsuario());
        registro.setTipo("digital");
        registro.setValido(isValido);
        registro.setImagem(imagem);
        registro.setOrigem("Sistema Biometria Digital");
        registro.setDataRegistro(LocalDateTime.now());

        if (!isValido) {
            String ref = notificacaoService.notificarFraude(registro);
            registro.setReferenciaNotificacao(ref);
        }

        registroRepository.save(registro);
        return isValido;
    }

    /**
     * Valida a biometria facial baseada no conteúdo base64 da imagem.
     */
    public boolean validarFacial(BiometriaFacialRequest request) {
        boolean isValido = request.getImagemBase64() != null && !request.getImagemBase64().isEmpty();

        ValidaImagemRequest imagem = new ValidaImagemRequest();
        imagem.setUsuarioId(request.getIdUsuario());
        imagem.setNomeArquivo("facial.jpg");
        imagem.setImagemBase64(request.getImagemBase64());

        RegistroValidacao registro = new RegistroValidacao();
        registro.setUsuarioId(request.getIdUsuario());
        registro.setTipo("facial");
        registro.setValido(isValido);
        registro.setImagem(imagem);
        registro.setOrigem("Sistema Biometria Facial");
        registro.setDataRegistro(LocalDateTime.now());

        if (!isValido) {
            String ref = notificacaoService.notificarFraude(registro);
            registro.setReferenciaNotificacao(ref);
        }

        registroRepository.save(registro);
        return isValido;
    }

    /**
     * Valida um documento baseado no seu conteúdo.
     */
    public boolean validarDocumento(DocumentoRequest request) {
        boolean isValido = request.getDocumento() != null && !request.getDocumento().isEmpty();

        ValidaImagemRequest imagem = new ValidaImagemRequest();
        imagem.setUsuarioId(request.getIdUsuario());
        imagem.setNomeArquivo("documento.jpg");
        imagem.setImagemBase64(request.getDocumento());

        RegistroValidacao registro = new RegistroValidacao();
        registro.setUsuarioId(request.getIdUsuario());
        registro.setTipo("documento");
        registro.setValido(isValido);
        registro.setImagem(imagem);
        registro.setOrigem("Sistema Validação de Documento");
        registro.setDataRegistro(LocalDateTime.now());

        if (!isValido) {
            String ref = notificacaoService.notificarFraude(registro);
            registro.setReferenciaNotificacao(ref);
        }

        registroRepository.save(registro);
        return isValido;
    }
}
