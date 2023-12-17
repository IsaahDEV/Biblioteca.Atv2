package com.example.Biblioteca.models;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "TB_AUTOR")
public class Autor implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idtAutor;
    private String nome;
    private String nacionalidade;





    public int getIdtAutor() {
        return idtAutor;
    }

    public void setIdtAutor(int idtAutor) {
        this.idtAutor = idtAutor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
}
