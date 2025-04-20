/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.devops.musica.api.repository;


import com.devops.musica.api.model.Musica;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Long> {

    // Verifica se uma música com o nome especificado já existe
    boolean existsByNome(String nome);

    // Busca uma música pelo nome
    Optional<Musica> findByNome(String nome);

    // Lista todas as músicas ordenadas por avaliação (descendente) e nome (ascendente)
    List<Musica> findAllByOrderByAvaliacaoDescNomeAsc();

}

