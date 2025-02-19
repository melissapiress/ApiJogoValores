package com.jogo.valoresJeF;

import com.jogo.valoresJeF.Exception.IsNullException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ValoresJeFService {
    @Autowired
    private ValoresJeFRepository cadastroRepository;

    public ResponseEntity<String> save(ValoresJeFModel valoresModel) {
        if (valoresModel.getEmail() == null) {
            throw new IsNullException("O email não pode ser vazio.");
        } else if (valoresModel.getUsername() == null) {
            throw new IsNullException("O nome de usuário não pode ser vazio.");
        } else {
            cadastroRepository.save(valoresModel);
            return ResponseEntity.status(HttpStatus.CREATED).body("Cadastro salvo");
        }
    }
}
