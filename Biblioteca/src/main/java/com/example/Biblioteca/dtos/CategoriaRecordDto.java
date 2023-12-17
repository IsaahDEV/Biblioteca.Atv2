package com.example.Biblioteca.dtos;

import jakarta.validation.constraints.NotNull;

public record CategoriaRecordDto(@NotNull String nome, @NotNull String descricao) {
}
