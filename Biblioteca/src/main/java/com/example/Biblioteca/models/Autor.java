package com.example.Biblioteca.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.UUID;

@Entity

public class Autor implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idtAutor;
    private String nome;
    private String nascionalidade;

    public UUID getIdtAutor() {
        return idtAutor;
    }

    public void setIdtAutor(UUID idtAutor) {
        this.idtAutor = idtAutor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNascionalidade() {
        return nascionalidade;
    }

    public void setNascionalidade(String nascionalidade) {
        this.nascionalidade = nascionalidade;
    }
}
