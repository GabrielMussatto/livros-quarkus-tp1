package br.unitins.topicos1.dto;

import jakarta.validation.constraints.NotBlank;

public record AlterarSenhaDTO(
    @NotBlank(message = "senha antiga não pode ser nulo")
    String senhaAntiga,

    @NotBlank(message = "senha nova não pode ser nulo" )
    String novaSenha
) { }
