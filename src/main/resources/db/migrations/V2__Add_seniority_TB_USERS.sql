-- V2: Migrations para adicionar coluna de senioridade na tabela de usuários

ALTER TABLE tb_users
ADD COLUMN seniority VARCHAR(255);