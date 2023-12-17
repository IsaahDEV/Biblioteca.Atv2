package com.example.Biblioteca.controllers;

import com.example.Biblioteca.models.Livro;
import com.example.Biblioteca.repositores.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroRepository livroRepository;
    private final AutorRepository autorRepository;
    private final EditoraRepository editoraRepository;
    private final CategoriasRepository categoriasRepository;
    private final AvaliacoesRepository avaliacoesRepository;
    private final ReservasRepository reservasRepository;

    @Autowired
    public LivroController(LivroRepository livroRepository, AutorRepository autorRepository,
                           EditoraRepository editoraRepository, CategoriasRepository categoriasRepository, AvaliacoesRepository avaliacoesRepository, ReservasRepository reservasRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
        this.editoraRepository = editoraRepository;
        this.categoriasRepository = categoriasRepository;
        this.avaliacoesRepository = avaliacoesRepository;
        this.reservasRepository = reservasRepository;
    }

    @GetMapping
    public ResponseEntity<List<Livro>> getAllLivros() {
        List<Livro> livros = livroRepository.findAll();
        return ResponseEntity.ok(livros);
    }

    @PostMapping
    public ResponseEntity<Livro> createLivro(@RequestBody Livro livro) {
        // Buscar autor, editora e categoria pelos IDs fornecidos no JSON
        int autorId = livro.getIdAutor();
        int editoraId = livro.getIdEditora();
        int categoriaId = livro.getIdCategoria();
        int avaliacaoID = livro.getIdAvaliacoes();
        int reservaID = livro.getIdReserva();

        autorRepository.findById(autorId).ifPresent(livro::setAutor);
        editoraRepository.findById(editoraId).ifPresent(livro::setEditora);
        categoriasRepository.findById(categoriaId).ifPresent(livro::setCategoria);
        avaliacoesRepository.findById(avaliacaoID).ifPresent(livro::setAvaliacao);
        reservasRepository.findById(reservaID).ifPresent(livro::setReserva);

        Livro savedLivro = livroRepository.save(livro);
        return ResponseEntity.ok(savedLivro);
    }

    // Adicione outros métodos conforme necessário (GET por ID, PUT, DELETE, etc.)
}
