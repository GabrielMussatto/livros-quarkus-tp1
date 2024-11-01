package br.unitins.topicos1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AutorDTO (
    @NotBlank(message = "O nome não pode ser nulo ou vazio")
    @Size(min = 2, max = 60, message = "O nome deve possuir no min 2 e no max 60 caracteres")
    String nome,
    @NotBlank(message = "A biografia não pode ser nula ou vazio") 
    @Size(min = 2, max = 10000, message = "A biografia deve possuir no min 2 e no max 10000 caracteres")
    String biografia
    ) {}
