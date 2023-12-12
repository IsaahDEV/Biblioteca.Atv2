package com.example.Biblioteca.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
public class Reservas  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idReservas;
     @ManyToOne
     private Usuario usuario;
     @ManyToOne
     private Livro livro;
     private Date dataReserva;

    public UUID getIdReservas() {
        return idReservas;
    }

    public void setIdReservas(UUID idReservas) {
        this.idReservas = idReservas;
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

    public Date getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(Date dataReserva) {
        this.dataReserva = dataReserva;
    }
}
