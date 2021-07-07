package br.com.casadocodigo.controller;

import br.com.casadocodigo.model.Categoria;
import br.com.casadocodigo.repository.CategoriaRepository;
import br.com.casadocodigo.request.CategoriaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    public ResponseEntity salvarCategoria(@RequestBody @Valid CategoriaRequest categoriaRequest) {

        Categoria categoria = categoriaRequest.toModel();
        categoriaRepository.save(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }
}
