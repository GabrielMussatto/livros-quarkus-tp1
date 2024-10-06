package br.unitins.topicos1.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record AvaliacaoDTO(
    String comentario,

    @NotNull
    @Min(1)
    @Max(5)
    Integer estrela,

    @NotNull
    @Min(1)
    Long idLivro,

    @NotNull
    @Min(1)
    Long idCliente
) {
    
}
