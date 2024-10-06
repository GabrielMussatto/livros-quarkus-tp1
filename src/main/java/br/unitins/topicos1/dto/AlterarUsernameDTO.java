package br.unitins.topicos1.dto;

import jakarta.validation.constraints.NotBlank;

public record AlterarUsernameDTO(
    @NotBlank(message = "senha não pode ser nulo")
    String senha,

    @NotBlank(message = "usarname não pode ser nulo" )
    String usernameNovo
) {}  

