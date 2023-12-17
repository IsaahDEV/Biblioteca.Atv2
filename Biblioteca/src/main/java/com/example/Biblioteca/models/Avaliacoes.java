package com.example.Biblioteca.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "TB_AVALIACOES")
public class Avaliacoes implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idAvaliacoes;

    @ManyToOne
    private Usuario usuario;

    private Integer idUsuario;

    private int classificacao;
    private String comentarios;

    public int getIdAvaliacoes() {
        return idAvaliacoes;
    }

    public void setIdAvaliacoes(int idAvaliacoes) {
        this.idAvaliacoes = idAvaliacoes;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

}
