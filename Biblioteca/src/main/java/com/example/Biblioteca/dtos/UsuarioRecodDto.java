package com.example.Biblioteca.dtos;

import jakarta.validation.constraints.NotNull;

public record UsuarioRecodDto(@NotNull String nome, @NotNull String email, @NotNull String senha) {
}
