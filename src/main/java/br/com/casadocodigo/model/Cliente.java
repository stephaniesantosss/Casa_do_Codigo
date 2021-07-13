package br.com.casadocodigo.model;

import br.com.casadocodigo.utils.CPFOrCNPJ;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @CPFOrCNPJ
    @NotBlank
    private String documento;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "idPais", nullable = false)
    private Pais pais;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "idEstado", nullable = true)
    private Estado estado;
    @NotBlank
    private String telefone;

    private Endereco endereco;
    @NotBlank
    private String complemento;

    @Deprecated
    public Cliente() {
    }

    public Cliente(String email, String nome, String sobrenome, String documento, Pais pais, Estado estado,
                   String telefone, Endereco endereco, String complemento) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.pais = pais;
        this.estado = estado;
        this.telefone = telefone;
        this.endereco = endereco;
        this.complemento = complemento;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public Pais getPais() {
        return pais;
    }

    public Estado getEstado() {
        return estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }
}
