package br.unitins.topicos1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record GeneroDTO(
    @NotBlank(message = "O nome não pode ser nulo ou vazio")
    @Size(min = 2, max = 60, message = "O nome deve possuir no min 2 e no max 60 caracteres")
    String nome, 
	@NotBlank(message = "A descrição não pode ser nula ou vazia")
    @Size(min = 2, max = 500, message = "A descrição deve possuir no min 2 e no max 500 caracteres")
    String descricao
) {}
