package br.com.casadocodigo.request;

import br.com.casadocodigo.client.ViaCepService;
import br.com.casadocodigo.model.Cliente;
import br.com.casadocodigo.model.Endereco;
import br.com.casadocodigo.model.Estado;
import br.com.casadocodigo.model.Pais;
import br.com.casadocodigo.repository.EstadoRepository;
import br.com.casadocodigo.repository.PaisRepository;
import br.com.casadocodigo.utils.CPFOrCNPJ;
import br.com.casadocodigo.utils.ExisteId;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

public class ClienteRequest {

    @Email @NotBlank
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank @CPFOrCNPJ
    private String documento;
    @NotNull @ExisteId(entidade = Pais.class, atributo = "id")
    private Long pais;
    @NotNull
    private Long estado;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;
    @NotBlank
    private String complemento;

    public ClienteRequest() {
    }

    public ClienteRequest(String email, String nome, String sobrenome, String documento, Long pais,
                          Long estado, String telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
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

    public String getComplemento() {
        return complemento;
    }

    public Cliente toModel(EstadoRepository estadoRepository, PaisRepository paisRepository, ViaCepService viaCepService){
        Estado estadoId = estadoRepository.getById(estado);
        Pais paisId = paisRepository.getById(pais);
        Endereco endereco = viaCepService.buscaEnderecoPorCep(cep);
        return new Cliente(email, nome, sobrenome, documento, paisId, estadoId, telefone, endereco, complemento);
    }
}
