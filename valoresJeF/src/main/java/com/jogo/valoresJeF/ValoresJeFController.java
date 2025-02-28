package com.jogo.valoresJeF;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class ValoresJeFController {
    @Autowired
    private ValoresJeFRepository valoresRepository;
    @Autowired
    private ValoresJeFService valoresService;
    @PostMapping("/cadastroUser")
    @CrossOrigin("https://jogovalores-e3h7.onrender.com/")
    public ResponseEntity<String> saveUser(@RequestBody ValoresJeFModel valoresModel){
        return new ResponseEntity(valoresService.save(valoresModel), HttpStatus.CREATED);
    }
    @GetMapping("/getUsers")
    public List<ValoresJeFModel> getAllUsers() {
        return valoresRepository.findAll();
    }
}

