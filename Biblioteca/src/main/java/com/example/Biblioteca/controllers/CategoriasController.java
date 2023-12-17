package com.example.Biblioteca.controllers;

import com.example.Biblioteca.models.Categorias;
import com.example.Biblioteca.repositores.CategoriasRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {

    @Autowired
    private CategoriasRepository categoriasRepository;

    @GetMapping
    public ResponseEntity<List<Categorias>> getAllCategorias() {
        List<Categorias> categorias = categoriasRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneCategoria(@PathVariable(value = "id") int id) {
        Optional<Categorias> categoriaOptional = categoriasRepository.findById(id);

        if (categoriaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria not found.");
        }

        Categorias categoria = categoriaOptional.get();
        return ResponseEntity.status(HttpStatus.OK).body(categoria);
    }

    @PostMapping
    public ResponseEntity<Object> createCategoria(@RequestBody @Valid Categorias categoria) {
        Categorias savedCategoria = categoriasRepository.save(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCategoria(@PathVariable(value = "id") int id, @RequestBody @Valid Categorias categoria) {
        if (categoriasRepository.existsById(id)) {
            categoria.setIdCategorias(id);
            Categorias updatedCategoria = categoriasRepository.save(categoria);
            return ResponseEntity.status(HttpStatus.OK).body(updatedCategoria);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria not found.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCategoria(@PathVariable(value = "id") int id) {
        if (categoriasRepository.existsById(id)) {
            categoriasRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Categoria deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria not found.");
        }
    }
}
