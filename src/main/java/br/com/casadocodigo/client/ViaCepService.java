package br.com.casadocodigo.client;

import br.com.casadocodigo.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url= "https://viacep.com.br/ws/" , name = "viacep")
public interface ViaCepService {

    @GetMapping("{cep}/json")
    Endereco buscaEnderecoPorCep(@PathVariable String cep);
}
