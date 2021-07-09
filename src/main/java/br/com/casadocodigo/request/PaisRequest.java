package br.com.casadocodigo.request;

import br.com.casadocodigo.model.Pais;
import br.com.casadocodigo.utils.UniqueValue;
import org.hibernate.validator.constraints.NotBlank;

public class PaisRequest {

    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    public PaisRequest(){}

    public PaisRequest(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Pais toModel(){
        return new Pais(nome);
    }
}
