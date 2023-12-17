package com.example.Biblioteca.controllers;

import com.example.Biblioteca.dtos.AutorRecordDto;
import com.example.Biblioteca.models.Autor;
import com.example.Biblioteca.repositores.AutorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorRepository autorRepository;

    @Autowired
    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @GetMapping
    public ResponseEntity<List<Autor>> getAllAutores() {
        List<Autor> autores = autorRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(autores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getAutorById(@PathVariable int id) {
        Optional<Autor> autorOptional = autorRepository.findById(id);
        if (autorOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(autorOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Autor not found.");
        }
    }

    @PostMapping
    public ResponseEntity<Autor> saveAutor(@RequestBody @Valid AutorRecordDto autorRecordDto) {
        Autor autor = new Autor();
        autor.setNome(autorRecordDto.nome());
        autor.setNacionalidade(autorRecordDto.nacionalidade()); // Verifique se está correto aqui
        Autor savedAutor = autorRepository.save(autor);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAutor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateAutor(@PathVariable int id, @RequestBody @Valid Autor autor) {
        if (!autorRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Autor not found.");
        }
        autor.setIdtAutor(id);
        autorRepository.save(autor);
        return ResponseEntity.status(HttpStatus.OK).body("Autor updated successfully.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAutor(@PathVariable int id) {
        if (!autorRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Autor not found.");
        }
        autorRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Autor deleted successfully.");
    }
}