/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  adriano
 * Created: 17 de abr. de 2025
 */
-- Criação da tabela 'musica'
CREATE TABLE IF NOT EXISTS musica (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL UNIQUE,
    avaliacao INTEGER DEFAULT 0
);

-- Inserção de dados iniciais (opcional)
INSERT INTO musica (nome, avaliacao) VALUES ('Undone thing', 5);
INSERT INTO musica (nome, avaliacao) VALUES ('One', 4);
INSERT INTO musica (nome, avaliacao) VALUES ('Still', 3);
INSERT INTO musica (nome, avaliacao) VALUES ('Uncover', 3);

