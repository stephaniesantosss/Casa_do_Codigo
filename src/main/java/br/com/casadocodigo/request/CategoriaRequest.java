package br.com.casadocodigo.request;

import br.com.casadocodigo.model.Categoria;
import org.hibernate.validator.constraints.NotBlank;

public class CategoriaRequest {

    @NotBlank
    private String nome;

    public String getNome() {
        return nome;
    }

    @Deprecated
    public CategoriaRequest() {
    }

    public CategoriaRequest(String nome) {
        this.nome = nome;
    }

    public Categoria toModel() {
        return new Categoria(nome);
    }
}
