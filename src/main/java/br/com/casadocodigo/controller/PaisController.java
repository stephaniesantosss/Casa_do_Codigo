package br.com.casadocodigo.controller;

import br.com.casadocodigo.model.Pais;
import br.com.casadocodigo.repository.PaisRepository;
import br.com.casadocodigo.request.PaisRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/pais")
public class PaisController {

    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    public ResponseEntity salvarPais(@RequestBody @Valid PaisRequest paisRequest){
        Pais pais = paisRequest.toModel();
        paisRepository.save(pais);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
