package br.com.casadocodigo.request;

import br.com.casadocodigo.model.Cliente;
import br.com.casadocodigo.model.Estado;
import br.com.casadocodigo.model.Pais;
import br.com.casadocodigo.repository.EstadoRepository;
import br.com.casadocodigo.repository.PaisRepository;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

public class ClienteRequest {

    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull
    private Long pais;
    @NotNull
    private Long estado;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

    public ClienteRequest() {
    }

    public ClienteRequest(String email, String nome, String sobrenome, String documento, String endereco,
                          String complemento, String cidade, Long pais, Long estado, String telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
        this.telefone = telefone;
        this.cep = cep;
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

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Long getPais() {
        return pais;
    }

    public Long getEstado() {
        return estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public Cliente toModel(EstadoRepository estadoRepository, PaisRepository paisRepository){
        Estado estadoId = estadoRepository.getById(estado);
        Pais paisId = paisRepository.getById(pais);
        return new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, paisId, estadoId, telefone, cep);
    }
}
