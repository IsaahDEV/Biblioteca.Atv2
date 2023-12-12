package com.example.Biblioteca.dtos;

import jakarta.validation.constraints.NotBlank;

public record LivroRecordDto(@NotBlank String titulo, @NotBlank String isbn, @NotBlank int anoPublicado) {
}
