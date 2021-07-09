package br.com.casadocodigo.request;

import br.com.casadocodigo.model.Estado;
import br.com.casadocodigo.model.Pais;
import br.com.casadocodigo.repository.PaisRepository;
import br.com.casadocodigo.utils.UniqueValue;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

public class EstadoRequest {

    @NotBlank
    @UniqueValue(domainClass = Estado.class, fieldName = "nome")
    private String nome;
    @NotNull
    private Long pais;

    public EstadoRequest() {
    }

    public EstadoRequest(String nome, Long pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public String getNome() {
        return nome;
    }

    public Long getPais() {
        return pais;
    }

    public Estado toModel(PaisRepository paisRepository){
        Pais estadoId = paisRepository.getById(pais);
        return new Estado(nome, estadoId);
    }
}
