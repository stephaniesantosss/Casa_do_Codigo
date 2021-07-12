package br.com.casadocodigo.controller;

import br.com.casadocodigo.client.ViaCepService;
import br.com.casadocodigo.model.Cliente;
import br.com.casadocodigo.model.Endereco;
import br.com.casadocodigo.repository.ClienteRepository;
import br.com.casadocodigo.repository.EstadoRepository;
import br.com.casadocodigo.repository.PaisRepository;
import br.com.casadocodigo.request.ClienteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private ViaCepService viaCepService;

    @PostMapping
    public ResponseEntity salvarCliente(@RequestBody @Valid ClienteRequest clienteRequest) {
        Cliente cliente = clienteRequest.toModel(estadoRepository, paisRepository, viaCepService);
        clienteRepository.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
