package com.example.Biblioteca.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
public class Avaliacoes implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idAvaliacoes;

    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Livro livro;

    private int classificacao;
    private String comentarios;

    public UUID getIdAvaliacoes() {
        return idAvaliacoes;
    }

    public void setIdAvaliacoes(UUID idAvaliacoes) {
        this.idAvaliacoes = idAvaliacoes;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
}
