package br.com.casadocodigo.repository;

import br.com.casadocodigo.model.Livro;
import br.com.casadocodigo.request.LivroProjecao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<LivroProjecao> findAllBy();
}
