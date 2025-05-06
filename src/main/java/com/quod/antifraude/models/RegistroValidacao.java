package com.quod.antifraude.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "registros")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistroValidacao {
    @Id
    private String id;
    private String tipo;
    private boolean fraude;
    private ValidaImagemRequest dadosImagem;
    private String dataRegistro;
}
