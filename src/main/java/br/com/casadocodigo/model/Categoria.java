package br.com.casadocodigo.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank
    private String nome;
    @Deprecated
    public Categoria(){}

    public Categoria(String nome){
        this.nome = nome;
    }

}
