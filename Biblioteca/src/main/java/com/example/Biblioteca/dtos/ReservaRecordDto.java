package com.example.Biblioteca.dtos;

import jakarta.validation.constraints.NotNull;


public record ReservaRecordDto(@NotNull int idUsuario, @NotNull String dataReserva) {
}
