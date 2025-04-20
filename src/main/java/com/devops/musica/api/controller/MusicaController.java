/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.devops.musica.api.controller;


import com.devops.musica.api.exception.MusicaAlreadyExistsException;
import com.devops.musica.api.model.Musica;
import com.devops.musica.api.services.MusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/musicas")
public class MusicaController {

    @Autowired
    private MusicaService musicaService;
    
    //Endpoint para cadastrar musicas
    @PostMapping
    public ResponseEntity<Musica> cadastrarMusica(@RequestParam String nome) {
        Musica musica = null;
        try {
            musica = musicaService.cadastrarMusica(nome);
            
        } catch (MusicaAlreadyExistsException ex) {
            Logger.getLogger(MusicaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ResponseEntity.ok(musica);
    }

    @GetMapping
    public ResponseEntity<List<Musica>> listarMusicas() {
        List<Musica> musicas = musicaService.listarMusicas();
        return ResponseEntity.ok(musicas);
    }

    @PutMapping("/{nome}/avaliar")
    public ResponseEntity<Void> avaliarMusica(@PathVariable String nome, @RequestParam Integer avaliacao) {
        musicaService.avaliarMusica(nome, avaliacao);
        return ResponseEntity.noContent().build();
    }
}
