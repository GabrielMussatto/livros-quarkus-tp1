package br.unitins.topicos1.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotEmpty;

public record CadastroBasicoDTO(
    String nome, 
    @NotEmpty(message = "O email não pode ser duplicado.")
    String email,
    @NotEmpty(message = "Já existe este username.")
    String username,
    String senha,
    Integer idSexo,
    String cpf,
    String endereco,
    String estado,
    String sigla,
    String cidade,
    String cep,
    LocalDate dataNascimento,
    TelefoneDTO telefone

) {
    
}