package com.quod.antifraude.services;

import com.quod.antifraude.dto.BiometriaDigitalRequest;
import com.quod.antifraude.models.RegistroValidacao;
import com.quod.antifraude.models.ValidaImagemRequest;
import com.quod.antifraude.repositories.RegistroRepository;
import org.springframework.stereotype.Service;

@Service
public class BiometriaService {

    private final RegistroRepository registroRepository;

    // Construtor para injeção de dependência do repositório
    public BiometriaService(RegistroRepository registroRepository) {
        this.registroRepository = registroRepository;
    }

    // Método para validar biometria digital
    public boolean validarDigital(BiometriaDigitalRequest request) {
        // Lógica para verificar se a imagem é válida
        boolean isValido = request.getImagemBase64() != null && request.getImagemBase64().length() > 100;

        // Criando objeto ValidaImagemRequest e atribuindo valores
        ValidaImagemRequest imagem = new ValidaImagemRequest();
        imagem.setNomeArquivo("nomeDoArquivo"); // Defina o nome do arquivo como necessário
        imagem.setImagemBase64(request.getImagemBase64()); // Passando a imagem em Base64

        // Criando objeto RegistroValidacao para salvar os dados
        RegistroValidacao registro = new RegistroValidacao();
        registro.setUsuarioId(request.getIdUsuario());
        registro.setTipo("digital");
        registro.setValido(isValido);
        registro.setImagem(imagem); // Associando a imagem validada

        // Salvando o registro no banco de dados
        registroRepository.save(registro);

        // Retornando o status da validação
        return isValido;
    }
}
