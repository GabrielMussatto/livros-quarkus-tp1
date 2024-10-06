package br.unitins.topicos1.dto;

import jakarta.validation.constraints.NotEmpty;

public record CadastroBasicoDTO(
    String nome, 
    @NotEmpty(message = "O email não pode ser duplicado.")
    String email,
    @NotEmpty(message = "Já existe este username.")
    String username,
    String senha,
    Integer idSexo
) {
    
}