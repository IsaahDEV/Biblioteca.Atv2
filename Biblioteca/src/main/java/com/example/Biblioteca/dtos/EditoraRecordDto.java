package com.example.Biblioteca.dtos;

import jakarta.validation.constraints.NotNull;

public record EditoraRecordDto(@NotNull String nome, @NotNull String endereco) {
}
