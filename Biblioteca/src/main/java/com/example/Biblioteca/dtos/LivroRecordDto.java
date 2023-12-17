package com.example.Biblioteca.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Optional;
import java.util.Set;
public record LivroRecordDto(
        @NotNull String titulo,
        @NotNull String isbn,
        @NotNull Integer anoPublicacao,
        int idAutor,
        int idEditora,
        int idCategoria,
        int idAvaliacoes,
        int idReserva
) {}