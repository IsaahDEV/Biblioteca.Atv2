package com.example.Biblioteca.repositores;

import com.example.Biblioteca.models.Reservas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservasRepository extends JpaRepository<Reservas, Integer> {
}
