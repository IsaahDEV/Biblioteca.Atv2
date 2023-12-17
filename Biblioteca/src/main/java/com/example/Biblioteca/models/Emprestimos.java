package com.example.Biblioteca.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;




@Entity
public class Emprestimos  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idEmprestimos;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Livro livro;

    private Date dataEmprestimos;
    private Date dataDevolicao;

    public int getIdEmprestimos() {
        return idEmprestimos;
    }

    public void setIdEmprestimos(int idEmprestimos) {
        this.idEmprestimos = idEmprestimos;
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

    public Date getDataEmprestimos() {
        return dataEmprestimos;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimos = dataEmprestimo;
    }

    public Date getDataDevolicao() {
        return dataDevolicao;
    }

    public void setDataDevolicao(Date dataDevolicao) {
        this.dataDevolicao = dataDevolicao;
    }
}
