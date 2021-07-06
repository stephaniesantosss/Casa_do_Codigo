package br.com.casadocodigo.controller;

import br.com.casadocodigo.model.Autor;
import br.com.casadocodigo.model.AutorRequest;
import br.com.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    public ResponseEntity salvarAutor(@RequestBody @Valid AutorRequest autorRequest){

        Autor autor = autorRequest.toModel();
        autorRepository.save(autor);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
