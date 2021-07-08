package br.com.casadocodigo.controller;

import br.com.casadocodigo.model.Livro;
import br.com.casadocodigo.repository.AutorRepository;
import br.com.casadocodigo.repository.CategoriaRepository;
import br.com.casadocodigo.repository.LivroRepository;
import br.com.casadocodigo.request.LivroRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    public ResponseEntity salvarLivro(@RequestBody @Valid LivroRequest livroRequest) {

        Livro livro = livroRequest.toModel(categoriaRepository, autorRepository);
        livroRepository.save(livro);

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }
}
