package com.example.Biblioteca.controllers;

import com.example.Biblioteca.models.Editora;
import com.example.Biblioteca.repositores.EditoraRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/editoras")
public class EditoraController {

    @Autowired
    private EditoraRepository editoraRepository;

    @GetMapping
    public ResponseEntity<List<Editora>> getAllEditoras() {
        List<Editora> editoras = editoraRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(editoras);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneEditora(@PathVariable(value = "id") int id) {
        Optional<Editora> editoraOptional = editoraRepository.findById(id);

        if (editoraOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Editora not found.");
        }

        Editora editora = editoraOptional.get();
        return ResponseEntity.status(HttpStatus.OK).body(editora);
    }

    @PostMapping
    public ResponseEntity<Object> createEditora(@RequestBody @Valid Editora editora) {
        Editora savedEditora = editoraRepository.save(editora);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEditora);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEditora(@PathVariable(value = "id") int id, @RequestBody @Valid Editora editora) {
        if (editoraRepository.existsById(id)) {
            editora.setIdEditora(id);
            Editora updatedEditora = editoraRepository.save(editora);
            return ResponseEntity.status(HttpStatus.OK).body(updatedEditora);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Editora not found.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEditora(@PathVariable(value = "id") int id) {
        if (editoraRepository.existsById(id)) {
            editoraRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Editora deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Editora not found.");
        }
    }
}
