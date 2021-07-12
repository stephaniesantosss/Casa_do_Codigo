package br.com.casadocodigo.request;

import br.com.casadocodigo.model.Autor;
import br.com.casadocodigo.model.Categoria;
import br.com.casadocodigo.utils.UniqueValue;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.validation.constraints.Size;

public class AutorRequest {

    @NotBlank
    private String nome;
    @Column(unique=true) @NotBlank @Email
    @UniqueValue(domainClass = Autor.class, fieldName = "email")
    private String email;
    @NotBlank @Size(max = 400)
    private String descricao;
    
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public Autor toModel(){
        return new Autor(nome, email, descricao);
    }
}
