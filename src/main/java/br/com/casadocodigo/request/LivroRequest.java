package br.com.casadocodigo.request;

import br.com.casadocodigo.model.Autor;
import br.com.casadocodigo.model.Categoria;
import br.com.casadocodigo.model.Livro;
import br.com.casadocodigo.repository.AutorRepository;
import br.com.casadocodigo.repository.CategoriaRepository;
import br.com.casadocodigo.utils.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroRequest {

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;
    @NotBlank
    @Size(max = 500)
    private String resumo;
    private String sumario;
    @NotNull
    @DecimalMin("20.00")
    private BigDecimal preco;
    @Min(100)
    private Integer numPagina;
    @NotBlank
    private String isbn;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataPublicacao;
    @NotNull
    private long categoria;
    @NotNull
    private long autor;

    @Deprecated
    public LivroRequest() {
    }

    public LivroRequest(String titulo, String resumo, String sumario, BigDecimal preco, Integer numPagina,
                        String isbn, LocalDate dataPublicacao, long categoria, long autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numPagina = numPagina;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getNumPagina() {
        return numPagina;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public long getCategoria() {
        return categoria;
    }

    public long getAutor() {
        return autor;
    }

    public Livro toModel(CategoriaRepository categoriaRepository, AutorRepository autorRepository) {

        Categoria categoriaId = categoriaRepository.getById(categoria);
        Autor autorId = autorRepository.getById(autor);
        return new Livro(titulo, resumo, sumario, preco, numPagina, isbn, dataPublicacao,  categoriaId, autorId);
    }

}
