package br.unitins.topicos1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SugestaoDTO(
    @NotBlank(message = "A sugestão não pode ser nula ou vazia")
    @Size(min = 2, max = 10000, message = "A sugestão deve possuir no min 2 e no max 10000 caracteres")      
    String sugestao
) {
    
}
