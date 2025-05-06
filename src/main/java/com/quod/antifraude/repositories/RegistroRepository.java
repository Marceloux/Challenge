package com.quod.antifraude.repositories;

import com.quod.antifraude.models.RegistroValidacao;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RegistroRepository extends MongoRepository<RegistroValidacao, String> {
}
