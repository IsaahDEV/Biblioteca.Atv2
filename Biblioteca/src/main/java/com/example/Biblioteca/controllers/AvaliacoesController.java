package com.example.Biblioteca.controllers;

import com.example.Biblioteca.models.Avaliacoes;
import com.example.Biblioteca.repositores.AvaliacoesRepository;
import com.example.Biblioteca.repositores.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/avaliacoes")
public class AvaliacoesController {

    private final AvaliacoesRepository avaliacoesRepository;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public AvaliacoesController(AvaliacoesRepository avaliacoesRepository, UsuarioRepository usuarioRepository) {
        this.avaliacoesRepository = avaliacoesRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public ResponseEntity<List<Avaliacoes>> getAllAvaliacoes() {
        List<Avaliacoes> avaliacoes = avaliacoesRepository.findAll();
        return ResponseEntity.ok(avaliacoes);
    }

    @PostMapping
    public ResponseEntity<Avaliacoes> createAvaliacao(@RequestBody Avaliacoes avaliacao) {
        int usuarioId = avaliacao.getIdUsuario();

        // Buscar usuário pelo ID
        usuarioRepository.findById(usuarioId).ifPresent(avaliacao::setUsuario);

        Avaliacoes savedAvaliacao = avaliacoesRepository.save(avaliacao);
        return ResponseEntity.ok(savedAvaliacao);
    }

    // Adicione outros métodos conforme necessário (GET por ID, PUT, DELETE, etc.)
}
