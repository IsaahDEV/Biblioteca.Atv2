package com.example.Biblioteca.repositores;

import com.example.Biblioteca.models.Avaliacoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AvaliacoesRepository extends JpaRepository<Avaliacoes, Integer> {
}
