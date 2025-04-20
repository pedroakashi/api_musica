package com.devops.musica.api;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



import com.devops.musica.api.exception.MusicaAlreadyExistsException;
import com.devops.musica.api.model.Musica;
import com.devops.musica.api.repository.MusicaRepository;
import com.devops.musica.api.services.MusicaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MusicaServiceTest {

    private final MusicaRepository musicaRepository = Mockito.mock(MusicaRepository.class);
    private final MusicaService musicaService = new MusicaService(musicaRepository);

    @BeforeEach
    void setUp() {
        reset(musicaRepository);
    }

    @Test
    void cadastrarMusica_DeveLancarExcecaoSeMusicaJaExistir() {
        when(musicaRepository.existsByNome("Música Existente")).thenReturn(true);

        assertThrows(MusicaAlreadyExistsException.class, () -> musicaService.cadastrarMusica("Música Existente"));
        verify(musicaRepository, times(1)).existsByNome("Música Existente");
    }

    @Test
    void avaliarMusica_DeveAtualizarAvaliacao() {
        Musica musica = new Musica("Música Avaliada");
        when(musicaRepository.findByNome("Música Avaliada")).thenReturn(Optional.of(musica));

        musicaService.avaliarMusica("Música Avaliada", 5);

        assertEquals(5, musica.getAvaliacao());
        verify(musicaRepository, times(1)).save(musica);
    }
}
