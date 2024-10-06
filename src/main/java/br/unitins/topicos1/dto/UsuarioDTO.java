package br.unitins.topicos1.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;

public record UsuarioDTO(
    @NotBlank(message = "O campo nome não pode estar nulo")
    String nome,

    @NotBlank(message = "O campo username não pode estar nulo")
    String username,

    @NotBlank(message = "O campo senha não pode estar nulo")
    String senha,
    
    LocalDate dataNascimento,

    String email,
    TelefoneDTO telefone,
    Integer idSexo,

    String cpf
) { }
