package br.com.casadocodigo.controller;

import br.com.casadocodigo.model.Estado;
import br.com.casadocodigo.repository.EstadoRepository;
import br.com.casadocodigo.repository.PaisRepository;
import br.com.casadocodigo.request.EstadoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    @Autowired
    EstadoRepository estadoRepository;

    @Autowired
    PaisRepository paisRepository;

    @PostMapping
    public ResponseEntity salvarEstado(@RequestBody @Valid EstadoRequest estadoRequest){
        Estado estado = estadoRequest.toModel(paisRepository);
        estadoRepository.save(estado);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
