package com.example.Biblioteca.controllers;


import com.example.Biblioteca.dtos.LivroRecordDto;
import com.example.Biblioteca.models.Livro;
import com.example.Biblioteca.repositores.LivroRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.hibernate.sql.ast.SqlTreeCreationLogger.LOGGER;

@RestController
public class LivroControllers {

    @Autowired
    LivroRepository livroRepository;

    /*METÓDO PARA ADICIONAR UM LIVRO*/

    @PostMapping("/livro")
    public ResponseEntity<Livro> saveLivro(@RequestBody @Valid LivroRecordDto livroRecordDto){
        LOGGER.info("Recebida solicitação para adicionar um novo livro.");
        var livro = new Livro();
        BeanUtils.copyProperties(livroRecordDto, livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(livroRepository.save(livro));
        
    }




}