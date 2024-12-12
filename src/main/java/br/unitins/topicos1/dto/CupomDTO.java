package br.unitins.topicos1.dto;

import jakarta.validation.constraints.NotBlank;

public record CupomDTO(
    @NotBlank(message = "O nome não pode ser nulo ou vazio")
    String nomeCupom,
    Double desconto
) {}
