package br.com.casadocodigo.model;

import br.com.casadocodigo.utils.Utils;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.text.Normalizer;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique=true)
    @NotBlank
    private String nome;
    @Deprecated
    public Categoria(){}

    public Categoria(String nome){
        this.nome = Utils.removerAcentos(nome.toLowerCase());
    }



}
