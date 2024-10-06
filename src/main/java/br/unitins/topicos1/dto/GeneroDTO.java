package br.unitins.topicos1.dto;

import jakarta.validation.constraints.NotEmpty;

public record GeneroDTO(
    String nome, 
	@NotEmpty(message = "A descrição deve ser informada.")
    String descricao
) {}
