package com.example.Biblioteca.controllers;

import com.example.Biblioteca.models.Reservas;
import com.example.Biblioteca.models.Usuario;
import com.example.Biblioteca.repositores.ReservasRepository;
import com.example.Biblioteca.repositores.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/reservas")
public class ReservasController {

    @Autowired
    private ReservasRepository reservasRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<List<Reservas>> getAllReservas() {
        List<Reservas> reservas = reservasRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(reservas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneReserva(@PathVariable(value = "id") int id) {
        Optional<Reservas> reservaOptional = reservasRepository.findById(id);

        if (reservaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reserva not found.");
        }

        Reservas reserva = reservaOptional.get();
        return ResponseEntity.status(HttpStatus.OK).body(reserva);
    }

    @PostMapping
    public ResponseEntity<Object> createReserva(@RequestBody @Valid Reservas reserva) {
        int usuarioId = reserva.getIdUsuario();
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuarioId);

        if (usuarioOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario not found.");
        }

        reserva.setUsuario(usuarioOptional.get());
        Reservas savedReserva = reservasRepository.save(reserva);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedReserva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateReserva(@PathVariable(value = "id") int id, @RequestBody @Valid Reservas reserva) {
        if (reservasRepository.existsById(id)) {
            reserva.setIdReservas(id);
            Reservas updatedReserva = reservasRepository.save(reserva);
            return ResponseEntity.status(HttpStatus.OK).body(updatedReserva);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reserva not found.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteReserva(@PathVariable(value = "id") int id) {
        if (reservasRepository.existsById(id)) {
            reservasRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Reserva deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reserva not found.");
        }
    }
}
