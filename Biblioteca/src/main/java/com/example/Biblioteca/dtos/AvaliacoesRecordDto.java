package com.example.Biblioteca.dtos;

import jakarta.validation.constraints.NotNull;


public record AvaliacoesRecordDto(@NotNull int classificacao, @NotNull String comentarios, @NotNull int idUsuario) {
}
