/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.devops.musica.api.services;


import com.devops.musica.api.exception.MusicaAlreadyExistsException;
import com.devops.musica.api.model.Musica;
import com.devops.musica.api.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicaService {

    @Autowired
    private MusicaRepository musicaRepository;

    public MusicaService(MusicaRepository musicaRepository) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Musica cadastrarMusica(String nome) throws MusicaAlreadyExistsException {
        if (musicaRepository.existsByNome(nome)) {
            throw new MusicaAlreadyExistsException("Música já cadastrada: " + nome);
        }
        Musica musica = new Musica(nome);
        return musicaRepository.save(musica);
    }

    public List<Musica> listarMusicas() {
        return musicaRepository.findAllByOrderByAvaliacaoDescNomeAsc();
    }

    public void avaliarMusica(String nome, Integer avaliacao) {
        Musica musica = musicaRepository.findByNome(nome)
                .orElseThrow(() -> new IllegalArgumentException("Música não encontrada: " + nome));
        musica.setAvaliacao(avaliacao);
        musicaRepository.save(musica);
    }
}
