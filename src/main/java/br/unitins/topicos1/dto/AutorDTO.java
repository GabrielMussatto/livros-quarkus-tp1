package br.unitins.topicos1.dto;

import jakarta.validation.constraints.NotBlank;

public record AutorDTO (
    @NotBlank(message = "O nome não pode ser nulo ou vazio")
    String nome,
    @NotBlank(message = "a biografia não pode ser nula ou vazio") 
    String biografia
    ) {}
