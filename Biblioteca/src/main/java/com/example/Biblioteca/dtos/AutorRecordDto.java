package com.example.Biblioteca.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AutorRecordDto(@NotNull String nome, @NotNull String nacionalidade) {
}
