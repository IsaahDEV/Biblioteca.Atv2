package com.example.Biblioteca.repositores;

import com.example.Biblioteca.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface LivroRepository extends JpaRepository<Livro, UUID> {
}
