package com.example.Biblioteca.models;

import jakarta.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "TB_RESERVAS")
public class Reservas implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idReservas;

    @ManyToOne
    private Usuario usuario;

    private Integer idUsuario;

    private String dataReserva;

    public int getIdReservas() {
        return idReservas;
    }

    public void setIdReservas(int idReservas) {
        this.idReservas = idReservas;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(String dataReserva) {
        this.dataReserva = dataReserva;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
}
