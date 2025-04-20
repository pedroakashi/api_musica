/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.devops.musica.api.integration;


import com.devops.musica.api.controller.MusicaController;
import com.devops.musica.api.exception.MusicaAlreadyExistsException;
import com.devops.musica.api.model.Musica;
import com.devops.musica.api.services.MusicaService;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestaOrdenacaoIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MusicaService musicaService;

    @BeforeEach
    void setUp() {
        try {
            musicaService.cadastrarMusica("Undone thing");
            musicaService.cadastrarMusica("One");
            musicaService.cadastrarMusica("Still");
            musicaService.avaliarMusica("Undone thing", 5);
            musicaService.avaliarMusica("One", 4);
            musicaService.avaliarMusica("Still", 3);
        } catch (MusicaAlreadyExistsException ex) {
            Logger.getLogger(TestaOrdenacaoIntegrationTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    void listarMusicas_DeveRetornarListaOrdenadaPorAvaliacaoENome() {
        ResponseEntity<Musica[]> response = restTemplate.getForEntity("/musicas", Musica[].class);
        List<Musica> musicas = Arrays.asList(response.getBody());

        assertEquals("Undone thing", musicas.get(0).getNome());
        assertEquals("One", musicas.get(1).getNome());
        assertEquals("Still", musicas.get(2).getNome());
    }
}