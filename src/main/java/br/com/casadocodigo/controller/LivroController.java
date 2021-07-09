package br.com.casadocodigo.controller;

import br.com.casadocodigo.model.Livro;
import br.com.casadocodigo.repository.AutorRepository;
import br.com.casadocodigo.repository.CategoriaRepository;
import br.com.casadocodigo.repository.LivroRepository;
import br.com.casadocodigo.request.LivroProjecao;
import br.com.casadocodigo.request.LivroRequest;
import br.com.casadocodigo.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

        if (!Utils.isValid(livroRequest.getDataPublicacao().toString())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A data de publicação precisa ser futura");
        }
        Livro livro = livroRequest.toModel(categoriaRepository, autorRepository);
        livroRepository.save(livro);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping()
    public ResponseEntity listar(){
        List<LivroProjecao> list = livroRepository.findAllBy();
        return ResponseEntity.ok().body(list);
    }
}
