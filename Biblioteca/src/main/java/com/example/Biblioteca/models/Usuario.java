package com.example.Biblioteca.models;


import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "TB_usuario")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int idUsuario;
    private String nome;
    private  String email;
    private String senha;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
