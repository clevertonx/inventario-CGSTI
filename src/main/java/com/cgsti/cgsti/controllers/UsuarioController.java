package com.cgsti.cgsti.controllers;

import com.cgsti.cgsti.models.Usuario;
import com.cgsti.cgsti.repository.UsuarioRepository;
import com.cgsti.cgsti.services.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping(value = "/registrar")
    public ResponseEntity<Usuario> registrarUsuario(@Valid @RequestBody Usuario usuarioRequest) {
        try {
            Usuario novoUsuario = usuarioService.cadastrarUsuario(usuarioRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping(value = "/login")
    public ResponseEntity<Void> loginUsuario(@RequestBody Usuario usuarioRequest) {
        try {
            Optional<Usuario> usuario = usuarioRepository.findByEmailOrUsername(usuarioRequest.getUsername(), usuarioRequest.getUsername());

            if (usuario.isPresent()) {
                if (passwordEncoder.matches(usuarioRequest.getSenha(), usuario.get().getSenha())) {
                    return ResponseEntity.ok().build();
                } else {
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
                }
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}



